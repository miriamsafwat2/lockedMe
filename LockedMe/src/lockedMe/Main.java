package lockedMe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
	final static String LIST_ALL_FILES = "1";
	final static String ADD_NEW_FILE = "2";
	final static String DELETE_FILE = "3";
	final static String SEARCH_FOR_FILE = "4";
	final static String EXIT = "5";
	
	static BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));
	static String directory;
	static String fileName;
	
	public static void main(String[] args) throws IOException {
		
		System.out.println("***** Welcome to LOCKEDMe Application *****");
		System.out.println("***** Developed by: Miriam Safwat     *****");
		
		boolean isAnotherOperation = true;
		while(isAnotherOperation) {
			displayOptions();
			String answer = "";
			while(!answer.toLowerCase().equals("yes") && !answer.toLowerCase().equals("no")) {
				System.out.println("Do you want to perform another operation? (yes/no)");
				answer = reader.readLine();
			}
			if(answer.toLowerCase().equals("no"))
				break;
		}
	}

	private static void displayOptions() throws IOException {
		System.out.println("***** Choose an option: *****");
		System.out.println(LIST_ALL_FILES + ". List all files");
		System.out.println(ADD_NEW_FILE + ". Add a new file");
		System.out.println(DELETE_FILE + ". Delete a file");
		System.out.println(SEARCH_FOR_FILE + ". Search for a file");
		System.out.println(EXIT + ". Exit");
		
		String choice = reader.readLine();
		switch(choice) {
		case LIST_ALL_FILES:{
			getDirectory();
			list(directory);
			break;
		}
		case ADD_NEW_FILE:{
			getDirectory();			
			getFileName();
			FileManager.addFile(directory, fileName);
			break;
		}
		case DELETE_FILE:{
			getDirectory();			
			getFileName();
			FileManager.deleteFile(directory, fileName);
			break;
		}
		case SEARCH_FOR_FILE:{
			getDirectory();			
			getFileName();
			boolean isFound = FileManager.searchFile(directory, fileName);
			String status = isFound ? "File is found" : "File is not found";
			System.out.println(status);
			break;
		}
		case EXIT:{
			System.exit(0);
		}
		
		default:{
			System.out.println("Please enter a valid number.");
			displayOptions();
		}
		}
	}

	private static void getDirectory() throws IOException {
		System.out.println("Enter directory path:");
		directory  = reader.readLine();
	}

	private static void getFileName() throws IOException {
		System.out.println("Enter file name:");
		fileName  = reader.readLine();
	}
	
	private static void list(String directory) {
		List<String> files = FileManager.listFiles(directory);
		if(files == null)
			return;
		
		for(String file : files) {
			System.out.println(file);
		}
	}

}
