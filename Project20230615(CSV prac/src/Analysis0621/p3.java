package Analysis0621;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

public class p3 {

	public static void main(String[] args) throws FileNotFoundException, IOException, CsvValidationException, NumberFormatException {
	      String csvFile = "C:\\Users\\kopo\\Desktop\\행복지수파일.csv";
	      String outputCsvFile = "C:\\Users\\kopo\\Desktop\\행복지수파일2.csv";

	      List<Integer> errorIndices = new ArrayList<>();
	      for (int i = 1; i < 7; i++) {
	         List<Double> xList = readCSVAndExtractColumn(csvFile, i); // 2는 freedom 열의 인덱스
	         double[] xArray = xList.stream().mapToDouble(Double::doubleValue).toArray();
	         Arrays.sort(xArray);
	         double q1 = getQuartile(xArray, 0.25);
	         double q2 = getQuartile(xArray, 0.5);
	         double q3 = getQuartile(xArray, 0.75);
	         double iqr = q3 - q1;
	         double minimum = q1 - 1.5 * iqr;
	         double maximum = q3 + 1.5 * iqr;

	         System.out.printf("\t\t\tX%d의 값\n", i);
	         System.out.println("Q1: " + q1);
	         System.out.println("Q2: " + q2);
	         System.out.println("Q3: " + q3);
	         System.out.println("IQR: " + iqr);
	         System.out.println("Minimum: " + minimum);
	         System.out.println("Maximum: " + maximum);
	         System.out.println("=======================================================================\n");
	         System.out.printf("\t\t\tX%d에서 판별\n", i);
	         List<Double> happinessList = readCSVAndExtractColumn(csvFile, i);

	         for (int j = 0; j < happinessList.size(); j++) {
	            double value = happinessList.get(j);
	            if (value < minimum || value > maximum) {
	               errorIndices.add(j + 1);
	               System.out.printf("인덱스 %d의 값 %f은(는) 최솟값과 최댓값 사이에 존재하지 않습니다.\n\n", j + 1, value);
	            } 
	         }
	         System.out.println("=======================================================================\n\n");
	      }
	      
	      if (!errorIndices.isEmpty()) {
	         Set<Integer> uniqueIndices = new HashSet<>(errorIndices);
	         List<Integer> sortedIndices = new ArrayList<>(uniqueIndices);
	         Collections.sort(sortedIndices);
	         System.out.print("해당하지 않는 값들의 인덱스: ");
	         for (int index : sortedIndices) {
	             System.out.print(index + " ");
	         }
	         System.out.println("\n");

	         deleteRows(csvFile, outputCsvFile, sortedIndices);
	      }
	   }

	   private static void deleteRows(String inputCsvFile, String outputCsvFile, List<Integer> indicesToDelete)
	         throws IOException {
	      try (BufferedReader reader = new BufferedReader(new FileReader(inputCsvFile));
	           BufferedWriter writer = new BufferedWriter(new FileWriter(outputCsvFile))) {
	         String line;
	         int rowIndex = 1;
	         while ((line = reader.readLine()) != null) {
	            if (!indicesToDelete.contains(rowIndex)) {
	               writer.write(line);
	               writer.newLine();
	            }
	            rowIndex++;
	         }
	      }
	   }

	   private static List<Double> readCSVAndExtractColumn(String csvFile, int columnIndex)
	         throws CsvValidationException, NumberFormatException {
	      List<Double> columnData = new ArrayList<>();
	      try (CSVReader reader = new CSVReaderBuilder(new FileReader(csvFile)).withSkipLines(1).build()) {
	         String[] line;
	         while ((line = reader.readNext()) != null) {
	            double value = Double.parseDouble(line[columnIndex]);
	            columnData.add(value);
	         }
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
	      return columnData;
	   }

	   private static double getQuartile(double[] arr, double quartile) {
	      double pos = quartile * (arr.length - 1);
	      if (pos < 0) {
	         return arr[0];
	      }
	      if (pos >= arr.length - 1) {
	         return arr[arr.length - 1];
	      } else {
	         double lower = arr[(int) pos];
	         double upper = arr[(int) pos + 1];
	         return lower + (pos - Math.floor(pos)) * (upper - lower);
	      }
	   }
	}