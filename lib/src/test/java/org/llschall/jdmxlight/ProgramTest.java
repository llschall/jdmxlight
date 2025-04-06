package org.llschall.jdmxlight;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.llschall.ardwloop.value.SerialData;
import org.llschall.ardwloop.value.V;

public class ProgramTest {

    @Test
    public void testProgram() {

        int max = 12;

        JDmxLightProgram program = new JDmxLightProgram(max);

        V a = program.ardwSetup(
                new SerialData( 0, 0, 0, 0, 0)
        ).a;

        assertEquals(max, a.x);

        final SerialData loopData = new SerialData(0, 0, 0, 0, 0);

        a = program.ardwLoop(loopData).a;
        assertEquals(-1, a.v);
        assertEquals(-1, a.x);
        assertEquals(-1, a.y);
        assertEquals(0, program.channel(1));
        assertEquals(0, program.channel(8));
        
        program.update(8, 20);
        a = program.ardwLoop(loopData).a;
        assertEquals(0, a.v);
        assertEquals(8, a.x);
        assertEquals(20, a.y);
        assertEquals(0, program.channel(1));
        assertEquals(20, program.channel(8));

        a = program.ardwLoop(loopData).a;
        assertEquals(-1, a.v);
        assertEquals(-1, a.x);
        assertEquals(-1, a.y);
        assertEquals(0, program.channel(1));
        assertEquals(20, program.channel(8));
    }

}
