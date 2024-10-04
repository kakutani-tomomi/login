package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.entity.EmployeeBean;

public class EmployeeDAO {
	public EmployeeBean getDatail(int id) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM m_employee WHERE id = ?";
		EmployeeBean bean = null;
		try(Connection con = ConnectionManager.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, id);
			ResultSet res = pstmt.executeQuery();
			
			if(res.next()) {
				bean = new EmployeeBean();
				//beanに格納
				bean.setId(res.getInt("id"));
				bean.setName(res.getString("name"));
				bean.setHomeTown(res.getString("home_town"));
			}
		}return bean;
	}
}
