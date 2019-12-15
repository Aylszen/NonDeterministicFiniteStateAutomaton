public class State {
	Transitions transitions;
	private String name;
	private int value;

	public State() {

	}

	public State(String name, int value) {
		this.name = name;
		this.value = value;
	}

	public void setTransitions(String value) {
		transitions = new Transitions(value);
	}

	public State goToNextState(String inputData) {
		if(Data.availableSymbols.contains(inputData))
		{
			return transitions.selectNextState(inputData);
		}
		System.out.println("Symbol does not belong to the list of available symbols!");
		return this;
	}

	@Override
	public String toString() {
		return name;
	}
	
	int getValue()
	{
		return value;
	}
}
