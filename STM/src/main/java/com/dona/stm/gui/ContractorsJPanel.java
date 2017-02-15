/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dona.stm.gui;

import java.awt.Dimension;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JButton;
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
    private JTextField addressTextField;

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

    private JButton addContractorButton;

    public ContractorsJPanel() {
        setPreferredSize(new Dimension(450, 350));
        setLayout(new MigLayout("", "100!", "35!"));
        initializeComponents();
        addComponents();
    }

    private void initializeComponents() {
        mainLabel = new JLabel();

        bulstatLabel = new JLabel();
        bulstatTextFuild = new JTextField();

        nameLabel = new JLabel();
        nameTextField = new JTextField();

        addressLabel = new JLabel();
        addressTextField = new JTextField();

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

        addContractorButton = new JButton();
    }

    private void addComponents() {
        add(mainLabel, "span");
        add(bulstatLabel);
        add(bulstatTextFuild, "width 60:80:100");

        add(nameLabel);
        add(nameTextField, "width 60:80:100, wrap");

        add(addressLabel);
        add(addressTextField, "width 60:80:100");

        add(apLabel);
        add(apTextField, "width 60:80:100, wrap");

        add(receiverGoodsLabel);
        add(receiverGoodsTextField, "width 60:80:100");

        add(faxLabel);
        add(faxTextField, "width 60:80:100, wrap");

        add(bankLabel);
        add(bankTextField, "width 60:80:100");

        add(bankCodeLabel);
        add(bankCodeTextField, "width 60:80:100, wrap");

        add(IBANLabel);
        add(IBANTextField, "width 60:80:100");

        add(taxRegistryNumberLabel);
        add(taxRegistryNumberTextField, "width 60:80:100, wrap");

        add(VATregistrationLabel);
        add(VATregistrationTextField, "width 60:80:100");

        add(phoneNumberLabel);
        add(phoneNumberTextField, "width 60:80:100, span");

        add(addContractorButton, "width 100:150:200, span, align center center");
    }

    public void setComponentText(Locale locale) {
        ResourceBundle r = ResourceBundle.getBundle("Bundle", locale);
        mainLabel.setText(r.getString("ContractorsJPanel.mainLabel.text"));
        bulstatLabel.setText(r.getString("ContractorsJPanel.bulstatLabel.text"));
        nameLabel.setText(r.getString("ContractorsJPanel.nameLabel.text"));
        addressLabel.setText(r.getString("ContractorsJPanel.addressLabel.text"));
        apLabel.setText(r.getString("ContractorsJPanel.apLabel.text"));
        receiverGoodsLabel.setText(r.getString("ContractorsJPanel.receiverGoodsLabel.text"));
        faxLabel.setText(r.getString("ContractorsJPanel.faxLabel.text"));
        bankLabel.setText(r.getString("ContractorsJPanel.bankLabel.text"));
        bankCodeLabel.setText(r.getString("ContractorsJPanel.bankCodeLabel.text"));
        IBANLabel.setText(r.getString("ContractorsJPanel.IBANLabel.text"));
        taxRegistryNumberLabel.setText(r.getString("ContractorsJPanel.taxRegistryNumberLabel.text"));
        VATregistrationLabel.setText(r.getString("ContractorsJPanel.VATregistrationLabel.text"));
        phoneNumberLabel.setText(r.getString("ContractorsJPanel.phoneNumberLabel.text"));
        addContractorButton.setText(r.getString("ContractorsJPanel.addContractorButton.text"));
    }
}
