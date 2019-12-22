import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class NonDeterministicFiniteStateAutomaton {

	public static void main(String[] args) {
		Data data = new Data();
		data.setInitialValues();
		String[] inputDataStringTable = Data.readDataFromFile();
		Data.printInputData(inputDataStringTable);
		start2(inputDataStringTable);
	}
	
	@SuppressWarnings("unchecked")
	static public void start2(String[] inputData) {
		State startingState = Data.listAllStatesMap.get(Data.startingState);
		Set<State> stateList = new HashSet<State>();
		stateList.add(startingState);
		Data.printStateAndTransitions(stateList);
		
		for(String dataElement : inputData)
		{
			for(int i=0; i < dataElement.length(); i++)
			{
				System.out.println(dataElement.charAt(i));
				Set<State> tempStateList = new HashSet<State>();
				for(State state : stateList)
				{
					ArrayList<State> tempNextStateList = state.goToNextState(String.valueOf(dataElement.charAt(i)));
					for (State nextState : tempNextStateList)
					{
						tempStateList.add(nextState);	
					}
				}
				System.out.println("#####");
				stateList.clear();
				stateList = tempStateList;
				Data.printStateAndTransitions(stateList);
			}
		}
	}
}