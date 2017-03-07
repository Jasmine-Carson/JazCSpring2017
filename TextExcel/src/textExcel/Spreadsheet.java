package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid
{
	private Cell[][] spreadsheet;
	
	public Spreadsheet(){
		spreadsheet = new Cell[12][20];
		for(int i = 0; i < 12; i++){
			for (int j = 0; j < 20; j++){
				spreadsheet[i][j] = new EmptyCell();
			}
		}
	}
	
	@Override
	public String processCommand(String command)
	{
		String [] words = command.split(" ",3);
	//clear cells
		if(words[0].equals("clear")){
			clearCells(words);
			return getGridText();
		}
	//set cell values
		if (words.length>2){
			if (words[1].equals("=")){
				setCell(words);
				return getGridText();
			}
		}
		
		return "";
	}

	@Override
	public int getRows()
	{
		return 20;
	}

	@Override
	public int getCols()
	{
		return 12;
	}

	@Override
	public Cell getCell(Location loc)
	{		
		return spreadsheet[loc.getCol()][loc.getRow()];
	}

	@Override
	public String getGridText()
	{
		String topline = "   |A         |B         |C         |D         |E         |F         |G         |H         |I         |J         |K         |L         |";
		String gridtext = "\n";
		for(int i = 0; i< spreadsheet[0].length; i++){
			gridtext = gridtext+(i+1);
			if(i+1<10){
				gridtext=gridtext+"  |";
			}
			else{
				gridtext=gridtext+" |";
			}
			for(int j = 0; j< spreadsheet.length; j++){
				gridtext=gridtext+spreadsheet[j][i].abbreviatedCellText()+"|";
			}
			gridtext=gridtext+"\n";
		}
		String fulltext = topline + gridtext;
		return fulltext;
	}
	
	public void clearCells(String[] clear){
		if(clear.length == 2){
			SpreadsheetLocation clearcell = new SpreadsheetLocation(clear[1]);
			spreadsheet[clearcell.getRow()][clearcell.getCol()] = new EmptyCell();
		}
		else{
			for(int i = 0; i < 12; i++){
				for (int j = 0; j < 20; j++){
					spreadsheet[i][j] = new EmptyCell();
				}
			}
		}
		return;
	}
	
	public void setCell(String[] values){
		//this only works for text cells!!!!!!
		//you're going to have to fix it later for real cells!!!!!
		SpreadsheetLocation textcell = new SpreadsheetLocation(values[0]);
		String text = values[2];
		text = text.substring(1, text.length()-2);
		spreadsheet[textcell.getCol()][textcell.getRow()] = new TextCell(text);
		return;
	}

}