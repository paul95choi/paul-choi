package Project_CSV;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class Project_CSV {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String readFileName= "C:/Users/kopo/Desktop/22년도 수원FC 경기관람 관중수 현황.csv";
		String writeFileName= "C:/Users/kopo/Desktop/hello.csv";
		String readfileName= "C:/Users/kopo/Desktop/국민 해외관광객 주요 목적지별 통계(202303).csv";
		CSVReader csvReader;
		try {
			csvReader = new CSVReader(new InputStreamReader(new FileInputStream(readFileName),"CP949"));
			String[] nextLine;
			while((nextLine = csvReader.readNext()) != null) {
				System.out.println(nextLine.length + " : " + String.join(" | ", nextLine));
			}
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		try {
			csvReader = new CSVReader(new InputStreamReader(new FileInputStream(readfileName),"CP949"));
			String[] nextLine;
			while((nextLine = csvReader.readNext()) != null) {
				System.out.println(nextLine.length + " : " + String.join(" | ", nextLine));
			}
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			CSVWriter cw = new CSVWriter(new FileWriter(writeFileName));
			String[] data = {"abc" , "def", "ghi"};
			cw.writeNext(data);
			cw.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
