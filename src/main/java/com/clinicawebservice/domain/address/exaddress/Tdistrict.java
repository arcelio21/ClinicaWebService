package com.clinicawebservice.domain.address.exaddress;

import com.clinicawebservice.domain.address.Taddress;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.List;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQueries({
        @NamedQuery(name = "Tdistrict.listAll",query = "SELECT td FROM Tdistrict td ORDER BY td.id")
})
@Table(name = "TDISTRICT")
public class Tdistrict implements Serializable {
    private static final long serialVersionUID = -1572537375105178767L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_idDistrict")
    @SequenceGenerator(name = "seq_idDistrict", sequenceName = "seq_idDistrict",initialValue = 2,allocationSize = 1)
    @Column(name = "ID_DISTRICT", nullable = false)
    private Integer id;

    @Column(name = "NAME_DISTRICT", nullable = false, length = 35)
    private String nameDistrict;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PROVINCE")
    private Tprovince idProvince;

    @XmlTransient
    @OneToMany(mappedBy = "idDistrict")
    private List<Taddress> taddresses;

    @XmlTransient
    @OneToMany(mappedBy = "idDistrict")
    private List<Tvillage> tvillages;

    public Tdistrict() {
    }

    public Tdistrict(Integer id) {
        this.id = id;
    }

    public Tdistrict(Integer id, String nameDistrict, Tprovince idProvince) {
        this.id = id;
        this.nameDistrict = nameDistrict;
        this.idProvince = idProvince;
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

    public Tprovince getIdProvince() {
        return idProvince;
    }

    public void setIdProvince(Tprovince idProvince) {
        this.idProvince = idProvince;
    }

    public List<Taddress> getTaddresses() {
        return taddresses;
    }

    public void setTaddresses(List<Taddress> taddresses) {
        this.taddresses = taddresses;
    }

    public List<Tvillage> getTvillages() {
        return tvillages;
    }

    public void setTvillages(List<Tvillage> tvillages) {
        this.tvillages = tvillages;
    }

    @Override
    public String toString() {
        return "Tdistrict{" +
                "id=" + id +
                ", nameDistrict='" + nameDistrict + '\'' +
                ", idProvince=" + idProvince +
                ", taddresses=" + taddresses +
                ", tvillages=" + tvillages +
                '}';
    }
}