package array;

import java.util.*;

/**
 * Created by gbalasubramanian on 18/10/18.
 */
public class LogMessages {
    public static void main(String[] args) {
        LogMessages logMessages = new LogMessages();
        System.out.println(logMessages.shouldPrintMessage(1, "foo"));
//        System.out.println(logMessages.shouldPrintMessage(1, "foo"));
        System.out.println(logMessages.shouldPrintMessage(2, "bar"));
        System.out.println(logMessages.shouldPrintMessage(3, "foo"));
        System.out.println(logMessages.shouldPrintMessage(8, "bar"));
        System.out.println(logMessages.shouldPrintMessage(10, "foo"));
        System.out.println(logMessages.shouldPrintMessage(11, "foo"));

    }
    Hashtable<String, Integer> logger = new Hashtable<>();

    boolean shouldPrintMessage(int timeStamp, String message) {
        if (!logger.containsKey(message)){
            logger.put(message,timeStamp);
            return true;
        }
        int time = logger.get(message);
        if (timeStamp < time){
            return false;
        }
        if (timeStamp - time >= 10){
            logger.put(message, timeStamp);
            return true;
        }
        return false;
    }

    class LogMessage implements Comparable<LogMessage>{
        public LogMessage(String message, int timeStamp){
            this.message = message;
            this.timeStamp = timeStamp;
        }
        public String message;
        public int timeStamp;

        @Override
        public int compareTo(LogMessage o) {
            if (this.timeStamp > o.timeStamp )
                return 1;
            else if (this.timeStamp == o.timeStamp)
                return 0;
            else
                return -1;
        }


    }
}
