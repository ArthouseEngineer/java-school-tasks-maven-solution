
import org.junit.Test;
import tractor.Orientation;


import static org.junit.Assert.assertTrue;

public class OrientationTester {

    @Test
    public void clockWithTest() {
        assertTrue("South - West",Orientation.WEST  == Orientation.turnClockwise(Orientation.SOUTH));
        assertTrue("North - East",Orientation.EAST == Orientation.turnClockwise(Orientation.NORTH));
        assertTrue("West - North", Orientation.NORTH == Orientation.turnClockwise(Orientation.WEST));
        assertTrue("East - South",Orientation.SOUTH == Orientation.turnClockwise(Orientation.EAST));
    }
}
