package pro.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import inPro.model.vo.InPro;
import notice.model.dao.NoticeDao;
import notice.model.vo.Notice;
import pro.model.dao.ProductDao;
import pro.model.vo.product;

public class ProductService {

	public ArrayList<InPro> selectProduct() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<InPro> list = new ProductDao().selectProduct(conn);
		JDBCTemplate.close(conn);
		return list;
	}

	public ArrayList<InPro> select3Product() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<InPro> list = new ProductDao().select3Product(conn);
		JDBCTemplate.close(conn);
		return list;
	}




	public InPro selectOnePro(int inpro_no) {
	
		Connection conn = JDBCTemplate.getConnection();
		InPro pro = new ProductDao().selectOnePro(conn,inpro_no);
		JDBCTemplate.close(conn);
		return pro;
	}

}
