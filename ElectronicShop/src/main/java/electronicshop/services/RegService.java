package electronicshop.services;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import lombok.AllArgsConstructor;
@AllArgsConstructor
public class RegService {
	private FileWriter nFileWriter;
	private FileWriter nFileWriter2;
	private String username;
	public void passwriting(String password) {
	File file = new File("resources/Pass.txt");
	try {
		nFileWriter = new FileWriter(file);
		//BufferedWriter nBufferedWriter = new BufferedWriter(nFileWriter);
		nFileWriter.write(password+",");
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
	
	

	public void setUsername(String Username) {
		this.username = Username;
	}
	public String getUsername() {
		return username;
	}
	
	public void userwriter(String username) {
		setUsername(username);
		File file2 = new File("resources/User.txt");
		try {
			nFileWriter2 = new FileWriter(file2);
			//BufferedWriter nBufferedWriter = new BufferedWriter(nFileWriter2);
			nFileWriter2.write(getUsername()+",");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	
	}

	
}
