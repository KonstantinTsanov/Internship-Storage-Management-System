/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dona.stm.enums;

import java.util.Locale;
import lombok.Getter;

/**
 *
 * @author Konstantin Tsanov <k.tsanov@gmail.com>
 */
public enum Languages {
    English("English", "en", "US") {
        @Override
        public Locale getLocale() {
            return new Locale(getShortLanguage(), getShortCountry());
        }
    },
    Bulgarian("Български", "bg", "BG") {
        @Override
        public Locale getLocale() {
            return new Locale(getShortLanguage(), getShortCountry());
        }
    };
    @Getter
    private final String name;
    @Getter
    private final String shortLanguage;
    @Getter
    private final String shortCountry;

    private Languages(String name, String shortLanguage, String shortCountry) {
        this.name = name;
        this.shortLanguage = shortLanguage;
        this.shortCountry = shortCountry;
    }

    public abstract Locale getLocale();
}
