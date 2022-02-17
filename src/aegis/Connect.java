package aegis;

import static aegis.Insert.delete;
import static aegis.Insert.display;
import static aegis.Insert.insert;
import static aegis.Insert.update;
import java.sql.SQLException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 2001s
 */
public class Connect {
    public static void main(String args[]) throws SQLException
    {
    
        while(true){
            
        System.out.println("............Menu..........");
    System.out.println("1. Add");
    System.out.println("2. Display");//1. Add
    System.out.println("3. Update");
    System.out.println("4. Delete");
    System.out.println("5. Exit");
    Scanner sc=new Scanner(System.in);
    int ch=Utilities.readInt(sc);
    switch(ch)
    {
    case 1:
    {
        while(true)
        {
    boolean s=insert(sc);
    System.out.println("Do you want to enter More records (Y/N)");
    char nex=Utilities.readChar(sc);
    if(nex=='N')
        display();
    if(nex!='Y')
        break;
        }
    break;
    }
    case 2:
    {
       display(); 
    
    break;
    }
    case 3:
    {
        update(sc);
        
        
    break;
    }
    case 4:
    {
    delete(sc);
        
    break;
    }
    case 5:
    {
    System.out.println("Exited Successfully");
    return;
    }
        }
    
    }
   
}

  
}
