package com.clinicawebservice.voData.addressDTO.exaddressDTO;

import java.io.Serializable;

public class TvillageDto implements Serializable {
    private Integer id;
    private String nameVillage;
    private Integer idDistrictId;

    public TvillageDto() {
    }

    public TvillageDto(Integer id, String nameVillage, Integer idDistrictId) {
        this.id = id;
        this.nameVillage = nameVillage;
        this.idDistrictId = idDistrictId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameVillage() {
        return nameVillage;
    }

    public void setNameVillage(String nameVillage) {
        this.nameVillage = nameVillage;
    }

    public Integer getIdDistrictId() {
        return idDistrictId;
    }

    public void setIdDistrictId(Integer idDistrictId) {
        this.idDistrictId = idDistrictId;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "nameVillage = " + nameVillage + ", " +
                "idDistrictId = " + idDistrictId + ")";
    }
}
