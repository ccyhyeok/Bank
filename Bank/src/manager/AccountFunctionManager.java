package manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.MemberInfo;


public class AccountFunctionManager implements IAccountFunctionManager {

	private static AccountFunctionManager instance;

	private Connection conn;

	MemberInfo memberinfo;

	private AccountFunctionManager(Connection conn) {
		this.conn = conn;
	}

	public static AccountFunctionManager getInstance(Connection conn) {
		if(instance == null)
			instance = new AccountFunctionManager(conn);
		return instance; 
	}


	@Override
	public void registAccount(int memNum) {

		String sql = "INSERT INTO accountinfo (memNum, accNum, balance) VALUES (?, ?, ?)";

		long accNumPart1 = (long)(Math.random()*1000L);
		long accNumPart2 = (long)(Math.random()*1000000L);
		long accNumPart3 = (long)(Math.random()*100000L);

		String stracc1 = Long.toString(accNumPart1);
		String stracc2 = Long.toString(accNumPart2);
		String stracc3 = Long.toString(accNumPart3);

		String accNum = stracc1+ "-" + stracc2 + "-" +stracc3;


		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, memNum);
			pstmt.setString(2, accNum);
			pstmt.setLong(3, 0);

			int result = pstmt.executeUpdate();

			if(result == 1) {
				System.out.println("계좌 생성 성공");
				System.out.println("계좌 번호: " + accNum + ", 잔액: 0");
			} else {
				System.out.println("계좌 생성 실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}

}
