import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void calculate_good_job() throws Exception {

        Assert.assertEquals(Solution.calculate(10), OperationOutcome.GOOD_JOB);
    }


    @Test
    public void calculate_wrong() throws Exception {

        Assert.assertEquals(Solution.calculate("aaa"), OperationOutcome.UNSUCCESSFULL_TERMINATION);
    }



}