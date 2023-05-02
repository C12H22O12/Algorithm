/*
 * Bronze 5
 * 
 * 총 N개의 정수가 주어졌을 때, 정수 v가 몇 개인지 구하는 프로그램을 작성하시오.
 * 
 * link : https://www.acmicpc.net/problem/10807
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String N = bf.readLine();

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        String v = bf.readLine();
        int ans = 0;

        while (true){
            try {
                if (v.equals(st.nextToken())) {
                    ans++;
                }
            } catch (NoSuchElementException e) {
                break;
            }
        }

        System.out.println(ans);
        bf.close();
    }
}