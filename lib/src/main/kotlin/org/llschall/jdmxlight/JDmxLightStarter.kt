package org.llschall.jdmxlight

import org.llschall.ardwloop.ArdwloopStarter
import org.llschall.ardwloop.IArdwConfig

class JDmxLightStarter(var max: Int) {

    val program: JDmxLightProgram = JDmxLightProgram(max)

    fun start() {
        ArdwloopStarter.get().start(program, IArdwConfig.BAUD_38400)
    }

    fun update(channel: Int, value: Int) {
        program.update(channel, value);
    }

    fun get(channel: Int): Int {
        return program.channel(channel);
    }

}
