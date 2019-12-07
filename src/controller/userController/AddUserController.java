package controller.userController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import database.connection.ConnectionFactory;
import database.dao.DaoUser;
import model.User;
import utils.json.JsonUtil;
import utils.json.adapters.UserAdapter;

@WebServlet("/user/add")

public class AddUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public AddUserController() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Gson jsonUtil = JsonUtil.registerAdapter(new User(), new UserAdapter());
		DaoUser daoUser = new DaoUser();
		User user = new User();
		
		try {
			request.setCharacterEncoding("UTF-8");
			String json = JsonUtil.readJsonFromRequest(request);
			user = (User) jsonUtil.fromJson(json, User.class);
			System.out.println(user);
			daoUser.add(user);
			response.getWriter().println("Usuário adicionado com sucesso.");
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().println("Não foi possível adicionar o usuário.");
		} finally {
			ConnectionFactory.fecharConexao();
		}
	}

}
