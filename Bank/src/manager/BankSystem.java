package manager;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import model.MemberInfo;

public class BankSystem {

	private static BankSystem instance;
	private MemberFunctionManager memManager;
	private AccountFunctionManager accManager;

	private BankSystem (Connection conn) {
		memManager = MemberFunctionManager.getInstance(conn);
		accManager = AccountFunctionManager.getInstance(conn);
	}

	public static BankSystem getInstance(Connection conn) throws IOException {
		if(instance == null)
			instance = new BankSystem(conn);
		return instance;
	}

	public void Join(String memId, String memPw, String memName) {

		/* 중복 아이디 있을 경우 가입 못하게 처리*/
		ArrayList<MemberInfo> memberList = memManager.selectAllMember();

		for(MemberInfo mem : memberList) {
			if(mem.getMemId().equals(memId)) {
				System.out.println("중복 아이디가 존재합니다.");
				return;
			}
		}
		memManager.memJoin(memId, memPw, memName);
	}


	public MemberInfo login(String memId, String memPw) {

		MemberInfo loginSession = memManager.selectMemberByMemId(memId);

		if (loginSession!=null) {

			if (loginSession.getMemPw().equals(memPw)) {
				System.out.println("로그인 되었습니다.");
				return loginSession;	
			} else {
				System.out.println("비밀번호를 다시 확인 해주세요.");
				return null;
			}
		}
		System.out.println("회원 정보가 존재하지 않습니다.");
		return null;
	}
	
	public void registAccount(int memNum) {
		accManager.registAccount(memNum);
	}









}
