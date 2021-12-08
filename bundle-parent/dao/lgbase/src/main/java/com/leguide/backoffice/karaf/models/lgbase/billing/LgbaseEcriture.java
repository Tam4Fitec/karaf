package com.leguide.backoffice.karaf.models.lgbase.billing;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "lg_ecritures")
@NamedQueries({
        @NamedQuery(name = "LgbaseEcriture.FIND_ECRITURES", query = "Select ec FROM LgbaseEcriture ec " +
                "WHERE ec.auxiliaire = :clientId  and ec.key.refInterne != 'ANO' ORDER BY ec.dateEcheance DESC")
})
public class LgbaseEcriture {

    public static final String FIND_ECRITURES_FOR_CLIENT = "LgbaseEcriture.FIND_ECRITURES";

    @Id
    @Embedded
    private LgbaseEcriturePrimaryKey key;

    @Column(name = "journal")
    private String journal;

    @Column(name = "numero_piece")
    private Integer numeroPiece;

    @Column(name = "generale")
    private String generale;

    @Column(name = "auxiliaire")
    private String auxiliaire;

    @Column(name = "debit")
    private Float debit;

    @Column(name = "credit")
    private Float credit;

    @Column(name = "libelle")
    private String libelle;

    @Column(name = "nature_piece")
    private String naturePiece;

    @Column(name = "lettrage")
    private String lettrage;

    @Column(name = "date_echeance")
    private Date dateEcheance;

    public LgbaseEcriturePrimaryKey getKey() {
        return key;
    }

    public void setKey(LgbaseEcriturePrimaryKey key) {
        this.key = key;
    }

    public String getJournal() {
        return journal;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    public Integer getNumeroPiece() {
        return numeroPiece;
    }

    public void setNumeroPiece(Integer numeroPiece) {
        this.numeroPiece = numeroPiece;
    }

    public String getGenerale() {
        return generale;
    }

    public void setGenerale(String generale) {
        this.generale = generale;
    }

    public String getAuxiliaire() {
        return auxiliaire;
    }

    public void setAuxiliaire(String auxiliaire) {
        this.auxiliaire = auxiliaire;
    }

    public Float getDebit() {
        return debit;
    }

    public void setDebit(Float debit) {
        this.debit = debit;
    }

    public Float getCredit() {
        return credit;
    }

    public void setCredit(Float credit) {
        this.credit = credit;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getNaturePiece() {
        return naturePiece;
    }

    public void setNaturePiece(String naturePiece) {
        this.naturePiece = naturePiece;
    }

    public String getLettrage() {
        return lettrage;
    }

    public void setLettrage(String lettrage) {
        this.lettrage = lettrage;
    }

    public Date getDateEcheance() {
        return dateEcheance;
    }

    public void setDateEcheance(Date dateEcheance) {
        this.dateEcheance = dateEcheance;
    }

}
