package com.clinicawebservice.daoData.addressDAO.addressEx;


import com.clinicawebservice.voData.addressDTO.exaddressDTO.TvillageDto;

import java.util.List;

public interface TvillageDAO {

    /**
     * METODO DE QUE LISTA TODOS LOS CORREGIMIENTOS DISPONIBLES
     * @return List<TvillageDto>
     */
    List<TvillageDto> listVillages();

    /**
     * METODO QUE REALIZA BUSQUEDA DE CORREGIMIENTO POR SU ID
     * @param tvillageDto
     * @return TvillageDto
     */
    TvillageDto searchVillageById(TvillageDto tvillageDto);

    /**
     * METODO QUE INSERTA NUEVO CORREGIMIENTO
     * @param tvillageDto
     * @return boolean
     */
    boolean insertVillage(TvillageDto tvillageDto);

    /**
     * METODO QUE ACTUALIZA INFORMACION DE UN CORREGIMIENTO EN ESPECIFICO
     * @param tvillageDto
     * @return boolean
     */
    boolean updateVillage(TvillageDto tvillageDto);

    /**
     * METODO QUE ELIMINA DATOS DE UN CORREGIMIENTO EN ESPECIFICO
     * @param tvillageDto
     * @return boolean
     */
    boolean deleteProvince(TvillageDto tvillageDto);
}
