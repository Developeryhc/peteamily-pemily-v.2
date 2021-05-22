package pro.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import inPro.model.vo.InPro;

public class ToyDao {

	public ArrayList<InPro> selectProduct(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<InPro> list = new ArrayList<InPro>();
		String query = "select inpro_no,inpro_name,inpro_price,inpro_pic from INPRO where inpro_sn=20";  //토이만
		InPro pro = null;
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				pro = new InPro();
				pro.setInProNo(rset.getInt("inpro_no"));
				pro.setInProName(rset.getString("inpro_name"));
				pro.setInProPrice(rset.getInt("inpro_price"));
				pro.setInProPic(rset.getString("inpro_pic"));
				list.add(pro);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

}
