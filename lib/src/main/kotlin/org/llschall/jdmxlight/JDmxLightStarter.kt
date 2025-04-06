package org.llschall.jdmxlight

import org.llschall.ardwloop.ArdwloopStarter
import org.llschall.ardwloop.IArdwConfig

class JDmxLightStarter(var max: Int) {

    val program: JDmxLightProgram = JDmxLightProgram(max)

    fun start(selector: DefaultUsbSelector) {
        val starter = ArdwloopStarter.get()
        starter.setSelector(SelectorAdapter(selector))
        starter.start(program, IArdwConfig.BAUD_9600)
    }

    fun update(channel: Int, value: Int) {
        program.update(channel, value)
    }

    fun get(channel: Int): Int {
        return program.channel(channel)
    }

}
