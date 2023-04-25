/*
* 스택: 일시적으로 데이터를 쌓아두는 자료구조
*
* 후입선출(LIFO: Last In First Out) -> 가장 나중에 넣은 데이터를 먼저 꺼냄
* push : 스택에 데이터를 넣는 작업
* pop : 스택에 데이터를 꺼내는 작업
* top : 푸시와 팝이 이루어지는 쪽
* bottom : 스택의 가장 아랫부분
* */

public class Stack {
    private int[] stk;      // 스택용 배열
    private int capacity;   // 스택 용량
    private int ptr;        // 스택 포인터

    // 실행 시 예외 : 스택이 비어있음
    public class EmptyIntStackException extends RuntimeException {
        public EmptyIntStackException() {}
    }

    // 실행 시 예외 : 스택이 가득 참
    public class OverflowIntStackException extends RuntimeException {
        public OverflowIntStackException() {}
    }

    public Stack(int max) {
        ptr = 0;
        capacity = max;
        try {
            stk = new int[capacity];
        } catch (OutOfMemoryError e) {
            capacity = 0;
        }
    }

    // push
    public int push(int x) throws OverflowIntStackException {
        if (ptr >= capacity) throw new OverflowIntStackException();

        return stk[ptr++] = x;
    }

    // pop
    public int pop() throws EmptyIntStackException {
        if (ptr <= 0) throw new EmptyIntStackException();

        return stk[--ptr];
    }

    // peek
    public int peek() throws EmptyIntStackException {
        if (ptr <= 0) throw new EmptyIntStackException();

        return stk[ptr-1];
    }

    // clear
    /*
    * 스택에서 일어나는 작업은 스택 포인터를 바탕으로 이루어짐
    *   -> 배열 요소값을 바꿔야할 필요는 없음
    * */
    public void clear() {
        ptr = 0;
    }

    public int indexOf(int x) {
        for (int i = ptr-1; i >= 0; i--)
            if (stk[i] == x) return i;

        return -1;
    }

    public int getCapacity() {
        return capacity;
    }

    public int size() {
        return ptr;
    }

    public boolean isEmpty() {
        return ptr <= 0;
    }

    public boolean isFull() {
        return ptr >= capacity;
    }

    public void dump() {
        if (isEmpty()) System.out.println("Stack is Empty");
        else {
            for (int i = 0; i < ptr; i++) {
                System.out.println(stk[i]);
            }
        }
    }
}
