package com.clinicawebservice.mapper.userinfoMapper;

import com.clinicawebservice.domain.userInfo.Tuserreg;
import com.clinicawebservice.voData.userinfoDTO.TuserregDto;

public interface TuserRegMaper {

    Tuserreg tusuarioregDtoToTusuarioreg(TuserregDto tuserregDto);

    TuserregDto tusuarioregToTusuarioregDto(Tuserreg tuserreg);
}
