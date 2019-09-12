/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author ryanfleming
 */
public class Tri {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int a = 5;
        int b = 3;
        int c = 8;
        algorithm(a,b,c);
    }
    
    public static void algorithm(int a,int b,int c)
    {
        testAddition(a,b,c);
        testSubtraction(a,b,c);
        testMultiplication(a,b,c);
        testDivision(a,b,c);
    }
    
    public static void testAddition(int a,int b,int c)
    {
        if(a+b==c){
            System.out.println( a + " + " + b + " = " + c);
        }
        else if(a+c==b){
            System.out.println(a + " + " + c + " = " + b);
        }
        else if(c+b==a){
           System.out.println( c + " + " + b + " = " + a);
        }
        
    }
    
    public static String testSubtraction(int a,int b,int c)
    {
        if(a-b==c){
            return a + " - " + b + " = " + c;
        }
        if(a-c==b){
            return a + " - " + c + " = " + b;
        }
        if(b-a==c){
            return b + " - " + a + " = " + c;
        }
        if(b-c==a){
            return b + " - " + c + " = " + a;
        }
        if(c-a==b){
            return c + " - " + a + " = " + b;
        }
        if(c-b==a){
            return c + " - " + b + " = " + a;
        }
        return "yellow";
    }
    
    public static String testMultiplication(int a,int b,int c)
    {
        if(a*b==c){
            
        }
        if(a*c==b){
            
        }
        if(c*b==a){
            
        }
        
        return "yellow";
    }
    
    public static String testDivision(int a,int b,int c)
    {
        if(a/b==c){
            
        }
        if(a/c==b){
            
        }
        if(b/a==c){
            
        }
        if(b/c==a){
            
        }
        if(c/a==b){
            
        }
        if(c/b==a){
            
        }
        
        return "yellow";
    }
    
}
