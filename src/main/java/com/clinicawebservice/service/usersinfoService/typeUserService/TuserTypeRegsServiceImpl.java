package com.clinicawebservice.service.usersinfoService.typeUserService;


import com.clinicawebservice.daoData.userInfoDAO.typeUserDAO.TuserTypeRegsDAO;
import com.clinicawebservice.voData.userinfoDTO.typeuserDTO.TuserTypeRegDto;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;
import java.util.List;

@Stateless(mappedName = "ejb/userTypeRegService")
@WebService(endpointInterface = "com.clinicawebservice.service.usersinfoService.typeUserService.TuserTypeRegsService")
public class TuserTypeRegsServiceImpl implements TuserTypeRegsService{

    @Inject
    private TuserTypeRegsDAO tuserTypeRegsDAO;

    /**
     * METODO DEVUELVE UNA LISTA CON DATOS CON CADA TIPO DE USUARIO POR USUARIO
     *
     * @return List<TuserTypeRegsDto>
     */
    @Override
    public List<TuserTypeRegDto> listUserTypeRegs() {
        return this.tuserTypeRegsDAO.listUserTypeRegs();
    }

    /**
     * METODO QUE DEVUELVE UN OBJETO CON DATOS DE UN TIPO DE USUARIO ASIGNADO A UN USUARIO
     *
     * @param tuserTypeRegsDto
     * @return TuserTypeRegsDto
     */
    @Override
    public TuserTypeRegDto searchUserTypeRegById(TuserTypeRegDto tuserTypeRegsDto) {
        return this.tuserTypeRegsDAO.searchUserTypeRegById(tuserTypeRegsDto);
    }

    /**
     * METODO QUE INSERTA UN TIPO DE USUARIO ASIGNADO A UN USUARIO
     *
     * @param tuserTypeRegsDto
     * @return boolean
     */
    @Override
    public boolean insertUserTypeReg(TuserTypeRegDto tuserTypeRegsDto) {
        return this.tuserTypeRegsDAO.insertUserTypeReg(tuserTypeRegsDto);
    }

    /**
     * METDDO QUE ACTUALIZA DATOS DE UN REGISTRO DE TIPO DE USUARIO ASIGNADO A UN USUARIO
     *
     * @param tuserTypeRegsDto
     * @return boolean
     */
    @Override
    public boolean updateUserTypeReg(TuserTypeRegDto tuserTypeRegsDto) {
        return this.tuserTypeRegsDAO.updateUserTypeReg(tuserTypeRegsDto);
    }

    /**
     * METODO DE ELIMINA UN REGISTRO DE TIPO DE USUARIO ASGINADO
     *
     * @param tuserTypeRegsDto
     * @return boolean
     */
    @Override
    public boolean deleteUserTypeReg(TuserTypeRegDto tuserTypeRegsDto) {
        return this.tuserTypeRegsDAO.deleteUserTypeReg(tuserTypeRegsDto);
    }
}
