package com.clinicawebservice.mapper.userinfoMapper;

import com.clinicawebservice.domain.address.Taddress;
import com.clinicawebservice.domain.userInfo.Tuserreg;
import com.clinicawebservice.voData.userinfoDTO.TuserregDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Date;

public class TuserRegMapImp implements TuserRegMaper {

    private static Logger log = LogManager.getRootLogger();

    @Override
    public Tuserreg tusuarioregDtoToTusuarioreg(TuserregDto tuserregDto) {
        if ( tuserregDto == null ) {
            return null;
        }

        Tuserreg tusuarioreg = new Tuserreg();

        tusuarioreg.setIdAddress( (tuserregDto.getIdAddressId()==null)?null:new Taddress(tuserregDto.getIdAddressId()) );
        tusuarioreg.setId( tuserregDto.getId() );
        tusuarioreg.setIdenCard( tuserregDto.getIdenCard() );
        tusuarioreg.setnameUser( tuserregDto.getNameUser() );
        tusuarioreg.setLastName( tuserregDto.getLastName() );
        tusuarioreg.setContact( tuserregDto.getContact() );
        tusuarioreg.setEmail( tuserregDto.getEmail() );
        tusuarioreg.setPassword( tuserregDto.getPass() );
        tusuarioreg.setFechaCreacion( tuserregDto.getFechaCreacion() );

        return tusuarioreg;
    }

    @Override
    public TuserregDto tusuarioregToTusuarioregDto(Tuserreg tuserreg) {
        if ( tuserreg == null ) {
            return null;
        }

        Long addressIdAddress = null;
        Long idUser = null;
        String idenCard = null;
        String name = null;
        String lastName = null;
        String contact = null;
        String email = null;
        String password = null;
        Date fechaCreacion = null;
        //log.debug(tuserreg.getIdAddress().getId());
        //if(!tuserreg.getIdAddress().equals(null)) {
            addressIdAddress = (tuserreg.getIdAddress()==null)?null:tuserreg.getIdAddress().getId();
        //}
        idUser = tuserreg.getId();
        idenCard = tuserreg.getIdenCard();
        name = tuserreg.getnameUser();
        lastName = tuserreg.getLastName();
        contact = tuserreg.getContact();
        email = tuserreg.getEmail();
        password = tuserreg.getPassword();
        fechaCreacion = tuserreg.getFechaCreacion();

        TuserregDto tusuarioregDto = new TuserregDto( idUser, idenCard, name, lastName, addressIdAddress, contact, email, password, fechaCreacion );

        return tusuarioregDto;
    }

}
