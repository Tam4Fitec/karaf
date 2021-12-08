package com.leguide.backoffice.karaf.business.models.pojo;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public class MergeAccount implements Serializable {

    private static final long serialVersionUID = 7253303904556490194L;

    private Account accountToUpdate;

    private Set<Account> accountsToDelete;

    private List<Long> merchantsToTransfer;

    private List<Long> contactsToTransfer;

    public Account getAccountToUpdate() {
        return accountToUpdate;
    }

    public void setAccountToUpdate(Account accountToUpdate) {
        this.accountToUpdate = accountToUpdate;
    }

    public Set<Account> getAccountsToDelete() {
        return accountsToDelete;
    }

    public void setAccountsToDelete(Set<Account> accountsToDelete) {
        this.accountsToDelete = accountsToDelete;
    }

    public List<Long> getMerchantsToTransfer() {
        return merchantsToTransfer;
    }

    public void setMerchantsToTransfer(List<Long> merchantsToTransfer) {
        this.merchantsToTransfer = merchantsToTransfer;
    }

    public List<Long> getContactsToTransfer() {
        return contactsToTransfer;
    }

    public void setContactsToTransfer(List<Long> contactsToTransfer) {
        this.contactsToTransfer = contactsToTransfer;
    }

    @Override
    public String toString() {
        return "MergeAccount{" +
                "accountToUpdate=" + accountToUpdate +
                ", accountsToDelete=" + accountsToDelete +
                ", merchantsToTransfer=" + merchantsToTransfer +
                ", contactsToTransfer=" + contactsToTransfer +
                '}';
    }
}
