package org.llschall.jdmxlight

import org.llschall.ardwloop.IArdwProgram
import org.llschall.ardwloop.structure.data.LoopData
import org.llschall.ardwloop.structure.data.SerialData
import org.llschall.ardwloop.structure.data.SetupData
import java.util.concurrent.atomic.AtomicInteger

class JDmxLightProgram(private val max: Int, private var channel: Int = 0) : IArdwProgram {

    var i = 0

    private val values: Array<AtomicInteger> = Array(512) { AtomicInteger(-1) }

    override fun ardwSetup(setupData: SetupData): SetupData {

        return SetupData(
            SerialData(0, 0, 0, max, 0, 0)
        )
    }

    override fun ardwLoop(loopData: LoopData): LoopData {

        while (i <= max) {
            val value = values[i].getAndSet(-1)
            if (value != -1) {
                val channel = i
                i++
                return LoopData(
                    SerialData(0, 0, 0, channel, value, 0)
                )
            }
            i++
        }
        i = 0;
        return LoopData(SerialData(-1, -1, -1, -1, -1, -1))
    }

    override fun getRc(): Int {
        return 1
    }

    override fun getSc(): Int {
        return 1
    }

    override fun getReadDelayMs(): Int {
        return 20
    }

    override fun getPostDelayMs(): Int {
        return 9999
    }

    fun update(channel: Int, value: Int) {
        values[channel].set(value);
    }

    fun channel(channel: Int): Int {
        return values[channel].get();
    }
}
