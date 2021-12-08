package com.leguide.backoffice.karaf.models.lgshop.referentiel;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

//table linking localized labels to rf_ksite. If not labels linked to the ksite, then you need to fallback on rf_ksite.desc. 
@Entity
@Table(name="rf_ksite_label")
@NamedQueries(
        { @NamedQuery(name = LgshopRefKSiteLabel.FIND_ALL_BY_RF_KSITE, query = "select ksiteRefLabel FROM LgshopRefKSiteLabel " +
        		"ksiteRefLabel where ksiteRefLabel.key.rfKSiteId = :rfksiteid")
        
        })
public class LgshopRefKSiteLabel implements Serializable {   

    private static final long serialVersionUID = 6755382693893333132L;

    public static final String FIND_ALL_BY_RF_KSITE = "LgshopRefKSiteLabel.find_all_by_rf_ksite";

    @EmbeddedId
    private LgshopRefKSiteLabelKey key;

    public LgshopRefKSiteLabel() {}
    
    public LgshopRefKSiteLabel(LgshopRefKSiteLabelKey key) {
        this.setKey(key);
    }

    public LgshopRefKSiteLabelKey getKey() {
        return key;
    }

    public void setKey(LgshopRefKSiteLabelKey key) {
        this.key = key;
    }

}
