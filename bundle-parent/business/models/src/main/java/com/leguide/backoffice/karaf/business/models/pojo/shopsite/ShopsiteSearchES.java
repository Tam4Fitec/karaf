package com.leguide.backoffice.karaf.business.models.pojo.shopsite;

public class ShopsiteSearchES {
	
	    protected String countryLabel;
	    protected String segmentation;
	    protected String shopState;
	    protected Long shopsiteId;
	    protected String storeName;
	    protected String refState;
	    protected Integer zeusNotation;
	    protected String zeusBlacklist;

	    /**
	     * Obtient la valeur de la propriété countryLabel.
	     * 
	     * @return
	     *     possible object is
	     *     {@link String }
	     *     
	     */
	    public String getCountryLabel() {
	        return countryLabel;
	    }

	    /**
	     * Définit la valeur de la propriété countryLabel.
	     * 
	     * @param value
	     *     allowed object is
	     *     {@link String }
	     *     
	     */
	    public void setCountryLabel(String value) {
	        this.countryLabel = value;
	    }

	    /**
	     * Obtient la valeur de la propriété segmentation.
	     * 
	     * @return
	     *     possible object is
	     *     {@link String }
	     *     
	     */
	    public String getSegmentation() {
	        return segmentation;
	    }

	    /**
	     * Définit la valeur de la propriété segmentation.
	     * 
	     * @param value
	     *     allowed object is
	     *     {@link String }
	     *     
	     */
	    public void setSegmentation(String value) {
	        this.segmentation = value;
	    }

	    /**
	     * Obtient la valeur de la propriété shopState.
	     * 
	     * @return
	     *     possible object is
	     *     {@link String }
	     *     
	     */
	    public String getShopState() {
	        return shopState;
	    }

	    /**
	     * Définit la valeur de la propriété shopState.
	     * 
	     * @param value
	     *     allowed object is
	     *     {@link String }
	     *     
	     */
	    public void setShopState(String value) {
	        this.shopState = value;
	    }

	    /**
	     * Obtient la valeur de la propriété shopsiteId.
	     * 
	     * @return
	     *     possible object is
	     *     {@link Long }
	     *     
	     */
	    public Long getShopsiteId() {
	        return shopsiteId;
	    }

	    /**
	     * Définit la valeur de la propriété shopsiteId.
	     * 
	     * @param value
	     *     allowed object is
	     *     {@link Long }
	     *     
	     */
	    public void setShopsiteId(Long value) {
	        this.shopsiteId = value;
	    }

	    /**
	     * Obtient la valeur de la propriété storeName.
	     * 
	     * @return
	     *     possible object is
	     *     {@link String }
	     *     
	     */
	    public String getStoreName() {
	        return storeName;
	    }

	    /**
	     * Définit la valeur de la propriété storeName.
	     * 
	     * @param value
	     *     allowed object is
	     *     {@link String }
	     *     
	     */
	    public void setStoreName(String value) {
	        this.storeName = value;
	    }
	    
	       

		public String getRefState() {
			return refState;
		}

		public void setRefState(String refState) {
			this.refState = refState;
		}

		public Integer getZeusNotation() {
			return zeusNotation;
		}

		public void setZeusNotation(Integer zeusNotation) {
			this.zeusNotation = zeusNotation;
		}

		public String getZeusBlacklist() {
			return zeusBlacklist;
		}

		public void setZeusBlacklist(String zeusBlacklist) {
			this.zeusBlacklist = zeusBlacklist;
		}

		@Override
		public String toString() {
			return "ShopsiteSearchES [countryLabel=" + countryLabel
					+ ", segmentation=" + segmentation + ", shopState="
					+ shopState + ", shopsiteId=" + shopsiteId + ", storeName="
					+ storeName + ", refState=" + refState + ", zeusNotation="
					+ zeusNotation + ", zeusBlacklist=" + zeusBlacklist + "]";
		}

		
		
		
}
