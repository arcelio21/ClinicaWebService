package com.clinicawebservice.daoData.addressDAO.addressEx;


import com.clinicawebservice.domain.address.exaddress.Tdistrict;
import com.clinicawebservice.mapper.addressMapper.exaddressMapper.TdistrictMapper;
import com.clinicawebservice.voData.addressDTO.exaddressDTO.TdistrictDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mapstruct.factory.Mappers;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class TdistrictImpl implements TdistrictDAO{

    private Logger log= LogManager.getRootLogger();
    private TdistrictMapper tdistrictMapper=Mappers.getMapper(TdistrictMapper.class);

    @PersistenceContext(unitName = "PoolDatosClinica")
    private EntityManager entityManager;


    /**
     * METODO DE QUE LISTA TODAS LOS DISTRITOS DISPONIBLES
     *
     * @return List<TdistrictDto>
     */
    @Override
    public List<TdistrictDto> listDistricts() {
        this.log.debug("START SEARCH");
        List<TdistrictDto> tdistrictDtos=new ArrayList<>();
        try {
            List<Tdistrict> tdistricts=this.entityManager.createNamedQuery("Tdistrict.listAll").getResultList();
            tdistricts.forEach(tdistrict -> {
                tdistrictDtos.add(this.tdistrictMapper.tdistrictToTdistrictDto(tdistrict));
            });

            this.log.debug("SUCCESS SEARCH");
        }catch (RuntimeException e){
            this.log.error("ERROR SEARCH: "+e.getCause());
            e.printStackTrace(System.out);
            return null;
        }
        return tdistrictDtos;
    }

    /**
     * METODO QUE REALIZA BUSQUEDA DE DISTRITOS POR SU ID
     *
     * @param tdistrictDto
     * @return TprovinceDto
     */
    @Override
    public TdistrictDto searchDistrictById(TdistrictDto tdistrictDto) {
        this.log.debug("START SEARCH BY ID");
        TdistrictDto tdistrictDtoReturn=null;
        try {
            Tdistrict tdistrict=this.entityManager.find(Tdistrict.class,tdistrictDto.getId());
            tdistrictDtoReturn=this.tdistrictMapper.tdistrictToTdistrictDto(tdistrict);
            this.log.debug("SUCCESS SEARCH BY ID");
        }catch (RuntimeException e){
            this.log.error("ERROR SEARCH BY ID: "+e.getCause());
            e.printStackTrace(System.out);
            return  null;
        }

        return tdistrictDtoReturn;
    }

    /**
     * METODO QUE INSERTA NUEVA DISTRITO
     *
     * @param tdistrictDto
     * @return boolean
     */
    @Override
    public boolean insertDistrict(TdistrictDto tdistrictDto) {

        this.log.debug("START INSERT");
        boolean validate=false;
        try {
            Tdistrict tdistrict=this.tdistrictMapper.tdistrictDtoToTdistrict(tdistrictDto);
            this.entityManager.persist(tdistrict);
            this.entityManager.flush();
            this.entityManager.refresh(tdistrict);
            validate=true;
            this.log.debug("SUCCESS INSERT");
        }catch (RuntimeException exception){
            this.log.error("ERROR INSERT: "+exception.getCause());
            exception.printStackTrace(System.out);
            return  false;
        }

        return validate;
    }

    /**
     * METODO QUE ACTAULIZA INFORMACION DE UNA PROVINCIA EN ESPECIFICO
     *
     * @param tdistrictDto
     * @return boolean
     */
    @Override
    public boolean updateDistrict(TdistrictDto tdistrictDto) {
        this.log.debug("START UPDATE");
        boolean validate=false;
        try {
            Tdistrict tdistrict=this.tdistrictMapper.tdistrictDtoToTdistrict(tdistrictDto);
            this.entityManager.merge(tdistrict);
            validate=true;
            this.log.debug("SUCCESS UPDATE");
        }catch (RuntimeException exception){
            this.log.debug("ERROR UPDATE: "+exception.getCause());
            exception.printStackTrace(System.out);
            return  false;
        }
        return validate;
    }

    /**
     * METODO QUE ELIMINA DATOS DE UNA PROVINCIA EN ESPECIFICO
     *
     * @param tdistrictDto
     * @return
     */
    @Override
    public boolean deleteDistrict(TdistrictDto tdistrictDto) {
        this.log.debug("START DELETE");
        boolean validate=false;
        try {
            Tdistrict tdistrict=this.tdistrictMapper.tdistrictDtoToTdistrict(tdistrictDto);
            this.entityManager.remove(this.entityManager.merge(tdistrict));
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
