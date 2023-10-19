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

		// response.getWriter().append("Served at: ").append(request.getContextPath());
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
		// Criando um objeto que ira receber os dados Batches
		ArrayList<Batch> list = batchDAO.listbatches();
		// Encaminhar a lists ao documento zumba.jsp
		request.setAttribute("batch", list);
		RequestDispatcher rd = request.getRequestDispatcher("zumba.jsp");
		rd.forward(request, response);

		/*
		 * //teste de recebimento for(int i=0; i<list.size(); i++) {
		 * System.out.println(list.get(i).getB_id());
		 * System.out.println(list.get(i).getName());
		 * System.out.println(list.get(i).getStartTime());
		 * System.out.println(list.get(i).getEndTime());
		 * System.out.println(list.get(i).getShift()); }
		 */
		// test de conexao
		// batchDAO.connectionTest();

	}

	// New Batch
	protected void newBatches(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * // Teste de recebimento System.out.println(request.getParameter("name"));
		 * System.out.println(request.getParameter("startTime"));
		 * System.out.println(request.getParameter("endTime"));
		 * System.out.println(request.getParameter("shift"));
		 */
		// setar as variaveis batch
		batch.setName(request.getParameter("name"));
		batch.setStartTime(request.getParameter("startTime"));
		batch.setEndTime(request.getParameter("endTime"));
		batch.setShift(request.getParameter("shift")); // invocar o metodo insertBatch
		// passando o objeto batch
		batchDAO.insertNewBatch(batch); // <-
		// redirecionar para odocument
		response.sendRedirect("main");

	}

	// Editar Contato

	protected void listBatches(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String b_id = request.getParameter("b_id");
		// System.out.println(b_id);
		// setar a variavel Batch
		batch.setB_id(b_id);
		// Executar o metodo selecionar contato
		batchDAO.selectBatch(batch);
		/*
		 * //teste de recebimento System.out.println(batch.getB_id());
		 * System.out.println(batch.getName());
		 * System.out.println(batch.getStartTime());
		 * System.out.println(batch.getEndTime()); System.out.println(batch.getShift());
		 */

		// setar os atributos do formulario com o contaudo batch
		request.setAttribute("b_id", batch.getB_id());
		request.setAttribute("name", batch.getName());
		request.setAttribute("startTime", batch.getStartTime());
		request.setAttribute("endTime", batch.getEndTime());
		request.setAttribute("shift", batch.getShift());
		// encaminhar ao documento jsp
		RequestDispatcher rd = request.getRequestDispatcher("updateBatch.jsp");
		rd.forward(request, response);

		// value="<%out.print(request.getAttribute("b_id"));%>"
	}

	protected void updateBatches(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * //test de recebiment System.out.println(request.getParameter("b_id"));
		 * System.out.println(request.getParameter("name"));
		 * System.out.println(request.getParameter("startTime"));
		 * System.out.println(request.getParameter("endTime"));
		 * System.out.println(request.getParameter("shift"));
		 */
		// setar as variaveis
		batch.setB_id(request.getParameter("b_id"));
		batch.setName(request.getParameter("name"));
		batch.setStartTime(request.getParameter("startTime"));
		batch.setEndTime(request.getParameter("endTime"));
		batch.setShift(request.getParameter("shift"));
		// executar o metodo updateBatch
		batchDAO.updateBatch(batch);
		// redirecionar para o documento zumba.jsp (atualizando as alteracoes)
		response.sendRedirect("main");

	}

	// Remove a batch
	protected void removeBatches(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String b_id = request.getParameter("b_id");
		// recebimento do id do batch a ser excluido
		System.out.println(b_id);
		// setar a variavel
		batch.setB_id(b_id);
		// executar o metodo deletar contato
		batchDAO.deleteBatch(batch);
		// redirecionar para o documento zumba.jsp (atualizando as alteracoes)
		response.sendRedirect("main");

	}

}
