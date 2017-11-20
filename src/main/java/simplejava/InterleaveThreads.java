package simplejava;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by gbalasubramanian on 18/11/17.
 */
public class InterleaveThreads {

    static class ThreadId {
        int id;

        public ThreadId() {
        }

        public ThreadId(int threadId) {
            this.id = threadId;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }

    public static void main(String[] args) {
        final Lock lock = new ReentrantLock();
        final Condition condition = lock.newCondition();

        ThreadId threadId = new ThreadId();
        threadId.setId(1);
        Thread t1 = setThread(lock, condition, 1, 2, threadId);
        Thread t2 = setThread(lock, condition, 2, 3, threadId);
        Thread t3 = setThread(lock, condition, 3, 1, threadId);
        t1.start();
        t2.start();
        t3.start();
    }

    static Thread setThread(final Lock lock, final Condition condition, int actualThread, int nextThreadId, ThreadId threadId) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    lock.lock();
                    try {
                        while (threadId.getId() != actualThread) {
                            try {
                                condition.await();

                            } catch (InterruptedException ex) {
                                System.out.println(ex.getLocalizedMessage());
                            }
                        }
                        System.out.println(actualThread + "");
                        threadId.setId(nextThreadId);
                        condition.signalAll();

                    } finally {
                        lock.unlock();
                    }

                }
            }
        };
        return thread;
    }
}
