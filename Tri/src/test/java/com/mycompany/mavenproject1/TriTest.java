/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ryanfleming
 */
public class TriTest {
    
    public TriTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of main method, of class Tri.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Tri.main(args);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of algorithm method, of class Tri.
     */
    @Test
    public void testAlgorithm() {
        System.out.println("algorithm");
        int a = 4;
        int b = 5;
        int c = 9;
        Tri.algorithm(a, b, c);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of testAddition method, of class Tri.
     */
    @Test
    public void testTestAddition() {
        System.out.println("testAddition");
        int a = 5;
        int b = 4;
        int c = 9;
        String expResult = "5+4=9";
        int result = Tri.testAddition(a, b, c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of testSubtraction method, of class Tri.
     */
    @Test
    public void testTestSubtraction() {
        System.out.println("testSubtraction");
        int a = 5;
        int b = 9;
        int c = 4;
        String expResult = "5=9-4";
        int result = Tri.testSubtraction(a, b, c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of testMultiplication method, of class Tri.
     */
    @Test
    public void testTestMultiplication() {
        System.out.println("testMultiplication");
        int a = 3;
        int b = 3;
        int c = 1;
        String expResult = "3=3*1";
        int result = Tri.testMultiplication(a, b, c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
 
    }

    /**
     * Test of testDivision method, of class Tri.
     */
    @Test
    public void testTestDivision() {
        System.out.println("testDivision");
        int a = 5;
        int b = 25;
        int c = 5;
        String expResult = "5=25/5";
        int result = Tri.testDivision(a, b, c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
