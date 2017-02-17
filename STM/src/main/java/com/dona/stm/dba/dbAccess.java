/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dona.stm.dba;

import com.dona.stm.Factory;
import com.dona.stm.IContractorsEntity;
import com.dona.stm.IProduct;
import com.dona.stm.Product;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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

    public void insertIntoPartners(IContractorsEntity contractor) throws SQLException {
        PreparedStatement statement;
        //bulstat,name,address,accountablePerson,receiverOfGoods,fax,bank,bankCode,IBAN,taxRegistryNumber,VATregistration,phone
        statement = conn.prepareStatement("INSERT INTO partners(bulstat,name,adr,mol,mol_pol,fax,bank,bankcc,bankdds,regdds,koddds,tel)VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
        statement.setString(1, contractor.getBulstat());
        statement.setString(2, contractor.getName());
        statement.setString(3, contractor.getAddress());
        statement.setString(4, contractor.getAccountablePerson());
        statement.setString(5, contractor.getReceiverOfGoods());
        statement.setString(6, contractor.getBank());
        statement.setString(7, contractor.getFax());
        statement.setString(8, contractor.getIBAN());
        statement.setString(9, contractor.getBankCode());
        statement.setBoolean(10, contractor.getTaxRegistryNumber());
        statement.setString(11, contractor.getVATregistration());
        statement.setString(12, contractor.getPhone());
        statement.executeUpdate();
    }

    public List<IProduct> searchAssortment(String id) throws SQLException {
        PreparedStatement statement;
        statement = conn.prepareStatement("SELECT code,name,merka,val,zavo_pr,buy_price,sell_price,sellpredro,sellprod FROM ASSORTMENT WHERE CODE LIKE ?");
        statement.setString(1, id);
        ResultSet rs = statement.executeQuery();
        List<IProduct> list = new ArrayList<>();
        while (rs.next()) {
            IProduct product = new Factory().createProduct(rs.getString("code"),
                    rs.getString("name"), rs.getString("merka"), rs.getString("val"),
                    rs.getString("zavo_pr"), rs.getString("buy_price"), rs.getString("sell_price"),
                    rs.getString("sellpredro"), rs.getString("sellprod"));
            list.add(product);
        }
        return list;
    }
}
