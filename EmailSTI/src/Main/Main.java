/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Mvc.Controller;
import Mvc.Model;
import Mvc.Panels.VMain;

/**
 * Classe Principal
 * @author Ramayan
 */
public class Main {
    
     public static void main(String args[]) {
        
        //Alterar o caminho do csv antes de rodar
        final Model model = new Model("D:\\Usuários\\Ramayan\\Documents\\NetBeansProjects\\EmailSTI\\src\\files\\alunos.csv");
        final VMain vmain = new VMain(model);
        final Controller controller = new Controller(model,vmain);
        
    }
    
}
