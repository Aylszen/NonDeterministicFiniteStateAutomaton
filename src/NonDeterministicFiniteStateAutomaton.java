import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class NonDeterministicFiniteStateAutomaton {

	public static void main(String[] args) {
		Data data = new Data();
		data.setInitialValues();
		String[] inputDataStringTable = Data.readDataFromFile();
		Data.printInputData(inputDataStringTable);
		for (String inputDataString : inputDataStringTable) {
			start2(inputDataString);

		}
	}

	@SuppressWarnings("unchecked")
	static public void start2(String inputDataString) {
		ArrayList<String> automatonPathList = new ArrayList<>();
		State startingState = Data.listAllStatesMap.get(Data.startingState);
		Set<State> stateSet = new HashSet<State>();
		stateSet.add(startingState);
		Data.printStateAndTransitions(stateSet);
		//Data.saveAutomatonPath(automatonPathList, stateSet);
		//automatonPathList.add("-->(" + startingState + ")");
		System.out.println("#####");

		for (int i = 0; i < inputDataString.length(); i++) {
			System.out.println("Entered symbol:" + inputDataString.charAt(i));
			Set<State> tempStateList = new HashSet<State>();
			for (State state : stateSet) {
				ArrayList<State> tempNextStateList = state.goToNextState(String.valueOf(inputDataString.charAt(i)));
				for (State nextState : tempNextStateList) {
					tempStateList.add(nextState);
				}
			}
			stateSet.clear();
			stateSet = tempStateList;
			//Data.saveAutomatonPath(automatonPathList, stateSet);
			Data.printStateAndTransitions(stateSet);
			System.out.println("#####");
		}

		//System.out.println(automatonPathList);
		for (State state : stateSet) {
			if (Data.acceptingStates.contains(state)) {
				System.out.println(state.getOutputString() + "\n");
				return;
			}
		}
		System.out.println("NonDeterministicFiniteStateAutomaton is not correct!\n");
	}
}