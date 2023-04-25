/*
 * 큐: 일시적으로 데이터를 쌓아두는 자료구조
 *
 * 선입선출(FIFO: First In First Out) -> 가장 먼저 넣은 데이터를 먼저 꺼냄
 * enqueue : 큐에 데이터를 넣는 작업
 * dequeue : 큐에 데이터를 꺼내는 작업
 * front : 데이터가 나오는 쪽
 * rear : 데이터를 넣는 쪽
 * */

 public class QueueBuffer {
    private int[] que;
    private int capacity;
    private int front;
    private int rear;
    private int num;            // 현재 데이터 개수

    // 실행 시 예외 : 큐가 비어있음
    public class EmptyIntQueueException extends RuntimeException {
        public EmptyIntQueueException() {}
    }

    // 실행 시 예외 : 큐가 가득 참
    public class OverflowIntQueueException extends RuntimeException {
        public OverflowIntQueueException() {}
    }

    public QueueBuffer(int maxlen) {
        num = front = rear = 0;
        capacity = maxlen;

        try {
            que = new int[capacity];
        } catch (OutOfMemoryError e) {
            capacity = 0;
        }
    }

    public int enqueue(int x) throws OverflowIntQueueException {
        if (num >= capacity) throw new OverflowIntQueueException();

        que[rear++] = x;
        num++;

        if (rear == capacity) rear = 0;

        return x;
    }

    public int dequeue() throws EmptyIntQueueException {
        if (num <= 0) throw new EmptyIntQueueException();

        int x = que[front++];
        num--;

        if (front == capacity) front = 0;

        return x;
    }

    public int peek() throws EmptyIntQueueException {
        if (num <= 0) throw new EmptyIntQueueException();

        return que[front];
    }

    public void clear() {
        num = front = rear = 0;
    }

    public int indexOf(int x) {
        for (int i = 0; i < num; i++) {
            int idx = (i+front) % capacity;
            if (que[idx] == x) return idx;
        }

        return -1;
    }

    public int getCapacity() {
        return  capacity;
    }

    public int size() {
        return num;
    }

    public boolean isEmpty() {
        return num <= 0;
    }

    public boolean isFull() {
        return num >= capacity;
    }

    public void dump() {
        if (num <= 0) System.out.println("Queue is Empty");
        else {
            for (int i = 0; i < num; i++)
                System.out.println(que[(i+front)%capacity]);
        }
    }
}
