package OCR;
import java.util.Arrays;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class ImgClass {
	//
	private double[][] imgMatrix = ReadMatrix();
	private NumFiles num = new NumFiles();
//

	
	public double[][] ReadMatrix() {
		String filename = JOptionPane.showInputDialog("Enter The file to be read");
		File fl = new File(filename);
		double matrix[][] = new double[0][0];
		try {
			Scanner fn = new Scanner(fl);
			int row = 0;
			while (fn.hasNext()) {
				row ++;
				fn.nextLine();
			}
			fn.close();
			matrix = new double[row][];
			Scanner f2 = new Scanner(fl);
			row = 0;
			while (f2.hasNext()) {
				String line = f2.nextLine();
				System.out.println(line);
				String[] numarr = line.split(" ");
				int x = numarr.length;
				double[] arr = new double[x];
				matrix[row]= arr;
				for (int i = 0; i<numarr.length;i++){
					matrix[row][i] = Double.parseDouble(numarr[i]);
				}
				row++;
			}
			f2.close();
	    } 
		catch (FileNotFoundException e) {
	        System.out.println("Error opening file. Please make sure that you have your text file in the same folder as the ImgFiles.class");
	        System.exit(0);
	    }
		return matrix;
	}

	public int[][] cleanup() {
		double[][] test = imgMatrix;
		
		// Potential error here
		int[][] cleanMatrix = new int[test.length][test[0].length];
		
		for (int i = 0; i < test.length; i++){
			for (int j = 0; j < test[0].length; j++){
				if (test[i][j] > 0.5){
					cleanMatrix[i][j] = 1;
				}
				else{
					cleanMatrix[i][j] = 0;
				}
			}
		}
		return cleanMatrix;
	}

	public String FindBestMatch() {
		double[] score = new double[9];

		String[] str_num  = new String[] {"zero","one","two","three","four","five","six","seven","eight","nine"};
		System.out.println("Now have created string of matrix, now comparing matrixes");
		
		for (int i = 0; i < score.length; i++){
		score[i] = compareMatrices(num.getMatrix(str_num[i]));
		}
		
		int top_score = 0;;
		
		for (int i = 1; i < score.length; i++){
			if (score[i] > score[top_score]){
				top_score = i;
			}
		}
		
		System.out.println(Arrays.toString(str_num));
		System.out.println(Arrays.toString(score));
		
		return (str_num[top_score]+" is the best match");	
	}
	
	private double compareMatrices(int[][] num) {
// program is pretty easy as soon as one knows how to call the size of the array in the x or y direction
// 4 for loops, and a score that will be manipulated based on the conditions given earlier
		
//2 loops are to move the box around
//2 are to test the current box
		int[][] clean = cleanup();
		double score = 0.0;
		
		//i_in refers to inner corner of imgMatrix
		int i_in = -1;
		int j_in = -1;				
	
		//i_out and j_out is used to tell how many times you have to use the function to test every possible box
	//i_in and j_in specifies the index to use inside of the box to compare
	//i_count and j_count make sure the box changes what is being read, as well as focus the index being compared as the box itself moves
		for(int i_out = 0; i_out < clean.length - num.length; i_out++ ){
			i_in++;
			j_in = -1;
			for(int j_out = 0; j_out < clean[0].length - num[0].length ; j_out++){
				j_in++;
				int i_count = 0;
				
				while (i_count < num.length ){
					int j_count = 0;
					
					//at the lowest level the acutal comparison happens
					while (j_count < num[0].length ){

						
						
						if (clean[i_in + i_count][j_in + j_count] == 1 && num[i_count][j_count] == 1){
							score += 1.0;
						}
						else if (clean[i_in + i_count][j_in + j_count] == 0 && num[i_count][j_count] == 1){
							score -= .25;
						}
						else if (clean[i_in + i_count][j_in + j_count] == 0 && num[i_count][j_count] == 0){
							score += .25;
						}

					j_count++;
					}
					
				i_count++;
				}
			}
		}
	
		return score;
		
	}
}
	
	

