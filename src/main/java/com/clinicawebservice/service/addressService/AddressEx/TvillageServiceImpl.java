package com.clinicawebservice.service.addressService.AddressEx;


import com.clinicawebservice.daoData.addressDAO.addressEx.TvillageDAO;
import com.clinicawebservice.voData.addressDTO.exaddressDTO.TvillageDto;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;
import java.util.List;
@Stateless(mappedName = "ejb/villageService")
@WebService(endpointInterface = "com.clinicawebservice.service.addressService.AddressEx.TvillageService")
public class TvillageServiceImpl implements TvillageService {

    @Inject
    private TvillageDAO tvillageDAO;
    /**
     * METODO DE QUE LISTA TODOS LOS CORREGIMIENTOS DISPONIBLES
     *
     * @return List<TvillageDto>
     */
    @Override
    public List<TvillageDto> listVillages() {
        return this.tvillageDAO.listVillages();
    }

    /**
     * METODO QUE REALIZA BUSQUEDA DE CORREGIMIENTO POR SU ID
     *
     * @param tvillageDto
     * @return TvillageDto
     */
    @Override
    public TvillageDto searchVillageById(TvillageDto tvillageDto) {
        return this.tvillageDAO.searchVillageById(tvillageDto);
    }

    /**
     * METODO QUE INSERTA NUEVO CORREGIMIENTO
     *
     * @param tvillageDto
     * @return boolean
     */
    @Override
    public boolean insertVillage(TvillageDto tvillageDto) {
        return this.tvillageDAO.insertVillage(tvillageDto);
    }

    /**
     * METODO QUE ACTUALIZA INFORMACION DE UN CORREGIMIENTO EN ESPECIFICO
     *
     * @param tvillageDto
     * @return boolean
     */
    @Override
    public boolean updateVillage(TvillageDto tvillageDto) {
        return this.tvillageDAO.updateVillage(tvillageDto);
    }

    /**
     * METODO QUE ELIMINA DATOS DE UN CORREGIMIENTO EN ESPECIFICO
     *
     * @param tvillageDto
     * @return boolean
     */
    @Override
    public boolean deleteProvince(TvillageDto tvillageDto) {
        return this.tvillageDAO.deleteProvince(tvillageDto);
    }
}
