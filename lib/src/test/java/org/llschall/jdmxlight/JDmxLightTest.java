package org.llschall.jdmxlight;

import org.junit.jupiter.api.Test;
import org.llschall.ardwloop.ArdwloopStarter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class JDmxLightTest {

    @Test
    public void testSetup() {
        assertEquals(1000, JDmxLight.VERSION_INT);
        assertEquals("0.1.2", ArdwloopStarter.ARDWLOOP_VERSION);
    }

    @Test
    public void testDmx() {
        JDmxLightStarter starter = new JDmxLightStarter(10);
        assertEquals(10, starter.getMax());

        starter.update(0, 99);
        assertEquals(99, starter.get(0));
    }
}
