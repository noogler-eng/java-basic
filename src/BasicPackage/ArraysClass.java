package BasicPackage;

import java.util.Arrays;
import java.util.Collections;

/*
    Arrays in Java:
    - Arrays are objects that store multiple values of the same data type
    - Fixed size once created (cannot be resized)
    - Elements are stored in contiguous memory locations
*/
public class ArraysClass {
    public static void main(String[] args){
        // 1. Array Declaration and Initialization
        System.out.println("1. Array Declaration and Initialization:");

        // Different ways to declare the array
        int[] numbers = {1, 2, 4};
        int[] another_numbers = new int[]{1, 2, 3, 4, 5};
        System.out.println(another_numbers.length);
        // we have to print the array in the string form....
        System.out.println(Arrays.toString(another_numbers));
        // System.out.println(another_numbers); this will give you address of the starting index....
        for(int i: numbers){
            System.out.println("num: " + i);
        }


        // 2. Array Elements and Default Values
        System.out.println("\n2. Array Elements and Default Values:");
        boolean[] boolArray = new boolean[3];     // Default: false
        int[] intArray = new int[3];              // Default: 0
        double[] doubleArray = new double[3];     // Default: 0.0
        String[] stringArray = new String[3];     // Default: null
        char[] charArray = new char[3];           // Default: '\u0000'

        System.out.println("boolean array defaults: " + Arrays.toString(boolArray));
        System.out.println("int array defaults: " + Arrays.toString(intArray));
        System.out.println("double array defaults: " + Arrays.toString(doubleArray));
        System.out.println("String array defaults: " + Arrays.toString(stringArray));
        System.out.println("char array defaults: " + Arrays.toString(charArray));


        // 3. Accessing and Modifying Array Elements
        System.out.println("\n3. Accessing and Modifying Array Elements:");
        String[] fruits = {"Apple", "Banana", "Orange", "Mango", "Grapes"};
        System.out.println("Original array: " + Arrays.toString(fruits));

        // Accessing elements
        System.out.println("First fruit: " + fruits[0]);
        System.out.println("Last fruit: " + fruits[fruits.length - 1]);

        // Modifying elements
        fruits[1] = "Strawberry";
        fruits[3] = "Pineapple";
        System.out.println("Modified array: " + Arrays.toString(fruits));

        // 4. Array Length and Iteration
        System.out.println("\n4. Array Length and Iteration:");

        // lengt of the string....
        int[] scores = {85, 92, 78, 96, 88, 75, 90};
        System.out.println("Array length: " + scores.length);

        // Traditional for loop
        System.out.print("Using traditional for loop: ");
        for (int i = 0; i < scores.length; i++) {
            System.out.print(scores[i] + " ");
        }
        System.out.println();

        // Enhanced for loop (for-each)
        System.out.print("Using enhanced for loop: ");
        for (int score : scores) {
            System.out.print(score + " ");
        }
        System.out.println();

        // While loop
        System.out.print("Using while loop: ");
        int index = 0;
        while (index < scores.length) {
            System.out.print(scores[index] + " ");
            index++;
        }
        System.out.println();


        // Built-in Methods from java.util.Arrays
        System.out.println("\n5. Built-in Methods from java.util.Arrays:");
        int[] originalArray = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original array: " + Arrays.toString(originalArray));

        // toString() - Convert array to string representation
        System.out.println("Using Arrays.toString(): " + Arrays.toString(originalArray));

        // sort() - Sort array in ascending order
        // Create copy to preserve original
        int[] sortedArray = originalArray.clone();
        Arrays.sort(sortedArray);
        System.out.println("After Arrays.sort(): " + Arrays.toString(sortedArray));

        // binarySearch() - Search for element (array must be sorted)
        int searchElement = 25;
        int position = Arrays.binarySearch(sortedArray, searchElement);
        System.out.println("Arrays.binarySearch(" + searchElement + "): index " + position);

        // fill() - Fill array with specified value
        // filling the array with the specific values....
        int[] fillArray = new int[5];
        Arrays.fill(fillArray, 100);
        System.out.println("Arrays.fill(array, 100): " + Arrays.toString(fillArray));

        // fill() with range
        // Fill from index 2 to 4 with 0
        int[] rangeArray = {1, 2, 3, 4, 5, 6, 7, 8};
        Arrays.fill(rangeArray, 2, 5, 0);
        System.out.println("Arrays.fill(array, 2, 5, 0): " + Arrays.toString(rangeArray));

        // equals() - Compare two arrays
        int[] array1 = {1, 2, 3};
        int[] array2 = {1, 2, 3};
        int[] array3 = {3, 2, 1};
        System.out.println("Arrays.equals(array1, array2): " + Arrays.equals(array1, array2));
        System.out.println("Arrays.equals(array1, array3): " + Arrays.equals(array1, array3));

        // copyOf() - Copy array with specified length
        int[] copiedArray = Arrays.copyOf(originalArray, originalArray.length);
        System.out.println("Arrays.copyOf(): " + Arrays.toString(copiedArray));

        // copyOf() with different length
        int[] expandedArray = Arrays.copyOf(originalArray, 10);
        System.out.println("Arrays.copyOf() with length 10: " + Arrays.toString(expandedArray));

        // copyOfRange() - Copy specific range
        int[] rangeClone = Arrays.copyOfRange(originalArray, 2, 5);
        System.out.println("Arrays.copyOfRange(2, 5): " + Arrays.toString(rangeClone));

        // 6. String Array Methods
        System.out.println("\n6. String Array Methods:");

        String[] languages = {"java", "python", "javascript", "c++", "go"};
        System.out.println("Original string array: " + Arrays.toString(languages));

        // Sort string array
        Arrays.sort(languages);
        System.out.println("Sorted string array: " + Arrays.toString(languages));

        // Sort in reverse order using Collections.reverseOrder()
        String[] languagesCopy = {"java", "python", "javascript", "c++", "go"};
        Arrays.sort(languagesCopy, Collections.reverseOrder());
        System.out.println("Reverse sorted: " + Arrays.toString(languagesCopy));

        // 7. Multi-dimensional Arrays
        System.out.println("\n7. Multi-dimensional Arrays:");


        // 2D Array declaration and initialization
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("2D Array:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        // Using Arrays.deepToString() for multi-dimensional arrays
        System.out.println("Using Arrays.deepToString(): " + Arrays.deepToString(matrix));


        // 3D Array example
        int[][][] cube = new int[2][2][2];
        int value = 1;
        for (int i = 0; i < cube.length; i++) {
            for (int j = 0; j < cube[i].length; j++) {
                for (int k = 0; k < cube[i][j].length; k++) {
                    cube[i][j][k] = value++;
                }
            }
        }

        System.out.println("3D Array: " + Arrays.deepToString(cube));


        // 8. Jagged Arrays (Arrays of different lengths)
        System.out.println("\n8. Jagged Arrays:");
        int[][] jaggedArray = {
                {1, 2},
                {3, 4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("Jagged Array");
        for(int i=0; i<jaggedArray.length; i++){
            for(int j=0; j<jaggedArray[i].length; j++){
                System.out.print(jaggedArray[i][j] + " ");
            }
            System.out.println();
        }


        // 9. Array Utility Methods (Custom implementations)
        System.out.println("\n9. Array Utility Methods:");

        int[] testArray = {10, 5, 8, 3, 9, 1, 7};
        System.out.println("Test array: " + Arrays.toString(testArray));

        // Find maximum element
        int max = findMax(testArray);
        System.out.println("Maximum element: " + max);

        // Find minimum element
        int min = findMin(testArray);
        System.out.println("Minimum element: " + min);

        // Calculate sum
        int sum = calculateSum(testArray);
        System.out.println("Sum of elements: " + sum);

        // Calculate average
        double average = calculateAverage(testArray);
        System.out.println("Average: " + average);

        // Reverse array
        int[] reversed = reverseArray(testArray.clone());
        System.out.println("Reversed array: " + Arrays.toString(reversed));

        // Check if array contains element
        boolean contains = containsElement(testArray, 5);
        System.out.println("Contains 5: " + contains);

        int elementIndex = findIndex(testArray, 5);
        System.out.println("Index of 5: " + elementIndex);

        // 10. Array Performance and Memory
        System.out.println("\n10. Array Performance and Memory:");

        // Creating large array
        int[] largeArray = new int[1000000];
        Arrays.fill(largeArray, 42);

        // Time array operations
        long startTime = System.currentTimeMillis();
        Arrays.sort(largeArray);
        long endTime = System.currentTimeMillis();
        System.out.println("Time to sort 1M elements: " + (endTime - startTime) + "ms");
        System.out.println("First 5 elements: " + Arrays.toString(Arrays.copyOf(largeArray, 5)));

        // 11. Common Array Operations
        System.out.println("\n11. Common Array Operations:");
        int[] nums = {1, 2, 3, 4, 5};
        int[] moreNums = {6, 7, 8};
        int[] combined = concatenateArrays(nums, moreNums);
        System.out.println("Concatenated arrays: " + Arrays.toString(combined));

        int[] afterRemoval = removeElementAtIndex(nums, 2);
        System.out.println("After removing index 2: " + Arrays.toString(afterRemoval));

        // Insert element at index
        int[] afterInsertion = insertElementAtIndex(nums, 2, 99);
        System.out.println("After inserting 99 at index 2: " + Arrays.toString(afterInsertion));

        System.out.println("\nn=== End of Arrays Demo ===");
    }
    // helper functions....
    public static int findMax(int[] arr){
        int maxi = Integer.MIN_VALUE;
        for (int j : arr) {
            maxi = Math.max(j, maxi);
        }
        return maxi;
    }

    public static int findMin(int[] arr){
        int mini = Integer.MAX_VALUE;
        for (int j : arr) {
            mini = Math.min(j, mini);
        }
        return mini;
    }

    public static int calculateSum(int[] arr){
        int sum = 0;
        for(int j: arr){
            sum += j;
        }
        return sum;
    }

    public static int calculateAverage(int[] arr){
        int sum = calculateSum(arr);
        return sum / arr.length;
    }

    public static int[] reverseArray(int[] arr){
        int left = 0;
        int right = arr.length - 1;
        while(left <= right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        return arr;
    }

    public static boolean containsElement(int[] arr, int x){
        for(int i: arr){
            if(x == i) return true;
        }
        return false;
    }

    public static int findIndex(int[] arr, int x){
        // binary search only applicable in sorted array
        Arrays.sort(arr);
        int low = 0, high = arr.length - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            System.out.println("mid: " + mid + " arr[mid]: " + arr[mid]);
            if(arr[mid] == x) return mid;
            else if(arr[mid] > x) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }

    public static int[] concatenateArrays(int[] arr, int[] num){
        int[] combined = new int[arr.length + num.length];
        int index = 0;

        for(int i: arr){
            combined[index] = i;
            index++;
        }

        for(int i: num){
            combined[index] = i;
            index++;
        }

        return combined;
    }

    public static int[] removeElementAtIndex(int[] arr, int ind){
        if(ind >= arr.length || ind < 0) return arr;
        int[] result = new int[arr.length - 1];
        int index = 0;
        int count = 0;
        for(int i: arr){
            if(count == 2){
                count++;
                continue;
            }

            result[index] = i;
            index++;
            count++;
        }
        return result;
    }

    public static int[] insertElementAtIndex(int[] arr, int ind, int ele){
        if(ind < 0 || ind > arr.length) return arr;
        int[] num = new int[arr.length + 1];
        int index = 0;
        int i = 0;
        while(i < arr.length){
            if(index == ind){
                num[index] = ele;
            }else{
                num[index] = arr[i];
                i++;
            }
            index++;
        }
        return num;
    }
}

















