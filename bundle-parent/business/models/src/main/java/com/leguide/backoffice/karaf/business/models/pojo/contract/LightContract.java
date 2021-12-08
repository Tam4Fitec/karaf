package com.leguide.backoffice.karaf.business.models.pojo.contract;

public class LightContract {

    private String contractCode;

    private String clientId;

    public LightContract(String contractCode, String clientId) {
        this.contractCode = contractCode;
        this.clientId = clientId;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LightContract that = (LightContract) o;

        if (contractCode != null ? !contractCode.equals(that.contractCode) : that.contractCode != null) return false;
        if (clientId != null ? !clientId.equals(that.clientId) : that.clientId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = contractCode != null ? contractCode.hashCode() : 0;
        result = 31 * result + (clientId != null ? clientId.hashCode() : 0);
        return result;
    }
}
