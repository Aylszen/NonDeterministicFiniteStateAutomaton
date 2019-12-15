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
		createStates(20);
		listAllStatesMap.put("qBRPlywalnia", new State("qBRPlywalnia", 0));
		listAllStatesMap.put("qR1Plywalnia", new State("qR1Plywalnia", 1));
		listAllStatesMap.put("qR2Plywalnia", new State("qR2Plywalnia", 2));
		listAllStatesMap.put("qBRSauna", new State("qBRSauna", 0));
		listAllStatesMap.put("qR1Sauna", new State("qR1Sauna", 1));
		listAllStatesMap.put("qR2Sauna", new State("qR2Sauna", 2));
		listAllStatesMap.put("qR3Sauna", new State("qR3Sauna", 3));
		listAllStatesMap.put("qR4Sauna", new State("qR4Sauna", 4));
		listAllStatesMap.put("qR5Sauna", new State("qR5Sauna", 5));
		
		// Setting starting state
		startingState = "q0";
		
		// Setting available symbols
		String[] availableSymbols = {"1", "2", "5", "K"};
		setAvailableSymbols(availableSymbols);
		
		//Setting accepting states
		addAcceptingStates(listAllStatesMap.get("qBRPlywalnia"));
		addAcceptingStates(listAllStatesMap.get("qR1Plywalnia"));
		addAcceptingStates(listAllStatesMap.get("qR2Plywalnia"));
		addAcceptingStates(listAllStatesMap.get("qBRSauna"));
		addAcceptingStates(listAllStatesMap.get("qR1Sauna"));
		addAcceptingStates(listAllStatesMap.get("qR2Sauna"));
		addAcceptingStates(listAllStatesMap.get("qR3Sauna"));
		addAcceptingStates(listAllStatesMap.get("qR4Sauna"));
		addAcceptingStates(listAllStatesMap.get("qR5Sauna"));
		
		setTransitions("q0", "1 q1;2 q2;5 q5;K q0");
		setTransitions("q1", "1 q2;2 q3;5 q6;K q1");
		setTransitions("q2", "1 q3;2 q4;5 q7;K q2");
		setTransitions("q3", "1 q4;2 q5;5 q8;K q3");
		setTransitions("q4", "1 q5;2 q6;5 q9;K q4");
		setTransitions("q5", "1 q6;2 q7;5 q10;K q5");
		setTransitions("q6", "1 q7;2 q8;5 q11;K q6");
		setTransitions("q7", "1 q8;2 q9;5 q12;K q7");
		setTransitions("q8", "1 q9;2 q10;5 qR1Sauna;K q8");
		setTransitions("q9", "1 q10;2 q11;5 qR2Sauna;K qBRPlywalnia");
		setTransitions("q10", "1 q11;2 q12;5 qR3Sauna;K qR1Plywalnia");
		setTransitions("q11", "1 q12;2 qR1Sauna;5 qR4Sauna;K qR2Plywalnia");
		setTransitions("q12", "1 qR1Sauna;2 qR2Sauna;5 qR5Sauna;K qBRSauna");

		setTransitions("qBRPlywalnia", "1 qBRPlywalnia;2 qBRPlywalnia;5 q0;K qBRPlywalnia");
		setTransitions("qR1Plywalnia", "1 qR1Plywalnia;2 qR1Plywalnia;5 q0;K qR1Plywalnia");
		setTransitions("qR2Plywalnia", "1 qR2Plywalnia;2 qR2Plywalnia;5 q0;K qR2Plywalnia");
		
		setTransitions("qBRSauna", "1 qBRSauna;2 qBRSauna;5 q0;K qBRSauna");
		setTransitions("qR1Sauna", "1 qR1Sauna;2 qR1Sauna;5 q0;K qR1Sauna");
		setTransitions("qR2Sauna", "1 qR2Sauna;2 qR2Sauna;5 q0;K qR2Sauna");
		setTransitions("qR3Sauna", "1 qR3Sauna;2 qR3Sauna;5 q0;K qR3Sauna");
		setTransitions("qR4Sauna", "1 qR4Sauna;2 qR4Sauna;5 q0;K qR4Sauna");
		setTransitions("qR5Sauna", "1 qR5Sauna;2 qR5Sauna;5 q0;K qR5Sauna");
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
