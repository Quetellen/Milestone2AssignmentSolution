package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Participant;
import model.ParticipantDAO;

@WebServlet(urlPatterns = { "/ControllerP", "/mainp", "/insertp", "/selectp", "/updatep", "/deletep" })
public class ControllerP extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ParticipantDAO participantDAO = new ParticipantDAO();
	Participant participant = new Participant();

	public ControllerP() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		System.out.println(action);

		if (action.equals("/mainp")) {
			participants(request, response);
		} else if (action.equals("/insertp")) {
			newParticipants(request, response);
		} else if (action.equals("/selectp")) {
			listParticipants(request, response);
		} else if (action.equals("/updatep")) {
			updateParticipants(request, response);
		} else if (action.equals("/deletep")) {
			removeParticipants(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}

	// READ
	protected void participants(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Participant> list = participantDAO.listOfParticipants();

		request.setAttribute("participant", list);
		RequestDispatcher rd = request.getRequestDispatcher("zumbaParticipants.jsp");
		rd.forward(request, response);

	}

	// INSERT
	protected void newParticipants(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		participant.setPname(request.getParameter("pname"));
		participant.setPhone(request.getParameter("phone"));
		participant.setEmail(request.getParameter("email"));
		participant.setB_id(request.getParameter("b_id"));

		participantDAO.insertNewParticipant(participant);

		response.sendRedirect("mainp");
	}

	// UPDATE
	protected void listParticipants(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String p_id = request.getParameter("p_id");

		participant.setP_id(p_id);

		participantDAO.selectParticipants(participant);

		request.setAttribute("p_id", participant.getP_id());
		request.setAttribute("pname", participant.getPname());
		request.setAttribute("phone", participant.getPhone());
		request.setAttribute("email", participant.getEmail());
		request.setAttribute("b_id", participant.getB_id());

		RequestDispatcher rd = request.getRequestDispatcher("UpdateParticipant.jsp");
		rd.forward(request, response);
	}

	protected void updateParticipants(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		participant.setP_id(request.getParameter("p_id"));
		participant.setPname(request.getParameter("pname"));
		participant.setPhone(request.getParameter("phone"));
		participant.setEmail(request.getParameter("email"));
		participant.setB_id(request.getParameter("b_id"));

		participantDAO.updateParticipants(participant);
		response.sendRedirect("mainp");
	}

	// REMOVE

	protected void removeParticipants(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String p_id = request.getParameter("p_id");

		participant.setP_id(p_id);
		participantDAO.deleteParticipant(participant);
		response.sendRedirect("mainp");

	}
}
