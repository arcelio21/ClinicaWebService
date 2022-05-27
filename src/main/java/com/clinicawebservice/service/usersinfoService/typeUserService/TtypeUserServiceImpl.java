package com.clinicawebservice.service.usersinfoService.typeUserService;


import com.clinicawebservice.daoData.userInfoDAO.typeUserDAO.TtypeUerDAO;
import com.clinicawebservice.voData.userinfoDTO.typeuserDTO.TtypeUserDto;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;
import java.util.List;

@Stateless(mappedName = "ejb/typeUserService")
@WebService(endpointInterface = "com.clinicawebservice.service.usersinfoService.typeUserService.TtypeUserService")
public class TtypeUserServiceImpl implements TtypeUserService{


    @Inject
    private TtypeUerDAO ttypeUerDAO;


    /**
     *
     * LIST ALL EXISTING USER TYPES
     *
     *
     * @return THE LIST OF ALL TYPES OF USERS
     * */
    @Override
    public List<TtypeUserDto> listTypeUser() {
        return this.ttypeUerDAO.listTypeUser();
    }

    /**
     *
     * SEARCH FOR USER TYPE BY ID
     *
     * @param ttypeUserDto
     * @return  TtypeUserDto
     *
     * */
    @Override
    public TtypeUserDto searchTypeUserById(TtypeUserDto ttypeUserDto) {
        return this.ttypeUerDAO.searchTypeUserById(ttypeUserDto);
    }

    /**
     *
     * INSERTS DATA OF A USER TYPE TO THE DATABASE
     * @param ttypeUserDto
     * @return boolean
     * */
    @Override
    public boolean insertTypeUser(TtypeUserDto ttypeUserDto) {
        return this.ttypeUerDAO.insertTypeUser(ttypeUserDto);
    }

    /**
     *UPDATES THE VALUES OF A SPECIFIC USER TYPE
     *
     * @param ttypeUserDto
     * @return boolean
     *
     * */
    @Override
    public boolean updateTypeUser(TtypeUserDto ttypeUserDto) {
        return this.ttypeUerDAO.updateTypeUser(ttypeUserDto);
    }

    /**
     *ELIMINATES USER TYPE INDICATED
     * @param ttypeUserDto
     * @return boolean
     *
     * */
    @Override
    public boolean deleteTypeUser(TtypeUserDto ttypeUserDto) {
        return this.ttypeUerDAO.updateTypeUser(ttypeUserDto);
    }
}
