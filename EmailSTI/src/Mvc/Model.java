/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mvc;

import Main.CsvParser;

/**
 *
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
    
    public boolean isMatRegistered(String matricula){
        if(info_aluno==null)return false;
        else return true;
    }
    
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
    
    public void createEmailSugestions(){
        String subnomes[] = getNome().split(" ");
        String[] sugestoes = new String[5];
        
        sugestoes[0] = (subnomes[0]+"_"+subnomes[subnomes.length-1]).toLowerCase()+"@id.uff.br";
        
        sugestoes[1] = subnomes[0];
        for(int i=0;i<subnomes.length-1;i++){
            sugestoes[1]+=(subnomes[i].charAt(0));
        }
        sugestoes[1]= sugestoes[1].toLowerCase()+"@id.uff.br";
        
        sugestoes[2]= subnomes[0]+subnomes[subnomes.length-1]+"@id.uff.br";
        
        sugestoes[3]= subnomes[0].charAt(0)+subnomes[subnomes.length-1]+"@id.uff.br";
        
        sugestoes[4]= subnomes[0].charAt(0)+subnomes[1]+subnomes[subnomes.length-1]+"@id.uff.br";
        
        email_sugestions = sugestoes;
    }
    
    public void setChoosenEmail(String s){
        this.choosen = s;
    }
    
    public boolean isEmailAvaliable(){
        if (parser.isEmailAviable(choosen)){
            setUffMail();
            updateUffMail();
            return true;
        }
        else return false;
    }    
    
    public void updateUffMail(){
        //Aqui se meche no parse dnv para colocar no csv o email criado
    }
        
    public String[] getEmailSugestions(){
        return email_sugestions;
    }
    
}
