/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mvc;

import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 * Classe abstrata das Telas
 * @author Ramayan
 */
public abstract class View extends JFrame{    
    
    public void addConfListener(ActionListener al) {
    }
    
    public String getChoosenIdUff(){
        return "";
    }
    
    public String getMat(){
        return "";
    }
    
}
