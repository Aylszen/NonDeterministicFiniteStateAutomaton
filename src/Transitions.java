import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Transitions {
	Integer input;
	Map<String, ArrayList<State>> listAllTransitionsMap = new HashMap<String, ArrayList<State>>();

	public Transitions(String Value) {
		if (Value.length() != 0) {
			String[] stringAfterSemicolonSplit = Value.split(";");
			for (String stringElem : stringAfterSemicolonSplit) {
				String[] stringAfterSpaceSplit = stringElem.split(" ");
				String[] stringAfterCommaSplit = stringAfterSpaceSplit[1].split(",");
				ArrayList<State> listOfStates = new ArrayList<State>();
				for (String stateName : stringAfterCommaSplit) {
					listOfStates.add(Data.listAllStatesMap.get(stateName));
				}
				listAllTransitionsMap.put(stringAfterSpaceSplit[0], listOfStates);
			}
		}
	}

	public ArrayList<State> selectNextState(String string) {
		ArrayList<State> tempListOfStates = listAllTransitionsMap.get(string);
		if (null != tempListOfStates) {
			return tempListOfStates;
		} else {
			return new ArrayList<State>();
		}
	}
}