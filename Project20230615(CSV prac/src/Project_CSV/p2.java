package Project_CSV;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class p2 {
   public static void main(String[] args) {
      String readFileName = "C:/Users/kopo/Desktop/국민 해외관광객 주요 목적지별 통계(202303).csv";
      String writeFileName = "C:/Users/kopo/Desktop/국민 해외관광객 주요 목적지별 통계(202303)_result2.csv";
      
      
      try {
         CSVReader csvReader = new CSVReader(new InputStreamReader(new FileInputStream(readFileName), "CP949"));
         CSVWriter csvWriter = new CSVWriter(new OutputStreamWriter(new FileOutputStream(writeFileName), "CP949"));

         String[] nextLine; // 데이터 한 줄씩 읽어서 저장하기 위한 변수
         int sum = 0;
         int avg = 0;
         boolean isEmpty = true;

         while ((nextLine = csvReader.readNext()) != null) { // 파일 끝까지 한줄씩 읽기
            if (isEmpty) {
               String[] field_name = new String[nextLine.length + 2]; // 필드 갯수 2개 추가
               for (int i = 0; i < nextLine.length; i++) {
                  field_name[i] = nextLine[i];
               }
               field_name[nextLine.length] = "PerMonthsum"; // sum 열 추가
               field_name[nextLine.length + 1] = "PerMonthavg"; // avg 열 추가
               csvWriter.writeNext(field_name); // 필드명을 파일에 씀
               isEmpty = false;
            } else {
               sum = 0;
               for (int i = 1; i < nextLine.length; i++) { // 행 합계 계산
                  int value = Integer.parseInt(nextLine[i]);
                  
                  sum += value;
               }
               avg = sum / (nextLine.length - 1); // 평균은 행 합계 / 길이-1 (필드명 빼고)

               String[] data = new String[nextLine.length + 2];
               for (int i = 0; i < nextLine.length; i++) {
                  data[i] = nextLine[i];
               }
               data[nextLine.length] = Integer.toString(sum);
               data[nextLine.length + 1] = Integer.toString(avg);
               csvWriter.writeNext(data);
            } 
         }               
         List<String[]> rows = new ArrayList<>(); // 데이터 행을 저장할 리스트
         String[] fieldNames = null; // 필드명을 저장할 변수
         int[] columnSum = null; // 각 열의 합계를 저장할 배열

         String[] nextLine1; // 데이터 한 줄씩 읽어서 저장하기 위한 변수
         boolean isEmpty1 = true;
         while ((nextLine1 = csvReader.readNext()) != null) { // 파일 끝까지 한 줄씩 읽기
             if (isEmpty1) {
                 fieldNames = new String[nextLine.length + 2]; // 필드 갯수 2개 추가
                 columnSum = new int[nextLine1.length]; // 열의 합계를 저장할 배열 초기화
                 for (int i = 0; i < nextLine1.length; i++) {
                     fieldNames[i] = nextLine1[i];
                 }
                 fieldNames[nextLine1.length] = "sum"; // sum 열 추가
                 fieldNames[nextLine1.length + 1] = "avg"; // avg 열 추가
                 isEmpty = false;
             } else {
                 for (int i = 1; i < nextLine1.length; i++) { // 각 열의 합계 계산
                     int value = Integer.parseInt(nextLine1[i]);
                     columnSum[i - 1] += value;
                 }
                 rows.add(nextLine1); // 현재 행 데이터를 리스트에 추가
             }
         }
        
         // 열별 합계와 평균 데이터를 새로운 행으로 추가
         String[] sumRow = new String[nextLine1.length + 2];
         for (int i = 0; i < nextLine1.length; i++) {
             sumRow[i] = Integer.toString(columnSum[i]);
         }
         rows.add(sumRow);

         // 필드명과 데이터 행들을 파일에 씀
         csvWriter.writeNext(fieldNames);
         csvWriter.writeAll(rows);
         

         csvReader.close();
         csvWriter.close();

         System.out.println("합계와 평균이 나온 파일이 생성");

      } catch (FileNotFoundException e) {
         e.printStackTrace();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}


