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
public class Factory {
    
    public IProduct createProduct(String id, String name, String measure, String currency, String discount, String buyPrice, String sellPrice, String sellPriceWholeSaler, String retailersPrice )
    {
        return new Product(id,name, measure, currency, discount, buyPrice, sellPrice, sellPriceWholeSaler, retailersPrice);
    }
}
