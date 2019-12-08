package controller.recordController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.connection.ConnectionFactory;
import database.dao.DaoRecord;
import model.Record;
import utils.json.JsonUtil;

@WebServlet("/record/list/*")
public class GetRecordByIdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetRecordByIdController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DaoRecord daoRecord = new DaoRecord();
		Record record = new Record();
		try {
			Integer id = Integer.parseInt(request.getParameter("id"));
			if(daoRecord.getById(id) != null) {
				record = daoRecord.getById(id);
				response.getWriter().println(JsonUtil.convertToJson(record));
			} else {
				response.getWriter().println("Não existe registro com este id.");
			}
			
		} catch (Exception e) {
			response.getWriter().println("Não foi possível listar o registro.");	
		} finally {
			ConnectionFactory.fecharConexao();
		}
	}
	
}
