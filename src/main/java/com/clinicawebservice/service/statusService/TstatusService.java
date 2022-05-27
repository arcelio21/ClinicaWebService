package com.clinicawebservice.service.statusService;


import com.clinicawebservice.voData.statusDTO.TstatusDto;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService(serviceName = "TstatusServiceJAX")
public interface TstatusService {

    /**
     * METODO QUE LISTA TODOS LOS TIPOS DE ESTADOS EXISTENTES
     * @return List<TstatusDTO>
     */
    @WebMethod(operationName = "LIST_ALL_STATUS")
    List<TstatusDto> listStatus();

    /**
     * METODO QUE REALIZA BUSQUEDA DE UN ESTADO POR SU ID
     * @param tstatusDto
     * @return TstatusDto
     */
    @WebMethod(operationName = "SEARCH_STATUS")
    TstatusDto searchStatusById(TstatusDto tstatusDto);

    /**
     * METODO QUE INSERTA UN NUEVO TIPO DE ESTADO
     * @param tstatusDto
     * @return boolean
     */
    @WebMethod(operationName = "INSERT_STATUS")
    boolean insertStatus(TstatusDto tstatusDto);

    /**
     * METODO QUE ACTUALIZA LOS VALORES DE UN ESTADO
     * @param tstatusDto
     * @return boolean
     */
    @WebMethod(operationName = "UPDATE_STATUS")
    boolean updateStatus(TstatusDto tstatusDto);

    /**
     * METODO QUE ELIMINA UN ESTADO EN ESPECIFICO
     * @param tstatusDto
     * @return boolean
     */
    @WebMethod(operationName = "DELETE_STATUS")
    boolean deleteStatus(TstatusDto tstatusDto);

}
