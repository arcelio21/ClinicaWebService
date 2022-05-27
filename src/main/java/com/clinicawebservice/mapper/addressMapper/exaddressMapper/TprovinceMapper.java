package com.clinicawebservice.mapper.addressMapper.exaddressMapper;

import com.clinicawebservice.domain.address.Taddress;
import com.clinicawebservice.domain.address.exaddress.Tprovince;
import com.clinicawebservice.domain.address.exaddress.Tvillage;
import com.clinicawebservice.domain.userInfo.infotypeuser.TtypeUser;
import com.clinicawebservice.domain.userInfo.infotypeuser.TuserTypeReg;
import com.clinicawebservice.voData.addressDTO.exaddressDTO.TprovinceDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TprovinceMapper {
    TprovinceMapper MAPPER = Mappers.getMapper(TprovinceMapper.class);

    Tprovince tprovinceDtoToTprovince(TprovinceDto tprovinceDto);

    TprovinceDto tprovinceToTprovinceDto(Tprovince tprovince);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateTprovinceFromTprovinceDto(TprovinceDto tprovinceDto, @MappingTarget Tprovince tprovince);

    default List<Long> tuserTypeRegsToTuserTypeRegIds(List<TuserTypeReg> tuserTypeRegs) {
        return tuserTypeRegs.stream().map(TuserTypeReg::getId).collect(Collectors.toList());
    }

    default List<Integer> ttypeUsersToTtypeUserIds(List<TtypeUser> ttypeUsers) {
        return ttypeUsers.stream().map(TtypeUser::getId).collect(Collectors.toList());
    }

    default List<Long> taddressesToTaddressIds(List<Taddress> taddresses) {
        return taddresses.stream().map(Taddress::getId).collect(Collectors.toList());
    }

    default List<Integer> tvillagesToTvillageIds(List<Tvillage> tvillages) {
        return tvillages.stream().map(Tvillage::getId).collect(Collectors.toList());
    }
}
