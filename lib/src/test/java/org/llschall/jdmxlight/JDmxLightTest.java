package org.llschall.jdmxlight;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.llschall.ardwloop.ArdwloopStarter;

public class JDmxLightTest {

    @Test
    public void testSetup() {
        Assertions.assertFalse(JDmxLight.VERSION.isBlank());
        Assertions.assertFalse(ArdwloopStarter.ARDWLOOP_VERSION.isBlank());
    }

}
