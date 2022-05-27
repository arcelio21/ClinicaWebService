package com.clinicawebservice.voData.userinfoDTO.typeuserDTO;

import java.io.Serializable;

public class TtypeUserDto implements Serializable {
    private Integer id;
    private String nameTypeUser;
    private Integer idStatusId;

    public TtypeUserDto() {
    }

    public TtypeUserDto(Integer id, String nameTypeUser, Integer idStatusId) {
        this.id = id;
        this.nameTypeUser = nameTypeUser;
        this.idStatusId = idStatusId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameTypeUser() {
        return nameTypeUser;
    }

    public void setNameTypeUser(String nameTypeUser) {
        this.nameTypeUser = nameTypeUser;
    }

    public Integer getIdStatusId() {
        return idStatusId;
    }

    public void setIdStatusId(Integer idStatusId) {
        this.idStatusId = idStatusId;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "nameTypeUser = " + nameTypeUser + ", " +
                "idStatusId = " + idStatusId + ")";
    }
}
