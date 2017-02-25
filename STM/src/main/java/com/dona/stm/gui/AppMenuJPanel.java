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
 * This is the main menu panel on the left
 *
 * @author Konstantin Tsanov <k.tsanov@gmail.com>
 */
public class AppMenuJPanel extends JPanel {

    //the parent frame is stored here, used to access its cardlayout
    private final CardLayoutCallback parent;
    private JLabel menuLabel;
    private JButton insertionJButton;
    private JButton removalJButton;

    public AppMenuJPanel(CardLayoutCallback parent) {
        super();
        this.parent = parent;
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
        insertionJButton = new JButton();
        removalJButton = new JButton();
    }

    /**
     * Attaches listeners to
     */
    private void attachListeners() {
        insertionJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.getMenuCardLayout().show(parent.getMenuJPanel(), JPanelNames.Insert.toString());
            }
        });
        removalJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO - implement the listener for the removal button
            }
        });
    }

    /**
     * Adds the components to the panel
     */
    private void addComponents() {
        add(menuLabel, "wrap");
        add(insertionJButton, "wrap");
        add(removalJButton, "wrap");
    }

    /**
     * Sets the components' text. Retrieves the text from a bundle based on the
     * preferred language and geographical location
     *
     * @param locale preferred language
     */
    public void setComponentText(Locale locale) {
        ResourceBundle r = ResourceBundle.getBundle("Bundle", locale);
        menuLabel.setText(r.getString("MenuJPanel.menuLabel.text"));
        insertionJButton.setText(r.getString("MenuJPanel.addProductJButton.text"));
        removalJButton.setText(r.getString("MenuJPanel.addContractorsJButton.text"));
    }
}
