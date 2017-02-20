/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dona.stm.gui;

import com.dona.stm.enums.JPanelNames;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Konstantin Tsanov <k.tsanov@gmail.com>
 */
public class InsertMenuJPanel extends JPanel {

    private final CardLayoutCallback parent;
    private JLabel menuLabel;
    private JButton contractorsJButton, productJButton;
    private JButton returnJButton;

    public InsertMenuJPanel(CardLayoutCallback parent) {
        this.parent = parent;
        setLayout(new MigLayout());
        initComponents();
        addComponents();
        attachListeners();
    }

    private void initComponents() {
        menuLabel = new JLabel();
        menuLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        contractorsJButton = new JButton();
        productJButton = new JButton();
        returnJButton = new JButton();
    }

    private void addComponents() {
        add(menuLabel, "wrap");
        add(contractorsJButton, "wrap");
        add(productJButton, "wrap");
        add(returnJButton, "wrap");
    }

    private void attachListeners() {
        productJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.getViewsCardLayout().show(parent.getViewsJPanel(), JPanelNames.Products.toString());
                parent.getViewsJPanel().setVisible(true);
            }
        });
        contractorsJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.getViewsCardLayout().show(parent.getViewsJPanel(), JPanelNames.Contractors.toString());
                parent.getViewsJPanel().setVisible(true);
            }
        });
        returnJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.getMenuCardLayout().show(parent.getMenuJPanel(), JPanelNames.Menu.toString());
                parent.getViewsJPanel().setVisible(false);
            }
        });
    }

    public void setComponentText(Locale locale) {
        ResourceBundle r = ResourceBundle.getBundle("Bundle", locale);
        menuLabel.setText(r.getString("InsertMenuJPanel.menuLabel.text"));
        contractorsJButton.setText(r.getString("InsertMenuJPanel.contractorsJButton.text"));
        productJButton.setText(r.getString("InsertMenuJPanel.productJButton.text"));
        returnJButton.setText(r.getString("InsertMenuJPanel.returnJButton.text"));
    }
}
