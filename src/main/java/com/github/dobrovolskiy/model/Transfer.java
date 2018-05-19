package com.github.dobrovolskiy.model;

import java.math.BigDecimal;

/**
 * Money transfer model
 *
 * @since 1.0
 */
public class Transfer implements Model {
    private String id;
    private String srcAccountId;
    private String destAccountId;
    private BigDecimal amount;
    private String currency;

    public Transfer() {
    }

    public Transfer(Transfer transfer) {
        id = transfer.id;
        srcAccountId = transfer.srcAccountId;
        destAccountId = transfer.destAccountId;
        amount = transfer.amount;
        currency = transfer.currency;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSrcAccountId() {
        return srcAccountId;
    }

    public void setSrcAccountId(String srcAccountId) {
        this.srcAccountId = srcAccountId;
    }

    public String getDestAccountId() {
        return destAccountId;
    }

    public void setDestAccountId(String destAccountId) {
        this.destAccountId = destAccountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
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

        Transfer transfer = (Transfer) o;

        if (id != null ? !id.equals(transfer.id) : transfer.id != null) return false;
        if (srcAccountId != null ? !srcAccountId.equals(transfer.srcAccountId) : transfer.srcAccountId != null)
            return false;
        if (destAccountId != null ? !destAccountId.equals(transfer.destAccountId) : transfer.destAccountId != null)
            return false;
        if (amount != null ? !amount.equals(transfer.amount) : transfer.amount != null) return false;
        return currency != null ? currency.equals(transfer.currency) : transfer.currency == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (srcAccountId != null ? srcAccountId.hashCode() : 0);
        result = 31 * result + (destAccountId != null ? destAccountId.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Transfer{" +
                "id='" + id + '\'' +
                ", srcAccountId='" + srcAccountId + '\'' +
                ", destAccountId='" + destAccountId + '\'' +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }
}
