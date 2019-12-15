import java.util.HashMap;
import java.util.Map;

public class Transitions {
	Integer input;
	Map<String, State> listAllTransitionsMap = new HashMap<String, State>();

	public Transitions(String Value) {
		String[] stringAfterSemicolonSplit = Value.split(";");
		for (String stringElem : stringAfterSemicolonSplit) {
			String[] stringAfterSpaceSplit = stringElem.split(" ");
			listAllTransitionsMap.put(stringAfterSpaceSplit[0], Data.listAllStatesMap.get(stringAfterSpaceSplit[1]));
		}
	}

	public State selectNextState(String value) {
		System.out.println("Lista tranzycji:");
		System.out.println(listAllTransitionsMap);
		return listAllTransitionsMap.get(value);
	}
}