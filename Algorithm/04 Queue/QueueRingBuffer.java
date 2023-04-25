/*
* 링 버퍼는 '오래된 데이터를 버리는' 용도로 활용할 수도 있음
* 총 요소 수가 N인 배열에 계속해서 데이터가 입력될 때 가장 최근에 들어온 데이터 n개만 저장, 나머지는 버리는 용도로 활용
* */

import java.util.Scanner;

public class QueueRingBuffer {
    public static void QueueRingBufferMethod() {
        Scanner sc = new Scanner(System.in);

        final int N = 10;
        int[] a = new int[N];
        int cnt = 0;
        int retry;

        do {
            a[cnt++ % N] = sc.nextInt();

            System.out.println("try again? (YES : 1/NO : 0) ");
            retry = sc.nextInt();
        } while (retry == 1);

        int i = cnt - N;
        if (i < 0) i = 0;

        for (; i < cnt; i++) System.out.println(a[i % N]);
    }
}
