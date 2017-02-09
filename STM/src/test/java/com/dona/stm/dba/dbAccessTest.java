/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dona.stm.dba;

import com.dona.stm.Factory;
import com.dona.stm.IProduct;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Konstantin Tsanov <k.tsanov@gmail.com>
 */
public class dbAccessTest {
    
    public dbAccessTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of insertIntoAssortment method, of class dbAccess.
     */
    @Test
    public void testInsertIntoAssortment() throws Exception {
        System.out.println("insertIntoAssortment");
        IProduct product = new Factory().createProduct("1000000", "bla", "m", "Dollar", "40", "5", "10", "15", "20");
        dbAccess instance = new dbAccess("jdbc:mysql://localhost:3306/productmanagementsystem?autoReconnect=true&useSSL=false", "root", "1234");
        instance.insertIntoAssortment(product);
    }

    /**
     * Test of listAssortment method, of class dbAccess.
     */
    @Test
    public void testListAssortment() {
    }
    
}
