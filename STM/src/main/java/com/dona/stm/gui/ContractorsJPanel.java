/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dona.stm.gui;

import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Iliya Velev <velev_bg@mail.bg>
 */
public class ContractorsJPanel extends JPanel {

    private JLabel mainLabel;

    private JLabel bulstatLabel;
    private JTextField bulstatTextFuild;

    private JLabel nameLabel;
    private JTextField nameTextField;

    private JLabel addressLabel;
    private JTextField adressTextField;

    private JLabel apLabel; //accountable person = mol
    private JTextField apTextField;

    private JLabel receiverGoodsLabel;
    private JTextField receiverGoodsTextField;

    private JLabel faxLabel;
    private JTextField faxTextField;

    private JLabel bankLabel;
    private JTextField bankTextField;

    private JLabel bankCodeLabel;
    private JTextField bankCodeTextField;

    private JLabel IBANLabel;
    private JTextField IBANTextField;

    private JLabel taxRegistryNumberLabel;
    private JTextField taxRegistryNumberTextField;

    private JLabel VATregistrationLabel;     //dds
    private JTextField VATregistrationTextField;

    private JLabel phoneNumberLabel;
    private JTextField phoneNumberTextField;

    public ContractorsJPanel() {
        setLayout(new MigLayout());
        InitializeComponents();
        AddComponents();

        //SetComponentText("bg", "BG");
        SetComponentText("en", "US");
    }

    private void InitializeComponents() {
        mainLabel = new JLabel();

        bulstatLabel = new JLabel();
        bulstatTextFuild = new JTextField();

        nameLabel = new JLabel();
        nameTextField = new JTextField();

        addressLabel = new JLabel();
        adressTextField = new JTextField();

        apLabel = new JLabel();
        apTextField = new JTextField();

        receiverGoodsLabel = new JLabel();
        receiverGoodsTextField = new JTextField();

        faxLabel = new JLabel();
        faxTextField = new JTextField();

        bankLabel = new JLabel();
        bankTextField = new JTextField();

        bankCodeLabel = new JLabel();
        bankCodeTextField = new JTextField();

        IBANLabel = new JLabel();
        IBANTextField = new JTextField();

        taxRegistryNumberLabel = new JLabel();
        taxRegistryNumberTextField = new JTextField();

        VATregistrationLabel = new JLabel();
        VATregistrationTextField = new JTextField();

        phoneNumberLabel = new JLabel();
        phoneNumberTextField = new JTextField();
    }

    private void AddComponents() {
        add(mainLabel, "span");
        

    }

    public void SetComponentText(String language, String country) {
        Locale locale = new Locale(language, country);
        ResourceBundle r = ResourceBundle.getBundle("Bundle", locale);
        mainLabel.setText(r.getString("ContractorsJPanel.mainLabel.text"));
    }
}
