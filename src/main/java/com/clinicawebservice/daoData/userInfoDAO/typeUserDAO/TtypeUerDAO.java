package com.clinicawebservice.daoData.userInfoDAO.typeUserDAO;


import com.clinicawebservice.voData.userinfoDTO.typeuserDTO.TtypeUserDto;

import java.util.List;

public interface TtypeUerDAO {

    List<TtypeUserDto> listTypeUser();

    TtypeUserDto searchTypeUserById(TtypeUserDto ttypeUserDto);

    boolean insertTypeUser(TtypeUserDto ttypeUserDto);

    boolean updateTypeUser(TtypeUserDto ttypeUserDto);

    boolean deleteTypeUser(TtypeUserDto ttypeUserDto);
}
