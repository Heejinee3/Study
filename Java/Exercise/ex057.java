import java.util.Arrays;
import java.util.Collections;

public class ex057 {
    public static void main(String[] args) {

        String[] names = {"장미", "수선화", "들국화"};

        // 1. for
        for (int i = 0; i<names.length; i++){
            System.out.println(names[i]);
        }

        // 2. 향상된 for
        for (String name : names){
            System.out.println(name);
        }

        // 오름차순
        Arrays.sort(names);
        for (String name : names){
            System.out.println(name);
        }

        // 내림차순
        Arrays.sort(names, Collections.reverseOrder());
        for (String name : names){
            System.out.println(name);
        }

    }
}
