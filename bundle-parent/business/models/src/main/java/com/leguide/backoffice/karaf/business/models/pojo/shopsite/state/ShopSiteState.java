package com.leguide.backoffice.karaf.business.models.pojo.shopsite.state;

import com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.enums.ReferentialStateEnum;
import com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.enums.SegmentationEnum;

import java.io.Serializable;


public class ShopSiteState implements Serializable {
    private static final long serialVersionUID = 1L;

    private ReferentialState referentialState;
    private ShopState shopState;
    private MerchantPrice price;
    private MerchantSort sort;
    private ClicType clicType;
    private StateReason reason;
    private SegmentationEnum segmentation;
    private Long kSite = -1l;
    private RefStateOptions options;
    private Integer zeusNotation;

    public ShopSiteState() {
    	options = new RefStateOptions();
    }

    public ShopSiteState(ShopSiteState state) {
        this.referentialState = state.getReferentialState();
        this.shopState = state.getShopState();
        this.price = state.getPrice();
        this.sort = state.getSort();
        this.clicType = state.getClicType();
        this.reason = state.getReason();
        this.segmentation = state.getSegmentation();
        this.kSite = state.getkSite();
        this.zeusNotation = state.getZeusNotation();
        this.options = RefStateOptions.builder().copy(state.getOptions()).build();
    }

    public ShopSiteState(ReferentialStateEnum refState) {
        this.referentialState = refState;
        this.shopState = refState.getDefaultShopState();
        this.price = refState.getDefaultPrice();
        this.sort = refState.getDefaultSort();
        this.clicType = refState.getDefaultClicType();
        this.reason = refState.getDefaultReason();
        this.segmentation = refState.getDefaultSegmentation();
        this.options = refState.getDefaultOptions();
    }

    public ShopSiteState(ReferentialStateEnum refState, Integer zeusNotation) {
        this.referentialState = refState;
        this.shopState = refState.getDefaultShopState();
        this.price = refState.getDefaultPrice();
        this.sort = refState.getDefaultSort();
        this.clicType = refState.getDefaultClicType();
        this.reason = refState.getDefaultReason();
        this.segmentation = refState.getDefaultSegmentation();
        this.options = refState.getDefaultOptions();
        this.zeusNotation = zeusNotation;
    }

    public ShopSiteState(ReferentialStateEnum refState, RefStateOptions options) {
        this.referentialState = refState;
        this.shopState = refState.getDefaultShopState();
        this.price = refState.getDefaultPrice();
        this.sort = refState.getDefaultSort();
        this.clicType = refState.getDefaultClicType();
        this.reason = refState.getDefaultReason();
        this.segmentation = refState.getDefaultSegmentation();
        this.options = options;
    }

    public ShopSiteState(ReferentialStateEnum refState, RefStateOptions options, SegmentationEnum segmentation) {
        this.referentialState = refState;
        this.shopState = refState.getDefaultShopState();
        this.price = refState.getDefaultPrice();
        this.sort = refState.getDefaultSort();
        this.clicType = refState.getDefaultClicType();
        this.reason = refState.getDefaultReason();
        this.segmentation = segmentation;
        this.options = options;
    }

    public ShopSiteState(ReferentialStateEnum refState, RefStateOptions options, SegmentationEnum segmentation, Long ksite, Integer zeusNotation) {
        this.referentialState = refState;
        this.shopState = refState.getDefaultShopState();
        this.price = refState.getDefaultPrice();
        this.sort = refState.getDefaultSort();
        this.clicType = refState.getDefaultClicType();
        this.reason = refState.getDefaultReason();
        this.segmentation = segmentation;
        this.options = options;
        this.kSite = ksite;
        this.zeusNotation = zeusNotation;
    }

    public ReferentialState getReferentialState() {
        return referentialState;
    }

    public void setReferentialState(ReferentialState referentialState) {
        this.referentialState = referentialState;
    }

    public ShopState getShopState() {
        return shopState;
    }

    public void setShopState(ShopState shopState) {
        this.shopState = shopState;
    }

    public MerchantPrice getPrice() {
        return price;
    }

    public void setPrice(MerchantPrice price) {
        this.price = price;
    }

    public MerchantSort getSort() {
        return sort;
    }

    public void setSort(MerchantSort sort) {
        this.sort = sort;
    }

    public ClicType getClicType() {
        return clicType;
    }

    public void setClicType(ClicType clicType) {
        this.clicType = clicType;
    }

    public SegmentationEnum getSegmentation() {
        return segmentation;
    }

    public void setSegmentation(SegmentationEnum segmentation) {
        this.segmentation = segmentation;
    }

    public StateReason getReason() {
        return reason;
    }

    public void setReason(StateReason reason) {
        this.reason = reason;
    }

    public Long getKSite() {
        return kSite;
    }

    public Long getkSite() {
        return kSite;
    }

    public void setkSite(Long kSite) {
        this.kSite = kSite;
    }

    public RefStateOptions getOptions() {
        return options;
    }

    public void setOptions(RefStateOptions options) {
        this.options = options;
    }

    public Integer getZeusNotation() {
        return zeusNotation;
    }

    public void setZeusNotation(Integer zeusNotation) {
        this.zeusNotation = zeusNotation;
    }

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ShopSiteState))
			return false;
		ShopSiteState other = (ShopSiteState) obj;
		if (referentialState == null) {
			if (other.referentialState != null)
				return false;
		} else if (!referentialState.equals(other.referentialState))
			return false;
		if (shopState == null) {
			if (other.shopState != null)
				return false;
		} else if (!shopState.equals(other.shopState))
			return false;
		if (reason == null) {
			if (other.reason != null)
				return false;
		} else if (!reason.equals(other.reason))
			return false;
		if (options == null) {
			if (other.options != null)
				return false;
		} else if (!options.equals(other.options))
			return false;
		if (segmentation != other.segmentation)
			return false;
		if (zeusNotation == null) {
			if (other.zeusNotation != null)
				return false;
		} else if (!zeusNotation.equals(other.zeusNotation))
			return false;
		if (kSite == null) {
			if (other.kSite != null)
				return false;
		} else if (!kSite.equals(other.kSite))
			return false;
		return true;
	}
    
}
