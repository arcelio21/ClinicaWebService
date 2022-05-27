package com.clinicawebservice.voData.userinfoDTO.typeuserDTO;

import java.io.Serializable;

public class TuserTypeRegDto implements Serializable {
    private Long id;
    private Long idUserRegId;
    private Integer idTypeUserId;
    private Integer idStatusId;

    public TuserTypeRegDto() {
    }

    public TuserTypeRegDto(Long id, Long idUserRegId, Integer idTypeUserId, Integer idStatusId) {
        this.id = id;
        this.idUserRegId = idUserRegId;
        this.idTypeUserId = idTypeUserId;
        this.idStatusId = idStatusId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdUserRegId() {
        return idUserRegId;
    }

    public void setIdUserRegId(Long idUserRegId) {
        this.idUserRegId = idUserRegId;
    }

    public Integer getIdTypeUserId() {
        return idTypeUserId;
    }

    public void setIdTypeUserId(Integer idTypeUserId) {
        this.idTypeUserId = idTypeUserId;
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
                "idUserRegId = " + idUserRegId + ", " +
                "idTypeUserId = " + idTypeUserId + ", " +
                "idStatusId = " + idStatusId + ")";
    }
}
