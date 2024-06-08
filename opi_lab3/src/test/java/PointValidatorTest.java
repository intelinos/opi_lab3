import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import validators.PointValidator;

public class PointValidatorTest {
    @Test
    public void testHitInArea() {
        assertTrue(PointValidator.isHit(-2f, 1f, 4f));
        assertTrue(PointValidator.isHit(1f, -0.5f, 4f));
        assertFalse(PointValidator.isHit(1f, 0.5f, 3f));
        assertFalse(PointValidator.isHit(-1f, -1f, 1f));
    }

    @Test
    public void testHitInRectangle(){
        assertTrue(PointValidator.isHit(-1f, 2f, 3f));
        assertTrue(PointValidator.isHit(-1f, 2f, 2f));
        assertFalse(PointValidator.isHit(-0.51f, 0.5f, 1f));
    }

    @Test
    public void testHitInTriangle(){
        assertTrue(PointValidator.isHit(-1f, -0.25f, 2f));
        assertTrue(PointValidator.isHit(-0.5f, -0.25f, 1f));
        assertFalse(PointValidator.isHit(-0.5f, -0.255f, 1f));
        assertFalse(PointValidator.isHit(-3f, -3f, 1f));
    }

    @Test
    public void testHitInSector(){
        assertTrue(PointValidator.isHit(1f, -0.25f, 4f));
        assertTrue(PointValidator.isHit(0.5f, -0.5f, 2f));
        assertFalse(PointValidator.isHit(1f, -1f, 1f));
        assertFalse(PointValidator.isHit(3f, -3f, 1f));
    }
}
