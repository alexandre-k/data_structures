package data_structures;

import data_structures.MyArray;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static double sumList(List<Integer> numbers) {
        return numbers.stream()
            .mapToDouble(Number::doubleValue)
            .sum();
    }
    public static void main (String[] args) {
        int[] anarray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        MyArray.printAllElements(anarray);
        MyArray.insertElementAtIndex(anarray, 5, 3);
        MyArray.printAllElements(anarray);
        System.out.println("Sum: " + sumList(Arrays.asList(1, 2, 3, 4, 5)));

        List<String> strings = new ArrayList();
        strings.add("hello");
        strings.add("world");
        for (String o : strings) {
            System.out.println("Element: " + o);
        }
    }
}
