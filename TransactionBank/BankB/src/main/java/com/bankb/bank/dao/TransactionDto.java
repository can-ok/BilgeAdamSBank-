package com.bankb.bank.dao;

public class TransactionDto {
    private Integer id;

    private int senderIban;
    private int reciverIban;
    private int amount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getSenderIban() {
        return senderIban;
    }

    public void setSenderIban(int senderIban) {
        this.senderIban = senderIban;
    }

    public int getReciverIban() {
        return reciverIban;
    }

    public void setReciverIban(int reciverIban) {
        this.reciverIban = reciverIban;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
