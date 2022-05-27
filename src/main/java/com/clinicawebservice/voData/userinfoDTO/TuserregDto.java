package com.clinicawebservice.voData.userinfoDTO;

import java.io.Serializable;
import java.util.Date;

public class TuserregDto implements Serializable {
    private Long id;
    private String idenCard;
    private String nameUser;
    private String lastName;
    private Long idAddressId;
    private String contact;
    private String email;
    private String pass;
    private Date fechaCreacion;

    public TuserregDto() {
    }

    public TuserregDto(Long id, String idenCard, String nameUser, String lastName, Long idAddressId, String contact, String email, String pass, Date fechaCreacion) {
        this.id = id;
        this.idenCard = idenCard;
        this.nameUser = nameUser;
        this.lastName = lastName;
        this.idAddressId = idAddressId;
        this.contact = contact;
        this.email = email;
        this.pass = pass;
        this.fechaCreacion = fechaCreacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdenCard() {
        return idenCard;
    }

    public void setIdenCard(String idenCard) {
        this.idenCard = idenCard;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getIdAddressId() {
        return idAddressId;
    }

    public void setIdAddressId(Long idAddressId) {
        this.idAddressId = idAddressId;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "idenCard = " + idenCard + ", " +
                "nameUser = " + nameUser + ", " +
                "lastName = " + lastName + ", " +
                "idAddressId = " + idAddressId + ", " +
                "contact = " + contact + ", " +
                "email = " + email + ", " +
                "pass = " + pass + ", " +
                "fechaCreacion = " + fechaCreacion + ")";
    }
}
