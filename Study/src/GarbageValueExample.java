
public class GarbageValueExample {
	public static void main(String[] args) {
		byte var1 = 125;
		int var2 = 125;
		
		for(int i=0; i<5; i++) {
			var1++;
			var2++;
			System.out.println("var1= " + var1 +"\t"+ "var2= " + var2);
		}
		//byte 타입의 범위를 넘어서 증가될 때 byte 타입의 최소범위로 다시 돌아가서 증가시켜주게 된다.
	}

}
