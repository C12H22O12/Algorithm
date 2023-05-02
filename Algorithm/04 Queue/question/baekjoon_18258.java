/*
 * Sliver 4
 * 
 * 정수를 저장하는 큐를 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.
 * 
 * 명령은 총 여섯 가지이다.

 *      push X: 정수 X를 큐에 넣는 연산이다.
 * 
 *      pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * 
 *      size: 큐에 들어있는 정수의 개수를 출력한다.
 * 
 *      empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
 * 
 *      front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * 
 *      back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * 
 * 
 * link : https://www.acmicpc.net/problem/18258
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] arr = new int[500];
        int front = 0, back = 0;

        while (N-- > 0) {
            String[] order = bf.readLine().split(" ");
            boolean isEmpty = ((back - front) == 0);

            switch (order[0]) {
                case "push":
                    arr[back] = Integer.parseInt(order[1]);
                    back++;
                    break;
                case "pop":
                    if (isEmpty) {
                        System.out.println(-1);
                    } else {
                        System.out.println(arr[front]);
                        front++;
                    }
                    break;
                case "size":
                    System.out.println(back - front);
                    break;
                case "empty":
                    System.out.println(isEmpty ? 1 : 0);
                    break;
                case "front":
                    System.out.println(isEmpty ? -1 : arr[front]);
                    break;
                case "back":
                    System.out.println(isEmpty ? -1 : arr[back - 1]);
                    break;
            }
        }

        bf.close();
    }
}