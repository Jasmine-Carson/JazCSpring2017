package textExcel;

public abstract class RealCell implements Cell {

	String fullCell;
	double doubleValue;
	
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
		return fullCell;
	}
	
	public double getDoubleValue(){
		return doubleValue;
	}
	
	public RealCell(String value){
		fullCell = value;
		if  (value.indexOf(".")>=0){
			String [] parts = value.split(".");
			int whole = Integer.parseInt(parts[0]);
			int decimal = Integer.parseInt(parts[1]);
			double dec = (double) decimal;
			while(dec>=1){
				dec = dec/10;
			}
			doubleValue = (double) whole + dec;
		}
		else{
			doubleValue = (double) Integer.parseInt(value);
		}
	}

}
