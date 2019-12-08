package controller.plataformController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import com.google.gson.Gson;
import database.connection.ConnectionFactory;
import database.dao.DaoPlatform;
import model.Platform;
import utils.json.JsonUtil;
import utils.json.adapters.PlatformAdapter;


@WebServlet("/platform/update/*")
public class UpdatePlatformController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdatePlatformController() {
		super();
	}

	@Override
	protected void doPut(HttpServletRequest req, javax.servlet.http.HttpServletResponse resp)
			throws ServletException, IOException {
		
		Gson jsonUtil = JsonUtil.registerAdapter(new Platform(), new PlatformAdapter());
		DaoPlatform daoPlatform = new DaoPlatform();
		Platform platform = new Platform();
		
		try {
			req.setCharacterEncoding("UTF-8");
			String json = JsonUtil.readJsonFromRequest(req);
			platform = (Platform) jsonUtil.fromJson(json, Platform.class);
			platform.setId(Integer.parseInt(req.getParameter("id")));
			
			if(daoPlatform.update(platform)) {
				resp.getWriter().println("Plataforma atualizada com sucesso.");	
			} else {
				resp.getWriter().println("Não foi possível atualizar a plataforma.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			resp.getWriter().println("Ocorreu um erro!");
		} finally {
			ConnectionFactory.fecharConexao();
		}
	}

}
