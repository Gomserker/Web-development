import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

//Easy Maintenance

//Spring이 추구하는 스타일(유지 보수)

//수정이 일어날만한 부분: 외부파일(C:\Users\MSI\Desktop\reo)
//Java에서는 그 파일을 불러다가 사용

public class EMain {
	public static void main(String[] args) throws IOException {

		// 물건 구매후 포인트 적립
		// 구매 가격: 1000
		// 적립 포인트: 100
		// 적립율: 10%
		try {
			Scanner input = new Scanner(System.in);

			System.out.print("구매가격: ");
			int price = input.nextInt();

			FileReader fr = new FileReader("C:\\Users\\MSI/Desktop/reo/pointRate.txt");
			BufferedReader br = new BufferedReader(fr);
			String pr = br.readLine();
			
			double pointRate = Double.parseDouble(pr);
			double point = price * pointRate;
			System.out.printf("적립포인트: %.1f점", point);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
