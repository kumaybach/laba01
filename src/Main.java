import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int numElements = 100000;
        int numInsertions = 1000;

        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        System.out.println("Кількість елементів у списку: " + numElements);
        System.out.println("Число введених елементів: " + numInsertions);

        measureAndPrintTime(() -> fillList(arrayList, numElements), "ArrayList", "Fill");
        measureAndPrintTime(() -> fillList(linkedList, numElements), "LinkedList", "Fill");

        measureAndPrintTime(() -> accessRandomly(arrayList), "ArrayList", "Random Access");
        measureAndPrintTime(() -> accessRandomly(linkedList), "LinkedList", "Random Access");

        measureAndPrintTime(() -> accessSequentially(arrayList), "ArrayList", "Sequential Access");
        measureAndPrintTime(() -> accessSequentially(linkedList), "LinkedList", "Sequential Access");

        measureAndPrintTime(() -> insertAtBeginning(arrayList, numInsertions), "ArrayList", "Insert at Beginning");
        measureAndPrintTime(() -> insertAtBeginning(linkedList, numInsertions), "LinkedList", "Insert at Beginning");

        measureAndPrintTime(() -> insertAtEnd(arrayList, numInsertions), "ArrayList", "Insert at End");
        measureAndPrintTime(() -> insertAtEnd(linkedList, numInsertions), "LinkedList", "Insert at End");

        measureAndPrintTime(() -> insertInMiddle(arrayList, numElements, numInsertions), "ArrayList", "Insert in Middle");
        measureAndPrintTime(() -> insertInMiddle(linkedList, numElements, numInsertions), "LinkedList", "Insert in Middle");
    }

    private static void measureAndPrintTime(Runnable operation, String listType, String operationType) {
        long startTime = System.currentTimeMillis();
        operation.run();
        long endTime = System.currentTimeMillis();
        System.out.printf("%s: %s - %d ms%n", listType, operationType, endTime - startTime);
    }

    private static void fillList(List<Integer> list, int count) {
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            list.add(random.nextInt(count));
        }
    }

    private static void accessRandomly(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            int element = list.get(i);
        }
    }

    private static void accessSequentially(List<Integer> list) {
        for (Integer element : list) {
            int value = element;
        }
    }

    private static void insertAtBeginning(List<Integer> list, int numInsertions) {
        for (int i = 0; i < numInsertions; i++) {
            list.add(0, i);
        }
    }

    private static void insertAtEnd(List<Integer> list, int numInsertions) {
        for (int i = 0; i < numInsertions; i++) {
            list.add(i);
        }
    }

    private static void insertInMiddle(List<Integer> list, int numElements, int numInsertions) {
        for (int i = 0; i < numInsertions; i++) {
            int index = numElements / 2;
            list.add(index, i);
        }
    }
}