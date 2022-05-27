package com.clinicawebservice.daoData.addressDAO.addressEx;


import com.clinicawebservice.voData.addressDTO.exaddressDTO.TdistrictDto;

import java.util.List;

public interface TdistrictDAO {

    /**
     * METODO DE QUE LISTA TODAS LOS DISTRITOS DISPONIBLES
     * @return List<TdistrictDto>
     */
    List<TdistrictDto> listDistricts();

    /**
     * METODO QUE REALIZA BUSQUEDA DE DISTRITOS POR SU ID
     * @param tdistrictDto
     * @return TprovinceDto
     */
    TdistrictDto searchDistrictById(TdistrictDto tdistrictDto);

    /**
     * METODO QUE INSERTA NUEVA DISTRITO
     * @param tdistrictDto
     * @return boolean
     */
    boolean insertDistrict(TdistrictDto tdistrictDto);

    /**
     * METODO QUE ACTAULIZA INFORMACION DE UNA PROVINCIA EN ESPECIFICO
     * @param tdistrictDto
     * @return boolean
     */
    boolean updateDistrict(TdistrictDto tdistrictDto);

    /**
     * METODO QUE ELIMINA DATOS DE UNA PROVINCIA EN ESPECIFICO
     * @param tdistrictDto
     * @return
     */
    boolean deleteDistrict(TdistrictDto tdistrictDto);
}
