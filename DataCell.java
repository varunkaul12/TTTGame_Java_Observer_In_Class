import java.util.Observable;

public class DataCell extends Observable{
	
	private String symbol = "";
	public DataCell(String value) {
		super();
		this.value = value;
	}

	private String value = null;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
		setChanged();
		notifyObservers(value);
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	
}
