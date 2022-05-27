package com.clinicawebservice.service.addressService.AddressEx;


import com.clinicawebservice.voData.addressDTO.exaddressDTO.TdistrictDto;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService(serviceName = "DistrictJAX")
public interface TdistrictService {

    /**
     * METODO DE QUE LISTA TODAS LOS DISTRITOS DISPONIBLES
     * @return List<TdistrictDto>
     */
    @WebMethod
    List<TdistrictDto> listDistricts();

    /**
     * METODO QUE REALIZA BUSQUEDA DE DISTRITOS POR SU ID
     * @param tdistrictDto
     * @return TprovinceDto
     */
    @WebMethod
    TdistrictDto searchDistrictById(TdistrictDto tdistrictDto);

    /**
     * METODO QUE INSERTA NUEVA DISTRITO
     * @param tdistrictDto
     * @return boolean
     */
    @WebMethod
    boolean insertDistrict(TdistrictDto tdistrictDto);

    /**
     * METODO QUE ACTAULIZA INFORMACION DE UNA PROVINCIA EN ESPECIFICO
     * @param tdistrictDto
     * @return boolean
     */
    @WebMethod
    boolean updateDistrict(TdistrictDto tdistrictDto);

    /**
     * METODO QUE ELIMINA DATOS DE UNA PROVINCIA EN ESPECIFICO
     * @param tdistrictDto
     * @return
     */
    @WebMethod
    boolean deleteDistrict(TdistrictDto tdistrictDto);
}
