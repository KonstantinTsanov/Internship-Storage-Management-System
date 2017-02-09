/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dona.stm.dba;

import com.dona.stm.IProduct;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import lombok.extern.java.Log;

/**
 *
 * @author Konstantin Tsanov <k.tsanov@gmail.com>
 */
@Log
public class dbAccess {

    private final Connection conn;

    public dbAccess(String connString, String user, String pass) throws SQLException {
        conn = DriverManager.getConnection(connString, user, pass);

    }

    public void insertIntoAssortment(IProduct product) throws SQLException {
        PreparedStatement statement;
        statement = conn.prepareStatement("INSERT INTO assortment(code,name,merka,val,zavo_pr,buy_price,sell_price,sellpredro,sellprod)VALUES(?,?,?,?,?,?,?,?,?)");
        statement.setLong(1, product.getId());
        statement.setString(2, product.getName());
        statement.setString(3, product.getMeasure());
        statement.setString(4, product.getCurrency());
        statement.setFloat(5, product.getDiscount());
        statement.setFloat(6, product.getBuyPrice());
        statement.setFloat(7, product.getSellPrice());
        statement.setFloat(8, product.getSellPriceWholeSeller());
        statement.setFloat(9, product.getRetailersPrice());
        statement.executeUpdate();
    }

    public void searchAssortment(long id) throws SQLException {
        PreparedStatement statement;
        statement = conn.prepareStatement("SELECT code,name,merka,val,zavo_pr,buy_price,sell_price,sellpredro,sellprod FROM ASSORTMENT WHERE CODE LIKE ?");
        statement.setLong(1, id);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            
        }
    }
}
