import java.awt.Button;
import java.awt.HeadlessException;
import java.util.Observable;
import java.util.Observer;

public class TTTButton extends Button implements Observer{
	
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	int index = 0;
	public TTTButton(int index) throws HeadlessException {
		super();
		this.index = index;
	}
	
	public void update(Observable o, Object arg)
	{
		String symbol = (String) arg;
		setLabel(symbol);
	}

}
