/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dona.stm.gui;

import com.dona.stm.Factory;
import com.dona.stm.IProduct;
import com.dona.stm.dba.dbAccess;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import lombok.extern.java.Log;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Konstantin Tsanov <k.tsanov@gmail.com>
 */
@Log
public class AddProductJPanel extends javax.swing.JPanel {

    private JLabel mainLabel;
    private JLabel codeLabel;
    private JTextField codeTf;
    private JLabel nameLabel;
    private JTextArea nameTa;
    private JLabel currencyLabel;
    private JTextField currencyTf;
    private JLabel discountLabel;
    private JTextField discountTf;
    private JLabel buyPriceLabel;
    private JTextField buyPriceTf;
    private JLabel sellPriceLabel;
    private JTextField sellPriceTf;
    private JLabel wholesalePriceLabel;
    private JTextField wholeSalePriceTf;
    private JLabel priceLabel;
    private JTextField priceTf;
    private JLabel measureLabel;
    private JTextField measureTf;

    private JScrollPane nameJSPane;
    private JButton addToDBJButton;

    public AddProductJPanel() {
        setPreferredSize(new Dimension(300, 350));
        setMaximumSize(new Dimension(500, 500));
        MigLayout layout = new MigLayout("", "[90!]", "[40!]");
        setLayout(layout);
        InitializeComponents();
        AddComponents();
        SetComponentText("en", "US");
    }

    private void InitializeComponents() {
        mainLabel = new JLabel();

        codeLabel = new JLabel();
        codeTf = new JTextField();

        nameLabel = new JLabel();
        nameTa = new JTextArea();
        nameTa.setLineWrap(true);
        nameJSPane = new JScrollPane(nameTa);

        currencyLabel = new JLabel();
        currencyTf = new JTextField();

        discountLabel = new JLabel();
        discountTf = new JTextField();

        buyPriceLabel = new JLabel();
        buyPriceTf = new JTextField();

        sellPriceLabel = new JLabel();
        sellPriceTf = new JTextField();

        wholesalePriceLabel = new JLabel();
        wholeSalePriceTf = new JTextField();

        priceLabel = new JLabel();
        priceTf = new JTextField();

        measureLabel = new JLabel();
        measureTf = new JTextField();
        addToDBJButton = new JButton();
    }

    private void AddComponents() {
        add(mainLabel, "span");
        add(codeLabel, "align right");
        add(codeTf, "width 60:80:100,align right");
        add(nameLabel, "align right");
        add(nameJSPane, "width 80:100:120, height 50:70:90,align right, span 1 2, wrap");
        add(currencyLabel, "align right");
        add(currencyTf, "width 60:80:100,align right, wrap");
        add(discountLabel, "align right");
        add(discountTf, "width 60:80:100,align right");
        add(buyPriceLabel, "align right");
        add(buyPriceTf, "width 60:80:100,align right, wrap");
        add(sellPriceLabel, "align right");
        add(sellPriceTf, "width 60:80:100,align right");
        add(wholesalePriceLabel, "align right");
        add(wholeSalePriceTf, "width 60:80:100,align right, wrap");
        add(priceLabel, "align right");
        add(priceTf, "width 60:80:100,align right");
        add(measureLabel, "align right");
        add(measureTf, "width 60:80:100,align right, wrap");
        add(addToDBJButton, "span, align center center");
    }

    public void SetComponentText(String language, String country) {
        Locale locale = new Locale(language, country);
        ResourceBundle r = ResourceBundle.getBundle("Bundle", locale);
        mainLabel.setText(r.getString("AddProductJPanel.mainLabel.text"));
        codeLabel.setText(r.getString("AddProductJPanel.codeLabel.text"));
        nameLabel.setText(r.getString("AddProductJPanel.nameLabel.text"));
        currencyLabel.setText(r.getString("AddProductJPanel.currencyLabel.text"));
        discountLabel.setText(r.getString("AddProductJPanel.discountLabel.text"));
        buyPriceLabel.setText(r.getString("AddProductJPanel.buyPriceLabel.text"));
        sellPriceLabel.setText(r.getString("AddProductJPanel.sellPriceLabel.text"));
        wholesalePriceLabel.setText(r.getString("AddProductJPanel.wholesalePriceLabel.text"));
        priceLabel.setText(r.getString("AddProductJPanel.priceLabel.text"));
        measureLabel.setText(r.getString("AddProductJPanel.measureLabel.text"));
        addToDBJButton.setText(r.getString("AddProductJPanel.addToDBJButton.text"));

    }

    private void addToDBJButtonActionPerformed(java.awt.event.ActionEvent evt) {

        try {
             //long id, String name, String measure, String currency,
                     //float discount, String buyPrice, String sellPrice, String sellPriceWholeSaler, String retailersPrice
                            
            String id = codeTf.getText();
            String name = nameTa.getText();
            String measure = measureTf.getText();
            String currency = currencyTf.getText();
            String discount = discountTf.getText();
            String buyPrice = buyPriceTf.getText();
            String sellPrice = sellPriceTf.getText();
            String sellPriceWholeSaler = wholeSalePriceTf.getText();
            String retailersPrice = priceTf.getText();
             Factory fa = new Factory();
            IProduct  prod = fa.createProduct(id, name, measure, currency, discount, buyPrice, sellPrice, sellPriceWholeSaler, retailersPrice);
            dbAccess db = new dbAccess("jdbc:mysql://localhost:3306/productmanagementsystem?autoReconnect=true&useSSL=false", "root", "1234");
            db.insertIntoAssortment(prod);
                    } catch (SQLException ex) {
            log.log(Level.SEVERE, null, ex);
                    }
    }
}
