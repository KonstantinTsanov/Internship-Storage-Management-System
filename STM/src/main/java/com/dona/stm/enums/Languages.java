/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dona.stm.enums;

import java.util.Locale;
import lombok.Getter;

/**
 * When a new language is present in the bundle it must be added here using the
 * following pattern Language("LanguageLabel","ShortLanguage","ShortCountry")
 *
 * @author Konstantin Tsanov <k.tsanov@gmail.com>
 */
public enum Languages {
    English("English", "en", "US"),
    Bulgarian("Български", "bg", "BG");
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

    public Locale getLocale() {
        return new Locale(getShortLanguage(), getShortCountry());
    }
}
