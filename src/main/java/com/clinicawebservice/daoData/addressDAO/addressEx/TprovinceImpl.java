package com.clinicawebservice.daoData.addressDAO.addressEx;


import com.clinicawebservice.domain.address.exaddress.Tprovince;
import com.clinicawebservice.mapper.addressMapper.exaddressMapper.TprovinceMapper;
import com.clinicawebservice.voData.addressDTO.exaddressDTO.TprovinceDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mapstruct.factory.Mappers;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class TprovinceImpl implements TprovinceDAO{

    private Logger log= LogManager.getRootLogger();
    private TprovinceMapper tprovinceMapper= Mappers.getMapper(TprovinceMapper.class);

    @PersistenceContext(unitName = "PoolDatosClinica")
    EntityManager entityManager;

    /**
     * METODO DE QUE LISTA TODAS LAS PROVINCIAS DISPONIBLES
     *
     * @return List<TprovinceDto>
     */
    @Override
    public List<TprovinceDto> listProvinces() {
        this.log.debug("START SEARCH");entityManager.flush();

        List<TprovinceDto> tprovinceDtos=new ArrayList<>();
        try {

            List<Tprovince> tprovinces=entityManager.createNamedQuery("Tprovince.listAll").getResultList();
            tprovinces.forEach(tprovince -> {
                tprovinceDtos.add(this.tprovinceMapper.tprovinceToTprovinceDto(tprovince));

            });
            this.log.debug("SUCCESS SEARCH");
        }catch (RuntimeException exception){
            exception.printStackTrace(System.out);
            this.log.debug("ERROR SEARCH: "+exception.getCause());
            return null;
        }

        return tprovinceDtos;
    }

    /**
     * METODO QUE REALIZA BUSQUEDA DE PROVINCIA POR SU ID
     *
     * @param tprovinceDto
     * @return TprovinceDto
     */
    @Override
    public TprovinceDto searchProvinceById(TprovinceDto tprovinceDto) {

        this.log.debug("START SEARCH BY ID");
        TprovinceDto tprovinceDtoReturn=null;
        try {
            Tprovince tprovince=this.entityManager.find(Tprovince.class,tprovinceDto.getId());
            tprovinceDtoReturn=this.tprovinceMapper.tprovinceToTprovinceDto(tprovince);
            this.log.debug("SUCCESS SEARCH BY ID");
        }catch (RuntimeException exception){
            this.log.error("ERROR SEARCH BY ID: "+exception.getCause());
            exception.printStackTrace(System.out);
            return null;
        }

        return tprovinceDtoReturn;
    }

    /**
     * METODO QUE INSERTA NUEVA PROVINCIA
     *
     * @param tprovinceDto
     * @return boolean
     */
    @Override
    public boolean insertProvince(TprovinceDto tprovinceDto) {

        this.log.debug("START INSERT");
        boolean validate=false;
        try {
            Tprovince tprovince=this.tprovinceMapper.tprovinceDtoToTprovince(tprovinceDto);
            this.entityManager.persist(tprovince);
            this.entityManager.flush();
            this.entityManager.refresh(tprovince);
            validate=true;
            this.log.debug("SUCCESS INSERT");
        }catch (RuntimeException e){
            this.log.error("ERROR INSERT: "+e.getCause());
            e.printStackTrace(System.out);
            return  false;
        }
        return validate;
    }

    /**
     * METODO QUE ACTAULIZA INFORMACION DE UNA PROVINCIA EN ESPECIFICO
     *
     * @param tprovinceDto
     * @return boolean
     */
    @Override
    public boolean updateProvince(TprovinceDto tprovinceDto) {
        this.log.debug("START UPDATE");
        boolean validate=false;
        try {
            Tprovince tprovince=this.tprovinceMapper.tprovinceDtoToTprovince(tprovinceDto);
            this.entityManager.merge(tprovince);

            validate=true;
            this.log.debug("SUCCESS UPDATE");
        }catch (RuntimeException exception){
            this.log.error("ERROR UPDATE: "+exception.getCause());
            exception.printStackTrace(System.out);
            return  false;
        }
        return validate;
    }

    /**
     * METODO QUE ELIMINA DATOS DE UNA PROVINCIA EN ESPECIFICO
     *
     * @param tprovinceDto
     * @return
     */
    @Override
    public boolean deleteProvince(TprovinceDto tprovinceDto) {
        this.log.debug("START DELETE");
        boolean validate=false;
        try {
            Tprovince tprovince=this.tprovinceMapper.tprovinceDtoToTprovince(tprovinceDto);
            this.entityManager.remove(this.entityManager.merge(tprovince));
            validate=true;
            this.log.debug("SUCCESS DELETE");
        }catch (RuntimeException exception){
            this.log.error("ERROR DELETE: "+exception.getCause());
            exception.printStackTrace(System.out);
            return false;
        }
        return validate;
    }
}
