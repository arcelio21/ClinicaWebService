package com.clinicawebservice.domain.userInfo.infotypeuser;

import com.clinicawebservice.domain.status.Tstatus;
import com.clinicawebservice.domain.userInfo.Tuserreg;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQueries({
        @NamedQuery(name = "TuserTypeReg.listAll",query = "SELECT utr FROM TuserTypeReg utr ORDER BY utr.id ASC ")
})
@Table(name = "TUSER_TYPE_REGS")
public class TuserTypeReg implements Serializable {
    private static final long serialVersionUID = 1l;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEC_IDUSERTYPEREG")
    @SequenceGenerator(name = "SEC_IDUSERTYPEREG", sequenceName = "SEC_IDUSERTYPEREG",initialValue = 2,allocationSize = 1)
    @Column(name = "ID_USER_TYPE_REG", nullable = false)
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY, optional = false,cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_USER_REG", nullable = false)
    private Tuserreg idUserReg;


    @ManyToOne(fetch = FetchType.LAZY, optional = false,cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_TYPE_USER", nullable = false)
    private TtypeUser idTypeUser;

    @XmlTransient
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_STATUS")
    private Tstatus idStatus;

    public TuserTypeReg() {
    }

    public TuserTypeReg(Long id) {
        this.id = id;
    }

    public TuserTypeReg(Long id, Tuserreg idUserReg, TtypeUser idTypeUser, Tstatus idStatus) {
        this.id = id;
        this.idUserReg = idUserReg;
        this.idTypeUser = idTypeUser;
        this.idStatus = idStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Tuserreg getIdUserReg() {
        return idUserReg;
    }

    public void setIdUserReg(Tuserreg idUserReg) {
        this.idUserReg = idUserReg;
    }

    public TtypeUser getIdTypeUser() {
        return idTypeUser;
    }

    public void setIdTypeUser(TtypeUser idTypeUser) {
        this.idTypeUser = idTypeUser;
    }

    public Tstatus getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(Tstatus idStatus) {
        this.idStatus = idStatus;
    }

    @Override
    public String toString() {
        return "TuserTypeReg{" +
                "id=" + id +
                ", idUserReg=" + idUserReg +
                ", idTypeUser=" + idTypeUser +
                ", idStatus=" + idStatus +
                '}';
    }
}