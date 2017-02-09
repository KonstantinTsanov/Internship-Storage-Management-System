/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dona.stm;

/**
 *
 * @author Cveti
 */
public interface IProduct {
    
    long getId();
    
    String getName();
    
    String getMeasure();
    
    String getCurrency();
    
    float getDiscount();
    
    float getBuyPrice();
    
    float getSellPrice();
    
    float getSellPriceWholeSaler();
    
    float getRetailersPrice();
}
