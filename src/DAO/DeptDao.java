package DAO;
//CRUD 함수 ....
//추가사항 (LIKE 사용해서 ... 부서이름 검색 하는 함수 추가)

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTO.Dept;
import UTILS.ConnectionHelper;

//1. 전체조회
//2. 조건조회
//3. 삽입
//4. 수정
//5. 삭제
//6. 문자열 LIKE 검색 (부서이름)
public class DeptDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	
	//삽입
	public void insertDept() {
		int row = 0;
		
		try {
			conn = ConnectionHelper.getConnection("oracle");
			String sql = "insert into Dept values (?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 50);
			pstmt.setString(2, "IT");
			pstmt.setString(3, "SEOUL");
			
			row = pstmt.executeUpdate();
			if(row>0) {
				System.out.println("insert_row >> "+row);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
	}
	
	//업데이트
	public void updateDept(int deptno, String dname, String loc) {
		int row = 0;
		
		try {
			conn = ConnectionHelper.getConnection("oracle");
			
			String sql = "update Dept set dname=?, loc=? where deptno=?";
			pstmt = conn.prepareStatement(sql);
			
			
			pstmt.setString(1, dname);
			pstmt.setString(2, loc);
			pstmt.setInt(3, deptno);
			
			row = pstmt.executeUpdate();
			if(row>0) {
				System.out.println("update_row >> "+row);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
	} 
	
	//전체조회
	public List<Dept> getDeptAllList() {
		List<Dept> deptlist = new ArrayList<>();
		ResultSet rs = null;
		try {
			conn = ConnectionHelper.getConnection("oracle");
			String sql = "select * from dept";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();//executeQuery() >> 실행시키기
			
			while(rs.next()) {
				Dept dept = new Dept(rs.getInt("deptno"),rs.getString("dname"),rs.getString("loc"));
				deptlist.add(dept);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
		return deptlist;
	}  
	//executeQuery() >> select 에서만
	//like 조건 조회
	public List<Dept> getDeptLikeList() {
		List<Dept> deptlist = new ArrayList<>();
		ResultSet rs = null;
		try {
			conn = ConnectionHelper.getConnection("oracle");
			String sql = "select * from dept where dname like ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%E%");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Dept dept = new Dept(rs.getInt("deptno"),rs.getString("dname"),rs.getString("loc"));
				deptlist.add(dept);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
		return deptlist;
	}  
	//삭제
	//executeUpdate() >> insert, update, delete에서만
	public void deleteDept(int deptno) {

		try {
			conn = ConnectionHelper.getConnection("oracle");
			String sql = "delete from dept where deptno=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
		
	}  
}
