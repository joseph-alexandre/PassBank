package controller.recordController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import database.connection.ConnectionFactory;
import database.dao.DaoRecord;
import model.Record;
import utils.json.JsonUtil;

@WebServlet("/record/list")
public class GetAllRecordsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public GetAllRecordsController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DaoRecord daoRecord = new DaoRecord();
		List<Record> records = new ArrayList<>();
		try {
			records.addAll(daoRecord.getAll());
			response.getWriter().println(JsonUtil.convertToJson(records));
		} catch (Exception e) {
			response.getWriter().println("Não foi possível listar os registros.");
			
		} finally {
			ConnectionFactory.fecharConexao();
		}
		
	}
	

}
