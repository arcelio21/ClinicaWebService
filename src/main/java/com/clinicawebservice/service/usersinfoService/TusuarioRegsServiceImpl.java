package com.clinicawebservice.service.usersinfoService;

import com.clinicawebservice.daoData.userInfoDAO.TusuarioRegDAO;
import com.clinicawebservice.voData.userinfoDTO.TuserregDto;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;
import java.util.List;

@Stateless(mappedName = "ejb/TusuarioRegsService")
@WebService(endpointInterface = "com.clinicawebservice.service.usersinfoService.TusuarioRegsService")
public class TusuarioRegsServiceImpl implements TusuarioRegsService{


    @Inject
    private TusuarioRegDAO tusuarioRegDAO;

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
        return this.tusuarioRegDAO.listUsersRegs();
    }

    /**
     *METHOD THAT LOOKS FOR A SPECIFIC USER BY ID
     * @param tusuarioregDto receives an object of type TusuarioregDto
     * @return TusuarioregDto if it finds the searched record
     * @return null, if an error occurs
     */
    @Override
    public TuserregDto searchUsersRegsById(TuserregDto tusuarioregDto) {
        return this.tusuarioRegDAO.searchUsersRegsById(tusuarioregDto);
    }

    @Override
    public TuserregDto validateCredencial(TuserregDto tuserregDto) {
        return this.tusuarioRegDAO.validateCredencial(tuserregDto);
    }

    /**
     *
     * INSERTS DATA OF A USER TO THE DATABASE
     * @param tusuarioregDto
     * @return boolean
     * */
    @Override
    public boolean insertUsersRegs(TuserregDto tusuarioregDto) {
        return this.tusuarioRegDAO.insertUsersRegs(tusuarioregDto);
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
        return this.tusuarioRegDAO.updateUserReg(tusuarioregDto);
    }

    /**
     *ELIMINATES USER TYPE INDICATED
     * @param tusuarioregDto
     * @return boolean
     *
     * */
    @Override
    public boolean deleteUserReg(TuserregDto tusuarioregDto) {
        return this.tusuarioRegDAO.deleteUserReg(tusuarioregDto);
    }
}
