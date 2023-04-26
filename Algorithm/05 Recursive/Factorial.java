
/*
* 재귀적
*   : 어떤 사건이 자기 자신을 포함하고 있거나 또는 자기 자신을 사용하여 정의하고 있을 때
*
* 직접재귀
*   : 자신과 동일한 메서드를 호출
*
* 간접재귀
*   : 메서드 a가 메서드 b를 호출, 다시 메서드 b가 메서드 a를 호출하는 구조
*
*  재귀 알고리즘에 맞는 경우
*   : 풀어야 할 문제, 처리할 자료구조, 계산할 메서드가 재귀로 정의되는 경우
*
* */
public class Factorial {
    static int factorial(int n) {
        if (n > 0) return n*factorial(n-1);
        else return 1;
    }
}
