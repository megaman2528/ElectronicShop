package electronicshop.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class ReadingService {
	
	public ReadingService(Set<String> set) {
		usrver(set);
	}
	private String line;
	private BufferedReader bufferedReader;
	private BufferedReader fileBR;
	private Set<String> usertxtdata;
	private Object passtxtinfo;
	private ArrayList<String> passtxtdata;

	
	public void  ReadingFile(){
	
	File file = new File("resources/User.txt");
	try {
		FileReader fileReader = new FileReader(file);
		fileBR = new BufferedReader(fileReader);
		usertxtdata = new HashSet<String>();
		
		while(( line=  fileBR.readLine() ) != null) {
			usertxtdata.add(line);
			
		}
		
	} catch (FileNotFoundException e) {
				e.printStackTrace();
	} catch (IOException e) {
				e.printStackTrace();
	}
	}
/*public Set<String>getUserTxtData(){
		return usertxtdata;
		usertxtdata.containsAll()
	}
	*/
	public boolean usrver(Set<String> set) {
		return usertxtdata.containsAll(set);
	}
	public void Readingpass() {
		File file = new File("resources/pass.txt");
		try {
			FileReader fileReader = new FileReader(file);
			passtxtdata = new ArrayList<String>(Arrays.asList(line.split("\\s*,\\s*")));		
			bufferedReader = new BufferedReader(fileReader);
			while(( line=  bufferedReader.readLine() ) != null) {
				passtxtdata.add(line);
				
			}
			System.out.println(passtxtdata);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			  
			e.printStackTrace();
	}
		
	}
	public boolean getpassver(ArrayList<String> passdatainfo) {
		return passtxtdata.containsAll(passdatainfo);
		
	}
}
