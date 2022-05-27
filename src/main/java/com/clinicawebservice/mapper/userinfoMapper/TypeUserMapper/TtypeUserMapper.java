package com.clinicawebservice.mapper.userinfoMapper.TypeUserMapper;

import com.clinicawebservice.domain.userInfo.infotypeuser.TtypeUser;
import com.clinicawebservice.voData.userinfoDTO.typeuserDTO.TtypeUserDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TtypeUserMapper {
    TtypeUserMapper MAPPER = Mappers.getMapper(TtypeUserMapper.class);

    @Mapping(source = "idStatusId", target = "idStatus.id")
    TtypeUser ttypeUserDtoToTtypeUser(TtypeUserDto ttypeUserDto);

    @Mapping(source = "idStatus.id", target = "idStatusId")
    TtypeUserDto ttypeUserToTtypeUserDto(TtypeUser ttypeUser);

    @Mapping(source = "idStatusId", target = "idStatus.id")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateTtypeUserFromTtypeUserDto(TtypeUserDto ttypeUserDto, @MappingTarget TtypeUser ttypeUser);
}
