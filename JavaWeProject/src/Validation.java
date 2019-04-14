
public class Validation {
	
	public boolean checkNum(String str){
		
		 
		//calling this method will gives back true/false identifying
		//whether the string input was convertable to an integer 
		
		try{
			Long num= Long.parseLong(str);
		}catch(NumberFormatException e){
			return false;
			
		}
		
		return true;
	}

}
