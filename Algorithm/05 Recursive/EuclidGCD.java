public class EuclidGCD {
    /*
    * 유클리드 호제법 : 두 정수의 최대공약수를 재귀적으로 구하는 방법
    *
    * 최대공약수 문제는 다음과 같이 변형 가능
    *   -> 직사각형을 정사각형으로 빈틈없이 채웁니다. 이렇게 만들어지는 정사각형 가운데 가장 긴 변의 길이를 구하세요.
    *       1. 짧은 변의 길이를 한 변으로 하는 정사각형으로 채웁니다.
    *       2. 남은 작사각형에도 같은 작업을 반복합니다.
    *       3. 정사각형만으로 구성했을 때 변의 길이가 최대공약수입니다.
    * */

    static int gcd(int x, int y) {
        if (y == 0) return x;
        else return gcd(y, x % y);
    }
}
