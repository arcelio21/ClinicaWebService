package com.clinicawebservice.mapper.addressMapper.exaddressMapper;

import com.clinicawebservice.domain.address.exaddress.Tprovince;
import com.clinicawebservice.voData.addressDTO.exaddressDTO.TprovinceDto;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-25T12:34:58-0500",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.12 (Oracle Corporation)"
)
public class TprovinceMapperImpl implements TprovinceMapper {

    @Override
    public Tprovince tprovinceDtoToTprovince(TprovinceDto tprovinceDto) {
        if ( tprovinceDto == null ) {
            return null;
        }

        Tprovince tprovince = new Tprovince();

        tprovince.setId( tprovinceDto.getId() );
        tprovince.setNameProvince( tprovinceDto.getNameProvince() );

        return tprovince;
    }

    @Override
    public TprovinceDto tprovinceToTprovinceDto(Tprovince tprovince) {
        if ( tprovince == null ) {
            return null;
        }

        TprovinceDto tprovinceDto = new TprovinceDto();

        tprovinceDto.setId( tprovince.getId() );
        tprovinceDto.setNameProvince( tprovince.getNameProvince() );

        return tprovinceDto;
    }

    @Override
    public void updateTprovinceFromTprovinceDto(TprovinceDto tprovinceDto, Tprovince tprovince) {
        if ( tprovinceDto == null ) {
            return;
        }

        if ( tprovinceDto.getId() != null ) {
            tprovince.setId( tprovinceDto.getId() );
        }
        if ( tprovinceDto.getNameProvince() != null ) {
            tprovince.setNameProvince( tprovinceDto.getNameProvince() );
        }
    }
}
