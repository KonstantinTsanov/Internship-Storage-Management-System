/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dona.stm.gui;

import com.dona.stm.enums.CardLayoutJPanels;
import com.dona.stm.enums.Languages;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Locale;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author Konstantin Tsanov <k.tsanov@gmail.com>
 */
public class StorageManagementJFrame extends JFrame implements CardLayoutCallback {

    private JPanel cardJPanel;
    private ContractorsJPanel contractorsJPanel;
    private AddProductJPanel assortmentsAddingJPanel;
    private final CardLayout cardLayout = new CardLayout();
    private MenuJPanel optionsJPanel;

    public StorageManagementJFrame() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(580, 420));
        setPreferredSize(new Dimension(680, 420));
        createMenuBar();
        optionsJPanel = new MenuJPanel(this);
        cardJPanel = new JPanel();
        contractorsJPanel = new ContractorsJPanel();
        assortmentsAddingJPanel = new AddProductJPanel();
        cardJPanel.setLayout(cardLayout);
        cardJPanel.add(assortmentsAddingJPanel, CardLayoutJPanels.Assortment.toString());
        cardJPanel.add(contractorsJPanel, CardLayoutJPanels.Contractors.toString());

        add(optionsJPanel, BorderLayout.WEST);
        add(cardJPanel, BorderLayout.EAST);
        pack();
    }

    private void setLanguage(Locale locale) {
        assortmentsAddingJPanel.SetComponentText(locale);
        contractorsJPanel.setComponentText(locale);
        optionsJPanel.setComponentText(locale);
    }

    private void createMenuBar() {
        //Menu bar
        JMenuBar menubar = new JMenuBar();

        //File menu
        JMenu file = new JMenu("File");
        file.setMnemonic(KeyEvent.VK_F);
        JMenuItem eMenuItem = new JMenuItem("Exit");
        eMenuItem.setMnemonic(KeyEvent.VK_E);
        eMenuItem.setToolTipText("Exit application");
        eMenuItem.addActionListener((ActionEvent event) -> {
            System.exit(0);
        });
        file.add(eMenuItem);
        menubar.add(file);

        //Options menu
        JMenu options = new JMenu("Options");
        file.setMnemonic(KeyEvent.VK_O);
        JMenu languages = new JMenu("Language");
        for (Languages lang : Languages.values()) {
            JMenuItem language = new JMenuItem(lang.getName());
            language.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ActionEvent) {
                    setLanguage(lang.getLocale());
                }
            });
            languages.add(language);
        }
        options.add(languages);
        menubar.add(options);
        setJMenuBar(menubar);
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StorageManagementJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StorageManagementJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StorageManagementJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StorageManagementJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                StorageManagementJFrame frame = new StorageManagementJFrame();
                frame.setVisible(true);
            }
        });
    }

    @Override
    public CardLayout getCardLayout() {
        return cardLayout;
    }

    @Override
    public JPanel getCardJPanel() {
        return cardJPanel;
    }
}
