package textExcel;

public class FormulaCell extends RealCell implements Cell {

	private String fullCell;
	
	@Override
	public String abbreviatedCellText() {
		//just trims to 10 spaces for now
		String abbText = getDoubleValue()+"";
		while(abbText.length()<10){
			abbText = abbText + " ";
		}
		if(abbText.length()>10){
			abbText = abbText.substring(0, 9)+")";
		}
		return abbText;
	}

	@Override
	public String fullCellText() {
		return getDoubleValue()+"";
	}
	
	public FormulaCell(String value){
		super(value);
		fullCell = value;
	}
	
	public double getDoubleValue(){
		//do operations
		String[] parts = fullCell.split(" ");
		double num1 = Double.parseDouble(parts[1]);
		double num2 = 0;
		for (int i = 3; i<parts.length; i=i+2){
			num2 = Double.parseDouble(parts[i]);
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
