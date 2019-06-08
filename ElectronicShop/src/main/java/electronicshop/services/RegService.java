package electronicshop.services;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import lombok.AllArgsConstructor;
@AllArgsConstructor
public class RegService {
	public void passwriting(String password) {
	File file = new File("Pass.txt");
	try {
		FileWriter nFileWriter =  new FileWriter(file);
		BufferedWriter nBufferedWriter = new BufferedWriter(nFileWriter);
		nBufferedWriter.write(password+",");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	public void userwriter(String username) {
		File file2 = new File("User.txt");
		try {
			FileWriter nFileWriter2 =  new FileWriter(file2);
			BufferedWriter nBufferedWriter = new BufferedWriter(nFileWriter2);
			nBufferedWriter.write(username+",");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
