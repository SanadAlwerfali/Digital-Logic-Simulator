package digital.implementation;

import digital.interfaces.DeviceInterface;
import digital.interfaces.PortInterface;
import digital.interfaces.Value;

public class NotGate implements DeviceInterface{
	
	Value value;
	private String name;
	PortInterface outputPort;
	PortInterface inputPort;
	
	public NotGate(String name) {
		this.name = name;
		outputPort = new Port(true);
		inputPort = new Port(false);
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public int numberOfPorts() {
		return 2;
	}

	@Override
	public PortInterface getPort(int portNumber) {
		PortInterface newport;
		if (portNumber == 0) {
			newport = outputPort;
			return newport;
		}
		else {
			newport = inputPort;
			return newport;
		}
	}
	

	@Override
	public boolean update() {
		Value tempValue = inputPort.getValue();
		if (tempValue == Value.FALSE){
			outputPort.setValue(Value.TRUE);
			return true;
		}
		if (tempValue == Value.TRUE) {
			outputPort.setValue(Value.FALSE);
			return true;
		}
		else {
		outputPort.setValue(Value.UNKNOWN);
		return false;
		}
	}

	@Override
	public void clock() {}

	

}
