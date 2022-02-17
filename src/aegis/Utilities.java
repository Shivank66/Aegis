/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aegis;

import java.util.Scanner;

/**
 *
 * @author 2001s
 */
public class Utilities {
    public static int readInt(Scanner s)
    {
        return Integer.parseInt(s.nextLine());
    }
    public static char readChar(Scanner s)
    {
        return (s.nextLine().charAt(0));
    }
    
}
