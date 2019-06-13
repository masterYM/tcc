package com.tcc.api.entity;

public class Transfer {
    private String sourceAcctId;
    private String targetAcctId;
    private Double amount;

    public String getSourceAcctId() {
        return sourceAcctId;
    }

    public void setSourceAcctId(String sourceAcctId) {
        this.sourceAcctId = sourceAcctId;
    }

    public String getTargetAcctId() {
        return targetAcctId;
    }

    public void setTargetAcctId(String targetAcctId) {
        this.targetAcctId = targetAcctId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
