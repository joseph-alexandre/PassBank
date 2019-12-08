package controller.plataformController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.dao.DaoPlatform;
import model.Platform;
import utils.json.JsonUtil;

@WebServlet("/platform/list/*")
public class GetPlatformByIdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetPlatformByIdController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DaoPlatform daoPlatform = new DaoPlatform();
		Platform platform = new Platform();
		try {
			Integer id = Integer.parseInt(request.getParameter("id"));
			if(daoPlatform.getById(id) != null) {
				platform = daoPlatform.getById(id);
				response.getWriter().println(JsonUtil.convertToJson(platform));
			} else {
				response.getWriter().println("Não existe Plataforma com este id.");
			}
			
		} catch (Exception e) {
			response.getWriter().println("Não foi possível listar a Plataforma.");
			
		}
	}
	
}
