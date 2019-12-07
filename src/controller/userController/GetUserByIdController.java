package controller.userController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import database.dao.DaoUser;
import model.User;
import utils.json.JsonUtil;

@WebServlet("/user/list/*")
public class GetUserByIdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetUserByIdController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DaoUser daoUser = new DaoUser();
		User user = new User();
		try {
			Integer id = Integer.parseInt(request.getParameter("id"));
			if(daoUser.getById(id) != null) {
				user = daoUser.getById(id);
				response.getWriter().println(JsonUtil.convertToJson(user));
			} else {
				response.getWriter().println("Não existe usuário com este id.");
			}
			
		} catch (Exception e) {
			response.getWriter().println("Não foi possível listar o usuário.");
			
		}
	}
	
}
