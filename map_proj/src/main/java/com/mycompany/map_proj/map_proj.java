/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.map_proj;
import java.util.Scanner;
import java.util.*; 
/**
 *
 * @author ryanfleming
 */



class Contactcard 
{ 
    String name;
    int phonenumber; 

    
    public Contactcard(String n, int num) 
    { 
        name=n;
        phonenumber=num;

    }
    public void printCard(){
        System.out.println("Name: " + name + "\nPhone : " + phonenumber);
    }
} 
public class map_proj {

    /**
     * @param args the command line arguments
     */
    public static HashMap<String,Contactcard> contactBook=new HashMap<String,Contactcard>();
    public static Scanner myObj = new Scanner(System.in);
    
    public static void getInput(){
        System.out.println("What contact would you like to print? (if none just hit enter)");
        String query = myObj.nextLine();
        if(query!="\n")printThingsMan(query);

    }
    public static String printThingsMan(String query){
        
        if(contactBook.containsKey(query)){
            contactBook.get(query).printCard();
            getInput();
            return contactBook.get(query).name + " " + contactBook.get(query).phonenumber;
            
        }
        else{
        System.out.println("We couldn't find that contact. Try again? y/n");
            String r1= myObj.nextLine();
            if(r1.equals("y"))
               getInput();
            return null;
        }
    }
    public static void main(String[] args) {
       
        System.out.println("Welcome to the Contact Book! When adding cards, you'll be asked for name, number, and email. \n The only one required is the name, leave the others blank if you need");
        System.out.println("How many contact cards would you like to enter?");
        boolean cont =true;
        
        int max = myObj.nextInt();
        myObj.nextLine();
        for(int i=1; i<=max; i++){
            System.out.println("Please input contact " + i +" name");
            String name=myObj.nextLine();
            System.out.println("Please input contact " + i +" phone");
            int phonenum=myObj.nextInt();
            myObj.nextLine();
            
            contactBook.put(name, new Contactcard(name, phonenum));
        }
           if(max!=0)
            getInput();
    }
        
   }
    
    

