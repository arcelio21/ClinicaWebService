package com.clinicawebservice.daoData.addressDAO;


import com.clinicawebservice.voData.addressDTO.TaddressDto;

import java.util.List;

public interface TaddressDAO {

    /**
     * METODO QUE LISTA TODO LOS ADDRESS QUE EXISTEN
     * @return List<TaddressDTO>
     */
    List<TaddressDto> listAddress();

    /**
     * METODO QUE REALIZA BUSQUEDA DE ADDRESS ESPECIFICO
     * @param taddressDto
     * @return TaddressDTO
     */
    TaddressDto searchAddressById(TaddressDto taddressDto);

    /**
     * METODO PARA INSERTAR ADDRESS
     * @param taddressDto
     * @return boolean
     */
    boolean insertAddress(TaddressDto taddressDto);

    /**
     * METODO PARA ACTUALIZAR DATOS DE ADDRESS
     * @param taddressDto
     * @return boolean
     */
    boolean updateAddress(TaddressDto taddressDto);

    /**
     * METODO QUE ELIMINA UA REGISTRO DE ADDRESS
     * @param taddressDto
     * @return boolean
     */
    boolean deleteAddress(TaddressDto taddressDto);
}
