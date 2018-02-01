/**
 * Created by pvakati on 2/1/2018.
 */
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DeDupDemoTest {


    int[] randomIntegers = { 1, 2, 34, 34, 25, 1, 45, 3, 26, 85, 4, 34, 86, 25, 43, 2, 1, 10000, 11, 16, 19, 1, 18,
            4, 9, 3, 20, 17, 8, 15, 6, 2, 5, 10, 14, 12, 13, 7, 8, 9, 1, 2, 15, 12, 18, 10, 14, 20, 17, 16, 3, 6,
            19, 13, 5, 11, 4, 7, 19, 16, 5, 9, 12, 3, 20, 7, 15, 17, 10, 6, 1, 8, 18, 4, 14, 13, 2, 11 };

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testDuplicates_Mehtod1() {
        Object [] testInput = {1,2,34,25,45,3,26,85,4,86,43,10000,11,16,19,18,9,20,17,8,15,6,5,10,14,12,13,7} ;
        assertArrayEquals(testInput, DeDupDemo.removeDuplicateValuesUsingSet(randomIntegers));

    }

    @Test
    public void testDuplicates_Mehtod2() {
        int [] testInput = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 25, 26, 34, 43, 45, 85, 86, 10000} ;
        assertArrayEquals(testInput, DeDupDemo.removeDuplicatesWithSort(randomIntegers));

    }


    @Test
    public void testDuplicates_Mehtod3() {
        int [] testInput1 = {1,2,34,25,45,3,26,85,4,86,43,10000,11,16,19,18,9,20,17,8,15,6,5,10,14,12,13,7} ;
        int [] testInput2 = {} ;
        assertNotEquals( testInput2, DeDupDemo.removeDuplicateValuesUsingStreams(randomIntegers)  );
        assertArrayEquals(testInput1, DeDupDemo.removeDuplicateValuesUsingStreams(randomIntegers));
        assertNotNull(DeDupDemo.removeDuplicateValuesUsingStreams(randomIntegers));

    }


}
