package javaexamples;

import java.util.ArrayList;
import java.util.List;

public class DataExamples {

    public static void main(String[] args) {
        List<String> ab = list("a", "b");
        List<String> cd = list("c", "d");
        List<String> abcd = concat(ab, cd);
        System.out.println("ab = " + ab + "\n" +
                           "cd = " + cd + "\n" +
                           "abcd = " + abcd);
    }
    
    // bad
    public static <T> List<T> concat(List<T> a, List<T> b) {
        a.addAll(b);
        return a;
    }

    public static <T> List<T> list(T... ts) {
        List<T> result = new ArrayList<T>();
        for (T t : ts) {
            result.add(t);
        }
        return result;
    }
}
