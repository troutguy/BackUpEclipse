package com.nerkait.utils;

import java.io.File;
import java.io.IOException;

public class CopyToTarget {

	String sourcePath = "";
	String targetPath = "";
	boolean srcFolderOnly =false;

	public CopyToTarget(String sourcePath, String targetPath, boolean srcFolderOnly) {

		this.sourcePath = sourcePath;
		this.targetPath = targetPath;
		this.srcFolderOnly=srcFolderOnly;
	}

	protected void copyFiles() {
		// check to see if a src directory

		ValidateDirectory checkIt = new ValidateDirectory();
		boolean srcOk = false;
		String srcFolderPath="";

		
		if(srcFolderOnly==true){
			srcFolderPath = sourcePath + "//src";
		}
		else{
			srcFolderPath = sourcePath;
		}
		
		
		try {
			srcOk = checkIt.checkPath(srcFolderPath);
		} catch (IOException e) {
			System.out.println("CopyToTarget.copyFiles.. exception checking dir:: " + e);
			e.printStackTrace();
		}

		//prepare new directory name

		GetTime getTime = new GetTime();
		String trailer = getTime.getTime();

		String tPath = targetPath + "//" + trailer;

		try {
			if (srcOk == true) {

				File f = new File(srcFolderPath);
				File target = new File(tPath);

				// this copies all folders, subfolders and directories recursively
				try {
					org.apache.commons.io.FileUtils.copyDirectoryToDirectory(f, target);
				} catch (Exception e) {
					System.out.println("CopyToTarget.copyFiles.. exception copying files and folders: " + e);
					e.printStackTrace();
				}

			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			System.out.println("CopyToTarget.copyFiles.. src folder NOT found, throwing exception: " + e);
			e.printStackTrace();
		}

	}

}
