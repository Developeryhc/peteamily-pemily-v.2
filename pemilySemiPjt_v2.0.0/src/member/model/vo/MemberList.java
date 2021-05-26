package member.model.vo;

public interface MemberList{
	// Member 테이블
	public int getMemberNo();
	public void setMemberNo(int memberNo);
	public String getMemberId();
	public void setMemberId(String memberId);
	public String getMemberPw();
	public void setMemberPw(String memberPw);
	public String getMemberName();
	public void setMemberName(String memberName);
	public int getMemberGrade();
	public void setMemberGrade(int memberGrade);
	public String getMemberGender();
	public void setMemberGender(String memberGender);
	public String getMemberPhone();
	public void setMemberPhone(String memberPhone);
	public String getMemberAddr();
	public void setMemberAddr(String memberAddr);
	public String getMemberEmail();
	public void setMemberEmail(String emailmemberEmail);
	public String getMemberEnter();
	public void setMemberEnter(String memberEnter);
	public int getMemberAn();
	public void setMemberAn(int memberAn);
	// Member, Employee 테이블 공용 메소드
	public int getSort();
	public void setSort(int sort);
	// Employee 테이블
	public int getEmpNo();
	public void setEmpNo(int empNo);
	public String getEmpId();
	public void setEmpId(String empId);
	public String getEmpPw();
	public void setEmpPw(String empPw);
	public String getEmpName();
	public void setEmpName(String empName);
	public int getEmpGrade();
	public void setEmpGrade(int empGrade);
	public String getEmpGender();
	public void setEmpGender(String empGenter);
	public String getEmpPhone();
	public void setEmpPhone(String empPhone);
	public String getEmpAddr();
	public void setEmpAddr(String empAddr);
	public String getEmpPic();
	public void setEmpPic(String empPic);
	public String getEmpPath();
	public void setEmpPath(String empPath);
	public int getEmpStore();
	public void setEmpStore(int empStore);
	public String getEmpEnter();
	public void setEmpEnter(String empEnter);
}