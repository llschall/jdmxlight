package org.llschall.jdmxlight;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JDmxLightTest {

    @Test
    public void testSetup() {
        Assertions.assertFalse(!JDmxLight.VERSION.isBlank());
    }

}
