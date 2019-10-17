package fr.gtm.communes.servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fr.gtm.communes.Constantes;
import fr.gtm.communes.entities.Commune;
import fr.gtm.communes.services.CommuneServices;


@WebServlet("/CommuneByNomServlet")
public class CommuneByNomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CommuneServices service = (CommuneServices) getServletContext().getAttribute(Constantes.COMMUNE_SERVICE);
		String nomVille = request.getParameter("nomVille");
		String page = "";
		if(nomVille==null || nomVille.isEmpty()) {
			page="/index.jsp";
		}else {
			List<Commune> communes = service.getCommunesByNom(nomVille);
			request.setAttribute("communes", communes);
			page = "/show-communes.jsp";
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(page);
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
