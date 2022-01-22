import java.util.Scanner;

//유지보수
//Bad Maintenance Example

//JAR로 한번 배포, 전달 후 포인트 정책 변경
//플젝 열기 또는 새로 작성 -> 소스코드 수정 -> 테스트 -> 재배포(JAR) -> 다시 전달
//그런데 2주 뒤에 설날이라고 또 이벤트한답시고 적립률을 다시 10%로 올리라네? 시발?
//위 프로세스 반복

public class BMain {
	public static void main(String[] args) {
		
		//물건 구매후 포인트 적립
		//구매 가격: 1000
		//적립 포인트: 100
		//적립율: 10%
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("구매가격: ");
		int price = input.nextInt();
		
		double pointRate = 0.1;
		double point = price * pointRate;
		
		System.out.printf("적립포인트: %.1f점", point);
		
	}
}
