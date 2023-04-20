import java.util.Scanner;

class CardConv {
    static int cardConv(int x, int r, char[] d) {
        int digits = 0;
        String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        // r로 나눈 나머지를 저장
        do {
            d[digits++] = dchar.charAt(x % r);
            x /= r;
        } while (x != 0);

        // 배열 d를 역순으로 정렬
        for (int i = 0; i < digits/2; i++) {
            char t = d[i];
            d[i] = d[digits - i - 1];
            d[digits - i -1] = t;
        }

        return digits;
    }

    static void answerCardConv() {
        Scanner stdIn = new Scanner(System.in);

        // 변환할 숫자 입력받기
        int no;
        System.out.print("Target Num: ");
        no = stdIn.nextInt();

        // 변환할 진수값 입력받기
        int cd;
        System.out.print("Notation Num: ");
        cd = stdIn.nextInt();

        // 변환 결과
        int dno;                                    // 변환 후 자릿수
        char[] cno = new char[32];                  // 변환 결과
        dno = cardConv(no, cd, cno);

        System.out.println("Return: ");

        for (int i = 0; i < dno; i++) System.out.print(cno[i]);
    }
}