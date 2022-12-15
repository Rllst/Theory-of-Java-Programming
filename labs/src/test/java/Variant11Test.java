import lab0.CardinalPoint;
import lab0.Variant11;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Variant11Test {
    @Test
    public void testIntegerTask() {
        Assert.assertArrayEquals(Variant11.integerTask(143), new int[]{8, 12});
        assertArrayEquals(Variant11.integerTask(654), new int[]{15, 120});
        assertArrayEquals(Variant11.integerTask(999), new int[]{27, 729});
        assertThrows(IllegalArgumentException.class, () -> Variant11.integerTask(1));
    }

    @Test
    public void testBooleanTask() {
        assertEquals(Variant11.booleanTask(2, 3), false);
        assertEquals(Variant11.booleanTask(4, 4), true);
        assertEquals(Variant11.booleanTask(3, 3), true);
    }

    @Test
    public void testIfTask() {
        assertArrayEquals(Variant11.ifTask(3, 4), new int[]{4, 4});
        assertArrayEquals(Variant11.ifTask(4, 4), new int[]{0, 0});
    }

    @Test
    public void testCaseTask() {
        Assert.assertEquals(Variant11.caseTask(CardinalPoint.NORTH, 2, 2), CardinalPoint.NORTH);
        assertEquals(Variant11.caseTask(CardinalPoint.WEST, 1, 1), CardinalPoint.EAST);
        assertEquals(Variant11.caseTask(CardinalPoint.SOUTH, 1, -1), CardinalPoint.SOUTH);
    }

    @Test
    public void testForTask() {
        assertEquals(Variant11.forTask(1), 5);
        assertEquals(Variant11.forTask(2), 29);
        assertEquals(Variant11.forTask(6), 595);
        assertThrows(IllegalArgumentException.class, () -> Variant11.forTask(-1));
    }

    @Test
    //foreach
    public void testWhileTask() {
        assertEquals(Variant11.whileTask(14), 5);
        assertEquals(Variant11.whileTask(27), 7);
        assertEquals(Variant11.whileTask(7), 4);
        assertEquals(Variant11.whileTask(3),2);
    }

    @Test
    public void testArrayTask() {
        assertArrayEquals(Variant11.arrayTask(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}, 3), new int[]{4, 7, 10, 13});
        assertArrayEquals(Variant11.arrayTask(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}, 5), new int[]{6, 11});
    }

    @Test
    public void testMatrixTask() {
        assertArrayEquals(Variant11.matrixTask(new int[][]{{1, 2}, {3, 4}}, 2, 2), new int[][]{{1, 2}, {4, 3}});
        assertArrayEquals(Variant11.matrixTask(new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}}, 4, 2), new int[][]{{1, 2}, {4, 3}, {5, 6}, {8, 7}});
    }
}
