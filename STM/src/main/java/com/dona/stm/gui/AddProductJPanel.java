/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dona.stm.gui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Konstantin Tsanov <k.tsanov@gmail.com>
 */
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

    public AddProductJPanel() {
        setLayout(new MigLayout());
        InitializeComponents();
        AddComponents();

        SetComponentText("bg", "BG");
    }

    private void InitializeComponents() {
        mainLabel = new JLabel();
        codeLabel = new JLabel();
        nameLabel = new JLabel();
        currencyLabel = new JLabel();
        discountLabel = new JLabel();
        buyPriceLabel = new JLabel();
        sellPriceLabel = new JLabel();
        wholesalePriceLabel = new JLabel();
        priceLabel = new JLabel();
        measureLabel = new JLabel();
        codeTf = new JTextField();
        nameTa = new JTextArea();
        currencyTf = new JTextField();
        discountTf = new JTextField();
        buyPriceTf = new JTextField();
        sellPriceTf = new JTextField();
        wholeSalePriceTf = new JTextField();
        priceTf = new JTextField();
        measureTf = new JTextField();
    }

    private void AddComponents() {
        add(mainLabel, "wrap");
    }

    public void SetComponentText(String language, String country) {
        Locale locale = new Locale(language);
//       
        ResourceBundle r = ResourceBundle.getBundle("src.main.resources.DriverSearch", new Locale("bg", "BG"));
        System.out.print(r.getString("dll.0"));
        mainLabel.setText(country);
//        codeLabel nameLabel
//        currencyLabel discountLabel
//        buyPriceLabel sellPriceLabel
//        wholesalePriceLabel priceLabel 
//        measureLabel 
    }
}
