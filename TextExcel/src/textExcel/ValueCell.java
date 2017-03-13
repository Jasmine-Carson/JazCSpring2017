package textExcel;

public class ValueCell extends RealCell implements Cell {

	String fullCell;
	double doubleValue;
	
	public ValueCell(String value){
		super(value);
	}
	
	@Override
	public String abbreviatedCellText() {
		String abbText = fullCell;
		while(abbText.length()<=10){
			abbText = abbText + " ";
		}
		return abbText.substring(0, 9);
	}

	@Override
	public String fullCellText() {
		return ("\""+fullCell+"\"");
	}
	
	public double getDoubleValue(){
		return doubleValue;
	}
	
}
