package com.clinicawebservice.service.usersinfoService.typeUserService;


import com.clinicawebservice.voData.userinfoDTO.typeuserDTO.TuserTypeRegDto;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService(serviceName = "TuserTypeRegsJAX")
public interface TuserTypeRegsService {

    /**
     * METODO DEVUELVE UNA LISTA CON DATOS CON CADA TIPO DE USUARIO POR USUARIO
     *
     * @return List<TuserTypeRegsDto>
     */
    @WebMethod(operationName = "LIST_USER_TYPE_REGS")
    List<TuserTypeRegDto> listUserTypeRegs();

    /**
     * METODO QUE DEVUELVE UN OBJETO CON DATOS DE UN TIPO DE USUARIO ASIGNADO A UN USUARIO
     * @param tuserTypeRegsDto
     * @return TuserTypeRegsDto
     */
    @WebMethod(operationName = "SEARCH_USER_TYPE_REGS")
    TuserTypeRegDto searchUserTypeRegById(TuserTypeRegDto tuserTypeRegsDto);

    /**
     * METODO QUE INSERTA UN TIPO DE USUARIO ASIGNADO A UN USUARIO
     * @param tuserTypeRegsDto
     * @return boolean
     */
    @WebMethod(operationName = "INSERT_USER_TYPE_REGS")
    boolean insertUserTypeReg(TuserTypeRegDto tuserTypeRegsDto);

    /**
     * METDDO QUE ACTUALIZA DATOS DE UN REGISTRO DE TIPO DE USUARIO ASIGNADO A UN USUARIO
     * @param tuserTypeRegsDto
     * @return boolean
     */
    @WebMethod(operationName = "UPDATE_USER_TYPE_REGS")
    boolean updateUserTypeReg(TuserTypeRegDto tuserTypeRegsDto);

    /**
     * METODO DE ELIMINA UN REGISTRO DE TIPO DE USUARIO ASGINADO
     * @param tuserTypeRegsDto
     * @return boolean
     */
    @WebMethod(operationName = "DELETE_USER_TYPE_REG")
    boolean deleteUserTypeReg(TuserTypeRegDto tuserTypeRegsDto);
}
