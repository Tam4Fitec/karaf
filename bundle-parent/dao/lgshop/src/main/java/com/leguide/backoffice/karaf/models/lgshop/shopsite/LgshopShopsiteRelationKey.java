package com.leguide.backoffice.karaf.models.lgshop.shopsite;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class LgshopShopsiteRelationKey implements Serializable {

    private static final long serialVersionUID = -2147483832245973710L;

    @Column(name = "id_label")
    private Integer labelId;

    @Column(name = "id_shopsite")
    private Long shopsiteId;

    @Column(name = "shr_namespace")
    private String namespace;

    public LgshopShopsiteRelationKey() {
    }

    public LgshopShopsiteRelationKey(Integer labelId, Long shopsiteId, String namespace) {
        this.labelId = labelId;
        this.shopsiteId = shopsiteId;
        this.namespace = namespace;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LgshopShopsiteRelationKey that = (LgshopShopsiteRelationKey) o;

        if (labelId != null ? !labelId.equals(that.labelId) : that.labelId != null) return false;
        if (namespace != null ? !namespace.equals(that.namespace) : that.namespace != null) return false;
        if (shopsiteId != null ? !shopsiteId.equals(that.shopsiteId) : that.shopsiteId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = labelId != null ? labelId.hashCode() : 0;
        result = 31 * result + (shopsiteId != null ? shopsiteId.hashCode() : 0);
        result = 31 * result + (namespace != null ? namespace.hashCode() : 0);
        return result;
    }

    public Integer getLabelId() {
        return labelId;
    }

    public void setLabelId(Integer labelId) {
        this.labelId = labelId;
    }

    public Long getShopsiteId() {
        return shopsiteId;
    }

    public void setShopsiteId(Long shopsiteId) {
        this.shopsiteId = shopsiteId;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }
}
