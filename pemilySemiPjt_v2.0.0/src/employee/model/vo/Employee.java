package employee.model.vo;

import member.model.vo.MemberList;

public class Employee implements MemberList {
	private int empNo;
	private String empId;
	private String empPw;
	private String empName;
	private int empGrade;
	private String empGender;
	private String empPhone;
	private String empAddr;
	private String empPic;
	private String empPath;
	private int empStore;
	private String empEnter;
	private int sort;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int empNo, String empId, String empPw, String empName, int empGrade, String empGender,
			String empPhone, String empAddr, String empPic, String empPath, int empStore, String empEnter, int sort) {
		super();
		this.empNo = empNo;
		this.empId = empId;
		this.empPw = empPw;
		this.empName = empName;
		this.empGrade = empGrade;
		this.empGender = empGender;
		this.empPhone = empPhone;
		this.empAddr = empAddr;
		this.empPic = empPic;
		this.empPath = empPath;
		this.empStore = empStore;
		this.empEnter = empEnter;
		this.sort = sort;
	}
	@Override
	public int getEmpNo() {
		return empNo;
	}
	@Override
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	@Override
	public String getEmpId() {
		return empId;
	}
	@Override
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	@Override
	public String getEmpPw() {
		return empPw;
	}
	@Override
	public void setEmpPw(String empPw) {
		this.empPw = empPw;
	}
	@Override
	public String getEmpName() {
		return empName;
	}
	@Override
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	@Override
	public int getEmpGrade() {
		return empGrade;
	}
	@Override
	public void setEmpGrade(int empGrade) {
		this.empGrade = empGrade;
	}
	@Override
	public String getEmpGender() {
		return empGender;
	}
	@Override
	public void setEmpGender(String empGenter) {
		this.empGender = empGenter;
	}
	@Override
	public String getEmpPhone() {
		return empPhone;
	}
	@Override
	public void setEmpPhone(String empPhone) {
		this.empPhone = empPhone;
	}
	@Override
	public String getEmpAddr() {
		return empAddr;
	}
	@Override
	public void setEmpAddr(String empAddr) {
		this.empAddr = empAddr;
	}
	@Override
	public String getEmpPic() {
		return empPic;
	}
	@Override
	public void setEmpPic(String empPic) {
		this.empPic = empPic;
	}
	@Override
	public String getEmpPath() {
		return empPath;
	}
	@Override
	public void setEmpPath(String empPath) {
		this.empPath = empPath;
	}
	@Override
	public int getEmpStore() {
		return empStore;
	}
	@Override
	public void setEmpStore(int empStore) {
		this.empStore = empStore;
	}
	@Override
	public String getEmpEnter() {
		return empEnter;
	}
	@Override
	public void setEmpEnter(String empEnter) {
		this.empEnter = empEnter;
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
	public int getMemberNo() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void setMemberNo(int memberNo) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getMemberId() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setMemberId(String memberId) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getMemberPw() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setMemberPw(String memberPw) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getMemberName() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setMemberName(String memberName) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int getMemberGrade() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void setMemberGrade(int memberGrade) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getMemberGender() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setMemberGender(String memberGender) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getMemberPhone() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setMemberPhone(String memberPhone) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getMemberAddr() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setMemberAddr(String memberAddr) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getMemberEmail() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setMemberEmail(String emailmemberEmail) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getMemberEnter() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setMemberEnter(String memberEnter) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int getMemberAn() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void setMemberAn(int memberAn) {
		// TODO Auto-generated method stub
		
	}
	
}
