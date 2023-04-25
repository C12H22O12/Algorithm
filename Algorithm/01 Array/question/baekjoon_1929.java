/*
 * Sliver 3
 * 
 * M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.
 * 
 * link : https://www.acmicpc.net/problem/1929
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        StringBuilder ans = new StringBuilder();
        boolean[] prime = new boolean[N+1];

        for (int i = 2; i <= N; i++) {
            if (prime[i]) continue;

            if (i >= M) ans.append(i+"\n");

            for (int j = i+i; j <= N; j += i) {
                prime[j] = true;
            }
        }

        System.out.println(ans);

        bf.close();
    }
}