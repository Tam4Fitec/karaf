package com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.enums;

import static com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.enums.MerchantPriceEnum.CATEGORY;
import static com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.enums.MerchantPriceEnum.CPO;
import static com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.enums.MerchantPriceEnum.INDIFFERENT;
import static com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.enums.MerchantPriceEnum.UNSPECIFIED;
import static com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.enums.MerchantPriceEnum.CPC;
import static com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.enums.MerchantSortEnum.AFFILIATED_PLUS;
import static com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.enums.MerchantSortEnum.MINIMUM;
import static com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.enums.MerchantSortEnum.PRIORITY_MINUS;
import static com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.enums.MerchantSortEnum.PRIORITY_PLUS;
import static com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.enums.ShopStateEnum.CLIENT;
import static com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.enums.ShopStateEnum.FREE_PLUS;
import static com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.enums.ShopStateEnum.NEW;
import static com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.enums.ShopStateEnum.STANDBY;
import static com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.enums.StateReasonEnum.APPROVED_FREE;
import static com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.enums.StateReasonEnum.TECHNICAL_SUSPENSION;

import com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.ClicType;
import com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.MerchantPrice;
import com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.MerchantSort;
import com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.RefStateOptions;
import com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.ReferentialState;
import com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.ShopState;
import com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.StateReason;

public enum ReferentialStateEnum implements ReferentialState {
	NON_REFERENCED(19, "Non Referenced", NEW, INDIFFERENT, MerchantSortEnum.FREE, ClicTypeEnum.FREE, null, RefStateOptions.builder().initAll(false).displayProducts().build()),
	REFERENCED_FREE(18, "Free", ShopStateEnum.FREE, INDIFFERENT, MerchantSortEnum.FREE, ClicTypeEnum.FREE, null, RefStateOptions.builder().initAll(false).displayProducts().build()),
	REFERENCED_FREE_PLUS(17, "Free plus", FREE_PLUS, INDIFFERENT, MerchantSortEnum.FREE, ClicTypeEnum.FREE, APPROVED_FREE, RefStateOptions.builder().initAll(false).displayProducts().build()),
	NORMAL_CLIENT(1, "Normal Client", CLIENT, CATEGORY, PRIORITY_PLUS, ClicTypeEnum.PAID, null, RefStateOptions.builder().initAll(false).enablePartner().enableLogo().enableEngineLogo().displayProducts().enableDooyoo().build()),
	MARKET_PLACE(14, "Market Place", CLIENT, CATEGORY, PRIORITY_MINUS, ClicTypeEnum.PAID, null, RefStateOptions.builder().initAll(false).enablePartner().enableLogo().enableEngineLogo().displayProducts().build()),
	CLASSIFIEDS(15, "Classifieds", CLIENT, CATEGORY, MINIMUM, ClicTypeEnum.PAID, null, RefStateOptions.builder().initAll(false).enableLogo().enableEngineLogo().displayProducts().build()),
	AFFILIATE_PLUS(10, "Affiliate plus", ShopStateEnum.AFFILIATE, CPO, AFFILIATED_PLUS, ClicTypeEnum.FREE, null, RefStateOptions.builder().initAll(false).enableLogo().enableEngineLogo().enableDooyoo().build()),
	AFFILIATE(20, "Affiliate", ShopStateEnum.AFFILIATE, INDIFFERENT, MerchantSortEnum.AFFILIATED_PLUS, ClicTypeEnum.FREE, null, RefStateOptions.builder().initAll(false).enableDooyoo().build()),
	CAPPED(2, "Capped", CLIENT, CATEGORY, MerchantSortEnum.FREE, ClicTypeEnum.CAPPED, null, RefStateOptions.builder().initAll(false).displayProducts().build()),
	SUSPENDED(4, "Suspended", STANDBY, INDIFFERENT, MerchantSortEnum.FREE, ClicTypeEnum.FREE, TECHNICAL_SUSPENSION, RefStateOptions.builder().initAll(false).displayProducts().build()),
	AFFILIATE_CPC(8, "Affiliate CPC", ShopStateEnum.AFFILIATE, CPC, MerchantSortEnum.PRIORITY_PLUS, ClicTypeEnum.PAID, null, RefStateOptions.builder().initAll(false).enableLogo().enableEngineLogo().displayProducts().build()),
	
	// To delete when dooyoo disappear
	DOOYOO_ONLY(16, "Dooyoo only", ShopStateEnum.DOOYOO_ONLY, INDIFFERENT, MerchantSortEnum.FREE, ClicTypeEnum.FREE, null, RefStateOptions.builder().initAll(false).enableDooyoo().build()),
	DOOYOO_PLUS(11, "Dooyoo plus", ShopStateEnum.DOOYOO_PLUS, UNSPECIFIED, PRIORITY_PLUS, ClicTypeEnum.FREE, TECHNICAL_SUSPENSION, RefStateOptions.builder().initAll(false).enableDooyoo().build()),
	
	ZEUS_REFERENCED_FREE(21, "Zeus Free", ShopStateEnum.FREE, INDIFFERENT, MerchantSortEnum.FREE, ClicTypeEnum.FREE, null, RefStateOptions.builder().initAll(false).displayProducts().build()),
	ZEUS_AFFILIATE(22, "Zeus Affiliate", ShopStateEnum.AFFILIATE, INDIFFERENT, MerchantSortEnum.AFFILIATED_PLUS, ClicTypeEnum.FREE, null, RefStateOptions.builder().initAll(false).dooyooEnabled(true).build()),
	ZEUS_NORMAL_CLIENT(23, "Zeus Normal Client", CLIENT, CATEGORY, PRIORITY_PLUS, ClicTypeEnum.PAID, null, RefStateOptions.builder().initAll(false).enablePartner().enableLogo().enableEngineLogo().displayProducts().enableDooyoo().build())

	;
	
	private ReferentialStateEnum(long id, String label, ShopStateEnum defaultShopState, MerchantPriceEnum price, MerchantSortEnum sort, ClicTypeEnum clicType, StateReasonEnum defaultReason, RefStateOptions options) {
		this.id = id;
		this.label = label;
		this.defaultShopState = defaultShopState;
		this.defaultPrice = price;
		this.defaultSort = sort;
		this.defaultClicType = clicType;
		this.defaultReason = defaultReason;
		this.defaultOptions = options;
		this.defaultSegmentation = SegmentationEnum.D;
	}
	
	private Long id;
	private String label;
	private ShopStateEnum defaultShopState;
	private MerchantPriceEnum defaultPrice;
	private MerchantSortEnum defaultSort;
	private ClicTypeEnum defaultClicType;
	private StateReasonEnum defaultReason;
	private SegmentationEnum defaultSegmentation;
	private RefStateOptions defaultOptions;
	
	public static ReferentialStateEnum getReferentialStateById(Long id) {
		ReferentialStateEnum[] values = values();
		for (ReferentialStateEnum state : values) {
			if(state.getId().equals(id))
				return state;
		}
		throw new java.lang.IllegalArgumentException("The id '"+id+"' referential state is unknown");
	}
	
	public Long getId() {
		return id;
	}
	
	public String getLibelle() {
		return label;
	}
	
	public ShopState getDefaultShopState() {
		return defaultShopState;
	}
	
	public MerchantPrice getDefaultPrice() {
		return defaultPrice;
	}
	
	public MerchantSort getDefaultSort() {
		return defaultSort;
	}
	
	public ClicType getDefaultClicType() {
		return defaultClicType;
	}
	
	public StateReason getDefaultReason() {
		return defaultReason;
	}
	
	public SegmentationEnum getDefaultSegmentation() {
		return defaultSegmentation;
	}
	
	public RefStateOptions getDefaultOptions() {
		return defaultOptions;
	}
	
	@Override
	public String toString() {
		return String.valueOf(id);
	}
}
