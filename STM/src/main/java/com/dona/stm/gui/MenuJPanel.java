/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dona.stm.gui;

import com.dona.stm.enums.CardLayoutJPanels;
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
public class MenuJPanel extends JPanel {

    private final CardLayoutCallback frame;
    private JLabel menuLabel;
    private JButton addProductJButton;
    private JButton addContractorsJButton;

    public MenuJPanel(CardLayoutCallback frame) {
        super();
        this.frame = frame;
        setLayout(new MigLayout());
        initializeComponents();
        addComponents();
    }

    private void initializeComponents() {
        menuLabel = new JLabel();
        menuLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        addProductJButton = new JButton();
        addContractorsJButton = new JButton();
        addProductJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getCardLayout().show(frame.getCardJPanel(), CardLayoutJPanels.Assortment.toString());
            }
        });
        addContractorsJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getCardLayout().show(frame.getCardJPanel(), CardLayoutJPanels.Contractors.toString());
            }
        });
    }

    private void addComponents() {
        add(menuLabel, "wrap");
        add(addProductJButton, "wrap");
        add(addContractorsJButton, "wrap");
    }

    public void setComponentText(Locale locale) {
        ResourceBundle r = ResourceBundle.getBundle("Bundle", locale);

        menuLabel.setText(r.getString("MenuJPanel.menuLabel.text"));
        addProductJButton.setText(r.getString("MenuJPanel.addProductJButton.text"));
        addContractorsJButton.setText(r.getString("MenuJPanel.addContractorsJButton.text"));
    }
}
