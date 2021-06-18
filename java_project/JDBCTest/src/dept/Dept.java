package dept;

// 부서 정보를 저장하는 기능 클래스
public class Dept { // 사용자 입력 data와 db dept데이터를 저장
	
	private int deptno; // 부서번호
	private String dname; // 부서이름
	private String loc; // 부서위치
	
	
	public Dept(int deptno, String dname, String loc) {
		super();
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}


	public int getDeptno() {
		return deptno;
	}


	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}


	public String getDname() {
		return dname;
	}


	public void setDname(String dname) {
		this.dname = dname;
	}


	public String getLoc() {
		return loc;
	}


	public void setLoc(String loc) {
		this.loc = loc;
	}


	@Override
	public String toString() { // 디버깅 용
		return "Dept [deptno=" + deptno + ", dname=" + dname + ", loc=" + loc + "]";
	}
	
	
	
}
