package com.clinicawebservice.service.usersinfoService;


import com.clinicawebservice.voData.userinfoDTO.TuserregDto;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService(serviceName = "TusuarioRegJAX")
public interface TusuarioRegsService {

    @WebMethod
    public List<TuserregDto> listUsersRegs();

    @WebMethod(operationName = "Search_Usuarios")
    public TuserregDto searchUsersRegsById(@WebParam(name = "Usuario") TuserregDto tusuarioregDto);

    @WebMethod
    TuserregDto validateCredencial( TuserregDto tuserregDto);

    @WebMethod
    public boolean insertUsersRegs(TuserregDto tusuarioregDto);

    @WebMethod
    public boolean updateUserReg(TuserregDto tusuarioregDto);

    @WebMethod
    public boolean deleteUserReg(TuserregDto tusuarioregDto);
}
