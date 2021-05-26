package member.model.vo;

public class Member implements MemberList {
	// 회원번호
	private int memberNo;
	// 회원아이디(UNI)
	private String memberId;
	// 회원비밀번호
	private String memberPw;
	// 회원이름
	private String memberName;
	// 회원등급(DFT)
	private int memberGrade;
	// 회원성별(CHK)
	private String memberGender;
	// 회원전화번호
	private String memberPhone;
	// 회원주소
	private String memberAddr;
	// 회원이메일
	private String memberEmail;
	// 가입일(DFT)
	private String memberEnter;
	// 분양예정
	private int memberAn;
	// 회원 list로 뽑아올때 정렬해 no를 매기는 변수
	private int sort;
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Member(int memberNo, String memberId, String memberPw, String memberName, int memberGrade,
			String memberGender, String memberPhone, String memberAddr, String emailmemberEmail, String memberEnter,
			int memberAn, int sort) {
		super();
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberGrade = memberGrade;
		this.memberGender = memberGender;
		this.memberPhone = memberPhone;
		this.memberAddr = memberAddr;
		this.memberEmail = emailmemberEmail;
		this.memberEnter = memberEnter;
		this.memberAn = memberAn;
		this.sort = sort;
	}
	@Override
	public int getMemberNo() {
		return memberNo;
	}
	@Override
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	@Override
	public String getMemberId() {
		return memberId;
	}
	@Override
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	@Override
	public String getMemberPw() {
		return memberPw;
	}
	@Override
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	@Override
	public String getMemberName() {
		return memberName;
	}
	@Override
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	@Override
	public int getMemberGrade() {
		return memberGrade;
	}
	@Override
	public void setMemberGrade(int memberGrade) {
		this.memberGrade = memberGrade;
	}
	@Override
	public String getMemberGender() {
		return memberGender;
	}
	@Override
	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}
	@Override
	public String getMemberPhone() {
		return memberPhone;
	}
	@Override
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	@Override
	public String getMemberAddr() {
		return memberAddr;
	}
	@Override
	public void setMemberAddr(String memberAddr) {
		this.memberAddr = memberAddr;
	}
	@Override
	public String getMemberEmail() {
		return memberEmail;
	}
	@Override
	public void setMemberEmail(String emailmemberEmail) {
		this.memberEmail = emailmemberEmail;
	}
	@Override
	public String getMemberEnter() {
		return memberEnter;
	}
	@Override
	public void setMemberEnter(String memberEnter) {
		this.memberEnter = memberEnter;
	}
	@Override
	public int getMemberAn() {
		return memberAn;
	}
	@Override
	public void setMemberAn(int memberAn) {
		this.memberAn = memberAn;
	}
	@Override
	public int getSort() {
		return sort;
	}
	@Override
	public void setSort(int sort) {
		this.sort = sort;
	}
	@Override
	public int getEmpNo() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void setEmpNo(int empNo) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getEmpId() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setEmpId(String empId) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getEmpPw() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setEmpPw(String empPw) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getEmpName() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setEmpName(String empName) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int getEmpGrade() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void setEmpGrade(int empGrade) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getEmpGender() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setEmpGender(String empGenter) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getEmpPhone() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setEmpPhone(String empPhone) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getEmpAddr() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setEmpAddr(String empAddr) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getEmpPic() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setEmpPic(String empPic) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getEmpPath() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setEmpPath(String empPath) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int getEmpStore() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void setEmpStore(int empStore) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getEmpEnter() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setEmpEnter(String empEnter) {
		// TODO Auto-generated method stub
		
	}

}