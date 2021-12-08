package com.leguide.backoffice.karaf.webservices.wsbrands.api.domain.wrapper.in.brands.builder;

import java.util.List;

import com.leguide.backoffice.karaf.webservices.wsbrands.api.domain.wrapper.in.brands.BrandInWrapper;
import com.leguide.backoffice.karaf.webservices.wsbrands.api.domain.wrapper.in.brands.BrandsListInWrapper;

public class BrandsListInWrapperBuilder {
    private List<BrandInWrapper> brand;

    public BrandsListInWrapperBuilder brand(List<BrandInWrapper> brand) {
        this.brand = brand;
        return this;
    }

    public BrandsListInWrapper build() {
        BrandsListInWrapper brandsListInWrapper = new BrandsListInWrapper();
        brandsListInWrapper.setBrand(this.brand);
        return brandsListInWrapper;
    }
}
