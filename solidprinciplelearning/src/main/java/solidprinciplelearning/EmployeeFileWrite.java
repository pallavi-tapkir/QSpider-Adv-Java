package solidprinciplelearning;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class EmployeeFileWrite extends EmployeeWriter {
	@Override
	public void write(String employee) {
		try {	
			Path path = Paths.get(getPath());
			Files.write(path, employee.toString().getBytes());
	
	        System.out.println("Saved employee " + employee.toString());
	    } catch (IOException e){
	        System.out.println("ERROR: Could not save employee. " + e);
	    }
	}
	
}
