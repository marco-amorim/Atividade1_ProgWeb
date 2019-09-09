package application;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String login, senha;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		out.println("<html><body>");

		out.println("<h1> Login de Estudantes</h1>");

		out.println("<form action=\"LoginServlet\" method=\"POST\">" + " Login <br><input type=\"text\" name=\"loginUser\">"
						+ "<br><br>Password<br><input type=\"password\" name=\"passUser\">"
						+ "<br><br><input type=\"submit\" value=\"Login\">" + "</form>");

		out.println("</body></html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		login = request.getParameter("loginUser");
		senha = request.getParameter("passUser");

		if (login.equals("teste") && senha.equals("teste")) {

			response.sendRedirect("FormServlet");

		} else {

			out.println("<html><body>");

			out.println("<h1> Login de Estudantes </h1>" + "<h2> Senha incorreta, por favor tente novamente!</h2>"
					+ "<form action=\"LoginServlet\" method=\"POST\">"
					+ " Login <br><input type=\"text\" name=\"loginUser\">"
					+ "<br><br>Password<br><input type=\"password\" name=\"passUser\">"
					+ "<br><br><input type=\"submit\" value=\"Login\">" + "</form>");

			out.println("</body></html>");

		}

	}

}
