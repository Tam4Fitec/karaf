package com.leguide.backoffice.karaf.dao.brands.entity;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "brands", uniqueConstraints = { @UniqueConstraint(columnNames = { "name" }) })
@NamedQueries(value = {
        @NamedQuery(name = BrandDTO.FIND_BY_NAME, query = "select distinct b from BrandDTO b where b.name = :brandName"),
        @NamedQuery(name = BrandDTO.FIND_BY_NAME_INCLUDING_ALIASES, query = "select distinct b from BrandDTO b left join fetch b.brandAliases where b.name = :brandName"),
        @NamedQuery(name = BrandDTO.SEARCH_BY_NAME, query = "select distinct b from BrandDTO b where b.name = :brandName"),
        @NamedQuery(name = BrandDTO.SEARCH_BY_NAME_INCLUDING_ALIASES, query = "select distinct b from BrandDTO b left join fetch b.brandAliases where b.name like :brandName"),
        @NamedQuery(name = BrandDTO.FIND_BY_ID, query = "select b from BrandDTO b where b.id = :brandId"),
        @NamedQuery(name = BrandDTO.FIND_BY_ID_INCLUDING_ALIASES, query = "select b from BrandDTO b left join fetch b.brandAliases where b.id = :brandId"),
        @NamedQuery(name = BrandDTO.FIND_NAMES_INSERTED, query = "select b.name from BrandDTO b where b.name in (:names)"),
        @NamedQuery(name = BrandDTO.COUNT_BRANDS, query = "select count(b) from BrandDTO b"),
        @NamedQuery(name = BrandDTO.FIND_BY_IDS, query = "select b from BrandDTO b where b.id in (:brandIds)"),
        @NamedQuery(name = BrandDTO.FIND_BY_IDS_INCLUDING_ALIASES, query = "select distinct b from BrandDTO b left join fetch b.brandAliases where b.id in (:brandIds)")})
public final class BrandDTO extends AbstractDTO {

    public static final String FIND_BY_NAME = "BrandDTO.findByName";
    public static final String FIND_BY_NAME_INCLUDING_ALIASES = "BrandDTO.findByNameIncludingAliases";
    public static final String SEARCH_BY_NAME = "BrandDTO.searchByNameLarge";
    public static final String SEARCH_BY_NAME_INCLUDING_ALIASES = "BrandDTO.searchByNameIncludingAliasesLarge";
    public static final String FIND_BY_ID = "BrandDTO.findById";
    public static final String FIND_BY_ID_INCLUDING_ALIASES = "BrandDTO.findByIdIncludingAliases";
    public static final String FIND_NAMES_INSERTED = "BrandDTO.findNamesInserted";
    public static final String COUNT_BRANDS = "BrandDTO.countBrands";
    public static final String FIND_BY_IDS = "BrandDTO.findByIds";
    public static final String FIND_BY_IDS_INCLUDING_ALIASES = "BrandDTO.findByIdsIncludingAliases";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(length = 10, name = "__id")
    private Long id;

    @Column(nullable = false, name = "name", unique = true)
    private String name;

    @Column(name = "name_normalized")
    private String normalizedName;

    @Column(name = "name_seo")
    private String seoName;

    @Column(name = "blacklisted_seo")
    private Boolean blacklistedSeo;

    @Column(name = "blacklisted_sem")
    private Boolean blacklistedSem;

    @Column(name = "activation_date")
    private Date activationDate;

    @OneToMany(mappedBy = "brand", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<BrandAliasDTO> brandAliases;

    @Transient
    private Long temporaryId;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeoName() {
        return this.seoName;
    }

    public void setSeoName(String seoName) {
        this.seoName = seoName;
    }

    public String getNormalizedName() {
        return this.normalizedName;
    }

    public void setNormalizedName(String normalizedName) {
        this.normalizedName = normalizedName;
    }

    public Date getActivationDate() {
        return this.activationDate;
    }

    public void setActivationDate(Date activationDate) {
        this.activationDate = activationDate;
    }

    public Set<BrandAliasDTO> getBrandAliases() {
        return this.brandAliases;
    }

    public void setBrandAliases(Set<BrandAliasDTO> brandAliases) {
        this.brandAliases = brandAliases;
    }

    public Boolean getBlacklistedSeo() {
        return this.blacklistedSeo;
    }

    public void setBlacklistedSeo(Boolean blacklistedSeo) {
        this.blacklistedSeo = blacklistedSeo;
    }

    public Boolean getBlacklistedSem() {
        return this.blacklistedSem;
    }

    public void setBlacklistedSem(Boolean blacklistedSem) {
        this.blacklistedSem = blacklistedSem;
    }

    public Long getTemporaryId() {
        return this.temporaryId;
    }

    public void setTemporaryId(Long temporaryId) {
        this.temporaryId = temporaryId;
    }

    @Override
    public String getMapKey() {
        return this.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BrandDTO brandDTO = (BrandDTO) o;

        if (id != null ? !id.equals(brandDTO.id) : brandDTO.id != null) return false;
        if (name != null ? !name.equals(brandDTO.name) : brandDTO.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BrandDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", normalizedName='" + normalizedName + '\'' +
                ", seoName='" + seoName + '\'' +
                ", blacklistedSeo=" + blacklistedSeo +
                ", blacklistedSem=" + blacklistedSem +
                ", activationDate=" + activationDate +
                ", brandAliases=" + brandAliases +
                ", temporaryId=" + temporaryId +
                '}';
    }
}
