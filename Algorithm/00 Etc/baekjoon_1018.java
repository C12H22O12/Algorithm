/*
 * Silver 4
 * 
 * 지민이는 자신의 저택에서 MN개의 단위 정사각형으로 나누어져 있는 M×N 크기의 보드를 찾았다. 어떤 정사각형은 검은색으로 칠해져 있고, 나머지는 흰색으로 칠해져 있다. 지민이는 이 보드를 잘라서 8×8 크기의 체스판으로 만들려고 한다.
 * 
 * 체스판은 검은색과 흰색이 번갈아서 칠해져 있어야 한다. 구체적으로, 각 칸이 검은색과 흰색 중 하나로 색칠되어 있고, 변을 공유하는 두 개의 사각형은 다른 색으로 칠해져 있어야 한다. 따라서 이 정의를 따르면 체스판을 색칠하는 경우는 두 가지뿐이다. 하나는 맨 왼쪽 위 칸이 흰색인 경우, 하나는 검은색인 경우이다.
 * 
 * 보드가 체스판처럼 칠해져 있다는 보장이 없어서, 지민이는 8×8 크기의 체스판으로 잘라낸 후에 몇 개의 정사각형을 다시 칠해야겠다고 생각했다. 당연히 8*8 크기는 아무데서나 골라도 된다. 지민이가 다시 칠해야 하는 정사각형의 최소 개수를 구하는 프로그램을 작성하시오.
 * 
 * link : https://www.acmicpc.net/problem/1018
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int MAX = 8;              // 최대 체스판 크기
    public static int min = 64;             // 8x8 체스판에서 발생할 수 있는 최대 교환 횟수 64
    public static boolean[][] board;        //체스보드

    public static void main(String[] args) throws IOException {
       BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

       int N = Integer.parseInt(st.nextToken());
       int M = Integer.parseInt(st.nextToken());

       board = new boolean[N][M];

       // 입력 받은 배열을 board에 집어넣되, W일 때 true, B일 때 false로 집어넣음
       for (int i = 0; i< N; i++) {
           char[] tmp = bf.readLine().toCharArray();

           for (int j = 0; j< M; j++) {
               board[i][j] = (tmp[j] == 'W') ? true:false;
           }
       }

       // 해당 체스판에서 나타날 수 있는 8x8의 경우 탐색
       int n = N - (MAX - 1);
       int m = M - (MAX - 1);

       for (int i = 0; i < n; i++) {
           for (int j = 0; j < m; j++) {
               // 시작점 put
               checkColor(i, j);
           }
       }

        System.out.println(min);

        bf.close();
    }

    // count하는 함수
    public static void checkColor(int i, int j) {
        // 들어온 시작점을 기준으로 끝부분 설정
        int endX = i+MAX, endY = j+MAX;
        int cnt = 0;

        // 시작 부분을 기준으로 잡는다
        boolean TF = board[i][j];

        for (int x = i; x < endX; x++) {
            for (int y = j; y < endY; y++) {
                if (board[x][y] != TF) {
                    cnt++;
                }
                
                TF = (!TF);
            }

            TF = !TF;
        }

        cnt = Math.min(cnt, 64-cnt);

        min = Math.min(min, cnt);
    }

}