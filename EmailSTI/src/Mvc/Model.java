/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mvc;

import Main.CsvParser;

/**
 * Classe que guarda e manipula os dados necessários 
 * @author Ramayan
 */
public class Model {
    
    private final CsvParser parser;
    private String[] email_sugestions;
    private String[] info_aluno;
    private String choosen;
    
    public Model(String csvfilePath){
        this.parser = new CsvParser(csvfilePath);        
    }
    
    /**Gets student's data based on his registered i
     * @param matricula* student's registered id
     * @return id that id is registered in the system
     */
    public boolean isMatRegistered(String matricula){
        if(info_aluno==null)return false;
        else return true;
    }
    
    /**Gets student's data based on his registered id, registering it in Model
     * @param matricula* student's registered id
     ***/
    public void getInfo(String matricula){
        this.info_aluno = parser.getInfo(matricula);
    }
    
    public String getNome(){return info_aluno[0];}
    public String getMatricula(){return info_aluno[1];}
    public String getTel(){return info_aluno[2];}
    public String getEmail(){return info_aluno[3];}
    public String getUffMail(){return info_aluno[4];}
    public String getStatus(){return info_aluno[5];}    
    public void setUffMail(){this.info_aluno[4]=choosen;}    
    public String[] getEmailSugestions(){return email_sugestions;}
    
    /***Makes all String operations over student's name to create email sugestions***/
    public void createEmailSugestions(){
        String subnomes[] = getNome().split(" ");
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
        
        email_sugestions = sugestoes;
    }
    
    /** Sets which option was choosen by the user to be his new uffmail
     * @param s* the new choosen uffmail
     **/
    public void setChoosenEmail(String s){
        this.choosen = s;
    }
    
    /** Passes to Parser to search in the csv file if the email is avaliable
     * @return true if email is avaliable and updates it*
     **/
    public boolean isEmailAvaliable(){
        if (parser.isEmailAviable(choosen)){
            setUffMail();
            updateUffMail();
            return true;
        }
        else return false;
    }    
    
    /*** Passes to Parser to update the uffmail to the new one***/
    public void updateUffMail(){
        //parser.editCsv(info_aluno);
        //Aqui se meche no parse dnv para colocar no csv o email criado
    }
        
    
}
