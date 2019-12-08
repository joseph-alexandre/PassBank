package controller.recordController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import database.connection.ConnectionFactory;
import database.dao.DaoRecord;


@WebServlet("/record/delete/")
public class DeleteRecordsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteRecordsController() {
		super();

	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		DaoRecord daoRecord = new DaoRecord();
		try {
			req.setCharacterEncoding("UTF-8");
			Integer id = Integer.parseInt(req.getParameter("id"));

			if (daoRecord.removeById(id)) {
				resp.getWriter().println("Registro removida com sucesso.");
			} else {
				resp.getWriter().println("Não existe registro com este id.");
			}

		} catch (Exception e) {
			e.printStackTrace();
			resp.getWriter().println("Não foi possível remover o registro.");
		} finally {
			ConnectionFactory.fecharConexao();
		}

	}
}
