package com.clinicawebservice.domain.userInfo;

import com.clinicawebservice.domain.address.Taddress;
import com.clinicawebservice.domain.userInfo.infotypeuser.TuserTypeReg;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.io.Serializable;
import java.util.Date;

import java.util.List;

@Entity@XmlAccessorType(XmlAccessType.FIELD) //CONVIERTE A XML LA CLASE
@NamedQueries({
        @NamedQuery(name = "Tusuarioreg.listAll",query = "SELECT utr FROM Tuserreg utr ORDER BY utr.id ASC"),
        @NamedQuery(name = "searchById", query = "SELECT utr FROM Tuserreg utr WHERE utr.id=:idUser")/*El parametro se agrega al llamar el query*/
        ,@NamedQuery(name = "tuserReg.validate", query = "SELECT ur FROM Tuserreg  ur WHERE ur.idenCard=:idenCard AND ur.pass=:pass")
}
)
@Table(name = "TUSERREG")
public class Tuserreg implements Serializable {
    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEC_IDUSERREG")
    @SequenceGenerator(name = "SEC_IDUSERREG", sequenceName = "SEC_IDUSERREG",initialValue = 2,allocationSize = 1)
    @Column(name = "ID_USER", nullable = false)
    private Long id;

    @Column(name = "IDEN_CARD", nullable = false, length = 20)
    private String idenCard;

    @Column(name = "NAMEUSER", nullable = false, length = 30)
    private String nameUser;

    @Column(name = "LAST_NAME", nullable = false, length = 30)
    private String lastName;


    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_ADDRESS")
    private Taddress idAddress;

    @Column(name = "CONTACT", length = 8)
    private String contact;

    @Column(name = "EMAIL", length = 50)
    private String email;

    @Column(name = "PASS", length = 150)
    private String pass;

    @Column(name = "FECHACREACION")
    private Date fechaCreacion;


    @OneToMany(mappedBy = "idUserReg",cascade = CascadeType.ALL)
    private List<TuserTypeReg> tuserTypeRegs;

    public Tuserreg() {
    }

    public Tuserreg(Long id) {
        this.id = id;
    }

    public Tuserreg(String idenCard, String password) {
        this.idenCard = idenCard;
        this.pass = password;
    }

    public Tuserreg(Long id, List<TuserTypeReg> tuserTypeRegs) {
        this.id = id;
        this.tuserTypeRegs = tuserTypeRegs;
    }

    public Tuserreg(Long id, String idenCard, String nameUser, String lastName, Taddress idAddress, String contact, String email, String password, Date fechaCreacion) {
        this.id = id;
        this.idenCard = idenCard;
        this.nameUser = nameUser;
        this.lastName = lastName;
        this.idAddress = idAddress;
        this.contact = contact;
        this.email = email;
        this.pass = password;
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

    public String getnameUser() {
        return nameUser;
    }

    public void setnameUser(String name) {
        this.nameUser = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Taddress getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(Taddress idAddress) {
        this.idAddress = idAddress;
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

    public String getPassword() {
        return pass;
    }

    public void setPassword(String password) {
        this.pass = password;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public List<TuserTypeReg> getTuserTypeRegs() {
        return tuserTypeRegs;
    }

    public void setTuserTypeRegs(List<TuserTypeReg> tuserTypeRegs) {
        this.tuserTypeRegs = tuserTypeRegs;
    }

    @Override
    public String toString() {
        return "Tuserreg{" +
                "id=" + id +
                ", idenCard='" + idenCard + '\'' +
                ", name='" + nameUser + '\'' +
                ", lastName='" + lastName + '\'' +
                ", idAddress=" + idAddress +
                ", contact='" + contact + '\'' +
                ", email='" + email + '\'' +
                ", password='" + pass + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", tuserTypeRegs=" + tuserTypeRegs +
                '}';
    }
}