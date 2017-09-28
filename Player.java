
public class Player {
	
	private String playerName;
	private String symbol;
	private DataCell[] cell = new DataCell[9];
	
	public Player(String playerName, String symbol) {
		super();
		this.playerName = playerName;
		this.symbol = symbol;
		for (int i = 0; i < 9; i++) {
			cell[i] = new DataCell("");
		}
	}
	
    public void MarkCell(int index) {
        cell[index].setSymbol(this.symbol);
       
    }
    
	public void clearAll() {
		for (int i = 0; i < 9; i++) {
			cell[i].setSymbol("");
		}
	}
	
	public String getPlayerName() {
		return playerName;
	}
	
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	
	public String getSymbol() {
		return symbol;
	}
	
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	
	public boolean amIaWinner() {
		// for(int i= 0;i<9;i++){
		// System.out.println("Cell : "+cell[i].getSymbol());
		// }
		boolean amI = false;
		if (cell[0].getSymbol().equals(this.symbol)
				&& cell[1].getSymbol().equals(this.symbol)
				&& cell[2].getSymbol().equals(this.symbol)) {
			amI = true;
		} else if (cell[3].getSymbol().equals(this.symbol)
				&& cell[4].getSymbol().equals(this.symbol)
				&& cell[5].getSymbol().equals(this.symbol)) {
			amI = true;
		} else if (cell[6].getSymbol().equals(this.symbol)
				&& cell[7].getSymbol().equals(this.symbol)
				&& cell[8].getSymbol().equals(this.symbol)) {
			amI = true;
		} else if (cell[0].getSymbol().equals(this.symbol)
				&& cell[3].getSymbol().equals(this.symbol)
				&& cell[6].getSymbol().equals(this.symbol)) {
			amI = true;
		} else if (cell[1].getSymbol().equals(this.symbol)
				&& cell[4].getSymbol().equals(this.symbol)
				&& cell[7].getSymbol().equals(this.symbol)) {
			amI = true;
		} else if (cell[2].getSymbol().equals(this.symbol)
				&& cell[5].getSymbol().equals(this.symbol)
				&& cell[8].getSymbol().equals(this.symbol)) {
			amI = true;
		} else if (cell[0].getSymbol().equals(this.symbol)
				&& cell[4].getSymbol().equals(this.symbol)
				&& cell[8].getSymbol().equals(this.symbol)) {
			amI = true;
		} else if (cell[2].getSymbol().equals(this.symbol)
				&& cell[4].getSymbol().equals(this.symbol)
				&& cell[6].getSymbol().equals(this.symbol)) {
			amI = true;
		}
		return amI;
	}
	

}
