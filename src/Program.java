import java.util.List;

import DAO.DeptDao;
import DTO.Dept;

/*
App 서버 구성 ( MVC 패턴) >> 웹 
잘 하는 것만 해 

Model (java) >> DTO(데이터를 담을 수 있는 클래스) , DAO(데이터를 처리할 수 있는 클래스(JDBC API)) , SERVICE
View (UI)    >> html , jsp 등등 >> 현재 console 화면제어 (main 정도)
Controller   >> 중앙제어 (통제) >> 웹의 접근 통제 >> 요청과 응답처리 >> JAVA >> Servlet(웹용 자바파일) (main 정도)
 */

public class Program {
	public static void main(String[] args) {
		
		//요청 받고 처리 담당
		//mvc에서 c의 역할(Controller)과 View의 역할까지 담당한다는 것
		
		//1. 부서 테이블 데이터 전체 조회하면 출력
		DeptDao dao = new DeptDao();
		List<Dept> deptlist = dao.getDeptAllList();
		
		for(Dept dept:deptlist) {
			System.out.println(dept);
		}
		
		
		System.out.println("===================================");
		
		//2. 부서 번호로 조건 조회 -> 1건의 부서 정보 화면 출력
		deptlist = dao.getDeptLikeList();
		for(Dept dept:deptlist) {
			System.out.println(dept);
		}
		
		System.out.println("===================================");
		
		//3. 데이터 삽입(1건) (50,'IT','SEOUL')
		dao.insertDept();
		//3.1 다시 전체 조회
		deptlist = dao.getDeptAllList();
		
		for(Dept dept:deptlist) {
			System.out.println(dept);
		}
		
		System.out.println("===================================");
		
		//4. 방금 전 삽입했던 데이터 수정
		//4.1 부서이름('IT_UP','BUSAN')
		dao.updateDept(50,"IT_UP","BUSAN");
		
		//4.2 다시 전체 조회
		deptlist = dao.getDeptAllList();
		
		for(Dept dept:deptlist) {
			System.out.println(dept);
		}
		
		System.out.println("===================================");
		
		
		//5. 방금 전 수정했던 데이터 삭제
		//5.1 부서번호 50번 삭제
		dao.deleteDept(50);
		//5.2 다시 전체 조회
		deptlist = dao.getDeptAllList();
		
		for(Dept dept:deptlist) {
			System.out.println(dept);
		}
	}
}
