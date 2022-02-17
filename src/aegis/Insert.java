package aegis;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 2001s
 */
public class Insert {
    public static boolean insert(Scanner s)throws SQLException
    {
        
            PreparedStatement ps=DatabaseConfig.connect().prepareStatement("INSERT INTO `student`  VALUES (NULL,?, ?, ?, ?, ?, ?)");
             System.out.println("1. Enter Roll No: ");
    String roll=s.nextLine();
            System.out.println("2.Enter Name");
            String name=s.nextLine();
            
    System.out.println("3. Enter Contact No: ");
    String phone=s.nextLine();
    System.out.println("4. Enter City: ");
    String city=s.nextLine();
    System.out.println("5. Enter Email ID: ");
    String email=s.nextLine();
    System.out.println("6. Enter Standard: ");
    String std=s.nextLine();
    ps.setString(1, roll);
    ps.setString(2, name);
    ps.setString(3,phone);
    
    ps.setString(4,city);
    ps.setString(5,email);
    ps.setString(6,std);
    ps.executeUpdate();
       return true;
        }
    
    public static boolean display()throws SQLException
    {
        
            PreparedStatement ps=DatabaseConfig.connect().prepareStatement("SELECT * FROM `student` WHERE 1");
            ResultSet rs=ps.executeQuery();
            ResultSetMetaData s=rs.getMetaData();
            int n=s.getColumnCount();
            while(rs.next())
            {
                for(int i=2;i<n;i++)
            System.out.print(rs.getObject(i)+",");
            System.out.print(rs.getObject(n));
            System.out.println();
            }
            return true;
        }
        
    public static void update(Scanner s) throws SQLException
    {
    System.out.println("1. Enter Roll No: ");
    String roll=s.nextLine();
    System.out.println("2.Enter Name");
    String name=s.nextLine();
    System.out.println("3. Enter Contact No: ");
    String phone=s.nextLine();
    System.out.println("4. Enter City: ");
    String city=s.nextLine();
    System.out.println("5. Enter Email ID: ");
    String email=s.nextLine();
    System.out.println("6. Enter Standard: ");
    String std=s.nextLine();
    PreparedStatement ps=DatabaseConfig.connect().prepareStatement("UPDATE `student` SET `name` = ?, `rollno` = ?, `contactno` = ?, `city` = ?, `emailid` = ?, `standard` = ? WHERE `student`.`rollno` = ?");
    ps.setString(1,name);
    ps.setString(2,roll);
    ps.setString(3,phone);
    ps.setString(4,city);
    ps.setString(5,email);
    ps.setString(6,std);
    ps.setString(7,roll);
    int y=ps.executeUpdate();
    System.out.println("----------------------------------");
    display();
    System.out.println("----------------------------------");
    if(y>0)
    System.out.println("Record updated successfully");
    else
        System.out.println("No Record updated "); 
    }
    
    
    
  public static void delete(Scanner s) throws SQLException
  {
      System.out.println("Enter roll no: ");
        String roll=s.nextLine();
        System.out.println("Are you sure you want to Delete(Y/N): ");
  char ans=s.nextLine().charAt(0);
  if(ans=='Y')
  {
  PreparedStatement ps=DatabaseConfig.connect().prepareStatement("DELETE FROM `student` WHERE `student`.`rollno` = ?");
  ps.setString(1,roll);
  int n=ps.executeUpdate();
  if(n>0)
    System.out.println(n+" Record deleted successfully");
    else
        System.out.println("No Record deleted "); 
    
      
  }
  display();
  
  }
    
    
    
}
