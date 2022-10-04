package model;

//CREATE TABLE accountInfo(
//memNum INT auto_increment primary key, 
//accNum varchar(50),
//balance varchar(50), 
//accpw varchar(50)
//);

public class AccountInfo {

	private int memNum;
	// 고유회원번호(join 용)
	private String accNum;
	// 계좌 번호(010 - 460076 - 26107처럼)
	private int balance;
	// 잔액
//	private String accPw;
//	// 계좌 비번
	
	public AccountInfo(String accNum, String accpw) {
		// TODO Auto-generated constructor stub
	}


	public int getMemNum() {
		return memNum;
	}
	public void setMemNum(int memNum) {
		this.memNum = memNum;
	}

	public String getAccNum() {
		return accNum;
	}
	public void setAccNum(String accNum) {
		this.accNum = accNum;
	}
	
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
//	public String getAccpw() {
//		return accPw;
//	}
//	public void setAccpw(String accpw) {
//		this.accPw = accpw;
//	}

	
	
	
	
	
	
}
