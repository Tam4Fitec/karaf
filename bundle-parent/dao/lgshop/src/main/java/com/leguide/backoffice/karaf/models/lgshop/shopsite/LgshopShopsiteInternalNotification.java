package com.leguide.backoffice.karaf.models.lgshop.shopsite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "tb_shopsite_internal_notification")
public class LgshopShopsiteInternalNotification implements Serializable {

    private static final long serialVersionUID = 6744193860295750925L;

    @Id
    @Column(name = "id_shopsite")
    private Long shopsiteId;

    @Column(name = "sin_price")
    private Float price;

    @Column(name = "sin_security")
    private Float security;

    @Column(name = "sin_service")
    private Float service;

    @Column(name = "sin_ergonomic")
    private Float ergonomic;

    @Column(name = "sin_catalog")
    private Float catalog;

    @Column(name = "sin_note_global")
    private Float noteGlobal;

    @Column(name = "sin_note_comment")
    private String noteComment;

    @Column(name = "sin_leguide_comment")
    private String leguideComment;

    @Column(name = "sin_public_comment")
    private String publicComment;

    public Long getShopsiteId() {
        return shopsiteId;
    }

    public void setShopsiteId(Long shopsiteId) {
        this.shopsiteId = shopsiteId;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getSecurity() {
        return security;
    }

    public void setSecurity(Float security) {
        this.security = security;
    }

    public Float getService() {
        return service;
    }

    public void setService(Float service) {
        this.service = service;
    }

    public Float getErgonomic() {
        return ergonomic;
    }

    public void setErgonomic(Float ergonomic) {
        this.ergonomic = ergonomic;
    }

    public Float getCatalog() {
        return catalog;
    }

    public void setCatalog(Float catalog) {
        this.catalog = catalog;
    }

    public Float getNoteGlobal() {
        return noteGlobal;
    }

    public void setNoteGlobal(Float noteGlobal) {
        this.noteGlobal = noteGlobal;
    }

    public String getNoteComment() {
        return noteComment;
    }

    public void setNoteComment(String noteComment) {
        this.noteComment = noteComment;
    }

    public String getLeguideComment() {
        return leguideComment;
    }

    public void setLeguideComment(String leguideComment) {
        this.leguideComment = leguideComment;
    }

    public String getPublicComment() {
        return publicComment;
    }

    public void setPublicComment(String publicComment) {
        this.publicComment = publicComment;
    }
}
