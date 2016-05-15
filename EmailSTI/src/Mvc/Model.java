/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mvc;

import Classes.Aluno;
import Classes.CsvEditor;

/**
 * Classe que guarda e manipula os dados necessários 
 * @author Ramayan
 */
public class Model {
    
    private final CsvEditor parser;
    private boolean isMatReg;
    private Aluno aluno;     
    
    public Model(String csvfilePath){
        this.parser = new CsvEditor(csvfilePath);        
    }
    
    /**Gets student's data based on his registered i
     * @param matricula* student's registered id
     * @return id that id is registered in the system
     */
    public boolean isMatRegistered(String matricula){
        return isMatReg;
    }
    
    /**Gets student's data based on his registered id, registering it in Model
     * @param matricula* student's registered id
     ***/
    public void getInfo(String matricula){
        isMatReg = false;
        String[] info = parser.getInfo(matricula);
        if(info!=null){
            this.aluno = new Aluno(info);
            isMatReg = true;
        }
    }
    
    public Aluno getAluno(){
        return this.aluno;
    }
    
    /***Makes all String operations over student's name to create email sugestions***/
    public void createEmailSugestions(){
        String subnomes[] = aluno.getNome().split(" ");
        String[] sugestoes = new String[5];
        
        sugestoes[0] = (subnomes[0]+"_"+subnomes[subnomes.length-1]).toLowerCase()+"@id.uff.br";
        
        sugestoes[1] = subnomes[0];
        for(int i=0;i<subnomes.length-1;i++){
            sugestoes[1]+=(subnomes[i].charAt(0));
        }
        sugestoes[1]= sugestoes[1].toLowerCase()+"@id.uff.br";
        
        sugestoes[2]= (subnomes[0]+subnomes[subnomes.length-1]).toLowerCase()+"@id.uff.br";
        
        sugestoes[3]= (subnomes[0].charAt(0)+subnomes[subnomes.length-1]).toLowerCase()+"@id.uff.br";
        
        sugestoes[4]= (subnomes[0].charAt(0)+subnomes[1]+subnomes[subnomes.length-1]).toLowerCase()+"@id.uff.br";
        
        aluno.setEmailSug(sugestoes);
    }
    

    
    /** Passes to Parser to search in the csv file if the email is avaliable
     * @return true if email is avaliable and updates it*
     **/
    public boolean isEmailAvaliable(){
        if (parser.isEmailAviable(aluno.getChoosenUffMail())){
            aluno.setUffMail(aluno.getChoosenUffMail());
            updateUffMail();
            return true;
        }
        else return false;
    }    
    
    /*** Passes to Parser to update the uffmail to the new one***/
    public void updateUffMail(){
        parser.editCsv(aluno.getInfo());
        //Aqui se meche no parse dnv para colocar no csv o email criado
    }
        
    
}
