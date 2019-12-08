package controller.recordController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import database.connection.ConnectionFactory;
import database.dao.DaoRecord;
import model.Record;
import utils.json.JsonUtil;
import utils.json.adapters.RecordAdapter;


@WebServlet("/record/add")
public class AddRecordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Gson jsonUtil = JsonUtil.registerAdapter(new Record(), new RecordAdapter());
		DaoRecord daoRecord = new DaoRecord();
		Record record = new Record();
		
		try {
			request.setCharacterEncoding("UTF-8");
			String json = JsonUtil.readJsonFromRequest(request);
			record = (Record) jsonUtil.fromJson(json, Record.class);
			daoRecord.add(record);
			response.getWriter().println("Registro adicionado com sucesso.");
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().println("Não foi possível adicionar o registro.");
		} finally {
			ConnectionFactory.fecharConexao();
		}
	}

}
