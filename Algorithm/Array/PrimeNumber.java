public class PrimeNumber {
    // 1000 이하의 소수를 나열(ver.1)

    /*
    * 바깥 for문에서 n값을 2부터 시작해서 1000이 될 때까지 1씩 증가시키면서 그 값이 소수인지 판단
    * 안쪽 for문의 반복이 종료된 시점에서 변수 i값은 다음과 같음
    *   - n이 소수인 경우 : n과 같은 값 -> for문이 끝까지 실행됨
    *   - n이 합성수인 경우 : n보다 작은 값 -> for문 중단
    * */
    public static void PrimeNumber1() {
        int counter = 0;

        for (int n = 2; n <= 1000; n++) {
            int i;
            for (i = 2; i < n; i++) {
                counter++;

                if (n == i) System.out.println(n);
            }
        }

        System.out.print("Tried number: " + counter);
    }

    // 1000 이하의 소수를 나열(ver.2)

    /*
    * 소수를 구하는 과정에서 그때까지 구한 소스를 배열 prime의 요소로 저장
    * 4 이상의 짝수는 모두 2를 약수로 가지고 있기 때문에 소수가 아님, 홀수만 생성
    * 각 홀수를 돌면서, 이전에 구한 소수값으로 나누어봄
    *   - 나누어지면 소수가 아님
    *   - 반복문이 끝날 때까지 break 되지 않으면(ptr과 i값이 같으면) 소수, prime 배열에 저장
    *
    * 이 경우 ver.1보다 속도는 빠르지만 메모리 사용량이 늘어남
    * */
    public static void  PrimeNumber2() {
        int counter = 0;
        int ptr = 0;
        int[] prime = new int[500];             // 소수가 들어갈 배열을 만듦

        prime[ptr++] = 2;                       // 2는 소수

        for (int n = 3; n <= 1000; n += 2) {    // 2를 제외한 모든 소수는 홀수이기 때문에 홀수만 검사
            int i;

            for (i = 1; i < ptr; i++) {         // 이미 찾은 소수로 나누어 봄
                counter++;
                if (n % prime[i] == 0) {        // 나누어떨어질 경우 소수가 아니기 때문에 break
                    break;
                }
            }

            if (ptr == i) prime[ptr++] = n;     // 마지막까지 나누어 떨어지지 않은 경우 소수이므로 배열에 저장
        }

        for (int i = 0; i < ptr; i++) {
            System.out.println(prime[i]);
        }

        System.out.print("Tried number: " + counter);
    }

    // 1000 이하의 소수를 나열(ver.3)

    /*
    * 합성수들의 약수 분포도를 보면 특정 파트를 기준으로 대칭임
    *   -> 합성수의 2제곱근까지만 소수로 나눗셈을 시도하고, 그 과정에서 한번도 나누어떨어지지 않으면 소수라고 판단해도 좋다는 뜻
    * 즉, 어떤 정수 n은 다음 조건을 만족하면 소수라고 판단할 수 있음
    *   => n의 제곱근 이하의 어떤 소수로도 나누어떨어지지 않는다
    *   => prime[i]의 제곱이 n 이하인가? 라는 조건을 추가
    *
    * n의 제곱근을 구하는 것보다 제곱을 구하는 것이 더 간단하고 빠르기 때문에 곱셈을 사용하여 제곱을 구함
    * 곱셈의 처리 비용은 나눗셈 처리비용과 동일
    * ver.1과 ver.2에서는 나눗셈 횟수를 셌지만, ver.3에서는 곱셈과 나눗셈 횟수를 합하여 counter에 저장
    * */
    public static void PrimeNumber3() {
        int counter = 0;
        int ptr = 0;
        int[] prime = new int[500];                         // 소수가 들어갈 배열을 만듦

        prime[ptr++] = 2;                                   // 소수인 2와 3을 추가
        prime[ptr++] = 3;

        for (int n = 5; n <= 1000; n += 2) {                // 5 이상 홀수만을 검사
            boolean flag = false;                           // 합성수인지 검사

            for (int i = 1; prime[i]*prime[i] <= n; i++) {  // 곱셈 : prime[i]*prime[i]
                counter += 2;                               // 곱셈과 나눗셈 수행 횟수를 구하기 위함

                if (n % prime[i] == 0) {                    // 나눗셈 : n % prime[i]
                    flag = true;                            // 나누어떨어지면 합성수
                    break;
                }
            }

            if (!flag) {                                    // 소수일 때
                prime[ptr++] = n;                           // prime 배열에 저장
                counter++;                                  // 위 반복문의 조건이 성립하지 않는 경우의 횟수 포함
            }
        }

        for (int i = 0; i < ptr; i++) {
            System.out.println(prime[i]);
        }

        System.out.print("Tried number: " + counter);
    }

    // 1000 이하의 소수를 나열(ver.4)
    /*
    * 에라토스테네스의 체 방법 활용
    * 여러 개의 소수를 구하고 싶을 때 체를 거르듯이 하는 방법
    * 2를 제외한 2의 배수인 수를 모두 거르고,
    * 3을 제외한 3의 배수인 수를 모두 거르는 식의 방법 반복
    * 구하려는 범위의 최댓값의 제곱근까지만 반복
    * */
    public boolean[] Eratosthenes(int Max) {
        boolean[] prime = new boolean[Max+1];

        prime[0] = true;                                // 0은 소수가 아님
        prime[1] = true;                                // 1은 소수가 아님

        for (int i = 2; i <= Math.sqrt(Max); i++) {     // 제곱근까지만 검사
            if (prime[i]) continue;

            for (int j = i*i; j < Max+1; j = j+i) {
                prime[i] = true;
            }
        }

        return prime;
    }
}
