public class JumpSearch {
    public static void main(String[] args) {

        int[] numbers = {1, 3, 4, 6, 8, 9, 10, 21, 31, 24, 53, 56, 74};
        int element = 56;
        int index = jumpSearch(numbers, element);

        if (index > -1)
            System.out.println("Element Found At: " + (index + 1) + " Position!");
        else
            System.out.println("Element Not Found!");
        
    }

    private static int jumpSearch(int[] numbers, int element) {

        int n = numbers.length;
        int squareRoot = (int) Math.sqrt(n);
        int step = squareRoot;
        int previous = 0;

        while (numbers[Math.min(step, n)] < element) {
            previous = step;
            step += squareRoot;

            if (previous > n)
                return -1;
        }

        while (numbers[previous] < element) {
            previous++;

            if (previous == Math.min(step, n))
                return -1;
        }

        if (numbers[previous] == element)
            return previous;

        return -1;
    }
}
