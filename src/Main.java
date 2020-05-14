import java.util.*;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        int[] a = {3,42,54,65,32,33,2,2,1};
        Queue<Integer> test = new PriorityQueue<>();
        test.add(4);
        test.add(2);

        Iterator<Integer> it = test.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}
