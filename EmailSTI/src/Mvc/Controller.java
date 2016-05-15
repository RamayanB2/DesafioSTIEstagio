/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mvc;

import Mvc.Panels.VMain;
import Mvc.Panels.VEmails;
import Mvc.Panels.VFinal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Ramayan
 */
public class Controller {
    
    private final Model model;
    private View view;
    
    public Controller(Model model,VMain view){
        this.model = model;
        this.view = view;
        
        view.addConfListener(new ConfMatListener());
    }

    
    
    private class ConfMatListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if(!view.getMat().equalsIgnoreCase("")){
                model.getInfo(view.getMat());
                
                if(model.isMatRegistered(view.getMat())){
                model.createEmailSugestions();
                view.dispose();
                view = new VEmails(model);
                view.addConfListener(new ConfEmailListener());
                }else JOptionPane.showMessageDialog(view,"A matrícula inserida não consta no nosso sistema.\n Por favor insira uma matricula correta.");
          }else JOptionPane.showMessageDialog(view,"Nenhuma matricula foi inserida. \nPor favor insira a matricula.");
        }
    }
    
    private class ConfEmailListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if(view.getChoosenIdUff()==null){
                JOptionPane.showMessageDialog(view,"Por favor, selecione alguma opção");
            }else {
            model.getAluno().setChoosenEmail(view.getChoosenIdUff());
            if(model.isEmailAvaliable()){
                view.dispose();
                view = new VFinal(model);
                view.addConfListener(new ConfDoneListener());
            }else JOptionPane.showMessageDialog(view,"Escolha outra opção por favor,\n esse uffmail já existe");
        }
        }
    }
    
    private class ConfDoneListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            view.dispose();
        }
    }
}
