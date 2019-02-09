package pl.lukaszgrymulski.kursspring.utils;

import java.util.Set;

public class Ids {


    public static int getNewId(Set<Integer> keysSoFar) {
        if (keysSoFar.isEmpty()) {
            return 0;
        } else {
            Integer maxId = keysSoFar.stream().max((o1,o2) -> o1.compareTo(o2)).get();
            return maxId + 1;
        }
    }
}
