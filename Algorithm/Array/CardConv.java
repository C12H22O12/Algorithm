import java.util.Scanner;

class CardConv {

    /*
    * cardConv 메서드는 정수 x를 r진수로 변환한 숫자 문자를 char형 배열 d에 넣어두고 그 자릿수(배열에 넣어 둔 문자수)를 반환
    *
    * do문에서 루프는 x가 0이 될 때까지 다음과 같은 작업 실행
    *   1. 먼저 x를 r로 나눈 나머지를 인덱스로 하는 문자를 배열 d의 요소 d[digits]에 대입하고 digits 값을 1 증가
    *   2. x를 r로 나눔
    * */
    static int cardConv(int x, int r, char[] d) {
        int digits = 0;                 //  변환한 수의 자릿수를 나타내기 위한 변수
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

    /*
    * cardConv에서 반환한 값이 대입되는 변수 dno에는 변환한 후의 자릿수가 들어있음
    * 변환한 후 각 자리의 문자는 배열 cno의 요소 cno[0], cno[1], cno[2]...cno[dno-1]에 들어있음
    * 배열 cno를 스캔하면서 변환 결과를 나타냄
    * */
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

        //결과를 순서대로 출력
        for (int i = 0; i < dno; i++) System.out.print(cno[i]);
    }
}