import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class DeDupDemo {

    public static void main(String[] args) {

        int[] randomIntegers = {1, 2, 34, 34, 25, 1, 45, 3, 26, 85, 4, 34, 86, 25, 43, 2, 1, 10000, 11, 16, 19, 1, 18,
                4, 9, 3, 20, 17, 8, 15, 6, 2, 5, 10, 14, 12, 13, 7, 8, 9, 1, 2, 15, 12, 18, 10, 14, 20, 17, 16, 3, 6,
                19, 13, 5, 11, 4, 7, 19, 16, 5, 9, 12, 3, 20, 7, 15, 17, 10, 6, 1, 8, 18, 4, 14, 13, 2, 11};

		/*
         * Method1 --sort the array and remove duplicates -- no order maintained
		 * chosen quick sort to sort the array - time complexity O(nlog(n)) and
		 * go through the array to remove the duplicates O(n) constant space
		 * complexity since no auxiliary array is used.
		 */

        removeDuplicatesWithSort(randomIntegers);

		/*
		 * Method2 -- using set to remove duplicates - order maintained but
		 * auxiliary array is used time complexity O(n) and go through the array
		 * to remove the duplicates O(n) space complexity O(n) since auxiliary
		 * array is used.
		 */
        removeDuplicateValuesUsingSet(randomIntegers);

		/*
		 * Method 3 - using java8 streams concise code performance wise not as
		 * fast as method 1 but consumes less memory as there is no temporary
		 * memory
		 */

        removeDuplicateValuesUsingStreams(randomIntegers);

    }

    static int[] removeDuplicatesWithSort(int[] randomIntegers) {

        quickSort(randomIntegers, 0, randomIntegers.length - 1);
        //System.out.println(" sorted array values:" +Arrays.toString(randomIntegers));
        // now remove the duplicate elements.
        randomIntegers = removeDuplicates(randomIntegers);
        //System.out.println("Unique elements in Array :" +Arrays.toString(randomIntegers));

        return randomIntegers;

    }

    // Time complexity O(n) but space compelxity O(n) becasue we used the
    // temporary array
    static Object[] removeDuplicateValuesUsingSet(int[] arrayWithDuplicates) {


        Set<Integer> set = new LinkedHashSet<Integer>(); // Use HashSet if you
        // don't want insertion order

        for (int arrayWithDuplicate : arrayWithDuplicates) {
            set.add(arrayWithDuplicate);
        }
        return set.toArray();
    }

    // removing duplicates using java 8 streams
    // not as faster as set option O(n3) but no temporary array space complexity
    // is constant
    static int[] removeDuplicateValuesUsingStreams(int[] arrayInputValues) {

        if (arrayInputValues.length <= 1) {
            return arrayInputValues;
        }
        return Arrays.stream(arrayInputValues)
                .distinct().toArray();

    }

    private static int[] removeDuplicates(int[] arr) {
        // if array length is one, return the array
        if (arr.length <= 1) {
            return arr;
        }

        // new array keep the length equal to current array.
        int[] uniqueArray = new int[arr.length];
        // keep the lastfound number to be 0th index.
        int lastFound = arr[0];
        // copy the 0th index value to new arrays 0th.
        uniqueArray[0] = arr[0];

        // current index position to put the unique number
        int currPos = 1;
        for (int num : arr) {
            if (lastFound != num) {
                lastFound = num;
                uniqueArray[currPos++] = num;
            }
        }
        return Arrays.copyOf(uniqueArray, currPos);

    }

    private static void quickSort(int[] arr, int s, int e) {

        if (s < e) {
            int pivot = findPivot(arr, s, e);
            //System.out.println(pivot);
            // sort left
            quickSort(arr, s, pivot - 1);
            // sort right
            quickSort(arr, pivot + 1, e);
        }

    }

    private static int findPivot(int[] arr, int s, int e) {
        int p = arr[e];
        int i = s;
        for (int j = s; j < e; j++) {
            if (arr[j] <= p) {
                swap(arr, i, j);
                i = i + 1;
            }
        }
        swap(arr, e, i);
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
