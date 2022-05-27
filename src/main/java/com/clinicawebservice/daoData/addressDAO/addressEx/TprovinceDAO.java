package com.clinicawebservice.daoData.addressDAO.addressEx;


import com.clinicawebservice.voData.addressDTO.exaddressDTO.TprovinceDto;

import java.util.List;

public interface TprovinceDAO {

    /**
     * METODO DE QUE LISTA TODAS LAS PROVINCIAS DISPONIBLES
     * @return List<TprovinceDto>
     */
    List<TprovinceDto> listProvinces();

    /**
     * METODO QUE REALIZA BUSQUEDA DE PROVINCIA POR SU ID
     * @param tprovinceDto
     * @return TprovinceDto
     */
    TprovinceDto searchProvinceById(TprovinceDto tprovinceDto);

    /**
     * METODO QUE INSERTA NUEVA PROVINCIA
     * @param tprovinceDto
     * @return boolean
     */
    boolean insertProvince(TprovinceDto tprovinceDto);

    /**
     * METODO QUE ACTAULIZA INFORMACION DE UNA PROVINCIA EN ESPECIFICO
     * @param tprovinceDto
     * @return boolean
     */
    boolean updateProvince(TprovinceDto tprovinceDto);

    /**
     * METODO QUE ELIMINA DATOS DE UNA PROVINCIA EN ESPECIFICO
     * @param tprovinceDto
     * @return
     */
    boolean deleteProvince(TprovinceDto tprovinceDto);
}
