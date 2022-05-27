package com.clinicawebservice.daoData.userInfoDAO.typeUserDAO;


import com.clinicawebservice.domain.userInfo.infotypeuser.TtypeUser;
import com.clinicawebservice.mapper.userinfoMapper.TypeUserMapper.TtypeUserMapper;
import com.clinicawebservice.voData.userinfoDTO.typeuserDTO.TtypeUserDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mapstruct.factory.Mappers;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class TtypeUserImpl implements TtypeUerDAO{

    private static Logger log= LogManager.getRootLogger();

    TtypeUserMapper ttypeUserMapper= Mappers.getMapper(TtypeUserMapper.class);

    @PersistenceContext(unitName = "PoolDatosClinica")
    private EntityManager entityManager;




    /**
     *
     * LIST ALL EXISTING USER TYPES
     *
     *
     * @return THE LIST OF ALL TYPES OF USERS
     * */
    @Override
    public List<TtypeUserDto> listTypeUser() {
        List<TtypeUserDto> ttypeUserDtos=new ArrayList<>();
        log.debug("STARTING TYPE_USER SEARCH");
        try {
            List<TtypeUser> ttypeUsers=entityManager.createNamedQuery("TypeUser.listAll").getResultList();
            ttypeUsers.forEach(ttypeUser ->{
                ttypeUserDtos.add(ttypeUserMapper.ttypeUserToTtypeUserDto(ttypeUser));
            } );

        }catch (RuntimeException e){
            e.printStackTrace(System.out);
            log.error("DATA SEARCH ERROR: "+e.getMessage());
            return null;
        }

        return ttypeUserDtos;
    }

    /**
     *
     * SEARCH FOR USER TYPE BY ID
     *
     * @param ttypeUserDto
     * @return  TtypeUserDto
     *
     * */
    @Override
    public TtypeUserDto searchTypeUserById(TtypeUserDto ttypeUserDto) {

        TtypeUserDto ttypeUserDtoReturn=null;
        log.debug("START USER TYPE SEARCH BY USER ID");


        try {
            TtypeUser ttypeUser=ttypeUserMapper.ttypeUserDtoToTtypeUser(ttypeUserDto);
            ttypeUser=entityManager.find(TtypeUser.class,ttypeUser.getId());
            ttypeUserDtoReturn=ttypeUserMapper.ttypeUserToTtypeUserDto(ttypeUser);
            log.debug("SUCCESSFUL SEARCH");
        }catch (RuntimeException e){
            e.printStackTrace(System.out);
            log.error("SEARCH ERROR: "+e.getMessage());
            return null;
        }

        return ttypeUserDtoReturn;
    }

    /**
     *
     * INSERTS DATA OF A USER TYPE TO THE DATABASE
     * @param ttypeUserDto
     * @return boolean
     * */
    @Override
    public boolean insertTypeUser(TtypeUserDto ttypeUserDto) {

        log.debug("START INSERT");
        boolean validate=false;
        try{
            TtypeUser ttypeUser=ttypeUserMapper.ttypeUserDtoToTtypeUser(ttypeUserDto);
            entityManager.persist(ttypeUser);
            entityManager.flush();
            entityManager.refresh(ttypeUser);
            validate=true;
            log.debug("SUCCESS INSERT");
        }catch (RuntimeException exception){
            exception.printStackTrace(System.out);
            log.debug("ERROR INSERT: "+exception.getMessage());
            return false;
        }

        return validate;
    }

    /**
     *UPDATES THE VALUES OF A SPECIFIC USER TYPE
     *
     * @param ttypeUserDto
     * @return boolean
     *
     * */
    @Override
    public boolean updateTypeUser(TtypeUserDto ttypeUserDto) {

        boolean validate=false;
        log.debug("START UPDATE");
        try {
            TtypeUser ttypeUser=ttypeUserMapper.ttypeUserDtoToTtypeUser(ttypeUserDto);
            entityManager.merge(ttypeUser);
            validate=true;
            log.debug("SUCCESS UPDATE");
        }catch (RuntimeException e){
            e.printStackTrace(System.out);
            log.error("ERROR UPDATE: "+e.getMessage());
            return false;
        }

        return validate;
    }

    /**
     *ELIMINATES USER TYPE INDICATED
     * @param ttypeUserDto
     * @return boolean
     *
     * */

    @Override
    public boolean deleteTypeUser(TtypeUserDto ttypeUserDto) {

        boolean validate=false;
        log.debug("START DELETE");

        try{
            TtypeUser ttypeUser=ttypeUserMapper.ttypeUserDtoToTtypeUser(ttypeUserDto);
            entityManager.remove(entityManager.merge(ttypeUser));
            validate=true;
            log.debug("SUCCESS DELETE");
        }catch (RuntimeException e){
            e.printStackTrace(System.out);
            log.error("ERROR DELETE: "+e.getMessage());
            return  false;
        }

        return validate;
    }
}
