/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dona.stm.dba;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import lombok.extern.java.Log;

/**
 *
 * @author Konstantin Tsanov <k.tsanov@gmail.com>
 */
@Log
public class dbAccess {

    private final Connection conn;

    public dbAccess(String connString, String user, String pass) throws SQLException {
        conn = DriverManager.getConnection(connString, user, pass);
        conn.setAutoCommit(false);
    }

    public void insertIntoAssortment() {

    }

    public void listAssortment() {

    }
}
