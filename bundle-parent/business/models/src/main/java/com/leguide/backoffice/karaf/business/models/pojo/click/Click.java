package com.leguide.backoffice.karaf.business.models.pojo.click;

import java.util.Date;

import com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.ClicType;

public class Click {

	// adresse IP de l'internaute
	private String ip;
	private String userAgent;
	// quel clic sur quel site. 
	// Exemple clic offre sur LeGuide.com et clic offre sur Webmarchand.com on un ID action différent. De même pour un clic offre et un clic annuaire de LeGuide.com
	private Long idAction = 0l;
    private Long storeId = 0l;
    private String country;
    private Long idPromo = 0l;
    // idx : identifiant de la catégorie
    private Long idCategory = 0l;
    // identifiant de la newsletter. 0 pour un clic hors newsletter
    private Long newsId;
    // identifiant de l'abonné Leguide.com : 0 par défaut
    private Long idSubscriber = 0l;
    // identifiant de la recherche
    private String idSearch;
    private ClicType type;
    // identifiant de la source d'achat de trafic. 0 si vide
    private Long idAds;
    
    private Date date;

	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getUserAgent() {
		return userAgent;
	}
	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}
	public Long getIdAction() {
		return idAction;
	}
	public void setIdAction(Long idAction) {
		this.idAction = idAction;
	}
	public Long getStoreId() {
		return storeId;
	}
	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Long getIdPromo() {
		return idPromo;
	}
	public void setIdPromo(Long idPromo) {
		this.idPromo = idPromo;
	}
	public Long getIdCategory() {
		return idCategory;
	}
	public void setIdCategory(Long idCategory) {
		this.idCategory = idCategory;
	}
	public Long getNewsId() {
		return newsId;
	}
	public void setNewsId(Long newsId) {
		this.newsId = newsId;
	}
	public Long getIdSubscriber() {
		return idSubscriber;
	}
	public void setIdSubscriber(Long idSubscriber) {
		this.idSubscriber = idSubscriber;
	}
	public String getIdSearch() {
		return idSearch;
	}
	public void setIdSearch(String idSearch) {
		this.idSearch = idSearch;
	}
	public ClicType getType() {
		return type;
	}
	public void setType(ClicType type) {
		this.type = type;
	}
	public Long getIdAds() {
		return idAds;
	}
	public void setIdAds(Long idAds) {
		this.idAds = idAds;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
    
}
