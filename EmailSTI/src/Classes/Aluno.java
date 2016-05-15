/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Ramayan
 */
public class Aluno {
    
    private final String nome;
    private final String matricula;
    private String telefone;
    private String email;    
    private String uffmail;
    private String status;    
    private String[] email_sugestions;    
    private String choosen_uffmail;
    
    public Aluno(String[] info){
        this.nome = info[0];
        this.matricula = info[1];
        this.telefone = info[2];
        this.email = info[3];
        this.uffmail = info[4];
        this.status = info[5];       
        
    }
    
    
    public String getNome(){return this.nome;}
    public String getMatricula(){return this.matricula;}
    public String getTel(){return this.telefone;}
    public String getEmail(){return this.email;}
    public String getUffMail(){return this.uffmail;}
    public String getStatus(){return this.status;}    
    public void setUffMail(String choosen){this.uffmail=choosen;}    
    public String[] getEmailSugestions(){return email_sugestions;}
    public void setEmailSug(String[] emails){this.email_sugestions =emails;}
    /** Sets which option was choosen by the user to be his new uffmail
     * @param s* the new choosen uffmail
     **/
    public void setChoosenEmail(String s){this.choosen_uffmail = s;}
    public String getChoosenUffMail(){return this.choosen_uffmail;}
    public String[] getInfo(){
        String[] info = new String[6];
        info[0]= this.nome;
        info[1]= this.matricula;
        info[2]= this.telefone;
        info[3]= this.email;
        info[4]= this.uffmail;
        info[5]= this.status;  
        return info;
    }
    
}
