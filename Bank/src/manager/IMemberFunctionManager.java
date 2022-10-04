package manager;

import java.util.ArrayList;

import model.MemberInfo;


public interface IMemberFunctionManager {
	
	// 회원가입	
	void memJoin(String memId, String memPw, String memName);
	
	// 모든 회원 정보 리스트
	ArrayList<MemberInfo> selectAllMember();
	
	MemberInfo selectMemberByMemId(String id);
	
	MemberInfo selectMember(int memNum);

	
}


