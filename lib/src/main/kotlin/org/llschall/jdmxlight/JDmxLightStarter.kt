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
        if (channel < 1 || channel > max) {
            throw IllegalArgumentException("Channel must be between 1 and $max")
        }
        program.update(channel, value)
    }

    fun get(channel: Int): Int {
        if (channel < 1 || channel > max) {
            throw IllegalArgumentException("Channel must be between 1 and $max")
        }
        return program.channel(channel)
    }

}
