import java.util.ArrayList;

public class State {
	Transitions transitions;
	private String name;
	private int value;
	private String outputString;
	public State() {

	}

	public State(String name, int value) {
		this.name = name;
		this.value = value;
	}

	public void setTransitions(String value) {
		transitions = new Transitions(value);
	}

	public ArrayList<State> goToNextState(String string) {
		if(Data.availableSymbols.contains(string))
		{
			return transitions.selectNextState(string);
		}
		System.out.println("Symbol does not belong to the list of available symbols!");
		return new ArrayList<State>();
	}

	@Override
	public String toString() {
		return name;
	}
	
	int getValue()
	{
		return value;
	}

	public String getOutputString() {
		return outputString;
	}

	public void setOutputString(String outputString) {
		this.outputString = outputString;
	}
}
