package org.llschall.jdmxlight

import org.llschall.ardwloop.IArdwProgram
import org.llschall.ardwloop.structure.data.LoopData
import org.llschall.ardwloop.structure.data.SerialData
import org.llschall.ardwloop.structure.data.SetupData
import java.util.concurrent.atomic.AtomicInteger

class JDmxLightProgram : IArdwProgram {
    var x: AtomicInteger? = null
    var y: AtomicInteger? = null
    var z: AtomicInteger? = null

    override fun ardwSetup(setupData: SetupData): SetupData {
        return SetupData(
            SerialData(0, 0, 0, x!!.get(), y!!.get(), z!!.get())
        )
    }

    override fun ardwLoop(loopData: LoopData): LoopData {
        return LoopData(
            SerialData(0, 0, 0, x!!.get(), y!!.get(), z!!.get())
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
}
