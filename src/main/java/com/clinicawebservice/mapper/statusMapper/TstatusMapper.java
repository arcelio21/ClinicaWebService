package com.clinicawebservice.mapper.statusMapper;

import com.clinicawebservice.domain.status.Tstatus;
import com.clinicawebservice.domain.userInfo.infotypeuser.TtypeUser;
import com.clinicawebservice.domain.userInfo.infotypeuser.TuserTypeReg;
import com.clinicawebservice.voData.statusDTO.TstatusDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TstatusMapper {
    TstatusMapper MAPPER = Mappers.getMapper(TstatusMapper.class);

    Tstatus tstatusDtoToTstatus(TstatusDto tstatusDto);

    @Mapping(target = "tuserTypeRegIds", expression = "java(tuserTypeRegsToTuserTypeRegIds(tstatus.getTuserTypeRegs()))")
    @Mapping(target = "ttypeUserIds", expression = "java(ttypeUsersToTtypeUserIds(tstatus.getTtypeUsers()))")
    TstatusDto tstatusToTstatusDto(Tstatus tstatus);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateTstatusFromTstatusDto(TstatusDto tstatusDto, @MappingTarget Tstatus tstatus);

    default List<Long> tuserTypeRegsToTuserTypeRegIds(List<TuserTypeReg> tuserTypeRegs) {
        return tuserTypeRegs.stream().map(TuserTypeReg::getId).collect(Collectors.toList());
    }

    default List<Integer> ttypeUsersToTtypeUserIds(List<TtypeUser> ttypeUsers) {
        return ttypeUsers.stream().map(TtypeUser::getId).collect(Collectors.toList());
    }
}
