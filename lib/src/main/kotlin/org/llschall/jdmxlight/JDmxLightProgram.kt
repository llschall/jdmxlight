package org.llschall.jdmxlight

import org.llschall.ardwloop.IArdwProgram
import org.llschall.ardwloop.value.SerialData
import java.util.concurrent.atomic.AtomicInteger

class JDmxLightProgram(private val max: Int) : IArdwProgram {

    var i = 0

    private val channels: Array<AtomicInteger> = Array(512) { AtomicInteger(0) }
    private val buffer: Array<AtomicInteger> = Array(max) { AtomicInteger(-1) }

    override fun ardwSetup(data: SerialData): SerialData {

        return SerialData(0, 0, max, 0, 0)
    }

    override fun ardwLoop(loopData: SerialData): SerialData {

        while (i < max) {
            val channel = i+1
            val value = buffer[i].getAndSet(-1)
            if (value != -1) {
                channels[i].set(value)
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

    fun update(channel: Int, value: Int) {
        buffer[channel-1].set(value)
    }

    fun channel(channel: Int): Int {
        return channels[channel-1].get();
    }
}
