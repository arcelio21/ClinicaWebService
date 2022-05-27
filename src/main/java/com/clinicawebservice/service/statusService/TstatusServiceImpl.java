package com.clinicawebservice.service.statusService;


import com.clinicawebservice.daoData.statusDAO.TstatusDAO;
import com.clinicawebservice.voData.statusDTO.TstatusDto;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;
import java.util.List;

@Stateless(mappedName = "ejb/statusService")
@WebService(endpointInterface = "com.clinicawebservice.service.statusService.TstatusService")
public class TstatusServiceImpl implements TstatusService{

    @Inject
    private TstatusDAO tstatusDAO;

    /**
     * METODO QUE LISTA TODOS LOS TIPOS DE ESTADOS EXISTENTES
     *
     * @return List<TstatusDTO>
     */
    @Override
    public List<TstatusDto> listStatus() {
        return this.tstatusDAO.listStatus();
    }

    /**
     * METODO QUE REALIZA BUSQUEDA DE UN ESTADO POR SU ID
     *
     * @param tstatusDto
     * @return TstatusDto
     */
    @Override
    public TstatusDto searchStatusById(TstatusDto tstatusDto) {
        return this.tstatusDAO.searchStatusById(tstatusDto);
    }

    /**
     * METODO QUE INSERTA UN NUEVO TIPO DE ESTADO
     *
     * @param tstatusDto
     * @return boolean
     */
    @Override
    public boolean insertStatus(TstatusDto tstatusDto) {
        return this.tstatusDAO.insertStatus(tstatusDto);
    }

    /**
     * METODO QUE ACTUALIZA LOS VALORES DE UN ESTADO
     *
     * @param tstatusDto
     * @return boolean
     */
    @Override
    public boolean updateStatus(TstatusDto tstatusDto) {
        return this.tstatusDAO.updateStatus(tstatusDto);
    }

    /**
     * METODO QUE ELIMINA UN ESTADO EN ESPECIFICO
     *
     * @param tstatusDto
     * @return boolean
     */
    @Override
    public boolean deleteStatus(TstatusDto tstatusDto) {
        return this.tstatusDAO.deleteStatus(tstatusDto);
    }
}
