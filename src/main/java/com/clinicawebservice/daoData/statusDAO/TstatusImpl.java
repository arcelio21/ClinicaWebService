package com.clinicawebservice.daoData.statusDAO;

import com.clinicawebservice.domain.status.Tstatus;
import com.clinicawebservice.mapper.statusMapper.TstatusMapper;
import com.clinicawebservice.voData.statusDTO.TstatusDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mapstruct.factory.Mappers;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class TstatusImpl implements TstatusDAO{

    private Logger log = LogManager.getRootLogger();

    TstatusMapper tstatusMapper= Mappers.getMapper(TstatusMapper.class);

    @PersistenceContext(unitName = "PoolDatosClinica")
    EntityManager entityManager;

    /**
     * METODO QUE LISTA TODOS LOS TIPOS DE ESTADOS EXISTENTES
     *
     * @return List<TstatusDTO>
     */
    @Override
    public List<TstatusDto> listStatus() {

        log.debug("START SEARCH ");
        List<TstatusDto> tstatusDtos=new ArrayList<>();
        try {
            List<Tstatus> tstatus=entityManager.createNamedQuery("Tstatus.listAll").getResultList();
            tstatus.forEach(tstatus1 -> {
                tstatusDtos.add(tstatusMapper.tstatusToTstatusDto(tstatus1));
            });

            log.debug("SUCCESS SEARCH");
        }catch (RuntimeException e){
            e.printStackTrace(System.out);
            log.error("ERROR SEARCH: "+e.getCause());
            return null;
        }

        return tstatusDtos;
    }

    /**
     * METODO QUE REALIZA BUSQUEDA DE UN ESTADO POR SU ID
     *
     * @param tstatusDto
     * @return TstatusDto
     */
    @Override
    public TstatusDto searchStatusById(TstatusDto tstatusDto) {

        log.debug("START SEARCH BY ID");
        TstatusDto tstatusDtoReturn=null;
        try {
            Tstatus tstatus=entityManager.find(Tstatus.class,tstatusDto.getId());
             tstatusDtoReturn=tstatusMapper.tstatusToTstatusDto(tstatus);
             log.debug("SEARCH SUCCESS");
        }catch (RuntimeException exception){
            exception.printStackTrace(System.out);
            log.error("ERROR SEARCH: "+exception.getCause());
            return null;
        }

        return tstatusDtoReturn;
    }

    /**
     * METODO QUE INSERTA UN NUEVO TIPO DE ESTADO
     *
     * @param tstatusDto
     * @return boolean
     */
    @Override
    public boolean insertStatus(TstatusDto tstatusDto) {

        log.debug("START INSERT");
        boolean validate=false;

        try {
            Tstatus tstatus=tstatusMapper.tstatusDtoToTstatus(tstatusDto);
            entityManager.persist(tstatus);
            entityManager.flush();
            entityManager.refresh(tstatus);
            validate=true;
            log.debug("SUCCESS INSERT");
        }catch (RuntimeException e){
            e.printStackTrace(System.out);
            log.error("ERROR INSERT: "+e.getCause());
            return false;
        }

        return validate;
    }

    /**
     * METODO QUE ACTUALIZA LOS VALORES DE UN ESTADO
     *
     * @param tstatusDto
     * @return boolean
     */
    @Override
    public boolean updateStatus(TstatusDto tstatusDto) {

        log.debug("START UPDATE");
        boolean validate=false;
        try {
            Tstatus tstatus=tstatusMapper.tstatusDtoToTstatus(tstatusDto);
            entityManager.merge(tstatus);
            validate=true;
            log.debug("SUCCESS UPDATE");
        }catch (RuntimeException e){
            e.printStackTrace(System.out);
            log.debug("ERROR SEARCH: "+e.getCause());
            return false;
        }

        return validate;
    }

    /**
     * METODO QUE ELIMINA UN ESTADO EN ESPECIFICO
     *
     * @param tstatusDto
     * @return boolean
     */
    @Override
    public boolean deleteStatus(TstatusDto tstatusDto) {

        log.debug("START DELETE");
        boolean validate=false;
        try {
            Tstatus tstatus=tstatusMapper.tstatusDtoToTstatus(tstatusDto);
            entityManager.remove(entityManager.merge(tstatus));
            log.debug("DELETE SUCCESS");
        }catch (RuntimeException exception){
            exception.printStackTrace(System.out);
            log.error("ERROR DELETE: "+exception.getCause());
            return false;
        }
        return false;
    }
}
