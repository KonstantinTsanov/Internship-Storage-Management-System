/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dona.stm.gui;

import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 * Used by the main frame as an intermediate variable. Instead of hardcoding a
 * StorageManagementJFame as parent (in every jpanel!) the frame implements this
 * interface, and we have a variable of that interface holding the frame.
 *
 * @author Konstantin Tsanov <k.tsanov@gmail.com>
 */
public interface CardLayoutCallback {

    /**
     * The views cardlayout is on the right in the frame
     *
     * @return
     */
    public CardLayout getViewsCardLayout();

    public JPanel getViewsJPanel();

    /**
     * The views cardlayout is on the left in the frame
     *
     * @return
     */
    public CardLayout getMenuCardLayout();

    public JPanel getMenuJPanel();
}
