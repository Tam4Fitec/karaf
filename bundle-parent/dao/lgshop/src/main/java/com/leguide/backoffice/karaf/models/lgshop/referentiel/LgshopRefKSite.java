package com.leguide.backoffice.karaf.models.lgshop.referentiel;

import java.io.Serializable;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name="rf_ksite")
@NamedQueries({ @NamedQuery(name = LgshopRefKSite.FIND_ALL, query = "select ksiteRef FROM LgshopRefKSite ksiteRef"),
    @NamedQuery(name = LgshopRefKSite.FIND_ALL_BY_ZERO_LANGUAGE, query = "select ksiteRef FROM LgshopRefKSite ksiteRef where ksiteRef.languageId = 0"),
    @NamedQuery(name = LgshopRefKSite.FIND_ALL_BY_LANGUAGE_ID, query = "select ksiteRef FROM LgshopRefKSite ksiteRef where" +
    		" ksiteRef.languageId = :" + LgshopRefKSite.LANGUAGE_ID_PARAMETER)})
public class LgshopRefKSite implements Serializable {   
    
    /**
     * 
     */
    private static final long serialVersionUID = 4394113440906984462L;
    public static final String FIND_ALL = "LgshopRefKSite.find_all";
    public static final String FIND_ALL_BY_ZERO_LANGUAGE = "LgshopRefKSite.find_all_by_ZERO_language";
    public static final String FIND_ALL_BY_LANGUAGE_ID = "LgshopRefKSite.find_all_by_language_id";
    public static final String LANGUAGE_ID_PARAMETER = "languageId";

    @Id
    @Column(name="id")  
    private Integer id;
    
    @Column(name="label", nullable=false)
    private String label;
    
    @Column(name="bit_index", nullable=false)
    private Integer flagIndex;

    @Column(name="bit_value", nullable=false)
    private Long value;
    
    @Column(name="partner_bl_sensitive", nullable=false)
    private Boolean partnerSensitive = false;

    @Column(name="adult_content_bl_sensitive", nullable=false)
    private Boolean adultContentSensitive = true;

    @Column(name="id_language", nullable=false)
    private Integer languageId = 0;

    @Transient
    private  Map<Integer, String> localizedLabels;

    public LgshopRefKSite() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getFlagIndex() {
        return flagIndex;
    }

    public void setFlagIndex(Integer flagIndex) {
        this.flagIndex = flagIndex;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public Boolean getPartnerSensitive() {
        return partnerSensitive;
    }

    public void setPartnerSensitive(Boolean partnerSensitive) {
        this.partnerSensitive = partnerSensitive;
    }

    public Boolean getAdultContentSensitive() {
        return adultContentSensitive;
    }

    public void setAdultContentSensitive(Boolean adultContentSensitive) {
        this.adultContentSensitive = adultContentSensitive;
    }

    public Map<Integer, String> getLocalizedLabels() {
        return localizedLabels;
    }

    public void setLocalizedLabels(Map<Integer, String> localizedLabels) {
        this.localizedLabels = localizedLabels;
    }

    public Integer getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Integer languageId) {
        this.languageId = languageId;
    }

}
