package DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//롬복 사용
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dept {
	
	private int deptno;
	private String dname;
	private String loc;
	
//	public Dept(int deptno, String dname, String loc) {
//		this.deptno=deptno;
//		this.dname=dname;
//		this.loc=loc;
//		
//	}

//	@Override
//	public String toString() {
//		return "Dept [deptno=" + deptno + ", dname=" + dname + ", loc=" + loc + "]";
//	}
	
	
	
}
