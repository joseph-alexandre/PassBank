package controller.userController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.connection.ConnectionFactory;
import database.dao.DaoUser;
import model.User;
import utils.json.JsonUtil;

@WebServlet("/user/list")
public class GetAllUsersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public GetAllUsersController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DaoUser daoUser = new DaoUser();
		List<User> users = new ArrayList<>();
		try {
			users.addAll(daoUser.getAll());
			response.getWriter().println(JsonUtil.convertToJson(users));
		} catch (Exception e) {
			response.getWriter().println("Não foi possível listar os usuários.");
			
		} finally {
			ConnectionFactory.fecharConexao();
		}
		
	}
	

}
