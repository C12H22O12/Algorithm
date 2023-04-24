import java.util.Scanner;

public class BinarySearch {
    /*
     * 이진 탐색
     *
     * 전제 조건 : 데이터가 키값으로 이미 정렬되어 있어야 함
     * 선형 검색보다 빠르다는 장점
     *
     * 해당 키 값의 범위를 절반씩 줄여나가면서 검색하는 방법
     * 이진 검색을 한 단계씩 진행할 때마다 검색 범위가 거의 반으로 좁혀짐+여러 칸을 단숨에 이동
     *
     * 시간 복잡도 : 실행에 필요한 시간을 평가
     * 공간 복잡도 : 기억 영역과 파일 공간이 얼마나 필요한가를 평가
     *
     * 시간 복잡도 O(logn)
     *
     * 자바는 표준 라이브러리로 이진 탐색을 하는 메서드를 제공 -> Arrays.binarySearch
     *      -> 배열 요소의 자료형과 관계없이 검색할 수 있음
     * */

    public static int binarySearch (int[] arr, int key) {
        int pl = 0;                 // 검색 범위의 첫 인덱스
        int pr = arr.length-1;      // 검색 범위의 마지막 인덱스

        do {
            int pc = (pl+pr)/2;     // 중앙 요소 인덱스
            if (arr[pc] == key) return pc;
            else if (arr[pc] < key) pl = pc+1;
            else pr = pc-1;
        } while (pl <= pr);

        return -1;
    }
    public static void executeLinearSearch() {
        Scanner sc = new Scanner(System.in);

        // 검색할 배열 총 크기 설정
        int num = sc.nextInt();
        int[] x = new int[num];

        // 순차적인 값을 배열에 입력
        for (int i = 1; i < num; i++) {
            do {
                x[i] = sc.nextInt();
            } while (x[i] < x[i-1]);
        }

        //검색할 값
        int key = sc.nextInt();
        //key가 x 안에서 위치한 idx 값
        int idx = binarySearch(x, key);

        if (idx == -1) {
            System.out.println("key is not in x");
        } else {
            System.out.println(idx);
        }
    }
}
