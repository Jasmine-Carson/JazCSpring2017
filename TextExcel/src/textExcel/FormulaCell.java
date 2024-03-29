package textExcel;

public class FormulaCell extends RealCell implements Cell {

	private String fullCell;
	Cell[][] spread;
	
	@Override
	public String abbreviatedCellText() {
		String abbText = getDoubleValue()+"";
		while(abbText.length()<10){
			abbText = abbText + " ";
		}
		if(abbText.length()>10){
			abbText = abbText.substring(0, 10);
		}
		return abbText;
	}

	@Override
	public String fullCellText() {
		return fullCell;
	}
	
	public FormulaCell(String value, Cell[][] spread){
		super(value);
		fullCell = value;
		this.spread = spread;
	}
	
	public double getDoubleValue(){
		String[] parts = this.fullCell.split(" ");
		if(parts[1].equalsIgnoreCase("SUM")){
			SpreadsheetLocation loc1 = new SpreadsheetLocation(parts[2].substring(0, parts[2].indexOf("-")));
			SpreadsheetLocation loc2 = new SpreadsheetLocation(parts[2].substring(parts[2].indexOf("-")+1));
			double ans = 0;
			for(int i = loc1.getCol(); i<=loc2.getCol(); i++){
				for(int j = loc1.getRow(); j<= loc2.getRow(); j++){
					RealCell value = (RealCell) spread[i][j];
					ans = ans + value.getDoubleValue();
				}
			}
			return ans;
		}
		else if(parts[1].equalsIgnoreCase("AVG")){
			double ans = 0;
			int counter = 0;
			SpreadsheetLocation loc1 = new SpreadsheetLocation(parts[2].substring(0, parts[2].indexOf("-")));
			SpreadsheetLocation loc2 = new SpreadsheetLocation(parts[2].substring(parts[2].indexOf("-")+1));
			for(int i = loc1.getCol(); i<=loc2.getCol(); i++){
				for(int j = loc1.getRow(); j<= loc2.getRow(); j++){
					RealCell value = (RealCell) spread[i][j];
					ans = ans + value.getDoubleValue();
					counter++;
				}
			}
			ans = ans/counter;
			return ans;
		}
		else{
			double num1 = 0;
			RealCell value;
			SpreadsheetLocation loc;
			if(isCell(parts[1])){
				loc = new SpreadsheetLocation(parts[1]);
				value = (RealCell) spread[loc.getCol()][loc.getRow()];
				num1 = value.getDoubleValue();
			}
				else{
					num1 = Double.parseDouble(parts[1]);
				}
				double num2 = 0;
				for (int i = 3; i<parts.length; i=i+2){
					if(isCell(parts[i])){
						loc = new SpreadsheetLocation(parts[i]);
						value = (RealCell) spread[loc.getCol()][loc.getRow()];
						num2 = value.getDoubleValue();
					}
					else{
						num2 = Double.parseDouble(parts[i]);
					}
					if(parts[i-1].equals("+")){
						num1 = num2 + num1;
					}
					else if(parts[i-1].equals("-")){
						num1 = num1-num2;
					}
					else if(parts[i-1].equals("*")){
						num1 = num1*num2;
					}
					else if(parts[i-1].equals("/")){
						num1 = num1/num2;
					}
				}
				return num1;
		}
		
	}
	
	
	public boolean isCell(String maybe){
		for(char c = 'A'; c <= 'L'; c++){
			if(maybe.charAt(0)==c){
				return true;
			}
		}
		for(char c = 'a'; c <= 'l'; c++){
			if(maybe.charAt(0)==c){
				return true;
			}
		}
		return false;
	}
	
	
}
