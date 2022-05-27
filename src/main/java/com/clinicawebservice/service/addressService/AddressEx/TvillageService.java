package com.clinicawebservice.service.addressService.AddressEx;

import com.clinicawebservice.voData.addressDTO.exaddressDTO.TvillageDto;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;
@WebService(serviceName = "villageService")
public interface TvillageService {

    /**
     * METODO DE QUE LISTA TODOS LOS CORREGIMIENTOS DISPONIBLES
     * @return List<TvillageDto>
     */
    @WebMethod
    List<TvillageDto> listVillages();

    /**
     * METODO QUE REALIZA BUSQUEDA DE CORREGIMIENTO POR SU ID
     * @param tvillageDto
     * @return TvillageDto
     */
    @WebMethod
    TvillageDto searchVillageById(TvillageDto tvillageDto);

    /**
     * METODO QUE INSERTA NUEVO CORREGIMIENTO
     * @param tvillageDto
     * @return boolean
     */
    @WebMethod
    boolean insertVillage(TvillageDto tvillageDto);

    /**
     * METODO QUE ACTUALIZA INFORMACION DE UN CORREGIMIENTO EN ESPECIFICO
     * @param tvillageDto
     * @return boolean
     */
    @WebMethod
    boolean updateVillage(TvillageDto tvillageDto);

    /**
     * METODO QUE ELIMINA DATOS DE UN CORREGIMIENTO EN ESPECIFICO
     * @param tvillageDto
     * @return boolean
     */
    @WebMethod
    boolean deleteProvince(TvillageDto tvillageDto);
}
