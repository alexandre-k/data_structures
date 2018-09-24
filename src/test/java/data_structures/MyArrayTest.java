package data_structures;

import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MyArrayTest {

    @Test
    @DisplayName("Test array insertion")
    public void testInsertion() {

        int[] anarray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] expected = {1, 2, 3, 6, 4, 5, 7, 8, 9, 10};
        MyArray.insertElementAtIndex(anarray, 5, 3);
        assertEquals(Arrays.toString(anarray), Arrays.toString(expected));
    }
}
