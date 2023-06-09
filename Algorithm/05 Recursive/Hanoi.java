public class Hanoi {
    static void hanoi(int no, int x, int y) {
        /*
        * no : 옮길 원반 / x : 현재 위치한 기둥 / y : 이동할 기둥
        * 기둥 번호의 합이 6이기 때문에 6에서 값을 빼는 것으로 함
        *
        * 1. 바닥의 원반을 제외한 그룹(원반[1]~원반[no-1])을 시작 기둥에서 중간 기둥으로 옮김
        * 2. 바닥의 원반 no를 시작 기둥에서 목표 기둥으로 옮겼음을 출력
        * 3. 바닥의 원반을 제외한 그룹(원반[1]~원반[no-1])을 중간 기둥에서 목표 기둥으로 옮김
        * 
        * EX)
        *   hanoi(3, 1, 3)                   (1, 2, 3)을 첫 번째 기둥에서 세 번째 기둥으로
        *       ㄴ hanoi(2, 1, 2)            (1, 2)을 첫 번째 기둥에서 두 번째 기둥으로
        *           ㄴ hanoi(1, 1, 3)        (1)을 첫 번째 기둥에서 세 번째 기둥으로
        *                                    (2)를 첫 번째 기둥에서 세 번째 기둥으로
        *           ㄴ hanoi(1, 3, 2)        (1)을 세 번째 기둥에서 두 번째 기둥으로
        *                                    (3)을 첫 번째 기둥에서 세 번째 기둥으로
        *       ㄴ hanoi(2, 2, 3)            (1, 2)을 두 번째 기둥에서 세 번째 기둥으로
        *           ㄴ hanoi(1, 2, 1)        (1)을 두 번째 기둥에서 첫 번째 기둥으로
        *                                    (2)를 두 번째 기둥에서 세 번째 기둥으로
        *          ㄴ hanoi(1, 1, 3)         (1)을 첫 번째 기둥에서 세 번째 기둥으로
        *  */
        if (no > 1) hanoi(no-1, x, 6-x-y);

        System.out.printf("disc[%d] : %d to %d\n", no, x, y);

        if (no > 1) hanoi(no-1, 6-x-y, y);
    }
}
