package com.clinicawebservice.mapper.userinfoMapper.TypeUserMapper;

import com.clinicawebservice.domain.status.Tstatus;
import com.clinicawebservice.domain.userInfo.Tuserreg;
import com.clinicawebservice.domain.userInfo.infotypeuser.TtypeUser;
import com.clinicawebservice.domain.userInfo.infotypeuser.TuserTypeReg;
import com.clinicawebservice.voData.userinfoDTO.typeuserDTO.TuserTypeRegDto;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-25T12:34:58-0500",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.12 (Oracle Corporation)"
)
public class TuserTypeRegMapperImpl implements TuserTypeRegMapper {

    @Override
    public TuserTypeReg tuserTypeRegDtoToTuserTypeReg(TuserTypeRegDto tuserTypeRegDto) {
        if ( tuserTypeRegDto == null ) {
            return null;
        }

        TuserTypeReg tuserTypeReg = new TuserTypeReg();

        tuserTypeReg.setIdUserReg( tuserTypeRegDtoToTuserreg( tuserTypeRegDto ) );
        tuserTypeReg.setIdTypeUser( tuserTypeRegDtoToTtypeUser( tuserTypeRegDto ) );
        tuserTypeReg.setIdStatus( tuserTypeRegDtoToTstatus( tuserTypeRegDto ) );
        tuserTypeReg.setId( tuserTypeRegDto.getId() );

        return tuserTypeReg;
    }

    @Override
    public TuserTypeRegDto tuserTypeRegToTuserTypeRegDto(TuserTypeReg tuserTypeReg) {
        if ( tuserTypeReg == null ) {
            return null;
        }

        TuserTypeRegDto tuserTypeRegDto = new TuserTypeRegDto();

        tuserTypeRegDto.setIdUserRegId( tuserTypeRegIdUserRegId( tuserTypeReg ) );
        tuserTypeRegDto.setIdTypeUserId( tuserTypeRegIdTypeUserId( tuserTypeReg ) );
        tuserTypeRegDto.setIdStatusId( tuserTypeRegIdStatusId( tuserTypeReg ) );
        tuserTypeRegDto.setId( tuserTypeReg.getId() );

        return tuserTypeRegDto;
    }

    @Override
    public void updateTuserTypeRegFromTuserTypeRegDto(TuserTypeRegDto tuserTypeRegDto, TuserTypeReg tuserTypeReg) {
        if ( tuserTypeRegDto == null ) {
            return;
        }

        if ( tuserTypeReg.getIdUserReg() == null ) {
            tuserTypeReg.setIdUserReg( new Tuserreg() );
        }
        tuserTypeRegDtoToTuserreg1( tuserTypeRegDto, tuserTypeReg.getIdUserReg() );
        if ( tuserTypeReg.getIdTypeUser() == null ) {
            tuserTypeReg.setIdTypeUser( new TtypeUser() );
        }
        tuserTypeRegDtoToTtypeUser1( tuserTypeRegDto, tuserTypeReg.getIdTypeUser() );
        if ( tuserTypeReg.getIdStatus() == null ) {
            tuserTypeReg.setIdStatus( new Tstatus() );
        }
        tuserTypeRegDtoToTstatus1( tuserTypeRegDto, tuserTypeReg.getIdStatus() );
        if ( tuserTypeRegDto.getId() != null ) {
            tuserTypeReg.setId( tuserTypeRegDto.getId() );
        }
    }

    protected Tuserreg tuserTypeRegDtoToTuserreg(TuserTypeRegDto tuserTypeRegDto) {
        if ( tuserTypeRegDto == null ) {
            return null;
        }

        Tuserreg tuserreg = new Tuserreg();

        tuserreg.setId( tuserTypeRegDto.getIdUserRegId() );

        return tuserreg;
    }

    protected TtypeUser tuserTypeRegDtoToTtypeUser(TuserTypeRegDto tuserTypeRegDto) {
        if ( tuserTypeRegDto == null ) {
            return null;
        }

        TtypeUser ttypeUser = new TtypeUser();

        ttypeUser.setId( tuserTypeRegDto.getIdTypeUserId() );

        return ttypeUser;
    }

    protected Tstatus tuserTypeRegDtoToTstatus(TuserTypeRegDto tuserTypeRegDto) {
        if ( tuserTypeRegDto == null ) {
            return null;
        }

        Tstatus tstatus = new Tstatus();

        tstatus.setId( tuserTypeRegDto.getIdStatusId() );

        return tstatus;
    }

    private Long tuserTypeRegIdUserRegId(TuserTypeReg tuserTypeReg) {
        if ( tuserTypeReg == null ) {
            return null;
        }
        Tuserreg idUserReg = tuserTypeReg.getIdUserReg();
        if ( idUserReg == null ) {
            return null;
        }
        Long id = idUserReg.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Integer tuserTypeRegIdTypeUserId(TuserTypeReg tuserTypeReg) {
        if ( tuserTypeReg == null ) {
            return null;
        }
        TtypeUser idTypeUser = tuserTypeReg.getIdTypeUser();
        if ( idTypeUser == null ) {
            return null;
        }
        Integer id = idTypeUser.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Integer tuserTypeRegIdStatusId(TuserTypeReg tuserTypeReg) {
        if ( tuserTypeReg == null ) {
            return null;
        }
        Tstatus idStatus = tuserTypeReg.getIdStatus();
        if ( idStatus == null ) {
            return null;
        }
        Integer id = idStatus.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected void tuserTypeRegDtoToTuserreg1(TuserTypeRegDto tuserTypeRegDto, Tuserreg mappingTarget) {
        if ( tuserTypeRegDto == null ) {
            return;
        }

        if ( tuserTypeRegDto.getIdUserRegId() != null ) {
            mappingTarget.setId( tuserTypeRegDto.getIdUserRegId() );
        }
    }

    protected void tuserTypeRegDtoToTtypeUser1(TuserTypeRegDto tuserTypeRegDto, TtypeUser mappingTarget) {
        if ( tuserTypeRegDto == null ) {
            return;
        }

        if ( tuserTypeRegDto.getIdTypeUserId() != null ) {
            mappingTarget.setId( tuserTypeRegDto.getIdTypeUserId() );
        }
    }

    protected void tuserTypeRegDtoToTstatus1(TuserTypeRegDto tuserTypeRegDto, Tstatus mappingTarget) {
        if ( tuserTypeRegDto == null ) {
            return;
        }

        if ( tuserTypeRegDto.getIdStatusId() != null ) {
            mappingTarget.setId( tuserTypeRegDto.getIdStatusId() );
        }
    }
}
