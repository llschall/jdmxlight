package org.llschall.jdmxlight;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.llschall.ardwloop.structure.data.LoopData;
import org.llschall.ardwloop.structure.data.SerialData;
import org.llschall.ardwloop.structure.data.SerialVector;
import org.llschall.ardwloop.structure.data.SetupData;

public class ProgramTest {

    @Test
    public void testProgram() {

        int max = 12;

        JDmxLightProgram program = new JDmxLightProgram(max);

        SerialVector a = program.ardwSetup(
                new SetupData(new SerialData(0, 0, 0, 0, 0, 0))
        ).getData().a;
        assertEquals(max, a.x);

        final LoopData loopData = new LoopData(new SerialData(0, 0, 0, 0, 0, 0));

        a = program.ardwLoop(loopData).getData().a;
        assertEquals(-1, a.v);
        assertEquals(-1, a.x);
        assertEquals(-1, a.y);

        program.update(8, 20);
        a = program.ardwLoop(loopData).getData().a;
        assertEquals(0, a.v);
        assertEquals(8, a.x);
        assertEquals(20, a.y);

        a = program.ardwLoop(loopData).getData().a;
        assertEquals(-1, a.v);
        assertEquals(-1, a.x);
        assertEquals(-1, a.y);
    }

}
