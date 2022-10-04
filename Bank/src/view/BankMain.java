package view;

import java.sql.Connection;
import java.util.Scanner;

import app.Bank.manager.BankSystem;
import app.Bank.manager.DBConnectionManager;
import app.Bank.model.MemberInfo;

public class BankMain {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		// console 창에 입력 시 인식 시켜주는 것
		
		Connection conn = DBConnectionManager.getInstance().getConnection();
		// DB하고 연동 될 수 있도록 하는 것 
		// 위에 한 번만 선언 해줌으로서 불필요한 Connection Error 방지 갸능
		
		MemberInfo loginSession = null;
		// MemberInfo 형태로 로그인 여부 파악 예정.
		BankSystem bankSystem = null;

		try {
			bankSystem = BankSystem.getInstance(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}

		boolean run = true;

		while(run) {
			// run이 되고 있다면

			if(loginSession == null ) {
				System.out.println("------------------------------");
				System.out.println(" 1. 회원가입 | 2. 로그인 ");
				System.out.println("------------------------------");
				System.out.print("메뉴 번호를 입력해주세요. >> ");

				int menuNum = scanner.nextInt();

				switch(menuNum) {

					case 1:
						System.out.println("회원가입할 아이디를 입력해주세요.");
						System.out.println(">> ");
						String id = scanner.next();
						System.out.println("회원가입할 비밀번호를 입력해주세요.");
						System.out.println(">> ");
						String pw = scanner.next();
						System.out.println("회원가입할 이름을 입력해주세요.");
						System.out.println(">> ");
						String name = scanner.next();
						
						bankSystem.Join(id, pw, name);
						break;
						
					case 2:
						System.out.println("로그인할 아이디를 입력해주세요.");
						String loginId = scanner.next();
						System.out.println( loginId +"의 비밀번호를 입력해주세요.");
						String loginPw = scanner.next();

						loginSession = bankSystem.login(loginId, loginPw);
						
						break;
				}
				
			} else {
				System.out.println("------------------------------");
				System.out.println(loginSession.getMemId() +  "님 환영합니다.");
				System.out.println("메뉴를 선택해주세요.");
				System.out.println("1. 계좌 생성");
				System.out.print(">> ");
				
				int input = scanner.nextInt();
				
				switch(input) {
						
					case 1:
						
						bankSystem.registAccount(loginSession.getMemNum());
						System.out.println(" ※ 계좌 번호는 자동 생성됩니다.");
						
						break;
	
				}

				break;
			}
		}
	}

}


















