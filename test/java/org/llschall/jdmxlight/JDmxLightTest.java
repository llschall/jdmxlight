package test.java.org.llschall.jdmxlight;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.llschall.jdmxlight.JDmxLight;

public class JDmxLightTest {

    @Test
    public void testSetup() {
        Assertions.assertFalse(JDmxLight.VERSION.isBlank());
    }

}
