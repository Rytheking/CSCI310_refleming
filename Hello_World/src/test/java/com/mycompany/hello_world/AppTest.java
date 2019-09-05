/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hello_world;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author ryanfleming
 */
public class AppTest {
    
    public AppTest() {
    }
    
    @Test
    public void testRun(){
        System.out.println("Run");
        App instance = new App();
        instance.run();
        fail("This test case is a prototype");
    }
    
    @Test
    public void testInEnglish(){
        App app = new App();
        app.setLanguage("en");
        String message = app.getMessage();
        String expect = "Hello World";
        assertEquals(expect,message);
    }
    
    @Test
    public void testInChinese(){
        App app = new App();
        app.setLanguage("cn");
        String message = app.getMessage();
        String expect = "你好，世界";
        assertEquals(expect,message);
    }
    
    
}
