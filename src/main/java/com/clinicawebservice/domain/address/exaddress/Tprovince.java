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
        @NamedQuery(name = "Tprovince.listAll",query = "SELECT p FROM Tprovince p ORDER BY p.id ASC ")
})
@Table(name = "TPROVINCE")
public class Tprovince implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_PROVINCE", nullable = false)
    private Integer id;

    @Column(name = "NAME_PROVINCE", nullable = false, length = 35)
    private String nameProvince;

    @XmlTransient
    @OneToMany(mappedBy = "idProvince")
    private List<Tdistrict> tdistricts;

    @XmlTransient
    @OneToMany(mappedBy = "idProvince")
    private List<Taddress> taddresses;

    public Tprovince() {
    }

    public Tprovince(Integer id) {
        this.id = id;
    }

    public Tprovince(Integer id, String nameProvince) {
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

    public List<Tdistrict> getTdistricts() {
        return tdistricts;
    }

    public void setTdistricts(List<Tdistrict> tdistricts) {
        this.tdistricts = tdistricts;
    }

    public List<Taddress> getTaddresses() {
        return taddresses;
    }

    public void setTaddresses(List<Taddress> taddresses) {
        this.taddresses = taddresses;
    }

    @Override
    public String toString() {
        return "Tprovince{" +
                "id=" + id +
                ", nameProvince='" + nameProvince + '\'' +
                ", tdistricts=" + tdistricts +
                ", taddresses=" + taddresses +
                '}';
    }
}