package com.clinicawebservice.domain.userInfo.infotypeuser;

import com.clinicawebservice.domain.status.Tstatus;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.io.Serializable;
import java.util.List;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQueries({
        @NamedQuery(name = "TypeUser.listAll",query = "SELECT tu FROM TtypeUser tu ORDER BY tu.id ASC ")
})
@Table(name = "TTYPE_USERS")
public class TtypeUser implements Serializable {
    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEC_IDTYPEUSER")
    @SequenceGenerator(name = "SEC_IDTYPEUSER", sequenceName = "SEC_IDTYPEUSER",initialValue = 7,allocationSize = 1)
    @Column(name = "ID_TYPE_USER", nullable = false)
    private Integer id;

    @Column(name = "NAME_TYPE_USER", nullable = false, length = 30)
    private String nameTypeUser;


    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_STATUS")
    private Tstatus idStatus;


    @OneToMany(mappedBy = "idTypeUser",cascade = CascadeType.ALL)
    private List<TuserTypeReg> tuserTypeRegs;

    public TtypeUser() {
    }

    public TtypeUser(Integer id) {
        this.id = id;
    }

    public TtypeUser(Integer id, String nameTypeUser, Tstatus idStatus) {
        this.id = id;
        this.nameTypeUser = nameTypeUser;
        this.idStatus = idStatus;
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

    public Tstatus getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(Tstatus idStatus) {
        this.idStatus = idStatus;
    }

    public List<TuserTypeReg> getTuserTypeRegs() {
        return tuserTypeRegs;
    }

    public void setTuserTypeRegs(List<TuserTypeReg> tuserTypeRegs) {
        this.tuserTypeRegs = tuserTypeRegs;
    }

    @Override
    public String toString() {
        return "TtypeUser{" +
                "id=" + id +
                ", nameTypeUser='" + nameTypeUser + '\'' +
                ", idStatus=" + idStatus +
                ", tuserTypeRegs=" + tuserTypeRegs +
                '}';
    }
}