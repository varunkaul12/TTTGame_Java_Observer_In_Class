import java.applet.Applet;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Main extends Applet{
	
		Panel topPanel = new Panel();
		Panel boardPanel = new Panel();
		Panel bottomPanel = new Panel();
		Label turnLabel = new Label();
		Button startButton = new Button();
		TTTButton[] tttButton = new TTTButton[9];
		Player[] players = new Player[2];
		Player currentPlayer = null;
		DataCell[] cells = new DataCell[9];
	
		void swapPlayer()
		{
			currentPlayer = currentPlayer == players[0] ? players[1] : players[0];
		}
	
	@Override
	public void init() {
		
		currentPlayer = players[0] = new Player("Varun", "X");
		players[1] = new Player("John Doe", "O");
		
		super.init();
		resize(250, 430);
		add(topPanel);
		add(boardPanel);
		add(bottomPanel);
		// Add top panel and its components
		topPanel.setPreferredSize(new Dimension(250,90));
		topPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		topPanel.add(turnLabel);
		turnLabel.setText("Game is not started yet!!!");
		// Add Center Board
		boardPanel.setPreferredSize(new Dimension(250, 250));
		boardPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		for(int i = 0; i < 9; i++)
		{
			tttButton[i] = new TTTButton(i);
			cells[i] = new DataCell("");
			cells[i].addObserver(tttButton[i]);
			
			tttButton[i].setPreferredSize(new Dimension(70,70));
//			tttButton[i].setEnabled(false);
			boardPanel.add(tttButton[i]);
			tttButton[i].addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
						
				
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub			
					TTTButton source = (TTTButton)e.getSource();
					int index = source.getIndex();
					cells[index].setValue(currentPlayer.getSymbol());
				
					currentPlayer.MarkCell(source.index);
					source.setLabel(currentPlayer.getSymbol());
					source.setEnabled(false);
					
					if (currentPlayer.amIaWinner()) {
						turnLabel.setText(currentPlayer.getPlayerName()+ " Wins!!!");
						for (int i = 0; i < 9; i++) {
							tttButton[i].setEnabled(false);
						}
						startButton.setLabel("Re-start");
					} else {
						swapPlayer();
						turnLabel.setText(("It is "+ currentPlayer.getPlayerName() + " s turn"));
					}
					
					if(startButton.getLabel().equalsIgnoreCase("Re-start"))
					{

						players[0].clearAll();
						players[1].clearAll();
						for (int i = 0; i < 9; i++) {
							tttButton[i].setEnabled(true);
							tttButton[i].setLabel("");
						}
						
					}
					
				}
			});
		}
		//Add bottom Layout
		bottomPanel.setPreferredSize(new Dimension(250, 90));
		bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		startButton.setLabel("Start");
		startButton.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
				arg0.getSource();
				turnLabel.setText("Game has Started!!!!");					
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		bottomPanel.add(startButton);
		
		}
	
}
