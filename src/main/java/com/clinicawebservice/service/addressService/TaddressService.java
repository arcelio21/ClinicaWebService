package com.clinicawebservice.service.addressService;


import com.clinicawebservice.voData.addressDTO.TaddressDto;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService(serviceName = "AddressJAX")
public interface TaddressService {

    /**
     * METODO QUE LISTA TODO LOS ADDRESS QUE EXISTEN
     * @return List<TaddressDTO>
     */
    @WebMethod
    List<TaddressDto> listAddress();

    /**
     * METODO QUE REALIZA BUSQUEDA DE ADDRESS ESPECIFICO
     * @param taddressDto
     * @return TaddressDTO
     */
    @WebMethod
    TaddressDto searchAddressById(TaddressDto taddressDto);

    /**
     * METODO PARA INSERTAR ADDRESS
     * @param taddressDto
     * @return boolean
     */
    @WebMethod
    boolean insertAddress(TaddressDto taddressDto);

    /**
     * METODO PARA ACTUALIZAR DATOS DE ADDRESS
     * @param taddressDto
     * @return boolean
     */
    @WebMethod
    boolean updateAddress(TaddressDto taddressDto);

    /**
     * METODO QUE ELIMINA UA REGISTRO DE ADDRESS
     * @param taddressDto
     * @return boolean
     */
    @WebMethod
    boolean deleteAddress(TaddressDto taddressDto);
}
