package Security;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

	public static void main(String[] args) {
        int[] lotto100 = {2, 12, 20, 31, 33, 30};
        int[] lotto101 = {1, 20, 30, 31, 34, 40};

        // 인덱스 차이 계산
        List<Integer> differences = calculateDifferences(lotto100, lotto101);

        // 기술통계 계산
        int minDifference = calculateMinDifference(differences);
        int maxDifference = calculateMaxDifference(differences);
        double averageDifference = calculateAverageDifference(differences);
        double standardDeviation = calculateStandardDeviation(differences);

        // 결과 출력
        System.out.println("인덱스 차이: " + differences);
        System.out.println("최소 차이: " + minDifference);
        System.out.println("최대 차이: " + maxDifference);
        System.out.println("평균 차이: " + averageDifference);
        System.out.println("표준 편차: " + standardDeviation);
    }

    // 인덱스 차이 계산
    private static List<Integer> calculateDifferences(int[] lotto100, int[] lotto101) {
        List<Integer> differences = new ArrayList<>();
        for (int i = 0; i < lotto100.length; i++) {
            int difference = lotto101[i] - lotto100[i];
            differences.add(difference);
        }
        return differences;
    }

    // 최소 차이 계산
    private static int calculateMinDifference(List<Integer> differences) {
        int min = differences.get(0);
        for (int i = 1; i < differences.size(); i++) {
            int difference = differences.get(i);
            if (difference < min) {
                min = difference;
            }
        }
        return min;
    }

    // 최대 차이 계산
    private static int calculateMaxDifference(List<Integer> differences) {
        int max = differences.get(0);
        for (int i = 1; i < differences.size(); i++) {
            int difference = differences.get(i);
            if (difference > max) {
                max = difference;
            }
        }
        return max;
    }

    // 평균 차이 계산
    private static double calculateAverageDifference(List<Integer> differences) {
        int sum = 0;
        for (int difference : differences) {
            sum += difference;
        }
        return (double) sum / differences.size();
    }

    // 표준 편차 계산
    private static double calculateStandardDeviation(List<Integer> differences) {
        double averageDifference = calculateAverageDifference(differences);
        double sumOfSquaredDifferences = 0;
        for (int difference : differences) {
            double squaredDifference = Math.pow(difference - averageDifference, 2);
            sumOfSquaredDifferences += squaredDifference;
        }
        double variance = sumOfSquaredDifferences / differences.size();
        return Math.sqrt(variance);
    }

}
