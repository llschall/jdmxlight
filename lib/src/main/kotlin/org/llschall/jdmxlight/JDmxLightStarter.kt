package org.llschall.jdmxlight

import org.llschall.ardwloop.ArdwloopStarter

class JDmxLightStarter(var max: Int) {

    val program: JDmxLightProgram = JDmxLightProgram(max)

    fun start() {
        ArdwloopStarter.get().start(program)
    }

    fun update(channel: Int, value: Int) {
        program.update(channel, value);
    }

    fun get(channel: Int): Int {
        return program.channel(channel);
    }

}
