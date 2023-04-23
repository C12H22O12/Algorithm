import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // next는 공백을 기준으로 값을 입력받음
        int a = sc.nextInt();
        int b = sc.nextInt();

        /*
        * 행을 기준으로 입력받을 시 nexLine() 사용
        * */

        System.out.println(a+b);

        sc.close();
    }

    // 여러 값을 입력받는 경우
    public static void anotherCase() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
    }

    //split 메서드를 이용하여 문자열 분리
    public static void splitString1() {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        for (String s : str) System.out.println(Integer.parseInt(s));
    }

    //StringTokenizer을 이용하여 문자열 분리
    public static void splitString2() {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        StringTokenizer st = new StringTokenizer(str);
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        sc.close();
    }
}