package com.demo;

import java.util.LinkedHashMap;
import java.util.Map;

public class RankAssignment {
    public static void main(String[] args) {
        RankSolution sol = new RankSolution();
        int[] ar = {330, 723, 730, 825};
        String[] s = sol.solution(ar);
        System.out.println(s);
    }

}

class RankSolution {
    String[] solution(int[] scores) {
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("Poor", 0);
        map.put("Fair", 0);
        map.put("Good", 0);
        map.put("Excellent", 0);
        map.put("Elite", 0);
        for(int score: scores) {
            if(300 <=score && score<=599) {
                map.put("Poor", map.get("Poor") +1);
            } else if(600 <=score && score <= 699){
                map.put("Fair", map.get("Fair") +1);
            }else if(700 <=score && score <= 749){
                map.put("Good", map.get("Good") +1);
            }else if(750 <=score && score <= 799){
                map.put("Excellent", map.get("Excellent") +1);
            }else if(score>=800){
                map.put("Elite", map.get("Elite") +1);
            }
        }

        return map.entrySet().stream()
                .filter(e ->e.getValue() != 0)
                .sorted((a,b) -> b.getValue().compareTo(a.getValue()))
                .map( e -> e.getKey().concat(" - ").concat(e.getValue().toString()))
                .toArray(String[]::new);
    }
}
