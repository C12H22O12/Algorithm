import java.util.Scanner;

/*
 * 선형 검색 / 순차 검색
 *
 * 요소가 직선 모양으로 늘어선 배열에서
 * 원하는 키값을 갖는 요소를 만날 때까지 맨 앞부터 순서대로 요소를 검색
 *
 *  - 종료 조건 1 : 종료 검색할 값을 발견하지 못하고 배열의 끝을 지나간 경우 => 검색 실패
 *  - 종료 조건 2 : 종료 검색할 값과 같은 요소를 발견할 경우 => 검색 성공
 *
 * 요솟수가 n개일 때 종료 조건 둘 모두를 판단하는 횟수는 평균 n/2회
 * 요소를 순서대로 검색 -> 요소가 정렬되지 않은 배열에서 검색할 때 사용하는 유일한 방법
 *
 * 시간 복잡도 : 실행에 필요한 시간을 평가
 * 공간 복잡도 : 기억 영역과 파일 공간이 얼마나 필요한가를 평가
 *
 * 시간 복잡도 O(n)
 * */

public class LinearSearch {

    /*
    * 무한 루프 구조
    *
    * do문은 끝까지 읽지 않으면 무한 루프인지 아닌지 알 수 없기 때문에
    * do 문으로 무한 루프를 구현하는 것은 권장하지 않음
    * */
    public static int linearSearch1(int[] arr, int key) {
        int i = 0;

        while (true) {
            if (i == arr.length) return -1;
            if (arr[i] == key) return i;

            i++;
        }
    }

    /*
     * for 구조
     *
     * for을 이용하면서 무한 루프를 방지할 수 있음
     * */
    public static int linearSearch2(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == key) return i;

        return -1;
    }
    public static void executeLinearSearch() {
        Scanner sc = new Scanner(System.in);

        // 검색할 배열 총 크기 설정
        int num = sc.nextInt();
        int[] x = new int[num];

        for (int i = 0; i < num; i++) {
            x[i] = sc.nextInt();
        }

        //검색할 값
        int key = sc.nextInt();
        //key가 x 안에서 위치한 idx 값
        int idx = linearSearch1(x, key);
        int idx2 = linearSearch2(x, key);

        if (idx == -1) {
            System.out.println("key is not in x");
        } else {
            System.out.println(idx);
        }
    }

    /*
    * 보초법 이용
    *
    * key와 값이 같은 보초를 배열의 맨 끝에 둠으로써
    * 종료 조건을 하나 줄이고, 종료 판단 횟수를 절반으로 줄일 수 있음
    * */
    public static int linearSearch3(int[] arr, int key) {
        int i = 0;

        arr[arr.length] = key;

        while (true) {
            if (arr[i] == key) return i;

            i++;
        }
    }

    public static void executeLinearSearch2() {
        Scanner sc = new Scanner(System.in);

        // 검색할 배열 총 크기 설정
        int num = sc.nextInt();
        // 맨 마지막에 보초값을 넣어야 하기 때문에 num+1
        int[] x = new int[num+1];

        for (int i = 0; i < num; i++) {
            x[i] = sc.nextInt();
        }

        //검색할 값
        int key = sc.nextInt();
        //key가 x 안에서 위치한 idx 값
        int idx = linearSearch3(x, key);

        if (idx == -1) {
            System.out.println("key is not in x");
        } else {
            System.out.println(idx);
        }
    }
}
