/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dona.stm.gui;

import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author Konstantin Tsanov <k.tsanov@gmail.com>
 */
public interface CardLayoutCallback {

    public CardLayout getCardLayout();

    public JPanel getCardJPanel();
}
