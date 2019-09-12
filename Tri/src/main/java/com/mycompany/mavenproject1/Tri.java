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
        
        a= 5;
        b=15;
        c=3;
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
        else if(a==b+c){
            System.out.println(a + " = " + b + " + " + c);
        }
        
    }
    
    public static void testSubtraction(int a,int b,int c)
    {
        if(a-b==c){
            System.out.println( a + " - " + b + " = " + c);
        }
        if(a==b-c){
            System.out.println( a + " = " + b + " - " + c);
        }
    }
    
    public static void testMultiplication(int a,int b,int c)
    {
        if(a*b==c){
            System.out.println( a + " * " + b + " = " + c);
        }
        if(a==b*c){
            System.out.println( a + " = " + b + " * " + c);
        }
    }
    
    public static void testDivision(int a,int b,int c)
    {
        if(a/b==c){
            System.out.println( a + " / " + b + " = " + c);
        }
        if(a==b/c){
            System.out.println( a + " = " + b + " / " + c);
        }
        
    }
    
}
