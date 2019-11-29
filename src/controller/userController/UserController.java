package controller.userController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Login;
import utils.json.JsonUtil;

@WebServlet("/user/cadastrar")
public class UserController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	Login login = new Login("userBla", "passBla");
	
	public UserController() {
        super();
        
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	PrintWriter out = resp.getWriter();
    	resp.setContentType("application/json");
    	resp.setCharacterEncoding("UTF-8");
    	out.print(JsonUtil.convertToJson(login));
    	out.flush();
    }

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
	}
}
