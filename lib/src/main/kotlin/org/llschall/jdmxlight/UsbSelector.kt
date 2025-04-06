package org.llschall.jdmxlight

import org.llschall.ardwloop.serial.ArdwPortDescriptor
import org.llschall.ardwloop.serial.DefaultPortSelector
import org.llschall.ardwloop.serial.IArdwPortSelector

open class DefaultUsbSelector {

    private val selector = DefaultPortSelector()

    public open fun listPorts(): List<UsbPort> {
        return selector.list()
            .map { port -> UsbPort(port.name, port.description, port.systemName) }
    }

    public open fun selectPort(port: UsbPort): Boolean {
        return selector.select(ArdwPortDescriptor(port.name, port.description, port.systemName))
    }

    fun select(desc: ArdwPortDescriptor): Boolean {
        return selectPort(UsbPort(desc.name, desc.description, desc.systemName))
    }
}

class UsbPort(val name: String, val description: String, val systemName: String) {

    override fun toString(): String {
        return "UsbPort(name='$name', description='$description', systemName='$systemName')"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as UsbPort

        if (name != other.name) return false
        if (description != other.description) return false
        if (systemName != other.systemName) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + description.hashCode()
        result = 31 * result + systemName.hashCode()
        return result
    }
}

class SelectorAdapter(private val selector: DefaultUsbSelector): IArdwPortSelector {

    override fun select(desc: ArdwPortDescriptor): Boolean {
        return selector.select(desc)
    }

    override fun list(): List<ArdwPortDescriptor> {
        return selector.listPorts().map { port ->
            ArdwPortDescriptor(port.name, port.description, port.systemName)
        }
    }

}