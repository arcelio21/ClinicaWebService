package com.clinicawebservice.daoData.statusDAO;

import com.clinicawebservice.voData.statusDTO.TstatusDto;

import java.util.List;

public interface TstatusDAO {

    /**
     * METODO QUE LISTA TODOS LOS TIPOS DE ESTADOS EXISTENTES
     * @return List<TstatusDTO>
     */
    List<TstatusDto> listStatus();

    /**
     * METODO QUE REALIZA BUSQUEDA DE UN ESTADO POR SU ID
     * @param tstatusDto
     * @return TstatusDto
     */
    TstatusDto searchStatusById(TstatusDto tstatusDto);

    /**
     * METODO QUE INSERTA UN NUEVO TIPO DE ESTADO
     * @param tstatusDto
     * @return boolean
     */
    boolean insertStatus(TstatusDto tstatusDto);

    /**
     * METODO QUE ACTUALIZA LOS VALORES DE UN ESTADO
     * @param tstatusDto
     * @return boolean
     */
    boolean updateStatus(TstatusDto tstatusDto);

    /**
     * METODO QUE ELIMINA UN ESTADO EN ESPECIFICO
     * @param tstatusDto
     * @return boolean
     */
    boolean deleteStatus(TstatusDto tstatusDto);

}
