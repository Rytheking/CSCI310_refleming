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
    
    public static void main(String[] args) {
        HashMap<String,Contactcard> contactBook=new HashMap<String,Contactcard>();
        System.out.println("Welcome to the Contact Book! When adding cards, you'll be asked for name, number, and email. \n The only one required is the name, leave the others blank if you need");
        System.out.println("Would you like to enter contact cards? y/n");
        boolean cont =true;
        Scanner myObj = new Scanner(System.in);
        String response = myObj.nextLine();
        if(response.equals("y"))
        {
        int i=1;
        while(cont){
            System.out.println("Please input contact " + i +" name");
            String name=myObj.nextLine();
            System.out.println("Please input contact " + i +" phone");
            
            int phonenum=myObj.nextInt();
            
            contactBook.put(name, new Contactcard(name, phonenum));
           
            System.out.println("Would you like to continue? y/n");
            
            String r2 = myObj.nextLine();
            if(!r2.equals("y"))
            {
                cont=false;
            }
        }
        System.out.println("What contact would you like to print?");
        response = myObj.nextLine();
        if(contactBook.containsKey(response)){
            contactBook.get(response).printCard();
        }
        else{
            System.out.println("We couldn't find that contact");
        }
    }
        else{
            System.out.println("Why'd you open this then?");
        }
        
   }
    
}
