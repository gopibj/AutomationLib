package org.zapto.ajad.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.zapto.ajad.common.CommonParams;
import org.zapto.ajad.utils.PropertyLoader;

//To read a file 

/**
 * @author Ajad
 *
 */
public class FileOps extends CommonParams
	{
		/*
		 * Str Obj - Should read the file, and out put a string Get the path
		 * from param Define vars to hold data
		 * 
		 * Read the file using a buffered reader
		 * 
		 * Get data in to buffer Out put the string
		 */

		public FileOps() throws IOException
			{
				// super();
				// TODO Auto-generated constructor stub
			}

		// public StringBuilder ReadFile(String ParStrDataFilePath, String
		// ParStrDataCsv ) throws IOException{
		public StringBuilder ReadFile(String ParStrDataCsv) throws IOException
			{
				// To hold the lines read
				String StrLineReader;

				// Get the file path from property file
				// String StrDataFilePath =
				// PropertyLoader.LoadProperty(ParStrDataFilePath);
				String StrDataCsv = PropertyLoader.LoadProperty(ParStrDataCsv);

				// Get the files path as defined in the application properties
				// Path ObjPath =
				// FileSystems.getDefault().getPath(StrDataFilePath, StrDataCsv
				// );
				// Path ObjPath = Paths.get(URI.create(StrDataCsv));
				// Path OPath =
				// Paths.get("/AutomationLib/src/test/resources/datalogin.csv");

				// Path ObjPath =
				// FileSystems.getDefault().getPath("src/test/resources/datalogin.csv");
				Path ObjPath = FileSystems.getDefault().getPath(StrDataCsv);
				// Path ObjPath =
				// FileSystems.getDefault().getPath(ParStrDataCsv);

				// Get the charset

				Charset ObjCharset = Charset.forName("UTF-8");

				// Prep a string builder
				StringBuilder ObjStringBuilder = new StringBuilder();

				// Read the file
				BufferedReader ObjBufferedReader = Files.newBufferedReader(
						ObjPath, ObjCharset);
				while ((StrLineReader = ObjBufferedReader.readLine()) != null)
					{
						ObjStringBuilder.append(StrLineReader);
					}

				return ObjStringBuilder;

			}
		// TestDrive
		/*
		 * public static void main(String[] args) throws IOException{
		 * CommonParams ObjCommonParams = new CommonParams();
		 * ObjCommonParams.InitCommonParams();
		 * 
		 * FileOps ObjFileOps = new FileOps(); //StringBuilder ObjStringBuilder
		 * =ObjFileOps.ReadFile("testResource //StringBuilder ObjStringBuilder
		 * =ObjFileOps.ReadFile("src/test/resources/datalogin.csv");
		 * StringBuilder ObjStringBuilder =ObjFileOps.ReadFile("datalogin.csv");
		 * System.out.println("FileOps.ReadFile() - "+
		 * ObjStringBuilder.toString());
		 * //System.out.println(oPath.toAbsolutePath());
		 * 
		 * }
		 */

	}
