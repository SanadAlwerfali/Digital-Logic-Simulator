package digital.implementation;

import digital.interfaces.DeviceInterface;
import digital.interfaces.PortInterface;
import digital.interfaces.Value;

public class OrGate implements DeviceInterface{
	
	Value value;
	private String name;
	PortInterface outputPort;
	PortInterface inputPort1;
	PortInterface inputPort2;
	
	public OrGate(String name) {
		this.name = name;
		outputPort = new Port(true);
		inputPort1 = new Port(false);
		inputPort2 = new Port(false);
	}
	
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public int numberOfPorts() {
		return 3;
	}

	@Override
	public PortInterface getPort(int portNumber) {
		PortInterface newport;
		if (portNumber == 0) {
			newport = outputPort;
			return newport;
		}
		if (portNumber == 1) {
			newport = inputPort1;
			return newport;
		}
		else {
			newport = inputPort2;
			return newport;
		}
	}

	@Override
	public boolean update() {
		Value tempValue = inputPort1.getValue();
		Value tempValue2 = inputPort2.getValue();
		Value outPort = outputPort.getValue();
		
		if (tempValue == Value.FALSE && tempValue2 == Value.FALSE){
			outputPort.setValue(Value.FALSE);
			if (outPort != Value.FALSE) {
				return true;
			}
		}
		else if (tempValue == Value.TRUE || tempValue2 == Value.TRUE){
			outputPort.setValue(Value.TRUE);
			if (outPort != Value.TRUE) {
				return true;
			}

		}
		else if (tempValue == Value.UNKNOWN || tempValue2 == Value.UNKNOWN) {
			outputPort.setValue(Value.UNKNOWN);
			if (outPort != Value.UNKNOWN) {
				return true;
			}
		}
		return false;
		
	}

	@Override
	public void clock() {}

}


