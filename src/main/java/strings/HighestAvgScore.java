package strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HighestAvgScore {
    public static void main(String[] args) {
        String scores[][] = {{"jerry","65"}, {"bob","1"}, {"jerry","23"},{"jerry","23"}, {"jerry","100"},{"Eric","83"}};
        Map<String, ArrayList<Integer>> scoreMap = new HashMap<>();
        float highestAvgScore = 0;
        String student = "";
        for(int i =0;i<scores.length;i++) {
            float currentAvgScore = 0;
            String[] sm = scores[i];
            if(!scoreMap.containsKey(sm[0])){
                ArrayList<Integer> marks = new ArrayList<>();
                marks.add(Integer.parseInt(sm[1]));
                marks.add(Integer.parseInt(sm[1]));
                scoreMap.put(sm[0], marks);
                currentAvgScore = (float)Integer.parseInt(sm[1]);

            } else {
                List<Integer> scList = scoreMap.get(sm[0]);
                int cuSc = Integer.parseInt(sm[1]);
                scList.add(cuSc);
                int curSum = scList.get(0) + cuSc;
                scList.set(0, curSum);
                currentAvgScore = curSum / (scList.size() - 1);

            }
            if (currentAvgScore > highestAvgScore) {
                highestAvgScore = currentAvgScore;
                student = sm[0];
            }

        }

        for (Map.Entry<String,ArrayList<Integer>> entry:scoreMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        System.out.println(student + " " + highestAvgScore);
    }
}
