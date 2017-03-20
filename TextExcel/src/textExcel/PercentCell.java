package textExcel;

public class PercentCell extends RealCell implements Cell {

	private String fullCell;
	private double doubleValue;
	
	@Override
	public String abbreviatedCellText() {
		String abbText = fullCell;
		if(abbText.indexOf(".")>=0){
			abbText = abbText.substring(0, abbText.indexOf("."))+"%";
		}
		while(abbText.length()<10){
			abbText = abbText + " ";
		}
		return abbText;
	}

	@Override
	public String fullCellText() {
		return (doubleValue+"");
	}
	
	public double getDoubleValue(){
		return doubleValue;
	}
	
	public PercentCell(String value){
		super(value);
		doubleValue = Double.parseDouble(value);
		fullCell = value;
		doubleValue = doubleValue/100.0;
	}

}
