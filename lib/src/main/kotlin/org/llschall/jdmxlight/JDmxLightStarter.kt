package org.llschall.jdmxlight

import org.llschall.ardwloop.ArdwloopStarter

class JDmxLightStarter {
    val program: JDmxLightProgram = JDmxLightProgram()

    fun start() {
        ArdwloopStarter.get().start(program)
    }

    fun update(x: Int, y: Int, z: Int) {
        program.x!!.set(x)
        program.y!!.set(y)
        program.z!!.set(z)
    }
}
