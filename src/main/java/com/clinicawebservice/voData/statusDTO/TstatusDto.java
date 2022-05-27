package com.clinicawebservice.voData.statusDTO;

import java.io.Serializable;
import java.util.List;

public class TstatusDto implements Serializable {
    private Integer id;
    private String nameStatus;
    private List<Long> tuserTypeRegIds;
    private List<Integer> ttypeUserIds;

    public TstatusDto() {
    }

    public TstatusDto(Integer id, String nameStatus, List<Long> tuserTypeRegIds, List<Integer> ttypeUserIds) {
        this.id = id;
        this.nameStatus = nameStatus;
        this.tuserTypeRegIds = tuserTypeRegIds;
        this.ttypeUserIds = ttypeUserIds;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameStatus() {
        return nameStatus;
    }

    public void setNameStatus(String nameStatus) {
        this.nameStatus = nameStatus;
    }

    public List<Long> getTuserTypeRegIds() {
        return tuserTypeRegIds;
    }

    public void setTuserTypeRegIds(List<Long> tuserTypeRegIds) {
        this.tuserTypeRegIds = tuserTypeRegIds;
    }

    public List<Integer> getTtypeUserIds() {
        return ttypeUserIds;
    }

    public void setTtypeUserIds(List<Integer> ttypeUserIds) {
        this.ttypeUserIds = ttypeUserIds;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "nameStatus = " + nameStatus + ", " +
                "tuserTypeRegIds = " + tuserTypeRegIds + ", " +
                "ttypeUserIds = " + ttypeUserIds + ")";
    }
}
