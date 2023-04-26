public class Recur {

    /*
    * 순수 재귀 : 재귀 호출을 여러번 실행
    *
    * 하향식 분석 : 가장 위쪽에 위치한 상자의 메서드를 호출하는 것부터 시작하여 계단식으로 자세히 조사해 나가는 분석 기법
    *   1. recur(n-1)을 실행합니다.
    *   2. n을 출력합니다.
    *   3. recur(n-2)를 실행합니다.
    *
    * 상향식 분석 : 아래쪽부터 쌓아 올리며 분석하는 방법
    *   1. recur(0)을 실행합니다.
    *   2. 1을 출력합니다.
    *   3. recur(-1)을 실행합니다.
    * */
    static void recur(int n) {
        if (n > 0) {
            recur(n-1);
            System.out.println(n);
            recur(n-2);
        }
    }

    /*
    * 메서드의 꼬리에서 재귀 호출하는 메서드 recur(n-2)는 다음과 같이 정의할 수 있음
    *   = 인수로 n-2를 전달하여 recur 메서드를 호출
    *   = n값을 n-2로 업데이트하고 메서드의 시작 지점으로 돌아감
    *
    * 이를 이용하여 꼬리 재귀를 제거
    * */
    static void recurX1(int n) {
        while (n > 0) {
            recur(n-1);
            System.out.println(n);
            n = n-2;
        }
    }

    /*
    * 꼬리 재귀와는 달리 변수 n값을 출력하기 전 recur(n-1)을 먼저 수행해야하는 앞쪽 재귀 메서드는 제거하기 힘듦
    * 현재 n값을 잠시 저장, recur(n-1)의 처리가 완료된 다음 n값을 출력할 때는 저장했던 값을 꺼내 출력하는 방식으로 해결
    * */

    static void recurX2(int n) {
        Stack s = new Stack(n);

        while (true) {
            if (n > 0) {
                s.push(n);
                n -= 1;
                continue;
            }

            if (!s.isEmpty()) {
                n = s.pop();
                System.out.println(n);
                n -= 2;
                continue;
            }

            break;
        }
    }
    
    /*
    * 메모이제이션 기법을 사용하여 동일한 계산을 반복하지 않고 1회만 수행하도록 할 수 있음
    * 
    * 어떤 문제에 대한 답을 구할 경우 그것을 메모,
    * 이후 다시 그 문제가 호출 되었을 때 메모해 둔 문자열을 화면에 출력하면 중복하여 계산할 필요가 없음
    * */
    
    static String[] memo;
    static void RecurMemo(int n) {
        if (memo[n+1] != null) System.out.println((memo[n+1]));
        else {
            if (n > 0) {
                recur(n-1);
                System.out.println(n);
                recur(n-2);
                // 이전 값을 연달아서 출력해야하기 때문에 문자열의 형태로 다음과 같이 저장
                memo[n + 1] = memo[n] + n + "\n" + memo[n-1];
            } else {
                memo[n + 1] = "";
            }
        }
    }
}
