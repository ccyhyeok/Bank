package model;

public class MemberInfo {

//	CREATE TABLE memberinfo(
//			memNum INT auto_increment primary key, 
//			id VARCHAR(50), 
//			pw VARCHAR(50), 
//			NAME VARCHAR(50)
//			);
	
	
	//필드
	private int memNum;
	private String memId;
	private String memPw;
	private String memName;
	
	
	public MemberInfo(int memNum, String memId, String memPw, String memName) {
		this.memNum = memNum;
		this.memId = memId;
		this.memPw = memPw;
		this.memName = memName;
	}
	
	public MemberInfo() {}


	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	
	public String getMemPw() {
		return memPw;
	}
	public void setMemPw(String memPw) {
		this.memPw = memPw;
	}
	
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}

	public int getMemNum() {
		return memNum;
	}

	public void setMemNum(int memNum) {
		this.memNum = memNum;
	}
	

	
	
	
	
	
}
