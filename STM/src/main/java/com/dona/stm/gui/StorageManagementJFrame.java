/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template fileJMenu, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dona.stm.gui;

import com.dona.stm.enums.JPanelNames;
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
 * The main entry point is here.
 *
 * @author Konstantin Tsanov <k.tsanov@gmail.com>
 */
public class StorageManagementJFrame extends JFrame implements CardLayoutCallback {

    //frame jpanels
    private JPanel viewsJPanel, menuJPanel;
    //frame card layouts
    private CardLayout menuCardLayout, viewsCardLayout;
    //views
    private ContractorsJPanel contractorsJPanel;
    private AddProductJPanel assortmentsAddingJPanel;
    //app menus
    private AppMenuJPanel appMenuJPanel;
    private InsertMenuJPanel insertMenuJPanel;
    //frame menus
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
        viewsJPanel.setVisible(false);
        viewsJPanel.setLayout(viewsCardLayout);
        menuJPanel.setLayout(menuCardLayout);

        viewsJPanel.add(assortmentsAddingJPanel, JPanelNames.Products.toString());
        viewsJPanel.add(contractorsJPanel, JPanelNames.Contractors.toString());

        menuJPanel.add(appMenuJPanel, JPanelNames.Menu.toString());
        menuJPanel.add(insertMenuJPanel, JPanelNames.Insert.toString());

        setLanguage(getLocaleFromPreferences());

        add(menuJPanel, BorderLayout.WEST);
        add(viewsJPanel, BorderLayout.EAST);
        pack();
    }

    /**
     * Initializes all components, excluding the submenus
     */
    private void initComponents() {
        viewsCardLayout = new CardLayout();
        menuCardLayout = new CardLayout();
        topMenuBar = new JMenuBar();
        insertMenuJPanel = new InsertMenuJPanel(this);
        appMenuJPanel = new AppMenuJPanel(this);
        viewsJPanel = new JPanel();
        menuJPanel = new JPanel();
        contractorsJPanel = new ContractorsJPanel();
        assortmentsAddingJPanel = new AddProductJPanel();
    }

    /**
     * Initializes the menu bar
     */
    private void initMenuBar() {
        createInitFileMenu();
        createInitOptionsMenu();
        setJMenuBar(topMenuBar);
    }

    /**
     * creates and initializes the file menu and submenus
     */
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

    /**
     * Creates and initizlies the options menu and submenu
     */
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

    /**
     * Sets sets the text of the entire application
     *
     * @param locale determines the component text
     */
    private void setLanguage(Locale locale) {
        assortmentsAddingJPanel.setComponentText(locale);
        contractorsJPanel.setComponentText(locale);
        appMenuJPanel.setComponentText(locale);
        insertMenuJPanel.setComponentText(locale);
        setComponentText(locale);
    }

    /**
     * Sets the components' text
     *
     * @param locale determines the component text
     */
    private void setComponentText(Locale locale) {
        ResourceBundle r = ResourceBundle.getBundle("Bundle", locale);
        fileJMenu.setText(r.getString("StorageManagementJFrame.optionsMenu.fileJMenu"));
        exitJMenuItem.setText(r.getString("StorageManagementJFrame.optionsMenu.exitJMenuItem"));
        optionsJMenu.setText(r.getString("StorageManagementJFrame.optionsMenu.optionsJMenu"));
        languageJMenu.setText(r.getString("StorageManagementJFrame.optionsMenu.languageJMenu"));
    }

    /**
     * Gets the lastly used language from the registry(windows) or whatever it
     * is in linux
     *
     * @return new locale object, composed of the extracted parameters
     */
    private Locale getLocaleFromPreferences() {
        Preferences prefs = Preferences.userRoot().node(getClass().getName());
        String language = "Language";
        String country = "Country";
        return new Locale(prefs.get(language, "en"), prefs.get(country, "US"));
    }

    /**
     * Sets the lastly used language in the registry(windows) or whatever it is
     * in linux
     *
     * @param lang enum containing the required variables
     */
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
    public CardLayout getViewsCardLayout() {
        return viewsCardLayout;
    }

    @Override
    public JPanel getViewsJPanel() {
        return viewsJPanel;
    }

    @Override
    public CardLayout getMenuCardLayout() {
        return menuCardLayout;
    }

    @Override
    public JPanel getMenuJPanel() {
        return menuJPanel;
    }
}
