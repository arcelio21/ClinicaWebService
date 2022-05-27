package com.clinicawebservice.service.addressService;


import com.clinicawebservice.daoData.addressDAO.TaddressDAO;
import com.clinicawebservice.voData.addressDTO.TaddressDto;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;
import java.util.List;
@Stateless(mappedName = "ejb/addressService")
@WebService(endpointInterface = "com.clinicawebservice.service.addressService.TaddressService")
public class TaddressServiceImpl implements TaddressService{

    @Inject
    private TaddressDAO taddressDAO;
     /**
     * METODO QUE LISTA TODO LOS ADDRESS QUE EXISTEN
     *
     * @return List<TaddressDTO>
     */
    @Override
    public List<TaddressDto> listAddress() {
        return this.taddressDAO.listAddress();
    }

    /**
     * METODO QUE REALIZA BUSQUEDA DE ADDRESS ESPECIFICO
     *
     * @param taddressDto
     * @return TaddressDTO
     */
    @Override
    public TaddressDto searchAddressById(TaddressDto taddressDto) {
        return this.taddressDAO.searchAddressById(taddressDto);
    }

    /**
     * METODO PARA INSERTAR ADDRESS
     *
     * @param taddressDto
     * @return boolean
     */
    @Override
    public boolean insertAddress(TaddressDto taddressDto) {
        return this.taddressDAO.insertAddress(taddressDto);
    }

    /**
     * METODO PARA ACTUALIZAR DATOS DE ADDRESS
     *
     * @param taddressDto
     * @return boolean
     */
    @Override
    public boolean updateAddress(TaddressDto taddressDto) {
        return this.taddressDAO.updateAddress(taddressDto);
    }

    /**
     * METODO QUE ELIMINA UA REGISTRO DE ADDRESS
     *
     * @param taddressDto
     * @return boolean
     */
    @Override
    public boolean deleteAddress(TaddressDto taddressDto) {
        return this.taddressDAO.deleteAddress(taddressDto);
    }
}
