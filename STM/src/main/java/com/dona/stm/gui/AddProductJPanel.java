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
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.DefaultCaret;
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

    private JScrollPane nameJSPane;
    private JButton addToDBJButton;

    public AddProductJPanel() {
        setLayout(new MigLayout());
        InitializeComponents();
        AddComponents();

        //SetComponentText("bg", "BG");
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
        add(codeLabel);
        add(codeTf, "width 60:80:100, gapright 20");
        add(nameLabel);
        add(nameJSPane, "width 80:100:120, height 60:80:100, wrap");
        add(mainLabel, "span");
        add(codeLabel);
        add(codeTf, "width 60:80:100");
        add(nameLabel);
        add(nameJSPane, "width 80:120:140, height 50:70:90, span 1 2, wrap");
        add(currencyLabel);
        add(currencyTf, "width 60:80:100, wrap");
        add(discountLabel);
        add(discountTf, "width 60:80:100");
        add(buyPriceLabel);
        add(buyPriceTf, "width 60:80:100, wrap");
        add(sellPriceLabel);
        add(sellPriceTf, "width 60:80:100");
        add(wholesalePriceLabel);
        add(wholeSalePriceTf, "width 60:80:100, wrap");
        add(priceLabel);
        add(priceTf, "width 60:80:100");
        add(measureLabel);
        add(measureTf, "width 60:80:100, wrap");
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
        //validate, repaint??????

    }
}
