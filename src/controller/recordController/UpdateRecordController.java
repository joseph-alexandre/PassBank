package controller.recordController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import com.google.gson.Gson;
import database.connection.ConnectionFactory;
import database.dao.DaoRecord;
import model.Record;
import utils.json.JsonUtil;
import utils.json.adapters.RecordAdapter;


@WebServlet("/record/update/*")
public class UpdateRecordController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateRecordController() {
		super();
	}

	@Override
	protected void doPut(HttpServletRequest req, javax.servlet.http.HttpServletResponse resp)
			throws ServletException, IOException {
		
		Gson jsonUtil = JsonUtil.registerAdapter(new Record(), new RecordAdapter());
		DaoRecord daoRecord = new DaoRecord();
		Record record = new Record();
		
		try {
			req.setCharacterEncoding("UTF-8");
			String json = JsonUtil.readJsonFromRequest(req);
			record = (Record) jsonUtil.fromJson(json, Record.class);
			record.setId(Integer.parseInt(req.getParameter("id")));
			
			if(daoRecord.update(record)) {
				resp.getWriter().println("Registro atualizado com sucesso.");	
			} else {
				resp.getWriter().println("Não foi possível atualizar o registro.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			resp.getWriter().println("Ocorreu um erro!");
		} finally {
			ConnectionFactory.fecharConexao();
		}
	}

}
