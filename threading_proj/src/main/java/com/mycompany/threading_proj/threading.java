/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.threading_proj;
import java.util.Scanner;
/**
 *
 * @author ryanfleming
 */
class Thread2 extends Thread{
    @Override
    public void run(){
        for(int i=1; i<=10; i++){
            System.out.println("Launching missile #"+i + " Enemy: #2");
        }
    }
   
}
public class threading {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Thread2 task = new Thread2();
        task.start();
        for(int i=1; i<=10; i++){
            System.out.println("Launching missile #"+i + " Enemy: #1");
        }
      
        
      
    }
    
}
