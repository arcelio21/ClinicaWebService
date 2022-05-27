package com.clinicawebservice.domain.address;

import com.clinicawebservice.domain.address.exaddress.Tdistrict;
import com.clinicawebservice.domain.address.exaddress.Tprovince;
import com.clinicawebservice.domain.address.exaddress.Tvillage;
import com.clinicawebservice.domain.userInfo.Tuserreg;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.io.Serializable;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQueries({
        @NamedQuery(name = "Taddress.listAll", query = "SELECT ad FROM Taddress  ad ORDER BY ad.id")
})
@Table(name = "TADDRESS")
public class Taddress implements Serializable {
    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_idAddress")
    @SequenceGenerator(name = "seq_idAddress", sequenceName = "seq_idAddress",initialValue = 2,allocationSize = 1)
    @Column(name = "ID_ADDRESS", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_PROVINCE", nullable = false)
    private Tprovince idProvince;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_DISTRICT", nullable = false)
    private Tdistrict idDistrict;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_VILLAGE", nullable = false)
    private Tvillage idVillage;

    @Column(name = "ADDRESS_SPEC", length = 60)
    private String addressSpec;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "idAddress")
    private Tuserreg tuserreg;

    public Taddress() {
    }

    public Taddress(Long id) {
        this.id = id;
    }

    public Taddress(Long id, Tprovince idProvince, Tdistrict idDistrict, Tvillage idVillage, String addressSpec) {
        this.id = id;
        this.idProvince = idProvince;
        this.idDistrict = idDistrict;
        this.idVillage = idVillage;
        this.addressSpec = addressSpec;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Tprovince getIdProvince() {
        return idProvince;
    }

    public void setIdProvince(Tprovince idProvince) {
        this.idProvince = idProvince;
    }

    public Tdistrict getIdDistrict() {
        return idDistrict;
    }

    public void setIdDistrict(Tdistrict idDistrict) {
        this.idDistrict = idDistrict;
    }

    public Tvillage getIdVillage() {
        return idVillage;
    }

    public void setIdVillage(Tvillage idVillage) {
        this.idVillage = idVillage;
    }

    public String getAddressSpec() {
        return addressSpec;
    }

    public void setAddressSpec(String addressSpec) {
        this.addressSpec = addressSpec;
    }

    public Tuserreg getTuserreg() {
        return tuserreg;
    }

    public void setTuserreg(Tuserreg tuserreg) {
        this.tuserreg = tuserreg;
    }

    @Override
    public String toString() {
        return "Taddress{" +
                "id=" + id +
                ", idProvince=" + idProvince +
                ", idDistrict=" + idDistrict +
                ", idVillage=" + idVillage +
                ", addressSpec='" + addressSpec + '\'' +
                ", tuserreg=" + tuserreg +
                '}';
    }
}