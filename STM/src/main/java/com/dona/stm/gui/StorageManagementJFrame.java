/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template fileJMenu, choose Tools | Templates
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
import java.util.ResourceBundle;
import java.util.prefs.Preferences;
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
    private MenuJPanel applicationMenu;
    private JMenuBar topMenuBar;
    private JMenu fileJMenu, optionsJMenu, languageJMenu;
    private JMenuItem exitJMenuItem;
    
    public StorageManagementJFrame() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(800, 600));
        setPreferredSize(new Dimension(800, 600));
        setResizable(false);
        initComponents();
        initMenuBar();
        
        cardJPanel.setLayout(cardLayout);
        cardJPanel.add(assortmentsAddingJPanel, CardLayoutJPanels.Assortment.toString());
        cardJPanel.add(contractorsJPanel, CardLayoutJPanels.Contractors.toString());
        
        setLanguage(getLocaleFromPreferences());
        
        add(applicationMenu, BorderLayout.WEST);
        add(cardJPanel, BorderLayout.EAST);
        pack();
    }
    
    private void initComponents() {
        topMenuBar = new JMenuBar();
        applicationMenu = new MenuJPanel(this);
        cardJPanel = new JPanel();
        contractorsJPanel = new ContractorsJPanel();
        assortmentsAddingJPanel = new AddProductJPanel();
    }
    
    private void initMenuBar() {
        createInitFileMenu();
        createInitOptionsMenu();
        setJMenuBar(topMenuBar);
    }
    
    private void createInitFileMenu() {
        fileJMenu = new JMenu();
        fileJMenu.setMnemonic(KeyEvent.VK_F);
        exitJMenuItem = new JMenuItem("Exit");
        exitJMenuItem.setMnemonic(KeyEvent.VK_E);
        exitJMenuItem.setToolTipText("Exit application");
        exitJMenuItem.addActionListener((ActionEvent event) -> {
            System.exit(0);
        });
        fileJMenu.add(exitJMenuItem);
        topMenuBar.add(fileJMenu);
    }
    
    private void createInitOptionsMenu() {
        optionsJMenu = new JMenu();
        optionsJMenu.setMnemonic(KeyEvent.VK_O);
        languageJMenu = new JMenu();
        for (Languages lang : Languages.values()) {
            JMenuItem language = new JMenuItem(lang.getName());
            language.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ActionEvent) {
                    setLanguage(lang.getLocale());
                    setLocaleToPreferences(lang);
                }
            });
            languageJMenu.add(language);
        }
        optionsJMenu.add(languageJMenu);
        topMenuBar.add(optionsJMenu);
    }
    
    private void setComponentText(Locale locale) {
        ResourceBundle r = ResourceBundle.getBundle("Bundle", locale);
        fileJMenu.setText(r.getString("StorageManagementJFrame.optionsMenu.fileJMenu"));
        exitJMenuItem.setText(r.getString("StorageManagementJFrame.optionsMenu.exitJMenuItem"));
        optionsJMenu.setText(r.getString("StorageManagementJFrame.optionsMenu.optionsJMenu"));
        languageJMenu.setText(r.getString("StorageManagementJFrame.optionsMenu.languageJMenu"));
    }
    
    private void setLanguage(Locale locale) {
        assortmentsAddingJPanel.setComponentText(locale);
        contractorsJPanel.setComponentText(locale);
        applicationMenu.setComponentText(locale);
        setComponentText(locale);
    }
    
    private Locale getLocaleFromPreferences() {
        Preferences prefs = Preferences.userRoot().node(getClass().getName());
        String language = "Language";
        String country = "Country";
        return new Locale(prefs.get(language, "en"), prefs.get(country, "US"));
    }
    
    private void setLocaleToPreferences(Languages lang) {
        Preferences prefs = Preferences.userRoot().node(getClass().getName());
        String language = "Language";
        String country = "Country";
        prefs.put(language, lang.getShortLanguage());
        prefs.put(country, lang.getShortCountry());
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
