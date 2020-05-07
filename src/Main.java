import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
       LinkedList<Integer>link = new LinkedList<>();
       link.push(1);
       link.push(2);
       link.push(3);
       link.removeLast();
        Iterator<Integer> it = link.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
