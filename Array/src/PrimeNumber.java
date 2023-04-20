public class PrimeNumber {
    // 1000 이하의 소수를 나열(ver.1)
    static public void PrimeNumber1() {
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
    static  public  void  PrimeNumber2() {
        int counter = 0;
        int ptr = 0;
        int[] prime = new int[500];

        prime[ptr++] = 2;

        for (int n = 3; n <= 1000; n += 2) {
            int i;

            for (i = 1; i < ptr; i++) {
                counter++;
                if (n % prime[i] == 0) {
                    break;
                }
            }

            if (ptr == i) prime[ptr++] = n;
        }

        for (int i = 0; i < ptr; i++) {
            System.out.println(prime[i]);
        }

        System.out.print("Tried number: " + counter);
    }

    // 1000 이하의 소수를 나열(ver.3)
    static void PrimeNumber3() {
        int counter = 0;
        int ptr = 0;
        int[] prime = new int[500];

        prime[ptr++] = 2;
        prime[ptr++] = 3;

        for (int n = 5; n <= 1000; n += 2) {
            boolean flag = false;

            for (int i = 1; prime[i]*prime[i] <= n; i++) {
                counter += 2;

                if (n % prime[i] == 0) {
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                prime[ptr++] = n;
                counter++;
            }
        }

        for (int i = 0; i < ptr; i++) {
            System.out.println(prime[i]);
        }

        System.out.print("Tried number: " + counter);
    }
}
