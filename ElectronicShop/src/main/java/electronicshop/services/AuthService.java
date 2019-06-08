package electronicshop.services;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import electronicshop.services.ReadingService;
import lombok.Data;

@Data
public class AuthService {
	
	
	private  String username,password;
	private BufferedReader bufferuseReader;
	private String linereader;
	private ReadingService readingService;
	private HashingService hashingService;
	private String pass;
	//public static String uname,pword;	
	public AuthService(ReadingService readingService) {
		this.readingService = readingService;
	}
	
	public AuthService(HashingService hashingService) {
		this.hashingService = hashingService;
		
	}
	public boolean auth(String uname,String pword) {
		
		setUsername(uname);
		pass = HashingService.getMd5(pword); 
		setPassword(pword);
		Set<String> usrdata = new HashSet<String>();
		usrdata.add(uname);
		ArrayList<String> passdata = new ArrayList<String>();
		passdata.add(pword);
		boolean gusrname = readingService.usrver(usrdata);
		boolean ghpass = readingService.getpassver(passdata);
		
		if(gusrname && ghpass) {
			return true;
			
		}
		else {
			return false;
		}
		
 		
		}
	

}
