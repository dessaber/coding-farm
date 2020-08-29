import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Pancakes {
    public static void main(String[] args) {
        Pancakes pancakes = new Pancakes();
        System.out.println(pancakes.pancakeSort(new int[]{3,2,4,1}));
        System.out.println(pancakes.pancakeSort(new int[]{}));
        System.out.println(pancakes.pancakeSort(new int[]{8, 6, 1, 5, 4, 2, 3, 7}));
    }

    public List<Integer> pancakeSort(int[] A) {
        int doneIters = 0;
        List<Integer> list = new LinkedList<>();
        while (doneIters < A.length - 1) {
            int maxValue = A[0];
            int maxValueIndex = 0;
            for (int i = 0; i < A.length - doneIters; i++) {
                if (A[i] > maxValue) {
                    maxValue = A[i];
                    maxValueIndex = i;
                }
            }
            System.out.printf("%d %d%n", maxValueIndex, maxValue);
            if (maxValueIndex != 0) {
                Stack<Integer> stack = new Stack<>();
                for (int i = 0; i <= maxValueIndex; i++) {
                    stack.add(A[i]);
                }
                for (int i = 0; i <= maxValueIndex; i++) {
                    A[i] = stack.pop();
                }
                list.add(maxValueIndex + 1);
            }
            for (int i = 0; i < (A.length - doneIters) / 2; i++) {
                int temp = A[A.length - 1 - i - doneIters];
                A[A.length - 1 - i - doneIters] = A[i];
                A[i] = temp;
            }
            list.add(A.length - doneIters);
            System.out.println(Arrays.toString(A));

            doneIters++;
        }
        return list;
    }
}
