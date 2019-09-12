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
    void run() {}
    
    private String language = "en";
    
    void setLanguage(String language){
        if(language.equals("en")||language.equals("cn")){
            this.language = language;
        }
        else{
            throw new UnsupportedOperationException("Not Supported yet");
        }
        
    }
    
    public String getMessage(){
        switch(language){
            case "en": return "Hello World!";
            case "cn": return "你好，世界";
            
        }
        throw new IllegalStateException("Not Supported yet");
    }
 
    public static void main(String[] args) throws Exception {
        /*contructing an app*/
        App app = new App();
        app.run();
    }

  
}
