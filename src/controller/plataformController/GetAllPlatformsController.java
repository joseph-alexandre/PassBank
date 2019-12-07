package controller.plataformController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.dao.DaoPlatform;
import model.Platform;
import utils.json.JsonUtil;

@WebServlet("/platform/list/")
public class GetAllPlatformsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public GetAllPlatformsController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DaoPlatform daoPlatform = new DaoPlatform();
		List<Platform> platforms = new ArrayList<>();
		try {
			platforms.addAll(daoPlatform.getAll());
			response.getWriter().println(JsonUtil.convertToJson(platforms));
		} catch (Exception e) {
			response.getWriter().println("Não foi possível listar as plataformas.");
			
		}
		
	}
	

}
