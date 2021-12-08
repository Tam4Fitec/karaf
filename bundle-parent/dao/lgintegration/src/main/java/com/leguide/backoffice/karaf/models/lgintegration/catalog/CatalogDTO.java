package com.leguide.backoffice.karaf.models.lgintegration.catalog;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_catalog")
public class CatalogDTO implements Serializable {

    private static final long serialVersionUID = 2822853591228480157L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_catalog")
    private Long catalogId;

    @Column(name="ctg_version")
    private String version;

    @Column(name="ctg_active")
    private String active;

    @Column(name="ctg_last_launch")
    private Date lastLaunch;

    @Column(name="ctg_end_processing")
    private Date endProcessing;

    @Column(name="ctg_offers_count")
    private Long offersCount = 0L;

    @Column(name="ctg_categories_count")
    private Long categoriesCount = 0L;

    @Column(name="ctg_online_count")
    private Long onlineCount = 0L;

    @Column(name="ctg_normalized")
    private String normalized = "N";

    @Column(name="ctg_state")
    private Integer state ;

    @Column(name="ctg_backups_count")
    private Integer backupsCount = 1;

    @Column(name="ctg_to_categorize_count")
    private Long toCategorizeCount = 0L;

    @Column(name="id_shopsite")
    private Long shopsiteId;

    @Column(name="ctg_completeness")
    private Float completeness = 0.0000F;

    @Column(name="ctg_validation_date")
    private Date validationDate;

    @Column(name="src_command")
    private String srcCommand;

    @Column(name="src_command_active")
    private String srcCommandActive = "0";
    
    
//	@OneToMany(fetch=FetchType.EAGER)
//	@JoinColumn(name="id_catalog")
//	private Set<Source> sourceList;
//
//	@OneToMany(fetch=FetchType.EAGER)
//	@JoinColumn(name="id_catalog")
//	private Set<FieldNormalization> normalizationList;
//    

    public Long getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(Long catalogId) {
        this.catalogId = catalogId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public Date getLastLaunch() {
        return lastLaunch;
    }

    public void setLastLaunch(Date lastLaunch) {
        this.lastLaunch = lastLaunch;
    }

    public Date getEndProcessing() {
        return endProcessing;
    }

    public void setEndProcessing(Date endProcessing) {
        this.endProcessing = endProcessing;
    }

    public Long getOffersCount() {
        return offersCount;
    }

    public void setOffersCount(Long offersCount) {
        this.offersCount = offersCount;
    }

    public Long getCategoriesCount() {
        return categoriesCount;
    }

    public void setCategoriesCount(Long categoriesCount) {
        this.categoriesCount = categoriesCount;
    }

    public Long getOnlineCount() {
        return onlineCount;
    }

    public void setOnlineCount(Long onlineCount) {
        this.onlineCount = onlineCount;
    }

    public String getNormalized() {
        return normalized;
    }

    public void setNormalized(String normalized) {
        this.normalized = normalized;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getBackupsCount() {
        return backupsCount;
    }

    public void setBackupsCount(Integer backupsCount) {
        this.backupsCount = backupsCount;
    }

    public Long getToCategorizeCount() {
        return toCategorizeCount;
    }

    public void setToCategorizeCount(Long toCategorizeCount) {
        this.toCategorizeCount = toCategorizeCount;
    }

    public Long getShopsiteId() {
        return shopsiteId;
    }

    public void setShopsiteId(Long shopsiteId) {
        this.shopsiteId = shopsiteId;
    }

    public Float getCompleteness() {
        return completeness;
    }

    public void setCompleteness(Float completeness) {
        this.completeness = completeness;
    }

    public Date getValidationDate() {
        return validationDate;
    }

    public void setValidationDate(Date validationDate) {
        this.validationDate = validationDate;
    }

    public String getSrcCommand() {
        return srcCommand;
    }

    public void setSrcCommand(String srcCommand) {
        this.srcCommand = srcCommand;
    }

    public String getSrcCommandActive() {
        return srcCommandActive;
    }

    public void setSrcCommandActive(String srcCommandActive) {
        this.srcCommandActive = srcCommandActive;
    }

//	public Set<Source> getSourceList() {
//		return sourceList;
//	}
//	
//	public void addSource(Source source) {
//		if ( this.sourceList == null ) {
//			this.sourceList = new HashSet<Source>();
//		}
//		this.sourceList.add(source);
//	}
//
//	public void setSourceList(Set<Source> sourceList) {
//		this.sourceList = sourceList;
//	}
//
//	public Set<FieldNormalization> getNormalizationList() {
//		return normalizationList;
//	}
//
//	public void setNormalizationList(Set<FieldNormalization> normalizationList) {
//		this.normalizationList = normalizationList;
//	}
//    
//	public void addNormalization(FieldNormalization fieldNormalization) {
//		if ( this.normalizationList == null ) {
//			this.normalizationList = new HashSet<FieldNormalization>();
//		}
//		 this.normalizationList.add(fieldNormalization);
//	}

    
}
