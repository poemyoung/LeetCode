import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Main implements Comparator<Integer>{
    public static void main(String[] args) {
        LinkedHashMap<Integer,String> test = new LinkedHashMap(16,0.75f,true);
        String value = "我爱陈钰琪";
        int i = 0;
        test.put(i++,i+"----"+value);
        test.put(i++,i+"----"+value);
        test.put(i++,i+"----"+value);
        test.put(i++,i+"----"+value);
        test.put(i++,i+"----"+value);
        test.put(i++,i+"----"+value);
        Set<Integer> sets = test.keySet();
        Integer[] arr = new Integer[sets.size()];
        sets.toArray(arr);
        System.out.println(sets.contains(2));
        System.out.println(Arrays.toString(arr));
        for (Integer a : arr){
            System.out.println(test.get(a));
        }
    }

    @Override
    public int compare(Integer o1, Integer o2) {
        return o1-o2;
    }
}
