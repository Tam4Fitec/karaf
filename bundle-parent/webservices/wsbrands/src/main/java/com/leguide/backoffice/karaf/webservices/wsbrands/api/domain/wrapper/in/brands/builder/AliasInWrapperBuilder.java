package com.leguide.backoffice.karaf.webservices.wsbrands.api.domain.wrapper.in.brands.builder;

import java.util.Date;

import com.leguide.backoffice.karaf.webservices.wsbrands.api.domain.wrapper.in.brands.AliasInWrapper;

public class AliasInWrapperBuilder {
    private String name;
    private String nameNormalized;
    private Date activationDate;
    private Long temporaryId;

    public AliasInWrapperBuilder name(String name) {
        this.name = name;
        return this;
    }

    public AliasInWrapperBuilder activationDate(Date activationDate) {
        this.activationDate = activationDate;
        return this;
    }

    public AliasInWrapperBuilder temporaryId(Long temporaryId) {
        this.temporaryId = temporaryId;
        return this;
    }

    public AliasInWrapper build() {
        AliasInWrapper aliasInWrapper = new AliasInWrapper();
        aliasInWrapper.setName(this.name);
        aliasInWrapper.setNameNormalized(this.nameNormalized);
        aliasInWrapper.setActivationDate(this.activationDate);
        aliasInWrapper.setTemporaryId(this.temporaryId);
        return aliasInWrapper;
    }
}
