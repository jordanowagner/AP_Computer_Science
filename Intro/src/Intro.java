
public class Intro {
	
	public static void main(String args[]){
		Intro obj = new Intro();//Create an instance
//		System.out.println(obj.ret());
//		System.out.println(obj.stars(4));
//		System.out.println(obj.logic(false, false, false));
		System.out.println(obj.coins(30));
	}
	
	public int ret() {
		
		return 17;
		
	}
	
	public boolean logic(boolean a, boolean b, boolean c) {
		
		return a && b && c;
		
	}
	
	public String stars(int n) {
		
		String answer = "";
		for(int i = 0; i < n + 1; i++){
			for(int c = 0; c < i; c++){
				answer += "*";
			}
			answer += "\n";
		}
		return answer;
		
	}
	//Coins should return the minimum number of coins that can be traded for 5 and 2 cent coins
	public int coins(int n) {
		if (n == 0){
			return 0;
		} else if (n%5 == 0 && n%2 != 0){
			int answer = n/5;
			return answer;
		} else if (n%2 == 0 && n%5 != 0){
			int answer = n/2;
			return answer;
		} else if (n%5 == 0 && n%2 == 0){
			return n/5;
		}	else if (n%2 != 0 && n%5 != 0 ){
			int remainder5 = n%5;
			int remainderTry = (n%5 +5);
			if (remainder5%2 == 0){
				int answer1 = n/5;
				int answer2 = remainder5/2;
				return answer1+answer2;
			} else if(remainderTry%2 == 0){
				int answer1 = n/5-1;
				int answer2 = remainderTry/2;
				return answer1 + answer2;
			}
		}
		return -1;
	}
	
}