import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class TimeCalTest {
    TimeCal timeCal = new TimeCal();

    @Test
    void testCalculateTime() {
        assertEquals(1.0, timeCal.calculateTime(100, 100), 0.0001);
    }
}