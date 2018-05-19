package com.github.dobrovolskiy.model;

import java.math.BigDecimal;

/**
 * Account model
 *
 * @since 1.0
 */
public class Account implements Model {
    private String id;
    private String client;
    private BigDecimal balance;
    private String currency;

    public Account() {
    }

    public Account(Account account) {
        id = account.id;
        client = account.client;
        balance = account.balance;
        currency = account.currency;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (id != null ? !id.equals(account.id) : account.id != null) return false;
        if (client != null ? !client.equals(account.client) : account.client != null) return false;
        if (balance != null ? !balance.equals(account.balance) : account.balance != null) return false;
        return currency != null ? currency.equals(account.currency) : account.currency == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (client != null ? client.hashCode() : 0);
        result = 31 * result + (balance != null ? balance.hashCode() : 0);
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", client=" + client +
                ", balance=" + balance +
                ", currency='" + currency + '\'' +
                '}';
    }
}
