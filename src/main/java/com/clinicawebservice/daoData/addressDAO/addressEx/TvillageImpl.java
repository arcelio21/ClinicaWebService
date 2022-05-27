package com.clinicawebservice.daoData.addressDAO.addressEx;


import com.clinicawebservice.domain.address.exaddress.Tvillage;
import com.clinicawebservice.mapper.addressMapper.exaddressMapper.TvillageMapper;
import com.clinicawebservice.voData.addressDTO.exaddressDTO.TvillageDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mapstruct.factory.Mappers;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class TvillageImpl implements TvillageDAO{

    private Logger log= LogManager.getRootLogger();
    private TvillageMapper tvillageMapper= Mappers.getMapper(TvillageMapper.class);

    @PersistenceContext(unitName = "PoolDatosClinica")
    private EntityManager entityManager;

    /**
     * METODO DE QUE LISTA TODOS LOS CORREGIMIENTOS DISPONIBLES
     *
     * @return List<TvillageDto>
     */
    @Override
    public List<TvillageDto> listVillages() {
        this.log.debug("START SEARCH");
        List<TvillageDto> tvillageDtos=new ArrayList<>();
        try {
            List<Tvillage> tvillages=this.entityManager.createNamedQuery("Tvillage.listAll").getResultList();
            tvillages.forEach(tvillage -> {
                tvillageDtos.add(this.tvillageMapper.tvillageToTvillageDto(tvillage));
            });
            this.log.debug("SUCCESS SEARCH");
        }catch (RuntimeException e){
            this.log.debug("ERROR SEARCH: "+e.getCause());
            e.printStackTrace(System.out);
            return null;
        }
        return tvillageDtos;
    }

    /**
     * METODO QUE REALIZA BUSQUEDA DE CORREGIMIENTO POR SU ID
     *
     * @param tvillageDto
     * @return TvillageDto
     */
    @Override
    public TvillageDto searchVillageById(TvillageDto tvillageDto) {
        this.log.debug("START SEARCH BY ID");
        TvillageDto tvillageDtoReturn=null;
        try {
            Tvillage tvillage=this.entityManager.find(Tvillage.class,tvillageDto.getId());
            tvillageDtoReturn=this.tvillageMapper.tvillageToTvillageDto(tvillage);
            this.log.debug("SUCCESS SEARCH BY ID");
        }catch (RuntimeException e){
            this.log.error("ERROR SEARCH BY ID: "+e.getCause());
            e.printStackTrace(System.out);
            return null;
        }
        return tvillageDtoReturn;
    }

    /**
     * METODO QUE INSERTA NUEVO CORREGIMIENTO
     *
     * @param tvillageDto
     * @return boolean
     */
    @Override
    public boolean insertVillage(TvillageDto tvillageDto) {
        this.log.debug("START INSERT");
        boolean validate=false;
        try {
            Tvillage tvillage=this.tvillageMapper.tvillageDtoToTvillage(tvillageDto);
            this.entityManager.persist(tvillage);
            this.entityManager.flush();
            this.entityManager.refresh(tvillage);
            validate=true;
            this.log.debug("SUCCESS INSERT");
        }catch (RuntimeException exception){
            this.log.error("ERROR INSERT: "+exception.getCause());
            exception.printStackTrace(System.out);
            return false;
        }
        return validate;
    }

    /**
     * METODO QUE ACTUALIZA INFORMACION DE UN CORREGIMIENTO EN ESPECIFICO
     *
     * @param tvillageDto
     * @return boolean
     */
    @Override
    public boolean updateVillage(TvillageDto tvillageDto) {
        this.log.debug("START UPDATE");
        boolean validate=false;
        try {
            Tvillage tvillage=this.tvillageMapper.tvillageDtoToTvillage(tvillageDto);
            this.entityManager.merge(tvillage);
            validate=true;
            this.log.debug("SUCCESS UPDATE");
        }catch (RuntimeException exception){
            this.log.error("ERROR UPDATE: "+exception.getCause());
            exception.printStackTrace(System.out);
            return false;
        }
        return validate;
    }

    /**
     * METODO QUE ELIMINA DATOS DE UN CORREGIMIENTO EN ESPECIFICO
     *
     * @param tvillageDto
     * @return boolean
     */
    @Override
    public boolean deleteProvince(TvillageDto tvillageDto) {
        this.log.debug("START DELETE");
        boolean validate=false;
        try {
            Tvillage tvillage=this.tvillageMapper.tvillageDtoToTvillage(tvillageDto);
            this.entityManager.remove(this.entityManager.merge(tvillage));
            validate=true;
            this.log.debug("SUCCESS DELETE");
        }catch (RuntimeException e){
            this.log.error("ERROR DELETE: "+e.getCause());
            e.printStackTrace(System.out);
            return false;
        }
        return validate;
    }
}
