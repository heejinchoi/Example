
public class VariableScopeExample {
	public static void main(String[] args) {
		int v1 = 15;
		if(v1>10) {
			int v2 = v1 - 10;
		}
		//int v3 = v1 + v2 + 5;		=> v2 변수를 사용할 수 없기 때문에 컴파일 에러가 생김
		
		int v4 = 0;
		if(v1>10) {
			v4 = v1 - 10;
		}
		System.out.println("v4의 값은: " + v4);
	}

}
