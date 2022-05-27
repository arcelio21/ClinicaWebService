package com.clinicawebservice.mapper.addressMapper;

import com.clinicawebservice.domain.address.Taddress;
import com.clinicawebservice.domain.address.exaddress.Tdistrict;
import com.clinicawebservice.domain.address.exaddress.Tprovince;
import com.clinicawebservice.domain.address.exaddress.Tvillage;
import com.clinicawebservice.domain.userInfo.Tuserreg;
import com.clinicawebservice.voData.addressDTO.TaddressDto;

public class TaddressMapImpl implements TaddressMap{
    @Override
    public Taddress taddressDtoToTaddress(TaddressDto taddressDto) {
        if ( taddressDto == null ) {
            return null;
        }

        Taddress taddress = new Taddress();

        taddress.setIdProvince( new Tprovince(taddressDto.getIdProvinceId()) );
        taddress.setIdDistrict( new Tdistrict(taddressDto.getIdDistrictId()) );
        taddress.setIdVillage( new Tvillage(taddressDto.getIdVillageId()));
        taddress.setTuserreg(new Tuserreg(taddressDto.getTuserregId()));
        taddress.setId( taddressDto.getId() );
        taddress.setAddressSpec( taddressDto.getAddressSpec() );

        return taddress;
    }

    @Override
    public TaddressDto taddressToTaddressDto(Taddress taddress) {
        if ( taddress == null ) {
            return null;
        }

        TaddressDto taddressDto = new TaddressDto();

        taddressDto.setIdProvinceId( taddress.getIdProvince().getId() );
        taddressDto.setIdDistrictId(taddress.getIdDistrict().getId());
        taddressDto.setIdVillageId(taddress.getIdVillage().getId());
        taddressDto.setTuserregId(taddress.getTuserreg().getId());
        taddressDto.setId(taddress.getId());
        taddressDto.setAddressSpec( taddress.getAddressSpec() );

        return taddressDto;
    }
}
