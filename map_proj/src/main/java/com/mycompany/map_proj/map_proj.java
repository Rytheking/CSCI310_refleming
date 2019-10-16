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
    public static void printThingsMan(){
        System.out.println("What contact would you like to print? (if none just hit enter)");
        Scanner myObj = new Scanner(System.in);
        String response = myObj.nextLine();
        if(contactBook.containsKey(response)){
            contactBook.get(response).printCard();
            printThingsMan();
        }
        else{
        System.out.println("We couldn't find that contact. Try again? y/n");
            String r1= myObj.nextLine();
            if(r1.equals("y"))
               printThingsMan();
        }
    }
    public static void main(String[] args) {
       
        System.out.println("Welcome to the Contact Book! When adding cards, you'll be asked for name, number, and email. \n The only one required is the name, leave the others blank if you need");
        System.out.println("How many contact cards would you like to enter?");
        boolean cont =true;
        Scanner myObj = new Scanner(System.in);
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
            printThingsMan();
    }
        
   }
    
    

