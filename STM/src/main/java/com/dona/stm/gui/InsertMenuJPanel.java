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
 * One of the menu panels, place the insert buttons here.
 *
 * @author Konstantin Tsanov <k.tsanov@gmail.com>
 */
public class InsertMenuJPanel extends JPanel {

    //the parent jframe
    private final CardLayoutCallback jframeParent;
    private JLabel menuLabel;
    private JButton contractorsJButton, productJButton;
    private JButton returnJButton;

    public InsertMenuJPanel(CardLayoutCallback parent) {
        this.jframeParent = parent;
        setLayout(new MigLayout());
        initComponents();
        addComponents();
        attachListeners();
    }

    /**
     * Initializes all components
     */
    private void initComponents() {
        menuLabel = new JLabel();
        menuLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        contractorsJButton = new JButton();
        productJButton = new JButton();
        returnJButton = new JButton();
    }

    /**
     * Adds the components to the panel
     */
    private void addComponents() {
        add(menuLabel, "wrap");
        add(contractorsJButton, "wrap");
        add(productJButton, "wrap");
        add(returnJButton, "wrap");
    }

    /**
     * Attaches listeners to the components
     */
    private void attachListeners() {
        //Button to insert into products
        productJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jframeParent.getViewsCardLayout().show(jframeParent.getViewsJPanel(), JPanelNames.Products.toString());
                jframeParent.getViewsJPanel().setVisible(true);
            }
        });
        //Button to insert into contractors
        contractorsJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jframeParent.getViewsCardLayout().show(jframeParent.getViewsJPanel(), JPanelNames.Contractors.toString());
                jframeParent.getViewsJPanel().setVisible(true);
            }
        });
        //button to return to the previous menu
        returnJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jframeParent.getMenuCardLayout().show(jframeParent.getMenuJPanel(), JPanelNames.Menu.toString());
                jframeParent.getViewsJPanel().setVisible(false);
            }
        });
    }

    /**
     * Sets the components' text
     *
     * @param locale determines the component text
     */
    public void setComponentText(Locale locale) {
        ResourceBundle r = ResourceBundle.getBundle("Bundle", locale);
        menuLabel.setText(r.getString("InsertMenuJPanel.menuLabel.text"));
        contractorsJButton.setText(r.getString("InsertMenuJPanel.contractorsJButton.text"));
        productJButton.setText(r.getString("InsertMenuJPanel.productJButton.text"));
        returnJButton.setText(r.getString("InsertMenuJPanel.returnJButton.text"));
    }
}
