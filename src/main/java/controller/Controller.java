package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Batch;
import model.BatchDAO;

@WebServlet(urlPatterns = { "/Controller", "/main", "/insert", "/select", "/update", "/delete" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	BatchDAO batchDAO = new BatchDAO();
	Batch batch = new Batch();

	public Controller() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/main")) {
			batches(request, response);
		} else if (action.equals("/insert")) {
			newBatches(request, response);
		} else if (action.equals("/select")) {
			listBatches(request, response);
		} else if (action.equals("/update")) {
			updateBatches(request, response);
		} else if (action.equals("/delete")) {
			removeBatches(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}

	// Listar Batches
	protected void batches(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<Batch> list = batchDAO.listbatches();

		request.setAttribute("batch", list);
		RequestDispatcher rd = request.getRequestDispatcher("zumba.jsp");
		rd.forward(request, response);

	}

	// New Batch
	protected void newBatches(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		batch.setName(request.getParameter("name"));
		batch.setStartTime(request.getParameter("startTime"));
		batch.setEndTime(request.getParameter("endTime"));
		batch.setShift(request.getParameter("shift"));

		batchDAO.insertNewBatch(batch);

		response.sendRedirect("main");

	}

	// Editar Contato

	protected void listBatches(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String b_id = request.getParameter("b_id");

		batch.setB_id(b_id);

		batchDAO.selectBatch(batch);

		request.setAttribute("b_id", batch.getB_id());
		request.setAttribute("name", batch.getName());
		request.setAttribute("startTime", batch.getStartTime());
		request.setAttribute("endTime", batch.getEndTime());
		request.setAttribute("shift", batch.getShift());

		RequestDispatcher rd = request.getRequestDispatcher("updateBatch.jsp");
		rd.forward(request, response);

	}

	protected void updateBatches(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		batch.setB_id(request.getParameter("b_id"));
		batch.setName(request.getParameter("name"));
		batch.setStartTime(request.getParameter("startTime"));
		batch.setEndTime(request.getParameter("endTime"));
		batch.setShift(request.getParameter("shift"));

		batchDAO.updateBatch(batch);

		response.sendRedirect("main");

	}

	// Remove a batch
	protected void removeBatches(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String b_id = request.getParameter("b_id");

		System.out.println(b_id);

		batch.setB_id(b_id);

		batchDAO.deleteBatch(batch);

		response.sendRedirect("main");

	}

}
