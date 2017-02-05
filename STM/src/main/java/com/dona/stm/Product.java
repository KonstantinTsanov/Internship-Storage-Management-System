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
public class Product implements IProduct{
    
    private String name;
    private String brand;
    private float buyPrice;
    private float sellPrice;
    private float sellPriceWholeSaler;
    private float retailersPrice;
    
    public Product(String name, String brand, String buyPrice, String sellPrice, String sellPriceWholeSaler, String retailersPrice)
    {
        SetName(name);
        SetBrand(brand);
        SetBuyPrice(Float.valueOf(buyPrice));
        SetSellPrice(Float.valueOf(sellPrice));
        SetSellPriceWholeSaler(Float.valueOf(sellPriceWholeSaler));
        SetRetailersPrice(Float.valueOf(retailersPrice));
    }
    
    public String GetName()
    {
        return this.name;
    }
    
    private void SetName(String val)
    {
        this.name = val;
    }
    
    public String GetBrand()
    {
        return this.brand;
    }
    
    private void SetBrand(String val)
    {
        this.brand = val;
    }
    
    public float GetBuyPrice()
    {
        return this.buyPrice;
    }
    
    private void SetBuyPrice(float val)
    {
        this.buyPrice = val;
    }
    
    public float GetSellPrice()
    {
        return this.sellPrice;
    }
    
    private void SetSellPrice(float val )
    {
        this.sellPrice = val ;
    }
    
    public float GetSellPriceWholeSaler()
    {
        return this.sellPriceWholeSaler;
    }
    
    private void SetSellPriceWholeSaler(float val)
    {
        this.sellPriceWholeSaler = val;
    }
    
    public float GetRetailersPrice()
    {
        return this.retailersPrice;
    }
    
    private void SetRetailersPrice(float val)
    {
        this.retailersPrice = val;
    }
    
}
