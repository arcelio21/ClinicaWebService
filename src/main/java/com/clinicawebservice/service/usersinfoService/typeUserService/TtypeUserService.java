package com.clinicawebservice.service.usersinfoService.typeUserService;

import com.clinicawebservice.voData.userinfoDTO.typeuserDTO.TtypeUserDto;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService(serviceName = "TtypeUserJAX")
public interface TtypeUserService {

    @WebMethod
    List<TtypeUserDto> listTypeUser();

    @WebMethod
    TtypeUserDto searchTypeUserById(TtypeUserDto ttypeUserDto);

    @WebMethod
    boolean insertTypeUser(TtypeUserDto ttypeUserDto);

    @WebMethod
    boolean updateTypeUser(TtypeUserDto ttypeUserDto);

    @WebMethod
    boolean deleteTypeUser(TtypeUserDto ttypeUserDto);
}
