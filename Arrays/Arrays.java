
// Find the sum of all the elements in an array of integers
public class Arrays {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50};
        int sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }

        System.out.println("The sum of the array is: " + sum);
    }
}

// Find the average of all the elements in an array of integers
public class Arrays {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50};
        int sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }

        double average = (double) sum / numbers.length;
        System.out.println("The average of the array is: " + average);
    }
}

// Find the maximum/minimum elements in an array of integers

public class Arrays {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50};
        int max = numbers[0];
        int min = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }

        System.out.println("The maximum element in the array is: " + max);
        System.out.println("The minimum element in the array is: " + min);
    }
}

// Search for given element(Linear Search) in an array of integers
public class Arrays {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50};
        int target = 30;
        boolean found = false;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == target) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Element " + target + " is found in the array.");
        } else {
            System.out.println("Element " + target + " is not found in the array.");
        }
    }
}

// Count the occurrence specific element in an array of integers
public class Arrays {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50, 30, 30};
        int target = 30;
        int count = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == target) {
                count++;
            }
        }

        System.out.println("Element " + target + " occurs " + count + " times in the array.");
    }
}

// Replace all the occurrences of a specific element with another element in an array of integers
public class Arrays {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50, 30, 30};
        int target = 30;
        int replacement = 99;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == target) {
                numbers[i] = replacement;
            }
        }

        System.out.print("Array after replacement: ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
    }
}

// Check if an array contains a given number
public class Arrays {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50};
        int target = 25;
        boolean found = false;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == target) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Element " + target + " is found in the array.");
        } else {
            System.out.println("Element " + target + " is not found in the array.");
        }
    }
}

// Count how many elements are even and odd in an array of integers
public class Arrays {
    public static void main(String[] args) {
        int[] numbers = {10, 21, 30, 41, 50};
        int evenCount = 0;
        int oddCount = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        System.out.println("Number of even elements: " + evenCount);
        System.out.println("Number of odd elements: " + oddCount);
    }
}

// Seperate even and odd elements into two different arrays
public class Arrays {
    public static void main(String[] args) {
        int[] numbers = {10, 21, 30, 41, 50};
        int evenCount = 0;
        int oddCount = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        int[] evenNumbers = new int[evenCount];
        int[] oddNumbers = new int[oddCount];
        int evenIndex = 0;
        int oddIndex = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                evenNumbers[evenIndex++] = numbers[i];
            } else {
                oddNumbers[oddIndex++] = numbers[i];
            }
        }

        System.out.print("Even numbers: ");
        for (int i = 0; i < evenNumbers.length; i++) {
            System.out.print(evenNumbers[i] + " ");
        }
        System.out.println();

        System.out.print("Odd numbers: ");
        for (int i = 0; i < oddNumbers.length; i++) {
            System.out.print(oddNumbers[i] + " ");
        }
    }
}

// Copy elements of one array into another array
public class Arrays {
    public static void main(String[] args) {
        int[] original = {10, 20, 30, 40, 50};
        int[] copy = new int[original.length];

        for (int i = 0; i < original.length; i++) {
            copy[i] = original[i];
        }

        System.out.print("Copied array: ");
        for (int i = 0; i < copy.length; i++) {
            System.out.print(copy[i] + " ");
        }
    }
}