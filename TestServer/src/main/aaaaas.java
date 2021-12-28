package main;

import java.io.*;
import java.util.Scanner;

public class aaaaas {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		FileWriter fout = null;
		try {
			fout = new FileWriter("C:/Users/J5409/Desktop/최단경로/aaa.txt");
			while(true) {
				String line = scan.nextLine();
				if(line.length()==0) 
					break;
				fout.write(line,0,line.length());
				fout.write("\r\n", 0, 2);
			}
			fout.close();
		}catch(IOException e) {
			System.out.println("입출력오류");
		}
		scan.close();
	}
}
