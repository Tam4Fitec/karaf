package com.leguide.backoffice.karaf.business.models.pojo.shopsite.state;

import java.io.Serializable;

public class RefStateOptions implements Serializable {
    private static final long serialVersionUID = 1L;

    private Boolean partnerEnabled;
    private Boolean logoEnabled;
    private Boolean engineLogoEnabled;
    private Boolean productsDisplayed;
    private Boolean dooyooEnabled;
    private Boolean strategic;
    private Boolean adultContent;

    public RefStateOptions() {
    }

    private RefStateOptions(Builder builder) {
        this.partnerEnabled = builder.partnerEnabled;
        this.logoEnabled = builder.logoEnabled;
        this.engineLogoEnabled = builder.engineLogoEnabled;
        this.productsDisplayed = builder.productsDisplayed;
        this.dooyooEnabled = builder.dooyooEnabled;
        this.strategic = builder.strategic;
        this.adultContent = builder.adultContent;
    }

    public Boolean isPartnerEnabled() {
        return partnerEnabled;
    }

    public void setPartnerEnabled(Boolean partnerEnabled) {
        this.partnerEnabled = partnerEnabled;
    }

    public Boolean isLogoEnabled() {
        return logoEnabled;
    }

    public void setLogoEnabled(Boolean logoEnabled) {
        this.logoEnabled = logoEnabled;
    }

    public Boolean isEngineLogoEnabled() {
        return engineLogoEnabled;
    }

    public void setEngineLogoEnabled(Boolean engineLogoEnabled) {
        this.engineLogoEnabled = engineLogoEnabled;
    }

    public Boolean isProductsDisplayed() {
        return productsDisplayed;
    }

    public void setProductsDisplayed(Boolean productsDisplayed) {
        this.productsDisplayed = productsDisplayed;
    }

    public Boolean isDooyooEnabled() {
        return dooyooEnabled;
    }

    public void setDooyooEnabled(Boolean dooyooEnabled) {
        this.dooyooEnabled = dooyooEnabled;
    }

    public Boolean isStrategic() {
        return strategic;
    }

    public void setStrategic(Boolean strategic) {
        this.strategic = strategic;
    }

    public Boolean hasAdultContent() {
		return adultContent;
	}
    
    public void setAdultContent(Boolean adultContent) {
		this.adultContent = adultContent;
	}
        
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof RefStateOptions))
			return false;
		RefStateOptions other = (RefStateOptions) obj;
		if (adultContent == null) {
			if (other.adultContent != null)
				return false;
		} else if (!adultContent.equals(other.adultContent))
			return false;
		if (dooyooEnabled == null) {
			if (other.dooyooEnabled != null)
				return false;
		} else if (!dooyooEnabled.equals(other.dooyooEnabled))
			return false;
		if (engineLogoEnabled == null) {
			if (other.engineLogoEnabled != null)
				return false;
		} else if (!engineLogoEnabled.equals(other.engineLogoEnabled))
			return false;
		if (logoEnabled == null) {
			if (other.logoEnabled != null)
				return false;
		} else if (!logoEnabled.equals(other.logoEnabled))
			return false;
		if (partnerEnabled == null) {
			if (other.partnerEnabled != null)
				return false;
		} else if (!partnerEnabled.equals(other.partnerEnabled))
			return false;
		if (productsDisplayed == null) {
			if (other.productsDisplayed != null)
				return false;
		} else if (!productsDisplayed.equals(other.productsDisplayed))
			return false;
		if (strategic == null) {
			if (other.strategic != null)
				return false;
		} else if (!strategic.equals(other.strategic))
			return false;
		return true;
	}
    
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
		private Boolean partnerEnabled;
        private Boolean logoEnabled;
        private Boolean engineLogoEnabled;
        private Boolean productsDisplayed;
        private Boolean dooyooEnabled;
        private Boolean strategic;
        private Boolean adultContent;

        public Builder initAll(boolean bool) {
            partnerEnabled = bool;
            logoEnabled = bool;
            engineLogoEnabled = bool;
            productsDisplayed = bool;
            dooyooEnabled = bool;
            strategic = bool;
            adultContent = bool;
            return this;
        }

        public Builder copy(RefStateOptions options) {
            partnerEnabled(options.isPartnerEnabled());
            logoEnabled(options.isLogoEnabled());
            engineLogoEnabled(options.isEngineLogoEnabled());
            productsDisplayed(options.isProductsDisplayed());
            dooyooEnabled(options.isDooyooEnabled());
            isStrategic(options.isStrategic());
            hasAdultContent(options.hasAdultContent());
            return this;
        }

		public Builder enablePartner() {
            this.partnerEnabled = true;
            return this;
        }

        public Builder partnerEnabled(Boolean enabled) {
            this.partnerEnabled = enabled;
            return this;
        }

        public Builder enableLogo() {
            this.logoEnabled = true;
            return this;
        }

        public Builder logoEnabled(Boolean enabled) {
            this.logoEnabled = enabled;
            return this;
        }

        public Builder enableEngineLogo() {
            this.engineLogoEnabled = true;
            return this;
        }

        public Builder engineLogoEnabled(Boolean enabled) {
            this.engineLogoEnabled = enabled;
            return this;
        }

        public Builder displayProducts() {
            this.productsDisplayed = true;
            return this;
        }

        public Builder productsDisplayed(Boolean display) {
            this.productsDisplayed = display;
            return this;
        }

        public Builder enableDooyoo() {
            this.dooyooEnabled = true;
            return this;
        }

        public Builder dooyooEnabled(Boolean enabled) {
            this.dooyooEnabled = enabled;
            return this;
        }

        public Builder strategic() {
            this.strategic = true;
            return this;
        }

        public Builder isStrategic(Boolean strategic) {
            this.strategic = strategic;
            return this;
        }
        
        public Builder hasAdultContent(Boolean adultOnly) {
        	this.adultContent = adultOnly;
        	return this;
		}
        public Builder hasAdultContent() {
        	this.adultContent = true;
        	return this;
		}

        public RefStateOptions build() {
            return new RefStateOptions(this);
        }
    }

}
