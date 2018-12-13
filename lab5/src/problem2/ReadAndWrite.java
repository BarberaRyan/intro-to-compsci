package problem2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;
import java.io.File;

public abstract class ReadAndWrite {
	private String readFile;
	private String writeFile;
	
	ReadAndWrite(String readFile, String writeFile){
		this.readFile = readFile;
		this.writeFile = writeFile;
	}
	
	public abstract void Readfile(Scanner file);
	public abstract String WriteString();
	
	public void OpenForReading(){
		try {
	        File file = new File(readFile);
	        Scanner input = new Scanner(file);
	        
	        //Takes scanned in file then reads it in the readfile method
	        Readfile(input);
	        
	        input.close();
		} 
			
		catch (FileNotFoundException e) {
			System.out.println("Error opening file. Please make sure it's in the correct spot");
			System.exit(0);
}
		
		//Now write OpenForWriting
	}
	public void OpenForWriting(){
		File fileName = new File(writeFile);
		//Text is what is written to the file by printStream
		
		if (!fileName.exists()){
			try {
				fileName.createNewFile();
				PrintStream FileStream = new PrintStream(fileName);
				String text = WriteString();
				FileStream.append(text);
				FileStream.close();
				} catch (IOException e) {
					e.printStackTrace();	
				} 
				}
		}	
		
}
