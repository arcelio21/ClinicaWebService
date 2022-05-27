package com.clinicawebservice.mapper.userinfoMapper.TypeUserMapper;

import com.clinicawebservice.domain.userInfo.infotypeuser.TuserTypeReg;
import com.clinicawebservice.voData.userinfoDTO.typeuserDTO.TuserTypeRegDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TuserTypeRegMapper {
    TuserTypeRegMapper MAPPER = Mappers.getMapper(TuserTypeRegMapper.class);

    @Mapping(source = "idUserRegId", target = "idUserReg.id")
    @Mapping(source = "idTypeUserId", target = "idTypeUser.id")
    @Mapping(source = "idStatusId", target = "idStatus.id")
    TuserTypeReg tuserTypeRegDtoToTuserTypeReg(TuserTypeRegDto tuserTypeRegDto);

    @InheritInverseConfiguration(name = "tuserTypeRegDtoToTuserTypeReg")
    TuserTypeRegDto tuserTypeRegToTuserTypeRegDto(TuserTypeReg tuserTypeReg);

    @InheritConfiguration(name = "tuserTypeRegDtoToTuserTypeReg")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateTuserTypeRegFromTuserTypeRegDto(TuserTypeRegDto tuserTypeRegDto, @MappingTarget TuserTypeReg tuserTypeReg);
}
