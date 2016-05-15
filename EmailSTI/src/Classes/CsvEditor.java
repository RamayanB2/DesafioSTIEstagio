
package Classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Module that controls the operations on the Csv file
 * @author Ramayan
 */
public class CsvEditor {
    
    private final String filePath;
    private int line_number;
    
    public CsvEditor(String filePath){
        this.filePath = filePath;
    }
    
    /***Prints the information about all students in the csv file***/
    public void print() {
            BufferedReader br = null;
            String line;
            String cvsSplitBy = ",";

            try {

                    br = new BufferedReader(new FileReader(filePath));
                    br.readLine();
                    while ((line = br.readLine()) != null) {

                            String[] row_info = line.split(cvsSplitBy);

                            System.out.println("Nome: " + row_info[0] 
                                     + " , Matrícula: " + row_info[1] 
                                     + " , Telefone: "+ row_info[2]
                                     + " , Email: "+ row_info[3]
                                    + " , UffMail: "+ row_info[4]
                                    +", Status: "+ row_info[5]);

                    }

            } catch (FileNotFoundException e) {
                    e.printStackTrace();
            } catch (IOException e) {
                    e.printStackTrace();
            } finally {
                    if (br != null) {
                            try {
                                    br.close();
                            } catch (IOException e) {
                                    e.printStackTrace();
                            }
                    }
            }

        }

    /**
     * @param matricula* student's data id
     * @return an array with all the data about an student
     ***/
    public String[] getInfo(String matricula){
        RandomAccessFile raf = null;
        String line;
        String cvsSplitBy = ",";
        int line_count = 0;
        String[] info = new String[6];
        try {
                raf = new RandomAccessFile(filePath,"r");
                raf.readLine();
                while ((line = raf.readLine()) != null) {
                        line_count++;
                        String[] row_info = line.split(cvsSplitBy);
                        if(row_info[1].equalsIgnoreCase(matricula)){
                        info = row_info;
                        line_number = line_count;
                        }

                }

        } catch (FileNotFoundException e) {
                e.printStackTrace();
        } catch (IOException e) {
                e.printStackTrace();
        } finally {
                if (raf != null) {
                        try {
                                raf.close();
                        } catch (IOException e) {
                                e.printStackTrace();
                        }
                }
        }
        return info;
    }

    /**
     * @param uffmail* students email of UFF example@id.uff.br
     * @return true if uffmail is not already being used, false otherwise
     ***/    
    public boolean isEmailAviable(String uffmail){
        RandomAccessFile raf = null;
        String line;
        String cvsSplitBy = ",";
        int line_count = 0;
        try {
               raf = new RandomAccessFile(filePath,"r");
               raf.readLine();
                while ((line = raf.readLine()) != null) {                        
                        line_count++;
                        String[] row_info = line.split(cvsSplitBy);
                        if(row_info[4].equalsIgnoreCase(uffmail)){
                            raf.close();
                            return false;
                        }                        
                }

        } catch (FileNotFoundException e) {
                e.printStackTrace();
        } catch (IOException e) {
                e.printStackTrace();
        } finally {
                if (raf != null) {
                        try {
                                raf.close();
                        } catch (IOException e) {
                                e.printStackTrace();
                        }
                }
        }
        return true;
    }

    /**
     * Creates a new File equal to the first one, but replacing the students info
     * @param info_aluno* New students info to be added in new file
     **/
    public void editCsv(String[] info_aluno){
        BufferedReader br = null;
        BufferedWriter bw = null;
        
        File file = new File(filePath.replaceAll(".csv", "")+"_temp"+".csv");
        FileWriter fw;
        
        String line;
        String cvsSplitBy = ",";
        int line_count = 0;
        
        try {
            fw  = new FileWriter(file);
            br = new BufferedReader(new FileReader(filePath));
            bw = new BufferedWriter(fw);
                br.readLine(); 
                while ((line =br.readLine()) != null) {                        
                        line_count++;
                        if(line_count==line_number){
                            line = (info_aluno[0]+","+info_aluno[1]+","+info_aluno[2]+","+info_aluno[3]
                            +","+info_aluno[4]+","+info_aluno[5]);
                            System.out.println(line);
                            bw.write(line);
                        }else bw.write(line);
                        bw.write("\n");
                }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CsvEditor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
                if (br != null && bw!= null) {
                        try {
                                br.close();
                                bw.close();                                
                                new File(filePath).delete();
                                file.renameTo(new File(filePath));
                        } catch (IOException e) {
                                e.printStackTrace();
                        }
                }
        }
 }

///OBS: existe uma biblioteca CSVReader para facilitar escrita e leitura em csv , mas n usei para n "roubar" no desafio
}