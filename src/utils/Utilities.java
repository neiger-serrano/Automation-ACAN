package utils;

public class Utilities {
	
	// Utility methods
	public String randomEmail(){
		String allowedChars = "abcdefghiklmnopqrstuvwxyz";
		int stringLength = 8;
		String randomstring ="";
				   
		for (int i=0; i<stringLength; i++){
			double rnum=0;
			rnum = Math.floor(Math.random()*allowedChars.length());
			randomstring += allowedChars.substring((int)rnum,(int)rnum+1);
		}
		return randomstring += "@" + randomstring + ".com";
	}
	
	public String randomUserName(){
		String allowedChars = "abcdefghiklmnopqrstuvwxyz";
		int stringLength = 8;
		String randomstring ="";
				   
		for (int i=0; i<stringLength; i++){
			double rnum=0;
			rnum = Math.floor(Math.random()*allowedChars.length());
			randomstring += allowedChars.substring((int)rnum,(int)rnum+1);
		}
		return randomstring;
	}

}
