package com.clinicawebservice.mapper.statusMapper;

import com.clinicawebservice.domain.status.Tstatus;
import com.clinicawebservice.voData.statusDTO.TstatusDto;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-25T12:34:58-0500",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.12 (Oracle Corporation)"
)
public class TstatusMapperImpl implements TstatusMapper {

    @Override
    public Tstatus tstatusDtoToTstatus(TstatusDto tstatusDto) {
        if ( tstatusDto == null ) {
            return null;
        }

        Tstatus tstatus = new Tstatus();

        tstatus.setId( tstatusDto.getId() );
        tstatus.setNameStatus( tstatusDto.getNameStatus() );

        return tstatus;
    }

    @Override
    public TstatusDto tstatusToTstatusDto(Tstatus tstatus) {
        if ( tstatus == null ) {
            return null;
        }

        TstatusDto tstatusDto = new TstatusDto();

        tstatusDto.setId( tstatus.getId() );
        tstatusDto.setNameStatus( tstatus.getNameStatus() );

        tstatusDto.setTuserTypeRegIds( tuserTypeRegsToTuserTypeRegIds(tstatus.getTuserTypeRegs()) );
        tstatusDto.setTtypeUserIds( ttypeUsersToTtypeUserIds(tstatus.getTtypeUsers()) );

        return tstatusDto;
    }

    @Override
    public void updateTstatusFromTstatusDto(TstatusDto tstatusDto, Tstatus tstatus) {
        if ( tstatusDto == null ) {
            return;
        }

        if ( tstatusDto.getId() != null ) {
            tstatus.setId( tstatusDto.getId() );
        }
        if ( tstatusDto.getNameStatus() != null ) {
            tstatus.setNameStatus( tstatusDto.getNameStatus() );
        }
    }
}
