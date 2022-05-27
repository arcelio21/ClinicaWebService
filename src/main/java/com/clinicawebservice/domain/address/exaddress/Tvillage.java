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
        @NamedQuery(name = "Tvillage.listAll",query = "SELECT tv FROM Tvillage tv ORDER BY tv.id")
})
@Table(name = "TVILLAGE")
public class Tvillage implements Serializable {
    private static final long serialVersionUID = 1l;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_idVillage")
    @SequenceGenerator(name = "seq_idVillage", sequenceName = "seq_idVillage",initialValue = 2,allocationSize = 1)
    @Column(name = "ID_VILLAGE", nullable = false)
    private Integer id;

    @Column(name = "NAME_VILLAGE", nullable = false, length = 35)
    private String nameVillage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_DISTRICT")
    private Tdistrict idDistrict;

    @XmlTransient
    @OneToMany(mappedBy = "idVillage")
    private List<Taddress> taddresses;

    public Tvillage() {
    }

    public Tvillage(Integer id) {
        this.id = id;
    }

    public Tvillage(Integer id, String nameVillage, Tdistrict idDistrict) {
        this.id = id;
        this.nameVillage = nameVillage;
        this.idDistrict = idDistrict;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameVillage() {
        return nameVillage;
    }

    public void setNameVillage(String nameVillage) {
        this.nameVillage = nameVillage;
    }

    public Tdistrict getIdDistrict() {
        return idDistrict;
    }

    public void setIdDistrict(Tdistrict idDistrict) {
        this.idDistrict = idDistrict;
    }

    public List<Taddress> getTaddresses() {
        return taddresses;
    }

    public void setTaddresses(List<Taddress> taddresses) {
        this.taddresses = taddresses;
    }

    @Override
    public String toString() {
        return "Tvillage{" +
                "id=" + id +
                ", nameVillage='" + nameVillage + '\'' +
                ", idDistrict=" + idDistrict +
                ", taddresses=" + taddresses +
                '}';
    }
}