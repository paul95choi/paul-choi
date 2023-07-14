package java심화4강;

public class asdfsadfsdafasdfadsf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int iNumVal = 1000000;

        String sNumVal = String.valueOf(iNumVal);
        String sNumVoice = "";

        System.out.printf("==> %s [%d자리]\n", sNumVal, sNumVal.length());

        int i, j;

        String[] units = {"영", "일", "이", "삼", "사", "오", "육", "칠", "팔", "구"};
        String[] unitX = {"", "십", "백", "천", "만", "십", "백", "천", "억", "십"};

        i = 0;
        j = sNumVal.length() - 1;

        while (true) {

            if (i >= sNumVal.length()) break;

            System.out.printf("%s[%s]", sNumVal.substring(i, i + 1), units[Integer.parseInt(sNumVal.substring(i, i + 1))]);

            if (sNumVal.substring(i, i + 1).equals("0")) {

                if (unitX[j].equals("만") || unitX[j].equals("억")) {
                    if (i != 0 && !sNumVal.substring(i - 1, i + 1).equals("00")) {
                        sNumVoice = sNumVoice + "" + unitX[j];
                    }
                } else {

                }
            } else {
                sNumVoice = sNumVoice + units[Integer.parseInt(sNumVal.substring(i, i + 1))] + unitX[j];
            }

            if (i == sNumVal.length() - 5 && !sNumVal.substring(i - 3, i + 1).equals("0000")) {
                sNumVoice += "만";
            }

            i++;
            j--;
        }
        System.out.printf("\n %s[%s]\n", sNumVal, sNumVoice);

	}

}
