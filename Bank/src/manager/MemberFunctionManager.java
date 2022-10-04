package manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import model.MemberInfo;

public class MemberFunctionManager implements IMemberFunctionManager {
	// 회원 정보 관련 된 것(통장 계좌 관련 아님)

	private static MemberFunctionManager instance;
	private HashMap<Integer, MemberInfo> memberList;
	private Connection conn;
	
	private MemberFunctionManager(Connection conn) {
		this.conn = conn;
	}
	
	public static MemberFunctionManager getInstance(Connection conn) {
		if(instance == null) {
			instance = new MemberFunctionManager(conn);
		}
		return instance;
	}

	
	@Override
	public void memJoin(String memId, String memPw, String memName) {
		
		String sql = "INSERT INTO memberList (memNum ,id, pw, NAME) VALUES (?, ?, ?, ?)";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			// memNum은 자동으로 AUTO_INCREMENT 될 예정.
			pstmt.setInt(1, 0);
			pstmt.setString(2, memId);
			pstmt.setString(3, memPw);
			pstmt.setString(4, memName);
			
			int result = pstmt.executeUpdate();
			
			if(result == 1) {
				System.out.println("회원 가입 성공함~");
			} else {
				System.out.println("회원 가입 실패함.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}


	@Override
	public ArrayList<MemberInfo> selectAllMember() {
		ArrayList<MemberInfo> memberList = new ArrayList<>();
		
		String sql = "SELECT * FROM memberList";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberInfo memberInfo = new MemberInfo(rs.getInt("memNum"),
						rs.getString("ID"),
						rs.getString("PW"),
						rs.getString("NAME"));
				memberList.add(memberInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return memberList;
	}

	@Override
	public MemberInfo selectMember(int memNum) {
		
		MemberInfo memberinfo = new MemberInfo();
		
		String sql = "SELECT * FROM memberList WHERE memNum=?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memNum);
			
			ResultSet rs = pstmt.executeQuery(sql);
			
			if(rs==null) {
				return null;
			}
			
			while(rs.next()) {
				memberinfo.setMemId("id");
				memberinfo.setMemPw(rs.getString("pw"));
				memberinfo.setMemName(rs.getString("NAME"));
				memberinfo.setMemNum(rs.getInt("memNum"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
		return memberinfo;
	}

	
	@Override
	public MemberInfo selectMemberByMemId(String id) {
		MemberInfo memberinfo = null;
		
		String sql = "SELECT * FROM memberList WHERE id=?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				memberinfo = new MemberInfo(
									rs.getInt("memNum"),
									rs.getString("id"),
									rs.getString("pw"),
									rs.getString("name"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memberinfo;
	}
}
