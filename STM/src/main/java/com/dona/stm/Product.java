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

    private String name;
    private String brand;
    private float buyPrice;
    private float sellPrice;
    private float sellPriceWholeSaler;
    private float retailersPrice;

    public Product(String name, String brand, String buyPrice, String sellPrice, String sellPriceWholeSaler, String retailersPrice) {
        setName(name);
        setBrand(brand);
        setBuyPrice(Float.valueOf(buyPrice));
        setSellPrice(Float.valueOf(sellPrice));
        setSellPriceWholeSaler(Float.valueOf(sellPriceWholeSaler));
        setRetailersPrice(Float.valueOf(retailersPrice));
    }

    public String getName() {
        return this.name;
    }

    private void setName(String val) {
        this.name = val;
    }

    public String getBrand() {
        return this.brand;
    }

    private void setBrand(String val) {
        this.brand = val;
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

    public float getSellPriceWholeSaler() {
        return this.sellPriceWholeSaler;
    }

    private void setSellPriceWholeSaler(float val) {
        this.sellPriceWholeSaler = val;
    }

    public float getRetailersPrice() {
        return this.retailersPrice;
    }

    private void setRetailersPrice(float val) {
        this.retailersPrice = val;
    }

}
