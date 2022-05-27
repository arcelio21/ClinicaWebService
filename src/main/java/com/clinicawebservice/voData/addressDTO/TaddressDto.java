package com.clinicawebservice.voData.addressDTO;

import java.io.Serializable;

public class TaddressDto implements Serializable {
    private Long id;
    private Integer idProvinceId;
    private Integer idDistrictId;
    private Integer idVillageId;
    private String addressSpec;
    private Long tuserregId;

    public TaddressDto() {
    }

    public TaddressDto(Long id, Integer idProvinceId, Integer idDistrictId, Integer idVillageId, String addressSpec, Long tuserregId) {
        this.id = id;
        this.idProvinceId = idProvinceId;
        this.idDistrictId = idDistrictId;
        this.idVillageId = idVillageId;
        this.addressSpec = addressSpec;
        this.tuserregId = tuserregId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIdProvinceId() {
        return idProvinceId;
    }

    public void setIdProvinceId(Integer idProvinceId) {
        this.idProvinceId = idProvinceId;
    }

    public Integer getIdDistrictId() {
        return idDistrictId;
    }

    public void setIdDistrictId(Integer idDistrictId) {
        this.idDistrictId = idDistrictId;
    }

    public Integer getIdVillageId() {
        return idVillageId;
    }

    public void setIdVillageId(Integer idVillageId) {
        this.idVillageId = idVillageId;
    }

    public String getAddressSpec() {
        return addressSpec;
    }

    public void setAddressSpec(String addressSpec) {
        this.addressSpec = addressSpec;
    }

    public Long getTuserregId() {
        return tuserregId;
    }

    public void setTuserregId(Long tuserregId) {
        this.tuserregId = tuserregId;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "idProvinceId = " + idProvinceId + ", " +
                "idDistrictId = " + idDistrictId + ", " +
                "idVillageId = " + idVillageId + ", " +
                "addressSpec = " + addressSpec + ", " +
                "tuserregId = " + tuserregId + ")";
    }
}
