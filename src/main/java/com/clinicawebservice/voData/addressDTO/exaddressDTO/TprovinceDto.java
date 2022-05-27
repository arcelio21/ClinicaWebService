package com.clinicawebservice.voData.addressDTO.exaddressDTO;

import java.io.Serializable;

public class TprovinceDto implements Serializable {
    private Integer id;
    private String nameProvince;

    public TprovinceDto() {
    }

    public TprovinceDto(Integer id, String nameProvince) {
        this.id = id;
        this.nameProvince = nameProvince;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameProvince() {
        return nameProvince;
    }

    public void setNameProvince(String nameProvince) {
        this.nameProvince = nameProvince;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "nameProvince = " + nameProvince + ")";
    }
}
