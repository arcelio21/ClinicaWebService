package com.clinicawebservice.mapper.addressMapper.exaddressMapper;

import com.clinicawebservice.domain.address.exaddress.Tdistrict;
import com.clinicawebservice.domain.address.exaddress.Tvillage;
import com.clinicawebservice.voData.addressDTO.exaddressDTO.TvillageDto;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-25T12:34:58-0500",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.12 (Oracle Corporation)"
)
public class TvillageMapperImpl implements TvillageMapper {

    @Override
    public Tvillage tvillageDtoToTvillage(TvillageDto tvillageDto) {
        if ( tvillageDto == null ) {
            return null;
        }

        Tvillage tvillage = new Tvillage();

        tvillage.setIdDistrict( tvillageDtoToTdistrict( tvillageDto ) );
        tvillage.setId( tvillageDto.getId() );
        tvillage.setNameVillage( tvillageDto.getNameVillage() );

        return tvillage;
    }

    @Override
    public TvillageDto tvillageToTvillageDto(Tvillage tvillage) {
        if ( tvillage == null ) {
            return null;
        }

        TvillageDto tvillageDto = new TvillageDto();

        tvillageDto.setIdDistrictId( tvillageIdDistrictId( tvillage ) );
        tvillageDto.setId( tvillage.getId() );
        tvillageDto.setNameVillage( tvillage.getNameVillage() );

        return tvillageDto;
    }

    @Override
    public void updateTvillageFromTvillageDto(TvillageDto tvillageDto, Tvillage tvillage) {
        if ( tvillageDto == null ) {
            return;
        }

        if ( tvillage.getIdDistrict() == null ) {
            tvillage.setIdDistrict( new Tdistrict() );
        }
        tvillageDtoToTdistrict1( tvillageDto, tvillage.getIdDistrict() );
        if ( tvillageDto.getId() != null ) {
            tvillage.setId( tvillageDto.getId() );
        }
        if ( tvillageDto.getNameVillage() != null ) {
            tvillage.setNameVillage( tvillageDto.getNameVillage() );
        }
    }

    protected Tdistrict tvillageDtoToTdistrict(TvillageDto tvillageDto) {
        if ( tvillageDto == null ) {
            return null;
        }

        Tdistrict tdistrict = new Tdistrict();

        tdistrict.setId( tvillageDto.getIdDistrictId() );

        return tdistrict;
    }

    private Integer tvillageIdDistrictId(Tvillage tvillage) {
        if ( tvillage == null ) {
            return null;
        }
        Tdistrict idDistrict = tvillage.getIdDistrict();
        if ( idDistrict == null ) {
            return null;
        }
        Integer id = idDistrict.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected void tvillageDtoToTdistrict1(TvillageDto tvillageDto, Tdistrict mappingTarget) {
        if ( tvillageDto == null ) {
            return;
        }

        if ( tvillageDto.getIdDistrictId() != null ) {
            mappingTarget.setId( tvillageDto.getIdDistrictId() );
        }
    }
}
