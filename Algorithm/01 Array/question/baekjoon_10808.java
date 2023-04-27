/*
 * Bronze 4
 * 
 * 알파벳 소문자로만 이루어진 단어 S가 주어진다. 각 알파벳이 단어에 몇 개가 포함되어 있는지 구하는 프로그램을 작성하시오.
 * 
 * link : https://www.acmicpc.net/problem/10808
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] S = bf.readLine().split("");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int[] ans = new int[26];

        int idx = 0;
        for (String str:S) {
            idx = alphabet.indexOf(str.toLowerCase());
            ans[idx] += 1;
        }

        for (int tmp:ans)
            System.out.printf(tmp+" ");

        bf.close();
    }
}