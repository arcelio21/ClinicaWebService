package com.clinicawebservice.daoData.addressDAO;


import com.clinicawebservice.domain.address.Taddress;
import com.clinicawebservice.mapper.addressMapper.TaddressMap;
import com.clinicawebservice.voData.addressDTO.TaddressDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mapstruct.factory.Mappers;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class TaddressImpl implements TaddressDAO {

    private Logger log= LogManager.getRootLogger();
    TaddressMap taddressMapper= Mappers.getMapper(TaddressMap.class);
    @PersistenceContext(unitName = "PoolDatosClinica")
    EntityManager entityManager;
    /**
     * METODO QUE LISTA TODO LOS ADDRESS QUE EXISTEN
     *
     * @return List<TaddressDTO>
     */
    @Override
    public List<TaddressDto> listAddress() {
        log.debug("START SEARCH");
        List<TaddressDto> taddressDtos=new ArrayList<>();
        try {
            List<Taddress> taddresses=entityManager.createNamedQuery("Taddress.listAll").getResultList();
            taddresses.forEach(taddress -> {
                taddressDtos.add(taddressMapper.taddressToTaddressDto(taddress));
            });
            log.debug("SUCCESS SEARCH");
        }catch (RuntimeException exception){
            exception.printStackTrace(System.out);
            log.error("ERROD SEARCH: "+exception.getCause());
            return null;
        }
        return taddressDtos;
    }

    /**
     * METODO QUE REALIZA BUSQUEDA DE ADDRESS ESPECIFICO
     *
     * @param taddressDto
     * @return TaddressDTO
     */
    @Override
    public TaddressDto searchAddressById(TaddressDto taddressDto) {
        log.debug("START SEARCH BY ID");
        TaddressDto taddressDtoReturn=null;
        try {
            Taddress taddress=entityManager.find(Taddress.class,taddressDto.getId());
            taddressDtoReturn=taddressMapper.taddressToTaddressDto(taddress);
            log.debug("SUCCESS SEARCH");
        }catch (RuntimeException exception){
            exception.printStackTrace(System.out);
            log.debug("ERROR SEARCH: "+exception.getCause());
            return null;
        }
        return taddressDtoReturn;
    }

    /**
     * METODO PARA INSERTAR ADDRESS
     *
     * @param taddressDto
     * @return boolean
     */
    @Override
    public boolean insertAddress(TaddressDto taddressDto) {
        log.debug("START INSERT");
        boolean validate=false;

        try {
            Taddress taddress=taddressMapper.taddressDtoToTaddress(taddressDto);
            entityManager.persist(taddress);
            entityManager.flush();
            entityManager.refresh(taddress);
            log.debug("SUCCESS INSERT");
            validate=true;
        }catch (RuntimeException e){
            e.printStackTrace(System.out);
            log.debug("ERROR INSERT: "+e.getCause());
            return false;
        }
        return validate;
    }

    /**
     * METODO PARA ACTUALIZAR DATOS DE ADDRESS
     *
     * @param taddressDto
     * @return boolean
     */
    @Override
    public boolean updateAddress(TaddressDto taddressDto) {

        log.debug("START UPDATE");
        boolean validate=false;
        try {
            Taddress taddress=taddressMapper.taddressDtoToTaddress(taddressDto);
            entityManager.merge(taddress);
            log.debug("SUCCESS UPDATE");
            validate=true;
        }catch (RuntimeException e){
            e.printStackTrace(System.out);
            log.error("ERROR UPDATE: "+e.getCause());
            return false;
        }

        return validate;
    }

    /**
     * METODO QUE ELIMINA UA REGISTRO DE ADDRESS
     *
     * @param taddressDto
     * @return boolean
     */
    @Override
    public boolean deleteAddress(TaddressDto taddressDto) {
        log.debug("START DELETE");
        boolean validate=false;
        try {
            Taddress taddress=taddressMapper.taddressDtoToTaddress(taddressDto);
            entityManager.remove(entityManager.merge(taddress));
            log.debug("SUCCESS DELETE");
            validate=true;
        }catch (RuntimeException exception){
            exception.printStackTrace(System.out);
            log.error("ERROR DELETE: "+exception.getCause());
            return false;
        }
        return validate;
    }
}
