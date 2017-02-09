/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dona.stm;

import java.math.BigDecimal;

/**
 *
 * @author Cveti
 */
public class Product implements IProduct {

    private long id;
    private String name;
    private String measure;
    private String currency;
    private float discount;

    private float buyPrice;
    private float sellPrice;
    private float sellPriceWholeSeller;
    private float retailersPrice;

    public Product(String id, String name, String measure, String currency, String discount, String buyPrice, String sellPrice, String sellPriceWholeSaler, String retailersPrice) {
        setId(Long.parseLong(id));
        setName(name);
        setMeasure(measure);
        setCurrency(currency);
        setDiscount(Float.valueOf(discount));

        setBuyPrice(Float.valueOf(buyPrice));
        setSellPrice(Float.valueOf(sellPrice));
        setSellPriceWholeSeller(Float.valueOf(sellPriceWholeSaler));
        setRetailersPrice(Float.valueOf(retailersPrice));
    }

    public long getId() {
        return this.id;
    }

    private void setId(long val) {
        this.id = val;
    }

    public String getName() {
        return this.name;
    }

    private void setName(String val) {
        this.name = val;
    }

    public String getMeasure() {
        return this.measure;
    }

    private void setMeasure(String val) {
        this.measure = val;
    }

    public String getCurrency() {
        return this.currency;
    }

    private void setCurrency(String val) {
        this.currency = val;
    }

    public float getDiscount() {
        return this.discount;
    }
    
    private void setDiscount(float val) {
        this.discount = val;
    }

    public float getBuyPrice() {
        return this.buyPrice;
    }

    private void setBuyPrice(float val) {
        this.buyPrice = val;
    }

    public float getSellPrice() {
        return this.sellPrice;
    }

    private void setSellPrice(float val) {
        this.sellPrice = val;
    }

    public float getSellPriceWholeSeller() {
        return this.sellPriceWholeSeller;
    }

    private void setSellPriceWholeSeller(float val) {
        this.sellPriceWholeSeller = val;
    }

    public float getRetailersPrice() {
        return this.retailersPrice;
    }

    private void setRetailersPrice(float val) {
        this.retailersPrice = val;
    }

}
