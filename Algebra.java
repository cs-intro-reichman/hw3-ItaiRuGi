// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
		   System.out.println(times(3,-4));
		   System.out.println(times(3,-1));
		   System.out.println(times(-5,-5));
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		//System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
		System.out.println(div(25,-7));
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		int ret = x1;
		int add = x2;
		if(x2 == 0){
			return x1;
		}
		if(x2 > 0){
		while(add > 0){
			ret ++;
			add --;
		}
		return ret;
	}
		if(x2 < 0){
			while(add < 0){
				ret --;
				add ++;
			}
			return ret;
		}
		return ret;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		int ret = x1;
		int min = x2;
		if(x2 > 0){
		while(min > 0){
			ret --;
			min --;
		}
		return ret;
	}
		else if(x2 == 0){
			return x1;
		}
		else if(x2 < 0){
			while(min < 0){

				ret ++;
				min ++;
			}
			return ret;
		}
		return ret;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		if (x1 == 0 || x2 == 0) {
            return 0;
        }
		int mult1 = x1;
		int mult2 = x2;
		boolean needspos = false;
		 if((mult1 > 0 && mult2 < 0) || (mult1 < 0 && mult2 > 0)){
			needspos = true;
		 }
		 if(mult1 < 0){
			mult1 = minus(0, mult1);
		 }
		 if(mult2 < 0){
			mult2 = minus(0, mult2);
		 }
        int ret = 0;
		for(int i = 0; i < mult2; i ++){
			ret = plus(ret, mult1);
		}
        
		if(needspos){
			ret = minus(0, ret);
		}
        
        return ret;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int ret = x;
		int base =x;
		int pow = n;
		if(pow == 0){
			return 1;
		}else{
		for(int i = 0; i < minus(n, 1); i++){
			ret = times(ret, base);
		}
		return ret;
	}
	}
	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
			if(x2 == 0){
				return 0;
			}
			if(x2 > x1  || ((x2 < 0) && times(x2, -1) > x1)){
				return 0;
			}
			if(x1 == x2){
				return 1;
			}
			boolean finalneg = false;
			if((x2 < 0 && x1 > 0) || (x1 < 0 && x2 > 0)){
				finalneg = true;
			}
			int numerator = x1;
			int denominator = x2;
			if(numerator < 0){
				numerator = times(numerator, -1);
			}
			if(denominator < 0){
				denominator = times(denominator, -1);
			}
			int divider = 0;
			
			while(times(denominator, divider) <= numerator){
				if(times(divider, denominator) == numerator){
					return divider;
					
				}else{
				
				divider ++;
				}
			}
			divider --;
			return finalneg ? times(divider, -1) : divider;

		}
		
	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		
		int x = div(x1, x2);
		return minus(x1, times(x, x2));
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		int ret = 1;
		while(pow(ret, 2) <= x){
			ret ++;
		}
		return minus(ret, 1);
	}	  	  
}