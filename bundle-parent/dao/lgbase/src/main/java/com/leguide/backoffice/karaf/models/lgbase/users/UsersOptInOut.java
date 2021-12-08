package com.leguide.backoffice.karaf.models.lgbase.users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity
@Table(name = "tb_users_opt_in_out")
@XmlRootElement(name = "UsersOptInOut")
public class UsersOptInOut implements Serializable {

    private static final long serialVersionUID = 9147045562391300031L;

    @Id
    @Column(name = "id_user")
    private Long userId;

    @Column(name = "uso_tips")
    private String tips;

    @Column(name = "uso_leguide")
    private String leguide;

    @Column(name = "uso_evenement")
    private String evenement;

    @Column(name = "uso_partners")
    private String partners;

    @Column(name = "uso_stats")
    private String stats;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public String getLeguide() {
        return leguide;
    }

    public void setLeguide(String leguide) {
        this.leguide = leguide;
    }

    public String getEvenement() {
        return evenement;
    }

    public void setEvenement(String evenement) {
        this.evenement = evenement;
    }

    public String getPartners() {
        return partners;
    }

    public void setPartners(String partners) {
        this.partners = partners;
    }

    public String getStats() {
        return stats;
    }

    public void setStats(String stats) {
        this.stats = stats;
    }


}
