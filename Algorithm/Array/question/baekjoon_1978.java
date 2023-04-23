/*
 * Bronze 2
 * 
 * 주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.
 * 
 * link : https://www.acmicpc.net/problem/1978
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        bf.readLine();
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        int ans = 0;

        while (st.hasMoreTokens()) {
            boolean isPrime = true;

            int num = Integer.parseInt((st.nextToken()));

            if (num == 1) continue;

            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }

            if(isPrime) {
                ans++;
            }
        }

        System.out.println(ans);

        bf.close();
    }
}