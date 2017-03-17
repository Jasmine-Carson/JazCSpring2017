package textExcel;

public class PercentCell extends RealCell implements Cell {

	private String fullCell;
	private double doubleValue;
	
	@Override
	public String abbreviatedCellText() {
		System.out.println();
		String abbText = fullCell;
		abbText = abbText+"%";
		while(abbText.length()<10){
			abbText = abbText + " ";
		}
		if(abbText.length()>10){
			abbText = abbText.substring(0, 9)+"%";
		}
		return abbText;
	}

	@Override
	public String fullCellText() {
		return (doubleValue+"");
	}
	
	public PercentCell(String value){
		super(value);
		doubleValue = doubleValue/100.0;
	}

}