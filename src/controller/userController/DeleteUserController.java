package controller.userController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import database.connection.ConnectionFactory;
import database.dao.DaoUser;

@WebServlet("/user/delete/")
public class DeleteUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteUserController() {
		super();

	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		DaoUser daoUser = new DaoUser();
		try {
			req.setCharacterEncoding("UTF-8");
			Integer id = Integer.parseInt(req.getParameter("id"));

			if (daoUser.removeById(id)) {
				resp.getWriter().println("Usu�rio removido com sucesso.");
			} else {
				resp.getWriter().println("N�o existe usu�rio com este id.");
			}

		} catch (Exception e) {
			e.printStackTrace();
			resp.getWriter().println("N�o foi poss�vel remover o usu�rio.");
		} finally {
			ConnectionFactory.fecharConexao();
		}

	}
}
