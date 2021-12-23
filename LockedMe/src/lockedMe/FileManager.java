package lockedMe;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

	public static List<String> listFiles(String folderDirectory) {
		File folder = new File(folderDirectory);
		
		if(!folder.isDirectory()) {
			System.out.println("Please enter a valid directory path.");
			return null;
		}
		
		if(folder.listFiles().length == 0) {
			System.out.println("No files are found.");
			return null;
		}
		
		List<String> results = new ArrayList<String>();
		
		for(File file : folder.listFiles()) {
			if(file.isDirectory())
				results.add("Directory: " + file.getName());
			else
				results.add("File: " + file.getName());
		}
		
		return results;
	}
	
	public static void addFile(String folderDirectory, String fileName) throws IOException {
		fileName = fileName.endsWith(".txt") ? fileName : fileName + ".txt";
		
		File folder = new File(folderDirectory + "\\" + fileName);
		folder.getParentFile().mkdirs(); 
		folder.createNewFile();
	}
	
	public static boolean deleteFile(String folderDirectory, String fileName) {
		File file = new File(folderDirectory + "\\" +  fileName);
		return file.delete();
	}
	
	public static boolean searchFile(String folderDirectory, String fileName) {
		File file = new File(folderDirectory + "\\" +  fileName);
		return file.exists();
	}
}
