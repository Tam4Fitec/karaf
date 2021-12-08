package com.leguide.backoffice.karaf.dao.brands.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "brands_aliases", uniqueConstraints = { @UniqueConstraint(columnNames = { "name" }) })
@NamedQueries(value = {
        @NamedQuery(name = BrandAliasDTO.FIND_ALL_WITH_NO_FETCH, query = "select distinct b from BrandAliasDTO b"),
        @NamedQuery(name = BrandAliasDTO.FIND_ALL, query = "select distinct b from BrandAliasDTO b inner join fetch b.brand order by b.id"),
        @NamedQuery(name = BrandAliasDTO.COUNT_ALL, query = "select count(distinct b.id) from BrandAliasDTO b"),
        @NamedQuery(name = BrandAliasDTO.FIND_NAMES_INSERTED, query = "select b.name from BrandAliasDTO b where b.name in (:names)"),
        @NamedQuery(name = BrandAliasDTO.FIND_ALIASES_INSERTED, query = "select b from BrandAliasDTO b where b.name in (:names)")})
public final class BrandAliasDTO extends AbstractDTO {

    public static final String FIND_ALL = "BrandAliasDTO.findAll";
    public static final String FIND_ALL_WITH_NO_FETCH = "BrandAliasDTO.findAllWithNoFetch";
    public static final String COUNT_ALL = "BrandAliasDTO.countAll";
    public static final String FIND_NAMES_INSERTED = "BrandAliasDTO.findNamesInserted";
    public static final String FIND_ALIASES_INSERTED = "BrandAliasDTO.findAliasesInsertedByNamesList";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(length = 10, name = "__id")
    private Long id;

    @Column(nullable = false, name = "name")
    private String name;

    @Column(nullable = true, name = "name_normalized")
    private String nameNormalized;

    @Column(name = "activation_date")
    private Date activationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brands_id")
    private BrandDTO brand;

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

    public Date getActivationDate() {
        return this.activationDate;
    }

    public void setActivationDate(Date activationDate) {
        this.activationDate = activationDate;
    }

    public BrandDTO getBrand() {
        return this.brand;
    }

    public void setBrand(BrandDTO brand) {
        this.brand = brand;
    }

    @Override
    public String getMapKey() {
        return this.getName();
    }

    public Long getTemporaryId() {
        return this.temporaryId;
    }

    public void setTemporaryId(Long temporaryId) {
        this.temporaryId = temporaryId;
    }

    public String getNameNormalized() {
        return nameNormalized;
    }

    public void setNameNormalized(String nameNormalized) {
        this.nameNormalized = nameNormalized;
    }
}
