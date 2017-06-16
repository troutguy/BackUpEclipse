package com.nerkait.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/* Class to read properties file
 * Written by Steve Garrison, 4/18/16
 */

public class ReadProperties {

	public String[] readPropFile() {

		String[] propertyValues = new String[4];
		Properties props = new Properties();

		try {
			props.load(new FileInputStream(new File("backup.properties")));
		} catch (IOException ie) {
			System.out.println("ReadProperties.readPropFile.. error reading file "+ ie);

		}
		
		try {

			Object _workspace_name = props.get("source_path");
			Object _project_name = props.get("source_folder_only");
			Object _target_path_alpha = props.get("target_path_alpha");
			Object _target_path_beta = props.get("target_path_beta");

			String wSpace = _workspace_name.toString();
			String projName = _project_name.toString();
			String targetA = _target_path_alpha.toString();
			String targetB = _target_path_beta.toString();

			propertyValues[0] = wSpace;
			propertyValues[1] = projName;
			propertyValues[2] = targetA;
			propertyValues[3] = targetB;

			// display only
			/*for (int j = 0; j < propertyValues.length; j++) {
				System.out.println("ReadProperties.readPropFile.. prop values "	+ propertyValues[j]);
			}
			*/

		} catch (Exception io) {
			System.out.println("ReadProperties.readPropFile...error reading prop file "+ io);
		}

		return propertyValues;

	}
}
