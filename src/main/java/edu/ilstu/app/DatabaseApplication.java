/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ilstu.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


/**
 *
 * @author Administrator
 */
public class DatabaseApplication {
    
    public static void main(String[] args)
    {
        
        try
        {    
        
        //Establish a connectiom
        Connection dbConnection = DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app","app");
        
        System.out.println(" Database connection was established!");
        
        
        //create statement
        Statement stmt = dbConnection.createStatement();
        
        System.out.println(" Statement created");
              
        
        //Execute query
        ResultSet rs = stmt.executeQuery("select * from app.customer");
        
        System.out.println(" Resul");
        
        
        //process results
        
        ArrayList<String> listOfNames = new ArrayList<>();
        
        while(rs.next())
        {
        
            String firstname = rs.getString("name");
            System.out.println( firstname );
            
            listOfNames.add(firstname);
        }
        
        
        dbConnection.close();
        
        }
        
        catch(Exception e)
        {
            System.out.println(">>>> Error: " +e.toString());
        }
        

        
    }
    
}
