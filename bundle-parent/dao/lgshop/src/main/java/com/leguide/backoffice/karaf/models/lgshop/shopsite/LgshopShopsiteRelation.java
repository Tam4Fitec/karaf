package com.leguide.backoffice.karaf.models.lgshop.shopsite;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_shopsite_relation")
@SqlResultSetMappings({
        @SqlResultSetMapping(name = "mappingLabel", columns = {
                @ColumnResult(name = "lbl_label")})
})
@NamedQueries({
        @NamedQuery(
                name = "LgshopShopsiteRelation.FIND_BY_SHOPSITE_AND_NAMESPACE",
                query = "Select sr FROM LgshopShopsiteRelation sr " +
                        "WHERE sr.key.shopsiteId = :shopsiteId AND sr.key.namespace = :namespace")
})
@NamedNativeQueries({
        @NamedNativeQuery(
                name = "LgshopShopsiteRelation.DELETE_BY_SHOPSITE_AND_NAMESPACE",
                query = "DELETE FROM tb_shopsite_relation WHERE id_shopsite = ? AND shr_namespace = ?"
        ),
        @NamedNativeQuery(
                name = "ShopsitePaymentInfo.findByNamespaceAndShopsiteId",
                query = "SELECT l.lbl_label FROM lgshop.tb_shopsite_relation_nm r, lgshop.rf_label l, lgshop.tb_shopsite_delivery d where r.rf_label_id = l.id_lbl and d.id_shopsite = rf_shopsite_id and rf_shopsite_id = ? and lbl_namespace = ?",
                resultClass = String.class,
                resultSetMapping = "mappingLabel"),
        @NamedNativeQuery(
                name = "ShopsiteDeliveryAvailable.findByShopsiteIdAndEmail",
                query = "select lbl_label from (SELECT l.lbl_label FROM lgshop.tb_shopsite_relation_nm r, lgshop.rf_label l, lgshop.tb_shopsite_delivery d where rf_shopsite_id = ? and lbl_namespace = 'delivery_available' and r.rf_label_id = l.id_lbl and d.id_shopsite = rf_shopsite_id and id_label <> 99 " +
                "UNION SELECT concat(l.lbl_label, ' : ', d.shd_delivery_mode_other) FROM lgshop.tb_shopsite_relation_nm r, lgshop.rf_label l, lgshop.tb_shopsite_delivery d where rf_shopsite_id = ? and lbl_namespace = 'delivery_available' and r.rf_label_id = l.id_lbl and d.id_shopsite = rf_shopsite_id and id_label = 99) modes where lbl_label is not null",
                resultClass = String.class,
                resultSetMapping = "mappingLabel")
})

public class LgshopShopsiteRelation implements Serializable {

    private static final long serialVersionUID = 2993964242817118787L;

    public static final String FIND_BY_SHOPSITE_AND_NAMESPACE = "LgshopShopsiteRelation.FIND_BY_SHOPSITE_AND_NAMESPACE";
    public static final String DELETE_BY_SHOPSITE_AND_NAMESPACE = "LgshopShopsiteRelation.DELETE_BY_SHOPSITE_AND_NAMESPACE";
    public static final String FIND_PAYMENT_INFO_BY_SHOPSITE_ID_AND_NAMESPACE = "ShopsitePaymentInfo.findByNamespaceAndShopsiteId";
    public static final String FIND_DELIVERY_AVAILABLE_BY_SHOPSITE_ID = "ShopsiteDeliveryAvailable.findByShopsiteIdAndEmail";

    @EmbeddedId
    private LgshopShopsiteRelationKey key;

    public LgshopShopsiteRelation() {
    }

    public LgshopShopsiteRelation(LgshopShopsiteRelationKey key) {
        this.key = key;
    }

    public LgshopShopsiteRelationKey getKey() {
        return key;
    }

    public void setKey(LgshopShopsiteRelationKey key) {
        this.key = key;
    }
}
