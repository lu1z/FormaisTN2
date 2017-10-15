public class Program {
	
	static int state;
	static char currentEntry;

	static String currentSentense;

	public static void main(String [] args){
		 new GUI();
	}
	
	public static void operator(String sentense) {
		GUI.concatText("\noperador aritmético: " + sentense);
	}
	
	public static void accept(String sentense) {
		GUI.concatText("\nsentença válida: " + sentense);
	}
	
	public static void reject(String sentense) {
		GUI.concatText("\nERRO – sentença inválida: " + sentense);
	}
	
	public static void invalid(String sentense) {
		GUI.concatText("\nERRO – símbolo(s) inválido(s): " + sentense);
	}

	// a = 0, b = 1, c = 2, d = 3
	public static void Start(String sentense) {
		boolean[] finalStates = {false, false, false, false, true, false, true};
		int[][] transitionTable = {{1, 2, -1, -1}, {0, 3, 4, -1}, {-1, 3, 4, -1}, {-1, 2, -1, -1}, {-1, -1, 5, 6}, {-1, -1, 4, -1}, {-1, -1, -1, 6}};
		
		while(!sentense.isEmpty()) {
			state = 0;
			currentSentense = "";
		
			while(!sentense.isEmpty() && (currentEntry = sentense.charAt(0)) != ' ' && (currentEntry = sentense.charAt(0)) != '\n') {
				switch(currentEntry) {
					case '+' :
					case '-' :
					case '*' :
					case '/' :
						if(state != -1 && state != -2 && !currentSentense.isEmpty())
							if(finalStates[state])
								accept(currentSentense);
							else
								reject(currentSentense);
						else
							if(!currentSentense.isEmpty() && state != -2)
								reject(currentSentense);
							else
								if(!currentSentense.isEmpty())
									invalid(currentSentense);
						
						operator(currentEntry + "");
						currentSentense = "";
						currentEntry = '\0';
						state = 0;
						break;
					case 'a' :
					case 'b' :
					case 'c' :
					case 'd' :
						if(state != -1 && state != -2)
							state = transitionTable[state][currentEntry - 97];
						break;
					default :
						if(currentSentense.isEmpty())
							state = -2;
						else
							if(state != -2)
								state = -1;
							else
								state = -2;
				}
				if(currentEntry != '\0')
					currentSentense = currentSentense + currentEntry;
				sentense = sentense.substring(1);
			}
			if(state != -1 && state != -2 && !currentSentense.isEmpty())
				if(finalStates[state])
					accept(currentSentense);
				else
					reject(currentSentense);
			else
				if(!currentSentense.isEmpty() && state != -2)
					reject(currentSentense);
				else
					if(!currentSentense.isEmpty())
						invalid(currentSentense);
				
			if(!sentense.isEmpty())
				sentense = sentense.substring(1);
		}
	}
}