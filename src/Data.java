import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Data {

	static Map<String, State> listAllStatesMap = new HashMap<String, State>();
	static String startingState = new String();
	static ArrayList<State> acceptingStates = new ArrayList<State>();
	static ArrayList<String> availableSymbols = new ArrayList<String>();

	public void setInitialValues() {
		//Setting up states
		createStates(15);

		// Setting starting state
		startingState = "q0";
		
		// Setting available symbols
		String[] availableSymbols = {"0", "1", "2", "3", "4", "a", "b", "c", "d", "e"};
		setAvailableSymbols(availableSymbols);
		
		//Setting accepting states
		addAcceptingStates(listAllStatesMap.get("q7"));
		addAcceptingStates(listAllStatesMap.get("q14"));
		
		setTransitions("q0", "0 q1,q2;1 q1,q3;2 q1,q4;3 q1,q5;4 q1,q6;a q8,q9;b q8,q10;c q8,q11;d q8,q12;e q8,q13");
		setTransitions("q1", "0 q1,q2;1 q1,q3;2 q1,q4;3 q1,q5;4 q1,q6;a X;b X;c X;d X;e X");
		setTransitions("q2", "0 q7;1 X;2 X;3 X;4 X;a X;b X;c X;d X;e X");
		setTransitions("q3", "0 X;1 q7;2 X;3 X;4 X;a X;b X;c X;d X;e X");
		
		setTransitions("q4", "1 q5;2 q6;5 q9;K q4");
		setTransitions("q5", "1 q6;2 q7;5 q10;K q5");
		setTransitions("q6", "1 q7;2 q8;5 q11;K q6");
		setTransitions("q7", "1 q8;2 q9;5 q12;K q7");
		setTransitions("q8", "1 q9;2 q10;5 qR1Sauna;K q8");
		setTransitions("q9", "1 q10;2 q11;5 qR2Sauna;K qBRPlywalnia");
		setTransitions("q10", "1 q11;2 q12;5 qR3Sauna;K qR1Plywalnia");
		setTransitions("q11", "1 q12;2 qR1Sauna;5 qR4Sauna;K qR2Plywalnia");
		setTransitions("q12", "1 qR1Sauna;2 qR2Sauna;5 qR5Sauna;K qBRSauna");
		setTransitions("q13", "1 qR1Sauna;2 qR2Sauna;5 qR5Sauna;K qBRSauna");
		setTransitions("q14", "1 qR1Sauna;2 qR2Sauna;5 qR5Sauna;K qBRSauna");

	}

	public void createStates(int numberOfStates) {
		for (int i = 0; i < numberOfStates; i++) {
			String stateName = "q" + i;
			listAllStatesMap.put(stateName, new State(stateName, i));
		}
	}
	
	public void setAvailableSymbols(String[] symbols)
	{
		for (String symbol : symbols)
		{
			availableSymbols.add(symbol);
		}
	}
	
	public void setTransitions(String stateName, String allTransitions)
	{
		listAllStatesMap.get(stateName).setTransitions(allTransitions);
	}
	
	public void addAcceptingStates(State acceptingState)
	{
		acceptingStates.add(acceptingState);
	}
}
