package com.nerkait.utils;

import java.io.File;
import java.io.IOException;

public class  ValidateDirectory {
			
	public boolean checkPath(String pathToCheck) throws IOException {
		
		boolean dirOk=false;
		
		File f = new File(pathToCheck);
		
		if(f.isDirectory()){
			System.out.println("ValidateDirectory.checkPath.. valid directory: "+ f.getAbsolutePath());
			dirOk=true;
		}
	
		return dirOk;
		
	}

}
