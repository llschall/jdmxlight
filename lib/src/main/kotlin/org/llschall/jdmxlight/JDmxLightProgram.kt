package org.llschall.jdmxlight

import org.llschall.ardwloop.IArdwProgram
import org.llschall.ardwloop.structure.data.LoopData
import org.llschall.ardwloop.structure.data.SerialData
import org.llschall.ardwloop.structure.data.SetupData
import java.util.concurrent.atomic.AtomicInteger

class JDmxLightProgram(private val max: Int, private var i: Int = 0) : IArdwProgram {

    private val values: Array<Int> = Array<Int>(512) { -1 }


    override fun ardwSetup(setupData: SetupData): SetupData {
        return SetupData(
            SerialData(0, 0, 0, max, 0, 0)
        )
    }

    override fun ardwLoop(loopData: LoopData): LoopData {

        val channel = i
        val value = values[i]

        i++
        if (i > max) {
            i = 0
        }

        return LoopData(
            SerialData(0, 0, 0, channel, value, 0)
        )
    }

    override fun getRc(): Int {
        return 1
    }

    override fun getSc(): Int {
        return 1
    }

    override fun getReadDelayMs(): Int {
        return 99
    }

    override fun getPostDelayMs(): Int {
        return 9999
    }

    fun update(channel: Int, value: Int) {
        values[channel] = value;
    }

    fun channel(channel: Int): Int {
        return values[channel];
    }
}
