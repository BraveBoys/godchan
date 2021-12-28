package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;

public class CSV_File {
	public static void main(String[] args) {
		BufferedReader br = null;
		String line;
		String extend = ".CSV";
		
		File csv = new File("C:/Users/J5409/Desktop/2021-1 프로젝트/CSV");
		File files[] = csv.listFiles();
		int fileName = files.length;
		String path = "C:/Users/J5409/Desktop/2021-1 프로젝트/CSV/" + fileName + extend;
		
		try {
			//br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));
			br = new BufferedReader(new FileReader(path)); 
			
			while((line = br.readLine()) != null) {
				String[] temp = line.split(","); 
				for(int i=0; i<temp.length; i++) {
					System.out.print(temp[i]);
					if(i!=temp.length-1) System.out.print(", ");
					else System.out.println();
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
