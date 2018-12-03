/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import java.text.ParseException;
import java.util.Scanner;

/**
 *
 * @author Ismael
 */
public interface Component {
    Scanner DADES = new Scanner(System.in);
    
    void mostrarComponent();
    
    public void modificarComponent() throws ParseException;
    
    Object demanarDades(String peticio, int tipus);
    
}
