package digital.implementation;

import digital.interfaces.DeviceInterface;
import digital.interfaces.PortInterface;
import digital.interfaces.Value;


public class DFlipFlops implements DeviceInterface{

	private String name;
	PortInterface outputPort;
	PortInterface inputPort;
	
	public DFlipFlops(String name) {
		this.name = name;
		outputPort = new Port(true);
		inputPort = new Port(false);
	}

	
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public int numberOfPorts() {
		return 2 ;
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
		return false;
	}

	@Override
	public void clock() {
		Value tempValue = inputPort.getValue();
		outputPort.setValue(tempValue);
	}
}
