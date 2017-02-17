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
public class AppMenuJPanel extends JPanel {

    private final CardLayoutCallback frame;
    private JLabel menuLabel;
    private JButton insertionJButton;
    private JButton removalJButton;

    public AppMenuJPanel(CardLayoutCallback frame) {
        super();
        this.frame = frame;
        setLayout(new MigLayout());
        initComponents();
        addComponents();
    }

    private void initComponents() {
        menuLabel = new JLabel();
        menuLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        insertionJButton = new JButton();
        removalJButton = new JButton();
        insertionJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getMenuCardLayout().show(frame.getMenuJPanel(), JPanelNames.Insert.toString());
            }
        });
        removalJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                frame.getMenuCardLayout().show(frame.getMenuJPanel(), JPanelNames.Select.toString());
            }
        });
    }

    private void addComponents() {
        add(menuLabel, "wrap");
        add(insertionJButton, "wrap");
        add(removalJButton, "wrap");
    }

    public void setComponentText(Locale locale) {
        ResourceBundle r = ResourceBundle.getBundle("Bundle", locale);

        menuLabel.setText(r.getString("MenuJPanel.menuLabel.text"));
        insertionJButton.setText(r.getString("MenuJPanel.addProductJButton.text"));
        removalJButton.setText(r.getString("MenuJPanel.addContractorsJButton.text"));
    }
}
