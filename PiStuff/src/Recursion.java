public class Recursion {
	public static void main(String[] args){
		System.out.println(changePi("xxpixpi"));
		System.out.println(changePi("x"));
		System.out.println(changePi("xpix"));
		System.out.println(changePi("pipi"));
		System.out.println(changePi("pip"));
	}
	
	public static String changePi(String str){
		if(str.length()<=2){
			if(str.equals("pi")){
				return "3.14";
			}
			else{
				return str;
			}
		}
		else if(str.indexOf("pi")>=0){
			if(str.indexOf("pi")>0){
				str = str.substring(0, str.indexOf("pi"))+"3.14"+str.substring(str.indexOf("pi")+2);
			}
			else{
				str = "3.14"+str.substring(2);
			}
			return changePi(str);
		}
		else{
			return str;
		}
	}
}
