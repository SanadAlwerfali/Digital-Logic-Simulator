package digital.implementation;

import java.util.ArrayList;
import java.util.List;

import digital.interfaces.InputDeviceInterface;
import digital.interfaces.PortInterface;
import digital.interfaces.Value;
import util.Assert;

public class InputDevice implements InputDeviceInterface {
	
	private int counter = 0;
	private List<PortInterface> ports = new ArrayList<PortInterface>() ;
	public static int outputPortIndex = 0 ;
	private Value[] portValues;
	private String name;
	public PortInterface port;
	
	public InputDevice(String name) {
		this.name = name;
		port = new Port(true);
		ports.add(port);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int numberOfPorts() {
		
		return 0;
	}

	@Override
	public PortInterface getPort(int portNumber) {
		// TODO Auto-generated method stub
		return ports.get(portNumber);
	}

	@Override
	public boolean update() {
		return false;
	}
	
	
	@Override
	public void clock() {
		if (counter < portValues.length) {
			ports.get(0).setValue(portValues[counter]);
		}
		else {
			ports.get(0).setValue(Value.UNKNOWN);
		}
		counter++;
	}
	
	@Override
	public void setInputSequence(Value[] values) {
		this.portValues = values;
	}
	
	public void addPort( PortInterface p ) {
		System.out.println(p);
		Assert.check( outputPortIndex == -1 || ! p.isOutputPort(),
				"Net "+name+" already has an output port." ) ;
		if( p.isOutputPort() ) outputPortIndex = ports.size() ;
		ports.add( p ) ;
	}

}
