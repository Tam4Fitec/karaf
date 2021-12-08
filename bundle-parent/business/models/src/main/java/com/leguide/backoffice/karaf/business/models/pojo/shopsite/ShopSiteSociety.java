package com.leguide.backoffice.karaf.business.models.pojo.shopsite;

import java.io.Serializable;

public class ShopSiteSociety implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private String address1;
    private String address2;
    private String zip;
    private String city;
    private String country;

    private String phone;
    private String type;
    private Long typeId;

    private String rcs;
    private String siret;
    private String tvaIntra;

    private Boolean autoEntrepreneur;

    private String alias1;
    private String alias2;
    private String alias3;
    private String alias4;
    private String alias5;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getRcs() {
        return rcs;
    }

    public void setRcs(String rcs) {
        this.rcs = rcs;
    }

    public String getSiret() {
        return siret;
    }

    public void setSiret(String siret) {
        this.siret = siret;
    }

    public String getTvaIntra() {
        return tvaIntra;
    }

    public void setTvaIntra(String tvaIntra) {
        this.tvaIntra = tvaIntra;
    }

    public Boolean getAutoEntrepreneur() {
        return autoEntrepreneur;
    }

    public void setAutoEntrepreneur(Boolean autoEntrepreneur) {
        this.autoEntrepreneur = autoEntrepreneur;
    }

    public String getAlias1() {
        return alias1;
    }

    public void setAlias1(String alias1) {
        this.alias1 = alias1;
    }

    public String getAlias2() {
        return alias2;
    }

    public void setAlias2(String alias2) {
        this.alias2 = alias2;
    }

    public String getAlias3() {
        return alias3;
    }

    public void setAlias3(String alias3) {
        this.alias3 = alias3;
    }

    public String getAlias4() {
        return alias4;
    }

    public void setAlias4(String alias4) {
        this.alias4 = alias4;
    }

    public String getAlias5() {
        return alias5;
    }

    public void setAlias5(String alias5) {
        this.alias5 = alias5;
    }
}
