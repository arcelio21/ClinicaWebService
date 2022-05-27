package com.clinicawebservice.daoData.userInfoDAO;

import com.clinicawebservice.voData.userinfoDTO.TuserregDto;

import java.util.List;

public interface TusuarioRegDAO {

    public List<TuserregDto> listUsersRegs();

    public TuserregDto searchUsersRegsById(TuserregDto tusuarioregDto);

    public TuserregDto validateCredencial( TuserregDto tuserregDto);

    public boolean insertUsersRegs(TuserregDto tusuarioregDto);

    public boolean updateUserReg(TuserregDto tusuarioregDto);

    public boolean deleteUserReg(TuserregDto tusuarioregDto);

}
