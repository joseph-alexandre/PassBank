package controller.plataformController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.connection.ConnectionFactory;
import database.dao.DaoPlatform;


@WebServlet("/platform/delete/")
public class DeletePlatformController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeletePlatformController() {
		super();

	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		DaoPlatform daoPlatform = new DaoPlatform();
		try {
			req.setCharacterEncoding("UTF-8");
			Integer id = Integer.parseInt(req.getParameter("id"));

			if (daoPlatform.removeById(id)) {
				resp.getWriter().println("Plataforma removida com sucesso.");
			} else {
				resp.getWriter().println("Não existe plataforma com este id.");
			}

		} catch (Exception e) {
			e.printStackTrace();
			resp.getWriter().println("Não foi possível remover a plataforma.");
		} finally {
			ConnectionFactory.fecharConexao();
		}

	}
}
