package pro.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import inPro.model.vo.InPro;
import pro.model.dao.ToyDao;

public class ToyService {

	public ArrayList<InPro> selectProduct() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<InPro> list = new ToyDao().selectProduct(conn);
		JDBCTemplate.close(conn);
		// TODO Auto-generated method stub
		return list;
	}

}
