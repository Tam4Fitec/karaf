package com.leguide.backoffice.karaf.models.lgshop.referentiel;

import javax.persistence.*;

@Entity
@Table(name = "rf_label")
@NamedQueries({
        @NamedQuery(
                name = "LgshopRefLabel.FIND_ACTIVE_BY_NAMESPACE_AND_LOCALE",
                query = "Select rl FROM LgshopRefLabel rl " +
                        "WHERE rl.namespace = :namespace AND rl.locale = :locale AND rl.enabled = 'Y' ORDER BY rl.rank")
})
public class LgshopRefLabel {

    public static final String FIND_ACTIVE_BY_NAMESPACE_AND_LOCALE = "LgshopRefLabel.FIND_ACTIVE_BY_NAMESPACE_AND_LOCALE";

    @Id
    @Column(name = "id_lbl")
    private Long id;

    @Column(name = "lbl_namespace")
    private String namespace;

    @Column(name = "lbl_locale")
    private String locale;

    @Column(name = "id_label")
    private Integer labelId;

    @Column(name = "lbl_label")
    private String label;

    @Column(name = "lbl_rank")
    private Integer rank;

    @Column(name = "lbl_enabled")
    private String enabled;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public Integer getLabelId() {
        return labelId;
    }

    public void setLabelId(Integer labelId) {
        this.labelId = labelId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }
}
