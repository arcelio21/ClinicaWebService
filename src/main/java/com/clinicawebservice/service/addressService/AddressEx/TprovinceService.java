package com.clinicawebservice.service.addressService.AddressEx;

import com.clinicawebservice.voData.addressDTO.exaddressDTO.TprovinceDto;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService(serviceName = "provinceJAX")
public interface TprovinceService {
    /**
     * METODO DE QUE LISTA TODAS LAS PROVINCIAS DISPONIBLES
     * @return List<TprovinceDto>
     */
    @WebMethod
    List<TprovinceDto> listProvinces();

    /**
     * METODO QUE REALIZA BUSQUEDA DE PROVINCIA POR SU ID
     * @param tprovinceDto
     * @return TprovinceDto
     */
    @WebMethod
    TprovinceDto searchProvinceById(TprovinceDto tprovinceDto);

    /**
     * METODO QUE INSERTA NUEVA PROVINCIA
     * @param tprovinceDto
     * @return boolean
     */
    @WebMethod
    boolean insertProvince(TprovinceDto tprovinceDto);

    /**
     * METODO QUE ACTAULIZA INFORMACION DE UNA PROVINCIA EN ESPECIFICO
     * @param tprovinceDto
     * @return boolean
     */
    @WebMethod
    boolean updateProvince(TprovinceDto tprovinceDto);

    /**
     * METODO QUE ELIMINA DATOS DE UNA PROVINCIA EN ESPECIFICO
     * @param tprovinceDto
     * @return
     */
    @WebMethod
    boolean deleteProvince(TprovinceDto tprovinceDto);
}
