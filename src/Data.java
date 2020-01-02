import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Data {

	static Map<String, State> listAllStatesMap = new HashMap<String, State>();
	static String startingState = new String();
	static ArrayList<State> acceptingStates = new ArrayList<State>();
	static ArrayList<String> availableSymbols = new ArrayList<String>();

	public void setInitialValues() {
		// Setting up states
		createStates(15);
		listAllStatesMap.put("X", new State("X", 0));
		// Setting starting state
		startingState = "q0";

		// Setting available symbols
		String[] availableSymbols = { "0", "1", "2", "3", "4", "a", "b", "c", "d", "e" };
		setAvailableSymbols(availableSymbols);

		// Setting accepting states
		addAcceptingStates(listAllStatesMap.get("q7"));
		listAllStatesMap.get("q7").setOutputString("Repetition found in numbers!");
		addAcceptingStates(listAllStatesMap.get("q14"));
		listAllStatesMap.get("q7").setOutputString("Repetition found in letters!");

		setTransitions("q0", "0 q1,q2;1 q1,q3;2 q1,q4;3 q1,q5;4 q1,q6;a q8,q9;b q8,q10;c q8,q11;d q8,q12;e q8,q13");
		setTransitions("q1", "0 q1,q2;1 q1,q3;2 q1,q4;3 q1,q5;4 q1,q6;a X;b X;c X;d X;e X");
		setTransitions("q2", "0 q7;1 X;2 X;3 X;4 X;a X;b X;c X;d X;e X");
		setTransitions("q3", "0 X;1 q7;2 X;3 X;4 X;a X;b X;c X;d X;e X");
		setTransitions("q4", "0 X;1 X;2 q7;3 X;4 X;a X;b X;c X;d X;e X");
		setTransitions("q5", "0 X;1 X;2 X;3 q7;4 X;a X;b X;c X;d X;e X");
		setTransitions("q6", "0 X;1 X;2 X;3 X;4 q7;a X;b X;c X;d X;e X");
		setTransitions("q7", "0 q7;1 q7;2 q7;3 q7;4 q7;a X;b X;c X;d X;e X");
		setTransitions("q8", "0 q7;1 q7;2 q7;3 q7;4 q7;a q8,q9;b q8,q10;c q8,q11;d q8,q12;e q8,q13");
		setTransitions("q9", "0 q7;1 q7;2 q7;3 q7;4 q7;a q14;b X;c X;d X;e X");
		setTransitions("q10", "0 q7;1 q7;2 q7;3 q7;4 q7;a X;b q14;c X;d X;e X");
		setTransitions("q11", "0 q7;1 q7;2 q7;3 q7;4 q7;a X;b X;c q14;d X;e X");
		setTransitions("q12", "0 q7;1 q7;2 q7;3 q7;4 q7;a X;b X;c X;d q14;e X");
		setTransitions("q13", "0 q7;1 q7;2 q7;3 q7;4 q7;a X;b X;c X;d X;e q14");
		setTransitions("q14", "0 q7;1 q7;2 q7;3 q7;4 q7;a q14;b q14;c q14;d q14;e q14");
		setTransitions("X", "");

	}

	public void createStates(int numberOfStates) {
		for (int i = 0; i < numberOfStates; i++) {
			String stateName = "q" + i;
			listAllStatesMap.put(stateName, new State(stateName, i));
		}
	}

	public void setAvailableSymbols(String[] symbols) {
		for (String symbol : symbols) {
			availableSymbols.add(symbol);
		}
	}

	public void setTransitions(String stateName, String allTransitions) {
		listAllStatesMap.get(stateName).setTransitions(allTransitions);
	}

	public void addAcceptingStates(State acceptingState) {
		acceptingStates.add(acceptingState);
	}

	public static void printStateAndTransitions(Set<State> stateList) {
		System.out.println("Current states:");
		System.out.println(stateList);
		System.out.println("Transitions:");
		for (State state : stateList) {
			System.out.println(state.transitions.listAllTransitionsMap);
		}
	}

	public static void printInputData(String[] inputDataStringTable) {
		System.out.println("Input data:");
		for (String inputDataStringElem : inputDataStringTable) {
			System.out.println(inputDataStringElem);
		}
		System.out.println("#####");

	}

	public static String[] readDataFromFile() {
		try {
			String file = "./data_input.txt";
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String currentLine = reader.readLine();
			String[] inputData = currentLine.split("#");
			reader.close();
			return inputData;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static void saveAutomatonPath(ArrayList<String> automatonPathList, Set<State> stateSet) {
		if (automatonPathList.isEmpty()) {
			String automatonString, leftBracket, rightBracket = new String();
			if (acceptingStates.contains(stateSet.iterator().next())) {
				leftBracket = "(";
				rightBracket = ")";
			} else {
				leftBracket = "((";
				rightBracket = "))";
			}
			automatonPathList.add(leftBracket + stateSet.iterator().next() + rightBracket + "-->");
		} else {
			Iterator<String> automatonPathListIter = automatonPathList.iterator();
			for (State state : stateSet) {
				String automatonString, leftBracket, rightBracket = new String();
				if (acceptingStates.contains(state)) {
					leftBracket = "(";
					rightBracket = ")";
				} else {
					leftBracket = "((";
					rightBracket = "))";
				}
				
				if (automatonPathListIter.hasNext()) {
					String automatonPath = automatonPathListIter.next();
					automatonPath = automatonPath + leftBracket + state + rightBracket;
				}
				else
				{
					automatonPathList.add( "-->" + leftBracket + state + rightBracket);
				}

			}
		}
	}
	
	public static void saveAutomatonPath2(ArrayList<String> automatonPathList, Set<State> stateSet) {
	
	}
}
