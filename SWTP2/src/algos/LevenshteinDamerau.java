package algos;

public class LevenshteinDamerau implements Distance{

		public final static int editDistance(String from, String to){
			
			return 0;
		}
		

	    private static int minimum(int a, int b, int c) {                            
	        return Math.min(Math.min(a, b), c);                                      
	    }                                                                            
	        
	     
	    public int computeDistance(String lhs, String rhs) {      
	    	   int[][] distance = new int[lhs.length() + 1][rhs.length() + 1];        
               
	           for (int i = 0; i <= lhs.length(); i++)                                 
	               distance[i][0] = i;                                                  
	           for (int j = 1; j <= rhs.length(); j++)                                 
	               distance[0][j] = j;                                                  
	                                                                                    
	           for (int i = 1; i <= lhs.length(); i++)                                 
	               for (int j = 1; j <= rhs.length(); j++)                             
	                   distance[i][j] = minimum(                                        
	                           distance[i - 1][j] + 1,                                  
	                           distance[i][j - 1] + 1,                                  
	                           distance[i - 1][j - 1] + ((lhs.charAt(i - 1) == rhs.charAt(j - 1)) ? 0 : 1))+damerauexpansion(i-1,j-1,lhs,rhs);                                                                       
	           return distance[lhs.length()][rhs.length()];          
	           
	       }  
	    
	    public int damerauexpansion(int i,int j, String lhs, String rhs){
	    	
	    	if(i<lhs.length()-1&&j<rhs.length()-1){
	    		if(i==lhs.length()||j==rhs.length()){
	    			return 0;
	    		}
	    		if(lhs.charAt(i)!=lhs.charAt(i+1)&&lhs.charAt(i)==rhs.charAt(j+1)&&lhs.charAt(i+1)==rhs.charAt(j)){
	    			return -1;
	    		}
	    	}
	    	
	    	return 0;
	    }

	}


