package controller.userController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import com.google.gson.Gson;
import database.dao.DaoUser;
import model.User;
import utils.json.JsonUtil;
import utils.json.adapters.UserAdapter;

@WebServlet("/user/update/*")
public class UpdateUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateUserController() {
		super();
	}

	@Override
	protected void doPut(HttpServletRequest req, javax.servlet.http.HttpServletResponse resp)
			throws ServletException, IOException {
		
		Gson jsonUtil = JsonUtil.registerAdapter(new User(), new UserAdapter());
		DaoUser daoUser = new DaoUser();
		User user = new User();
		
		try {
			req.setCharacterEncoding("UTF-8");
			String json = JsonUtil.readJsonFromRequest(req);
			user = (User) jsonUtil.fromJson(json, User.class);
			user.setId(Integer.parseInt(req.getParameter("id")));
			
			daoUser.update(user);
			if(daoUser.update(user)) {
				resp.getWriter().println("Usuário atualizado com sucesso.");	
			} else {
				resp.getWriter().println("Não foi possível atualizar ");
			}

			
		} catch (Exception e) {
			e.printStackTrace();
			resp.getWriter().println("Ocorreu um erro!");
		}
	}

}
