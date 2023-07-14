package Project_CSV;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;


		public class p3 {
		   public static void main(String[] args) {
		      String readFileName = "C:/Users/kopo/Desktop/국민 해외관광객 주요 목적지별 통계(202303).csv";
		      String writeFileName = "C:/Users/kopo/Desktop/국민 해외관광객 주요 목적지별 통계(202303)_2.csv";

		      try {
		         CSVReader csvReader = new CSVReader(new InputStreamReader(new FileInputStream(readFileName), "CP949"));
		         CSVWriter csvWriter = new CSVWriter(new OutputStreamWriter(new FileOutputStream(writeFileName), "CP949"));

		         List<String[]> lines = csvReader.readAll();
		         csvReader.close();

		         // 각각의 컬럼에 대해 총합과 평균 계산해서 아래에서 불러서 넣기
		         double[] sums = new double[lines.get(0).length];
		         for (int i = 1; i < lines.size(); i++) {
		            String[] row = lines.get(i);
		            for (int j = 1; j < row.length; j++) {
		               double value = Double.parseDouble(row[j]);
		               sums[j] += value;
		            }
		         }

		         int totalRows = lines.size();
		         int numColumns = lines.get(0).length;

		         // 계산해서 추가한 두 개의 행에 값을 삽입
		         String[] sumRow = new String[numColumns];
		         String[] averageRow = new String[numColumns];

		         sumRow[0] = "SUM";
		         averageRow[0] = "Average";

		         for (int j = 1; j < numColumns; j++) {
		            sumRow[j] = String.valueOf(sums[j]);
		            averageRow[j] = String.valueOf(sums[j] / (totalRows - 1));
		         }

		         lines.add(sumRow);
		         lines.add(averageRow);

		         // Write
		         csvWriter.writeAll(lines);
		         csvWriter.close();

		         System.out.println("최종 CSV 파일 작성 완료.");
		      } catch (FileNotFoundException e) {
		         e.printStackTrace();
		      } catch (Exception e) {
		         e.printStackTrace();
		      }

	}

}
