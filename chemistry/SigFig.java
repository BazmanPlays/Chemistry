public class SigFig
{
	public SigFig() {
		
	}
	
	public static int sigFigCount(double input){
	    String inStr = String.valueOf(input);
	    int sigFig = 0;
	    boolean contain = inStr.contains(".");
	    if(contain && (inStr.charAt(1) != '.')) return inStr.length() - 1;
	    else if((int)Math.floor(input) == input){
    	        inStr = "" + (int)Math.floor(input);
    	        for(int i = 0; i < inStr.length(); i++){
    	        if(inStr.charAt(i) != '0'){
    	            sigFig++;
    	        }
    	    }
	    }
	    else if(inStr.charAt(1) == '.'){
	        for(int i = 2; i < inStr.length(); i++){
	            if(inStr.charAt(i) != '0'){
	                return inStr.length() - i;
	            }
	        }
	    }
	    return sigFig;
	}
}
