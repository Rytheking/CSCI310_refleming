/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.util.*;
        
/**
 *
 * @author ryanfleming
 */
public class Tri {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
        
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLong()) {
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        algorithm(a,b,c);
        
        }
    }
    
    public static void algorithm(int a,int b,int c)
    {
        if(testAddition(a,b,c)==1) return;
        else if(testSubtraction(a,b,c)==1) return;
        else if(testMultiplication(a,b,c)==1) return;
        else if(testDivision(a,b,c)==1) return;
    }
    
    public static int testAddition(int a,int b,int c)
    {
        if(a+b==c){
            System.out.println( a + "+" + b + "=" + c);
            return 1;
        }
        else if(a==b+c){
            System.out.println(a + "=" + b + "+" + c);
            return 1;
        }
        return 0;
        
    }
    
    public static int testSubtraction(int a,int b,int c)
    {
        if(a-b==c){
            System.out.println( a + "-" + b + "=" + c);
            return 1;
        }
        if(a==b-c){
            System.out.println( a + "=" + b + "-" + c);
            return 1;
        }
        return 0;
    }
    
    public static int testMultiplication(int a,int b,int c)
    {
        if(a*b==c){
            System.out.println( a + "*" + b + "=" + c);
            return 1;
        }
        if(a==b*c){
            System.out.println( a + "=" + b + "*" + c);
            return 1;
        }
        return 0;
    }
    
    public static int testDivision(int a,int b,int c)
    {
        if(a/b==c){
            System.out.println( a + "/" + b + " = " + c);
            return 1;
        }
        if(a==b/c){
            System.out.println( a + "=" + b + "/" + c);
            return 1;
        }
        return 0;
    }
    
}
