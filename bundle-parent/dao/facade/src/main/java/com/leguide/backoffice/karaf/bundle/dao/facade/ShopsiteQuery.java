package com.leguide.backoffice.karaf.bundle.dao.facade;

public class ShopsiteQuery {

    private boolean society;

    private boolean state;

    private boolean account;

    private boolean delivery;

    private boolean privacyPolicy;

    private boolean security;

    private boolean internalNotification;


    private ShopsiteQuery(Builder b) {
        this.society = b.society;
        this.state = b.state;
        this.account = b.account;
        this.delivery = b.delivery;
        this.privacyPolicy = b.privacyPolicy;
        this.security = b.security;
        this.internalNotification = b.internalNotification;
    }

    public static class Builder {

        private boolean society;

        private boolean state;

        private boolean account;

        private boolean delivery;

        private boolean privacyPolicy;

        private boolean security;

        private boolean internalNotification;

        public Builder() {
        }

        public Builder withSociety() {
            this.society = true;
            return this;
        }

        public Builder withState() {
            this.state = true;
            return this;
        }

        public Builder withAccount() {
            this.account = true;
            return this;
        }

        public Builder withDelivery() {
            this.delivery = true;
            return this;
        }

        public Builder withPrivacyPolicy() {
            this.privacyPolicy = true;
            return this;
        }

        public Builder withSecurity() {
            this.security = true;
            return this;
        }

        public Builder withInternalNotification() {
            this.internalNotification = true;
            return this;
        }

        public ShopsiteQuery build() {
            return new ShopsiteQuery(this);
        }
        
    }

    public boolean isSociety() {
        return society;
    }

    public boolean isState() {
        return state;
    }

    public boolean isAccount() {
        return account;
    }

    public boolean isDelivery() {
        return delivery;
    }

    public boolean isPrivacyPolicy() {
        return privacyPolicy;
    }

    public boolean isSecurity() {
        return security;
    }

    public boolean isInternalNotification() {
        return internalNotification;
    }
    
}
