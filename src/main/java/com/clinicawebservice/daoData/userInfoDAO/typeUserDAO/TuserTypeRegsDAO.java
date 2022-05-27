package com.clinicawebservice.daoData.userInfoDAO.typeUserDAO;


import com.clinicawebservice.voData.userinfoDTO.typeuserDTO.TuserTypeRegDto;

import java.util.List;

public interface TuserTypeRegsDAO {

    /**
     * METODO DEVUELVE UNA LISTA CON DATOS CON CADA TIPO DE USUARIO POR USUARIO
     *
     * @return List<TuserTypeRegsDto>
     */
    List<TuserTypeRegDto> listUserTypeRegs();

    /**
     * METODO QUE DEVUELVE UN OBJETO CON DATOS DE UN TIPO DE USUARIO ASIGNADO A UN USUARIO
     * @param tuserTypeRegsDto
     * @return TuserTypeRegsDto
     */
    TuserTypeRegDto searchUserTypeRegById(TuserTypeRegDto tuserTypeRegsDto);

    /**
     * METODO QUE INSERTA UN TIPO DE USUARIO ASIGNADO A UN USUARIO
     * @param tuserTypeRegsDto
     * @return boolean
     */
    boolean insertUserTypeReg(TuserTypeRegDto tuserTypeRegsDto);

    /**
     * METDDO QUE ACTUALIZA DATOS DE UN REGISTRO DE TIPO DE USUARIO ASIGNADO A UN USUARIO
     * @param tuserTypeRegsDto
     * @return boolean
     */
    boolean updateUserTypeReg(TuserTypeRegDto tuserTypeRegsDto);

    /**
     * METODO DE ELIMINA UN REGISTRO DE TIPO DE USUARIO ASGINADO
     * @param tuserTypeRegsDto
     * @return boolean
     */
    boolean deleteUserTypeReg(TuserTypeRegDto tuserTypeRegsDto);

}
