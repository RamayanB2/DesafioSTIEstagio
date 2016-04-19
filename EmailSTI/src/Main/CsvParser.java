
package Main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Ramayan
 */
public class CsvParser {
    
    private final String filePath;
    
    public CsvParser(String filePath){
        this.filePath = filePath;
    }

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
    
    public String[] getInfo(String matricula){
        BufferedReader br = null;
	String line;
	String cvsSplitBy = ",";
        String[] info = new String[6];
	try {

		br = new BufferedReader(new FileReader(filePath));
                br.readLine();
		while ((line = br.readLine()) != null) {

			String[] row_info = line.split(cvsSplitBy);
                        if(row_info[1].equalsIgnoreCase(matricula))
			info = row_info;

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
        return info;
    }
    
    public boolean isEmailAviable(String email){
        BufferedReader br = null;
	String line;
	String cvsSplitBy = ",";
        String[] info = new String[6];
	try {

		br = new BufferedReader(new FileReader(filePath));
                br.readLine();
		while ((line = br.readLine()) != null) {

			String[] row_info = line.split(cvsSplitBy);
                        if(row_info[4].equalsIgnoreCase(email))
			return false;

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
        return true;
    }
    

}