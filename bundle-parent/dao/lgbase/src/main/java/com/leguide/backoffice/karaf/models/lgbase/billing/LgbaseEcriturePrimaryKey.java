package com.leguide.backoffice.karaf.models.lgbase.billing;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Date;

@Embeddable
public class LgbaseEcriturePrimaryKey implements Serializable {

    private static final long serialVersionUID = 3030085433739480229L;

    @Column(name = "date_comptable")
    private Date dateComptable;

    @Column(name = "ref_interne")
    private String refInterne;

    @Column(name = "sens")
    private String sens;

    public Date getDateComptable() {
        return dateComptable;
    }

    public void setDateComptable(Date dateComptable) {
        this.dateComptable = dateComptable;
    }

    public String getRefInterne() {
        return refInterne;
    }

    public void setRefInterne(String refInterne) {
        this.refInterne = refInterne;
    }

    public String getSens() {
        return sens;
    }

    public void setSens(String sens) {
        this.sens = sens;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LgbaseEcriturePrimaryKey that = (LgbaseEcriturePrimaryKey) o;

        if (dateComptable != null ? !dateComptable.equals(that.dateComptable) : that.dateComptable != null)
            return false;
        if (refInterne != null ? !refInterne.equals(that.refInterne) : that.refInterne != null) return false;
        if (sens != null ? !sens.equals(that.sens) : that.sens != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dateComptable != null ? dateComptable.hashCode() : 0;
        result = 31 * result + (refInterne != null ? refInterne.hashCode() : 0);
        result = 31 * result + (sens != null ? sens.hashCode() : 0);
        return result;
    }
}
