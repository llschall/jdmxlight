package org.llschall.jdmxlight;

import org.junit.jupiter.api.Test;
import org.llschall.ardwloop.ArdwloopStarter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JDmxLightTest {

    @Test
    public void testSetup() {
        assertEquals(1001, JDmxLight.VERSION_INT);
        assertEquals("0.3.3", ArdwloopStarter.VERSION);
    }

    @Test
    public void testDmx() {
        JDmxLightStarter starter = new JDmxLightStarter(10);
        assertEquals(10, starter.getMax());
    }
}
