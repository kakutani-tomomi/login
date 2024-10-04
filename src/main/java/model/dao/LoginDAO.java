package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {

	public String loginCheck(String loginId,String password) throws ClassNotFoundException, SQLException {
		String name = null;
		String sql = "SELECT name FROM m_login WHERE login_id = ? AND password = ?;";
		//データベースとの接続・sqlの準備
		try(Connection con = ConnectionManager.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql)){
			//プレースホルダに値を設定
			pstmt.setString(1, loginId);
			pstmt.setString(2, password);
			//sqlの実行
			ResultSet res = pstmt.executeQuery();
			if(res.next()) {
				name = res.getString("name");
			}
		}
		return name;
	}
}
