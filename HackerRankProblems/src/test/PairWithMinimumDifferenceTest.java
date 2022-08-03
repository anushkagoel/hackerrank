package test;

import org.junit.Test;
import org.mockito.Mockito;
import problems.PairsWithMinimumDifference;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class PairWithMinimumDifferenceTest {

    @Test
    public void testFindMax(){
//        Mockito.mock()
        assertEquals(4, PairsWithMinimumDifference.minimumDifference(Arrays.asList(1,3,4,2)));
//        assertEquals(-1,Calculation.findMax(new int[]{-12,-1,-3,-4,-2}));
    }
}
