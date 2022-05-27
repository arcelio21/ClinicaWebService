package com.clinicawebservice.domain.status;

import com.clinicawebservice.domain.userInfo.infotypeuser.TtypeUser;
import com.clinicawebservice.domain.userInfo.infotypeuser.TuserTypeReg;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.List;


@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQueries({
        @NamedQuery(name = "Tstatus.listAll",query = "SELECT s FROM Tstatus  s ORDER BY s.id ASC")
})
@Table(name = "TSTATUS")
public class Tstatus implements Serializable {
    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "autoIdStatus")
    @SequenceGenerator(name = "autoIdStatus", sequenceName = "seq_idStatus",initialValue = 8,allocationSize = 1)
    @Column(name = "ID_STATUS", nullable = false)
    private Integer id;

    @Column(name = "NAME_STATUS", nullable = false, length = 30)
    private String nameStatus;

    @XmlTransient
    @OneToMany(mappedBy = "idStatus")
    private List<TuserTypeReg> tuserTypeRegs;

    @XmlTransient
    @OneToMany(mappedBy = "idStatus")
    private List<TtypeUser> ttypeUsers ;

    public Tstatus() {
    }

    public Tstatus(Integer id) {
        this.id = id;
    }

    public Tstatus(Integer id, String nameStatus) {
        this.id = id;
        this.nameStatus = nameStatus;
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

    public List<TuserTypeReg> getTuserTypeRegs() {
        return tuserTypeRegs;
    }

    public void setTuserTypeRegs(List<TuserTypeReg> tuserTypeRegs) {
        this.tuserTypeRegs = tuserTypeRegs;
    }

    public List<TtypeUser> getTtypeUsers() {
        return ttypeUsers;
    }

    public void setTtypeUsers(List<TtypeUser> ttypeUsers) {
        this.ttypeUsers = ttypeUsers;
    }

    @Override
    public String toString() {
        return "Tstatus{" +
                "id=" + id +
                ", nameStatus='" + nameStatus + '\'' +
                ", tuserTypeRegs=" + tuserTypeRegs +
                ", ttypeUsers=" + ttypeUsers +
                '}';
    }
}