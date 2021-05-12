package ch13.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.naming.*;
import javax.sql.DataSource;
public class PdsItemDao {
//	singleton
	private static PdsItemDao instance = new PdsItemDao();
	private PdsItemDao() {}
	public static PdsItemDao getInstance() {
		return instance;
	}
//	DataBase Connection Pool
	private Connection getConnection() {
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/OracleDB");
			conn = ds.getConnection();	
		}catch (Exception e) {
			System.out.println("연결 에러 : "+e.getMessage());
		}
		return conn;
	}
	public int insert(PdsItem pi) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sqlId = "select nvl(max(id),0)+1 from pds_item"; // sequence사용 가능
		String sql = "insert into pds_item values (?,?,?,?)";
		Connection conn = getConnection();
		try {
			pstmt = conn.prepareStatement(sqlId);
			rs = pstmt.executeQuery();
			rs.next();
			int id = rs.getInt(1);
			pstmt.close();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.setString(2, pi.getFileName());
			pstmt.setInt(3, pi.getFileSize());
			pstmt.setString(4, pi.getDescription());
			
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			}catch (Exception e) {		}
		}
		return result;
	}
	public List<PdsItem> list() {
		List<PdsItem> list = new ArrayList<PdsItem>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from pds_item order by id desc";
		Connection conn = getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next() ) {
				PdsItem pi = new PdsItem();
				pi.setId(rs.getInt("id"));
				pi.setFileName(rs.getString("fileName"));
				pi.setFileSize(rs.getInt("fileSize"));
				pi.setDescription(rs.getString("description"));
				 
				list.add(pi);
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			}catch (Exception e) {		}
		}
		return list;
	}
}