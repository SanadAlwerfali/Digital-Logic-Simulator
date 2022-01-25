package digital.implementation;


import digital.interfaces.PortInterface;
import digital.interfaces.Value;
import util.Assert;

public class Port implements PortInterface{
	
	// setting class attributes 
	private Value portValue;
	private boolean outputPort;
	private boolean inputPort;
	
	// creating a constructor
	public Port(boolean output) {
		this.outputPort = output;
	}

	@Override
	public boolean isOutputPort() {
		// check if the port is an output port
		// if not 'true' 
		return outputPort;
	}
	
	public boolean isInputPort() {
		// check if the port is an output port
		Assert.check(inputPort == true);
		return true;
	}

	@Override
	public void setValue(Value v) {
		this.portValue = v;
	}

	@Override
	public Value getValue() {
		if (portValue != null) {
		return portValue;
		}
		else 
		{
			return Value.UNKNOWN;
		}
	}

}
