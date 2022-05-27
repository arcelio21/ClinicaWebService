package com.clinicawebservice.voData.addressDTO.exaddressDTO;

import java.io.Serializable;

public class TdistrictDto implements Serializable {
    private Integer id;
    private String nameDistrict;
    private Integer idProvinceId;

    public TdistrictDto() {
    }

    public TdistrictDto(Integer id, String nameDistrict, Integer idProvinceId) {
        this.id = id;
        this.nameDistrict = nameDistrict;
        this.idProvinceId = idProvinceId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameDistrict() {
        return nameDistrict;
    }

    public void setNameDistrict(String nameDistrict) {
        this.nameDistrict = nameDistrict;
    }

    public Integer getIdProvinceId() {
        return idProvinceId;
    }

    public void setIdProvinceId(Integer idProvinceId) {
        this.idProvinceId = idProvinceId;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "nameDistrict = " + nameDistrict + ", " +
                "idProvinceId = " + idProvinceId + ")";
    }
}
