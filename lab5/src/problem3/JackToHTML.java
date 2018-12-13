package problem3;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class JackToHTML {
	private String readFile;
	private String writeFile;
	
	JackToHTML(){
		this.readFile = "JackBeanstalk.txt";
		this.writeFile = "JackintheBeanstalk.html";
	}
	
	public void MakeJackHTML(){
		try {
	        File file = new File(readFile);
	        Scanner input = new Scanner(file);
	        //First, add begining of the final file
	        //Use the loop to edit the file based on the contents
	        //then after add the final part
	        Write("<!doctype html>");
	        Write("<html>");
	        Write("<head>");
	        Write("<meta charset=\"utf-8\">");
	        Write("<title>My Web Page</title>");
	        Write("</head>");
	        Write("<body>");
	        
	        //needed for the h in the <h*> tags
	        int hnum = 1;
	        //Writes all of the text inside of the html file
	        try{
				while (input.hasNextLine()){
				String nextLine = input.nextLine();
				if (!nextLine.equals(nextLine.toUpperCase())){
					//add the things you want to add
					Write("<h"+ hnum +">" + nextLine + "</h"+ hnum +">");
					hnum++;
				}
				else{
					Write("<p>" + nextLine + "</p>");
				}
				}
			}finally{
				input.close();
			}
	        Write("</body>");
	        Write("</html>");
	        
	        //Finally, with all the guts of the html file in place, it can launch
	        File f2 = new File(writeFile);
	        try {
	        	Desktop.getDesktop().browse(f2.toURI());
	        }
	        catch (IOException e) {
	        	System.out.println(e.getMessage());
	        }
	}
	
	catch (FileNotFoundException e) {
		System.out.println("Error opening file. Please make sure it's in the correct spot");
		System.exit(0);

}
}
	
	
	public void Write(String text){
		//Text is what is written to the file by filewriter
		try {
				FileWriter Write = new FileWriter(writeFile, true);
				Write.write(text + "\n");
				Write.close();
				} catch (IOException e) {
					e.printStackTrace();	
				} 
	}
}

