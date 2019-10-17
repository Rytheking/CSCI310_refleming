/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.map_proj;


import java.util.HashMap;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ryanfleming
 */
public class map_projTest {
    
  
    @Test
    public void testPrintThingsMan() {
       HashMap<String,Contactcard> contactBook=new HashMap<String,Contactcard>();
       map_proj.contactBook.put("Ryan", new Contactcard("Ryan", 7128362));
       assert(map_proj.printThingsMan("Ryan").equals("Ryan 7128362"));
    }

    
}
