import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        br.close();
    }

    //문자열 분리
    public static void splitString() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        String[] str = br.readLine().split(" ");

        for (String s: str) System.out.println((Integer.parseInt(s)));
    }
}