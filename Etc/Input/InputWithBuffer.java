import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        br.close();
    }

    //split 메서드를 이용하여 문자열 분리
    public static void splitString1() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        String[] str = br.readLine().split(" ");

        for (String s: str) System.out.println((Integer.parseInt(s)));
    }

    //StringTokenizer을 이용하여 문자열 분리
    public static void splitString2() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        bf.close();
    }
}