/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dona.stm.enums;

/**
 *
 * @author Konstantin Tsanov <k.tsanov@gmail.com>
 */
public enum Languages {
    English("English"),
    Bulgarian("Български");
    private final String name;

    private Languages(String s) {
        name = s;
    }
}
