
import java.util.List;

public class GenericToolkit {

    public static <T extends Comparable<T>> T max(
            T first, T second, T third) {

        T largest = first;

        if (second.compareTo(largest) > 0) {
            largest = second;
        }

        if (third.compareTo(largest) > 0) {
            largest = third;
        }

        return largest;
    }

    public static void printAll(List<?> items) {
        for (Object item : items) {
            System.out.println(item);
        }
    }

    public static double sum(List<? extends Number> numbers) {
        double total = 0;

        for (Number number : numbers) {
            total += number.doubleValue();
        }

        return total;
    }

    public static void addIntegers(List<? super Integer> numbers) {
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
    }
}
