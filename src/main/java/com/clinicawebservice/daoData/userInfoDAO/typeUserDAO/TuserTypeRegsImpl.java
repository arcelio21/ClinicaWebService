package com.clinicawebservice.daoData.userInfoDAO.typeUserDAO;


import com.clinicawebservice.domain.userInfo.infotypeuser.TuserTypeReg;
import com.clinicawebservice.mapper.userinfoMapper.TypeUserMapper.TuserTypeRegMapper;
import com.clinicawebservice.voData.userinfoDTO.typeuserDTO.TuserTypeRegDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mapstruct.factory.Mappers;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class TuserTypeRegsImpl implements TuserTypeRegsDAO{

    @PersistenceContext(unitName = "PoolDatosClinica")
    EntityManager entityManager;

    TuserTypeRegMapper tuserTypeRegsMapper= Mappers.getMapper(TuserTypeRegMapper.class);

    private Logger log= LogManager.getRootLogger();


    /**
     * METODO DEVUELVE UNA LISTA CON DATOS CON CADA TIPO DE USUARIO POR USUARIO
     *
     * @return List<TuserTypeRegsDto>
     */
    @Override
    public List<TuserTypeRegDto> listUserTypeRegs() {
        log.debug("STARTING SEARCH ");
        List<TuserTypeRegDto> tuserTypeRegsDtos=new ArrayList<>();
        try{
            List<TuserTypeReg> tuserTypeRegs=entityManager.createNamedQuery("TuserTypeReg.listAll").getResultList(); //BUSCANDO LOS DATOS
            tuserTypeRegs.forEach(tuserTypeRegs1 -> {

                tuserTypeRegsDtos.add(tuserTypeRegsMapper.tuserTypeRegToTuserTypeRegDto(tuserTypeRegs1));

            });

        }catch (RuntimeException exception){
            log.error("ERROR SEARCH: "+exception.getCause());
            return null;
        }


        return tuserTypeRegsDtos;
    }

    /**
     * METODO QUE DEVUELVE UN OBJETO CON DATOS DE UN TIPO DE USUARIO ASIGNADO A UN USUARIO
     *
     * @param tuserTypeRegsDto
     * @return TuserTypeRegsDto
     */
    @Override
    public TuserTypeRegDto searchUserTypeRegById(TuserTypeRegDto tuserTypeRegsDto) {
        log.debug("START SEARCH BY ID");
        TuserTypeRegDto tuserTypeRegsDtoReturn=null;

        try {
            TuserTypeReg tuserTypeRegs=entityManager.find(TuserTypeReg.class,tuserTypeRegsDto.getId());
            tuserTypeRegsDtoReturn=tuserTypeRegsMapper.tuserTypeRegToTuserTypeRegDto(tuserTypeRegs);
            log.debug("SUCCESS SEARCH");
        }catch (RuntimeException e){
            log.debug("ERROR SEARCH BY ID: "+e.getCause());
        }

        return tuserTypeRegsDtoReturn;
    }

    /**
     * METODO QUE INSERTA UN TIPO DE USUARIO ASIGNADO A UN USUARIO
     *
     * @param tuserTypeRegsDto
     * @return boolean
     */
    @Override
    public boolean insertUserTypeReg(TuserTypeRegDto tuserTypeRegsDto) {
        log.debug("START INSERT");
        boolean validate=false;
        try {
            TuserTypeReg tuserTypeRegs=tuserTypeRegsMapper.tuserTypeRegDtoToTuserTypeReg(tuserTypeRegsDto);
            entityManager.persist(tuserTypeRegs);
            entityManager.flush();
            entityManager.refresh(tuserTypeRegs);
            validate=true;
        }catch (RuntimeException e){
            log.debug("ERROR INSERT: "+e.getCause());
            return false;
        }

        return validate;
    }

    /**
     * METDDO QUE ACTUALIZA DATOS DE UN REGISTRO DE TIPO DE USUARIO ASIGNADO A UN USUARIO
     *
     * @param tuserTypeRegsDto
     * @return boolean
     */
    @Override
    public boolean updateUserTypeReg(TuserTypeRegDto tuserTypeRegsDto) {

        log.debug("START UPDATE");
        boolean validate=false;
        try {
            TuserTypeReg tuserTypeRegs=tuserTypeRegsMapper.tuserTypeRegDtoToTuserTypeReg(tuserTypeRegsDto);
            entityManager.merge(tuserTypeRegs);
            validate=true;
            log.debug("SUCCESS UPDATE");
        }catch (RuntimeException e){
            e.printStackTrace(System.out);
            log.debug("ERROR UPDATE: "+e.getCause());
            return false;
        }

        return validate;
    }

    /**
     * METODO DE ELIMINA UN REGISTRO DE TIPO DE USUARIO ASGINADO
     *
     * @param tuserTypeRegsDto
     * @return boolean
     */
    @Override
    public boolean deleteUserTypeReg(TuserTypeRegDto tuserTypeRegsDto) {

        log.debug("START DELETE");
        boolean validate=false;

        try {
            TuserTypeReg tuserTypeRegs=tuserTypeRegsMapper.tuserTypeRegDtoToTuserTypeReg(tuserTypeRegsDto);
            entityManager.remove(entityManager.merge(tuserTypeRegs));
            validate=true;
            log.debug("SUCCESS DELETE");
        }catch (RuntimeException e){
            e.printStackTrace(System.out);
            log.error("ERROR DELETE: "+e.getCause());
            return false;

        }

        return validate;
    }
}
