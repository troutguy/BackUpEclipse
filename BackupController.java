package com.nerkait.utils;

import java.io.IOException;

public class BackupController {

	/* How to use:
	 This app will copy all directories, sub-directories and files to a target location.
	 
	 A trailing date field is added to new directory name each time app is executed
	 
	 All params are set in .properties file
	 
	 first property is source path, escape with double slashes on Windows
	 
	 2nd property is whether or not to only copy src folder or to copy ALL files & folders
	 
	 target_path_alpha is target location; path must already exist
	 
	 final prop isn't used but could be a second directory, if desired
	 */

	public static void main(String args[]) throws IOException {

		String sourcePath = getProp(0);
		String targetPath = getProp(2);

		// check source path
		ValidateDirectory checkWorkspace = new ValidateDirectory();
		boolean isDir = checkWorkspace.checkPath(sourcePath);

		// check target path
		boolean targetOk = checkWorkspace.checkPath(targetPath);

		// verify both ok, then proceed
		boolean goodToGo = proceedOrNo(isDir, targetOk);

		// copy from source folder IN or just the path from properties file?

		String srcOnly = getProp(1);

		boolean sourceFolderOnly = convertStr(srcOnly);

		if (goodToGo == true) {

			CopyToTarget copyIt = new CopyToTarget(sourcePath, targetPath, sourceFolderOnly);

			// get location of project
			String projPath = getProp(1);
			System.out.println("BackupController.main...source & target paths are ok, proceeding: " + goodToGo);

			copyIt.copyFiles();
		} else {
			System.out.println("BackupController.main...both paths (src and target) are NOT valid, won't proceed: "	+ goodToGo);
		}

	}

	public static boolean proceedOrNo(boolean srcOk, boolean targetOk) {

		boolean goodToGo = false;

		try {
			if (srcOk && targetOk) {
				goodToGo = true;
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			System.out.println("BackupController.proceedOrNo...bad paths exception, check source & target paths: " + e);
			e.printStackTrace();
		}

		return goodToGo;

	}

	private static boolean convertStr(String useSrcStr) {

		boolean useSource = false;

		if (useSrcStr.equalsIgnoreCase("true")) {
			useSource = true;
		}

		return useSource;

	}

	public static String getProp(int propNumber) {

		String theProp = "";
		String[] theProps = new String[4];

		ReadProperties readEm = new ReadProperties();
		theProps = readEm.readPropFile();

		theProp = theProps[propNumber];

		return theProp;
	}

}
