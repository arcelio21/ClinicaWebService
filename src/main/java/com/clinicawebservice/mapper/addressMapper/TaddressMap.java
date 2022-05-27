package com.clinicawebservice.mapper.addressMapper;

import com.clinicawebservice.domain.address.Taddress;
import com.clinicawebservice.voData.addressDTO.TaddressDto;

public interface TaddressMap {

    public Taddress taddressDtoToTaddress(TaddressDto taddressDto);

    public TaddressDto taddressToTaddressDto(Taddress taddress);
}
