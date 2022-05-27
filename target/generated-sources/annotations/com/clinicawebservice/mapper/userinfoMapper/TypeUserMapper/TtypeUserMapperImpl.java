package com.clinicawebservice.mapper.userinfoMapper.TypeUserMapper;

import com.clinicawebservice.domain.status.Tstatus;
import com.clinicawebservice.domain.userInfo.infotypeuser.TtypeUser;
import com.clinicawebservice.voData.userinfoDTO.typeuserDTO.TtypeUserDto;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-25T12:34:58-0500",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.12 (Oracle Corporation)"
)
public class TtypeUserMapperImpl implements TtypeUserMapper {

    @Override
    public TtypeUser ttypeUserDtoToTtypeUser(TtypeUserDto ttypeUserDto) {
        if ( ttypeUserDto == null ) {
            return null;
        }

        TtypeUser ttypeUser = new TtypeUser();

        ttypeUser.setIdStatus( ttypeUserDtoToTstatus( ttypeUserDto ) );
        ttypeUser.setId( ttypeUserDto.getId() );
        ttypeUser.setNameTypeUser( ttypeUserDto.getNameTypeUser() );

        return ttypeUser;
    }

    @Override
    public TtypeUserDto ttypeUserToTtypeUserDto(TtypeUser ttypeUser) {
        if ( ttypeUser == null ) {
            return null;
        }

        TtypeUserDto ttypeUserDto = new TtypeUserDto();

        ttypeUserDto.setIdStatusId( ttypeUserIdStatusId( ttypeUser ) );
        ttypeUserDto.setId( ttypeUser.getId() );
        ttypeUserDto.setNameTypeUser( ttypeUser.getNameTypeUser() );

        return ttypeUserDto;
    }

    @Override
    public void updateTtypeUserFromTtypeUserDto(TtypeUserDto ttypeUserDto, TtypeUser ttypeUser) {
        if ( ttypeUserDto == null ) {
            return;
        }

        if ( ttypeUser.getIdStatus() == null ) {
            ttypeUser.setIdStatus( new Tstatus() );
        }
        ttypeUserDtoToTstatus1( ttypeUserDto, ttypeUser.getIdStatus() );
        if ( ttypeUserDto.getId() != null ) {
            ttypeUser.setId( ttypeUserDto.getId() );
        }
        if ( ttypeUserDto.getNameTypeUser() != null ) {
            ttypeUser.setNameTypeUser( ttypeUserDto.getNameTypeUser() );
        }
    }

    protected Tstatus ttypeUserDtoToTstatus(TtypeUserDto ttypeUserDto) {
        if ( ttypeUserDto == null ) {
            return null;
        }

        Tstatus tstatus = new Tstatus();

        tstatus.setId( ttypeUserDto.getIdStatusId() );

        return tstatus;
    }

    private Integer ttypeUserIdStatusId(TtypeUser ttypeUser) {
        if ( ttypeUser == null ) {
            return null;
        }
        Tstatus idStatus = ttypeUser.getIdStatus();
        if ( idStatus == null ) {
            return null;
        }
        Integer id = idStatus.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected void ttypeUserDtoToTstatus1(TtypeUserDto ttypeUserDto, Tstatus mappingTarget) {
        if ( ttypeUserDto == null ) {
            return;
        }

        if ( ttypeUserDto.getIdStatusId() != null ) {
            mappingTarget.setId( ttypeUserDto.getIdStatusId() );
        }
    }
}
