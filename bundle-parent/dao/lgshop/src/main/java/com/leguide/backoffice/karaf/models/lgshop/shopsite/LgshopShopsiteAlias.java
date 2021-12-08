package com.leguide.backoffice.karaf.models.lgshop.shopsite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="tb_shopsite_alias")
public class LgshopShopsiteAlias implements Serializable {

    private static final long serialVersionUID = -8975885766781601992L;

    @Id
    @Column(name="id_shopsite")
    private Long shopsiteId;

    @Column(name="alias1")
    private String alias1;

    @Column(name="alias2")
    private String alias2;

    @Column(name="alias3")
    private String alias3;

    @Column(name="alias4")
    private String alias4;

    @Column(name="alias5")
    private String alias5;

    public Long getShopsiteId() {
        return shopsiteId;
    }

    public void setShopsiteId(Long shopsiteId) {
        this.shopsiteId = shopsiteId;
    }

    public String getAlias1() {
        return alias1;
    }

    public void setAlias1(String alias1) {
        this.alias1 = alias1;
    }

    public String getAlias2() {
        return alias2;
    }

    public void setAlias2(String alias2) {
        this.alias2 = alias2;
    }

    public String getAlias3() {
        return alias3;
    }

    public void setAlias3(String alias3) {
        this.alias3 = alias3;
    }

    public String getAlias4() {
        return alias4;
    }

    public void setAlias4(String alias4) {
        this.alias4 = alias4;
    }

    public String getAlias5() {
        return alias5;
    }

    public void setAlias5(String alias5) {
        this.alias5 = alias5;
    }
}
