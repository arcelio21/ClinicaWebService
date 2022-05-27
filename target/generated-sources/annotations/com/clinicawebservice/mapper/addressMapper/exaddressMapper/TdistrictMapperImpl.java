package com.clinicawebservice.mapper.addressMapper.exaddressMapper;

import com.clinicawebservice.domain.address.exaddress.Tdistrict;
import com.clinicawebservice.domain.address.exaddress.Tprovince;
import com.clinicawebservice.voData.addressDTO.exaddressDTO.TdistrictDto;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-25T12:34:58-0500",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.12 (Oracle Corporation)"
)
public class TdistrictMapperImpl implements TdistrictMapper {

    @Override
    public Tdistrict tdistrictDtoToTdistrict(TdistrictDto tdistrictDto) {
        if ( tdistrictDto == null ) {
            return null;
        }

        Tdistrict tdistrict = new Tdistrict();

        tdistrict.setIdProvince( tdistrictDtoToTprovince( tdistrictDto ) );
        tdistrict.setId( tdistrictDto.getId() );
        tdistrict.setNameDistrict( tdistrictDto.getNameDistrict() );

        return tdistrict;
    }

    @Override
    public TdistrictDto tdistrictToTdistrictDto(Tdistrict tdistrict) {
        if ( tdistrict == null ) {
            return null;
        }

        TdistrictDto tdistrictDto = new TdistrictDto();

        tdistrictDto.setIdProvinceId( tdistrictIdProvinceId( tdistrict ) );
        tdistrictDto.setId( tdistrict.getId() );
        tdistrictDto.setNameDistrict( tdistrict.getNameDistrict() );

        return tdistrictDto;
    }

    @Override
    public void updateTdistrictFromTdistrictDto(TdistrictDto tdistrictDto, Tdistrict tdistrict) {
        if ( tdistrictDto == null ) {
            return;
        }

        if ( tdistrict.getIdProvince() == null ) {
            tdistrict.setIdProvince( new Tprovince() );
        }
        tdistrictDtoToTprovince1( tdistrictDto, tdistrict.getIdProvince() );
        if ( tdistrictDto.getId() != null ) {
            tdistrict.setId( tdistrictDto.getId() );
        }
        if ( tdistrictDto.getNameDistrict() != null ) {
            tdistrict.setNameDistrict( tdistrictDto.getNameDistrict() );
        }
    }

    protected Tprovince tdistrictDtoToTprovince(TdistrictDto tdistrictDto) {
        if ( tdistrictDto == null ) {
            return null;
        }

        Tprovince tprovince = new Tprovince();

        tprovince.setId( tdistrictDto.getIdProvinceId() );

        return tprovince;
    }

    private Integer tdistrictIdProvinceId(Tdistrict tdistrict) {
        if ( tdistrict == null ) {
            return null;
        }
        Tprovince idProvince = tdistrict.getIdProvince();
        if ( idProvince == null ) {
            return null;
        }
        Integer id = idProvince.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected void tdistrictDtoToTprovince1(TdistrictDto tdistrictDto, Tprovince mappingTarget) {
        if ( tdistrictDto == null ) {
            return;
        }

        if ( tdistrictDto.getIdProvinceId() != null ) {
            mappingTarget.setId( tdistrictDto.getIdProvinceId() );
        }
    }
}
