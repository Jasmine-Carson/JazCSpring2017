package textExcel;

public abstract class RealCell implements Cell {

	private String fullCell;
	private double doubleValue;
	
	@Override
	public String abbreviatedCellText() {
		String abbText = fullCell;
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
		return (fullCell+"");
	}
	
	public double getDoubleValue(){
		return doubleValue;
	}
	
	public RealCell(String value){
		fullCell = value;
		//make decimal value
		doubleValue = Double.parseDouble(value);
	}

}
