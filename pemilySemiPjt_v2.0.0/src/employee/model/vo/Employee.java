package employee.model.vo;

public class Employee {
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
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpPw() {
		return empPw;
	}
	public void setEmpPw(String empPw) {
		this.empPw = empPw;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getEmpGrade() {
		return empGrade;
	}
	public void setEmpGrade(int empGrade) {
		this.empGrade = empGrade;
	}
	public String getEmpGender() {
		return empGender;
	}
	public void setEmpGender(String empGenter) {
		this.empGender = empGenter;
	}
	public String getEmpPhone() {
		return empPhone;
	}
	public void setEmpPhone(String empPhone) {
		this.empPhone = empPhone;
	}
	public String getEmpAddr() {
		return empAddr;
	}
	public void setEmpAddr(String empAddr) {
		this.empAddr = empAddr;
	}
	public String getEmpPic() {
		return empPic;
	}
	public void setEmpPic(String empPic) {
		this.empPic = empPic;
	}
	public String getEmpPath() {
		return empPath;
	}
	public void setEmpPath(String empPath) {
		this.empPath = empPath;
	}
	public int getEmpStore() {
		return empStore;
	}
	public void setEmpStore(int empStore) {
		this.empStore = empStore;
	}
	public String getEmpEnter() {
		return empEnter;
	}
	public void setEmpEnter(String empEnter) {
		this.empEnter = empEnter;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	
}
