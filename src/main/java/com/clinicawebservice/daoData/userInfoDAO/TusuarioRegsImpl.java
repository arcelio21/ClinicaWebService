package com.clinicawebservice.daoData.userInfoDAO;

import com.clinicawebservice.domain.userInfo.Tuserreg;
import com.clinicawebservice.mapper.userinfoMapper.TuserRegMapImp;
import com.clinicawebservice.mapper.userinfoMapper.TuserRegMaper;
import com.clinicawebservice.voData.userinfoDTO.TuserregDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class TusuarioRegsImpl implements TusuarioRegDAO {

    private static Logger log = LogManager.getRootLogger();

    @PersistenceContext(unitName = "PoolDatosClinica")
    EntityManager entityManager;

    @Inject
    private TuserRegMaper tusuarioregMapper;

    /**
     * METODO QUE LISTA USUARIOS DE BD
     *
     * @return UN List<TusuarioregDto> si encuentra datos
     * @return null, si sucede un error
     *
     *
     * */
    @Override
    public List<TuserregDto> listUsersRegs() {
        List<TuserregDto> usersRegsDTOs=new ArrayList<>();;
        log.debug("STARTING USER SEARCH");
        try{

            List<Tuserreg> tusuarioregList=  entityManager.createNamedQuery("Tusuarioreg.listAll").getResultList();
            tusuarioregList.forEach(tusuarioreg -> {
                usersRegsDTOs.add(tusuarioregMapper.tusuarioregToTusuarioregDto(tusuarioreg));
            });

        }catch ( RuntimeException exception){
            log.error("DATA SEARCH ERROR: "+exception.getMessage());
            exception.printStackTrace(System.out);

            return null;
        }
        return usersRegsDTOs;
    }

    /**
     *METHOD THAT LOOKS FOR A SPECIFIC USER BY ID
     * @param tusuarioregDto receives an object of type TusuarioregDto
     * @return TusuarioregDto if it finds the searched record
     * @return null, if an error occurs
     */
    @Override
    public TuserregDto searchUsersRegsById(TuserregDto tusuarioregDto) {
        TuserregDto tusuarioregDtoReturn=null;
        log.debug("START USER SEARCH BY ID");
        try {
            Tuserreg tusuarioreg1 = entityManager.find(Tuserreg.class, tusuarioregDto.getId());
            log.debug(tusuarioreg1);
            tusuarioregDtoReturn = tusuarioregMapper.tusuarioregToTusuarioregDto(tusuarioreg1);

        } catch (RuntimeException exception) {
            exception.getCause().printStackTrace(System.out);
            log.debug("SEARCH ERROR: " + exception.getMessage());
            return  null;
        }
        return tusuarioregDtoReturn;
    }

    @Override
    public TuserregDto validateCredencial(TuserregDto tuserregDto) {
        TuserregDto userValidate=null;
        log.debug("START VALIDATION");
        try {
            Tuserreg tuserreg=null;
             tuserreg=entityManager.createNamedQuery("tuserReg.validate",Tuserreg.class).
                    setParameter("idenCard",tuserregDto.getIdenCard()).setParameter("pass",tuserregDto.getPass()).getSingleResult();

            if (tuserreg!=null){
                userValidate=this.tusuarioregMapper.tusuarioregToTusuarioregDto(tuserreg);
            }
            log.error("SUCCESS VALIDATE");
        }catch (RuntimeException runtimeException){
            log.error("ERROR VALIDATE: "+runtimeException.getCause());
            runtimeException.printStackTrace(System.out);
            return null;
        }

        return userValidate;
    }


    /**
     *
     * INSERTS DATA OF A USER TO THE DATABASE
     * @param tusuarioregDto
     * @return boolean
     * */
    @Override
    public boolean insertUsersRegs(TuserregDto tusuarioregDto) {
        boolean validate=false;
        try {
            Tuserreg tusuarioreg1=tusuarioregMapper.tusuarioregDtoToTusuarioreg(tusuarioregDto);
            entityManager.persist(tusuarioreg1);
            entityManager.flush(); //VERIFICAR QUE LOS DATOS FUERON INSERTADOS
            entityManager.refresh(tusuarioreg1); //VERIFICA QUE EL INDETIFCADOR SE CARGO A LA CLASE
            validate=true;
        }catch (PersistenceException exception){
                exception.printStackTrace(System.out);
                log.error("ERROR EN INSERCION DE DATOS: "+ exception.getMessage());
            return false;
        }
        return validate;
    }

    /**
     *UPDATE THE VALUES OF A SPECIFIC USER
     *
     * @param tusuarioregDto
     * @return boolean
     *
     * */
    @Override
    public boolean updateUserReg(TuserregDto tusuarioregDto) {

        boolean validate=false;
        log.debug("STARTING UPDATE");

        try{
            Tuserreg tusuarioreg=tusuarioregMapper.tusuarioregDtoToTusuarioreg(tusuarioregDto);
            entityManager.merge(tusuarioreg);
            validate=true;
            log.debug("SUCCESSFUL UPGRADE");
        }catch (RuntimeException e){
            e.printStackTrace(System.out);
            log.error("ERROR UPDATING: "+e.getMessage());
        }

        return validate;
    }

    /**
     *ELIMINATES USER TYPE INDICATED
     * @param tusuarioregDto
     * @return boolean
     *
     * */
   @Override
    public boolean deleteUserReg(TuserregDto tusuarioregDto) {
        boolean validate=false;
        log.debug("START OF REMOVAL");
        try{
            Tuserreg tusuarioreg=tusuarioregMapper.tusuarioregDtoToTusuarioreg(tusuarioregDto);
            entityManager.remove(entityManager.merge(tusuarioreg));
            validate=true;
            log.debug("SUCCESSFUL REMOVAL");
        }catch (RuntimeException e){
            e.printStackTrace(System.out);
            log.error("ERROR REMOVE: "+e.getMessage());
        }

        return validate;
    }


}
