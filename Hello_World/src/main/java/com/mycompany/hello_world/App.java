/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hello_world;

/**
 *
 * @author ryanfleming
 */

public class App {
    private String greeting = "Hello";
    public String getGreeting(){
        return greeting;
    }
    public void setGreeting(String greeting){
        this.greeting = greeting;
    }
    public static void main(String[] args) throws Exception {
        
        
        /*contructing an app*/
        App app = new App();
        app.run();
    }

    private void run() {
        String who = "World";
        System.out.println("Hello " + who + "!");
    }
}
