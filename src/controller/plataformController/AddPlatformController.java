package controller.plataformController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import database.connection.ConnectionFactory;
import database.dao.DaoPlatform;
import model.Platform;
import utils.json.JsonUtil;
import utils.json.adapters.PlatformAdapter;


@WebServlet("/platform/add")
public class AddPlatformController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Gson jsonUtil = JsonUtil.registerAdapter(new Platform(), new PlatformAdapter());
		DaoPlatform daoPlatform = new DaoPlatform();
		Platform platform = new Platform();
		
		try {
			request.setCharacterEncoding("UTF-8");
			String json = JsonUtil.readJsonFromRequest(request);
			platform = (Platform) jsonUtil.fromJson(json, Platform.class);
			System.out.println(platform);
			daoPlatform.add(platform);
			response.getWriter().println("Platforma adicionada com sucesso.");
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().println("Não foi possível adicionar a plataforma.");
		} finally {
			ConnectionFactory.fecharConexao();
		}
	}

}
