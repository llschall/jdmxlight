package org.llschall.jdmxlight

import org.llschall.ardwloop.IArdwProgram
import org.llschall.ardwloop.value.SerialData
import java.util.concurrent.atomic.AtomicInteger

class JDmxLightProgram(private val max: Int) : IArdwProgram {

    var i = 0

    private val values: Array<AtomicInteger> = Array(512) { AtomicInteger(0) }
    private val buffer: Array<AtomicInteger> = Array(512) { AtomicInteger(-1) }

    override fun ardwSetup(data: SerialData): SerialData {

        return SerialData(0, 0, max, 0, 0)
    }

    override fun ardwLoop(loopData: SerialData): SerialData {

        while (i <= max) {
            val value = buffer[i].getAndSet(-1)
            if (value != -1) {
                val channel = i
                i++
                return SerialData(0, 0, channel, value, 0)

            }
            i++
        }
        i = 0;
        return SerialData(-1, -1, -1, -1, -1)
    }

    override fun getReadDelayMs(): Int {
        return 20
    }

    override fun getPostDelayMs(): Int {
        return 9999
    }

    fun update(channel: Int, value: Int) {
        values[channel].set(value)
        buffer[channel].set(value)
    }

    fun channel(channel: Int): Int {
        return values[channel].get();
    }
}
