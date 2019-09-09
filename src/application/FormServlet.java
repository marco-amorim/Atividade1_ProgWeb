package application;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Student;

@WebServlet("/FormServlet")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	List<Student> listStudents = new ArrayList<Student>();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		out.println("<html><body>");

		out.println("<title> Cadastro de Estudante </title>" + "<h2> Cadastro de Estudantes</h2>"
				+ "<form action=\"FormServlet\" method=\"POST\">"
				+ "Nome: <input type=\"text\" name=\"studentName\"><br><br>"
				+ "Idade: <input type=\"number\" name=\"studentAge\"><br><br>"
				+ "Gênero: <select name=\"studentGender\">" + "		 <option>Masculino</option>"
				+ "		 <option>Feminino</option>" + "		 </select><br><br>"
				+ "		Selecione as Disciplinas que ja cursou: <br><br>"
				+ "		<input type=\"checkbox\" name=\"disciplina\" value=\"Matemática\"> Matemática\r\n<br>"
				+ "		<input type=\"checkbox\" name=\"disciplina\" value=\"Português\"> Português\r\n<br>"
				+ "		<input type=\"checkbox\" name=\"disciplina\" value=\"Geografia\"> Geografia\r\n<br>"
				+ "		<input type=\"checkbox\" name=\"disciplina\" value=\"Inglês\"> Inglês\r\n<br>"
				+ "		<input type=\"checkbox\" name=\"disciplina\" value=\"História\"> História\r\n<br>"
				+ "		<input type=\"checkbox\" name=\"disciplina\" value=\"Filosofia\"> Filosofia\r\n<br>"
				+ "		<input type=\"checkbox\" name=\"disciplina\" value=\"Física\"> Física\r\n<br>"
				+ "		<input type=\"checkbox\" name=\"disciplina\" value=\"Química\"> Química\r\n<br><br>"
				+ "		<input type=\"submit\" value=\"Cadastrar\" " + "</form><br><br>");

		out.println("</body></html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		String name = request.getParameter("studentName");
		int age = Integer.parseInt(request.getParameter("studentAge"));
		String gender = request.getParameter("studentGender");
		List<String> listClasses = new ArrayList<String>();
		String[] classesList = request.getParameterValues("disciplina");

		for (String x : classesList) {
			listClasses.add(x);
		}

		Student student = new Student(name, age, gender, listClasses);
		listStudents.add(student);

		out.println("<html><body>");

		out.println("<title> Cadastro de Estudante </title>" + "<h2> Cadastro de Estudantes</h2>"
				+ "<form action=\"FormServlet\" method=\"POST\">"
				+ "Nome: <input type=\"text\" name=\"studentName\"><br><br>"
				+ "Idade: <input type=\"number\" name=\"studentAge\"><br><br>"
				+ "Gênero: <select name=\"studentGender\">" + "		 <option>Masculino</option>"
				+ "		 <option>Feminino</option>" + "		 </select><br><br>"
				+ "		Selecione as Disciplinas que ja cursou: <br><br>"
				+ "		<input type=\"checkbox\" name=\"disciplina\" value=\"Matemática\"> Matemática\r\n<br>"
				+ "		<input type=\"checkbox\" name=\"disciplina\" value=\"Português\"> Português\r\n<br>"
				+ "		<input type=\"checkbox\" name=\"disciplina\" value=\"Geografia\"> Geografia\r\n<br>"
				+ "		<input type=\"checkbox\" name=\"disciplina\" value=\"Inglês\"> Inglês\r\n<br>"
				+ "		<input type=\"checkbox\" name=\"disciplina\" value=\"História\"> História\r\n<br>"
				+ "		<input type=\"checkbox\" name=\"disciplina\" value=\"Filosofia\"> Filosofia\r\n<br>"
				+ "		<input type=\"checkbox\" name=\"disciplina\" value=\"Física\"> Física\r\n<br>"
				+ "		<input type=\"checkbox\" name=\"disciplina\" value=\"Química\"> Química\r\n<br><br>"
				+ "		<input type=\"submit\" value=\"Cadastrar\" " + "</form><br><br>");

		out.println("<table border=\"2\" align=\"left\">" + "<tr>" + "<th>Nome</th>" + "<th>Idade</th>"
				+ "<th>Gênero</th>" + "<th>Disciplinas</th>" + "</tr>");

		for (Student x : listStudents) {
			out.println("<tr>" + "<td>" + x.getName() + "</td>" + "<td>" + x.getAge() + "</td>" + "<td>" + x.getGender()
					+ "</td>" + "<td>" + x.getListClasses());

		}

		out.println("</td></table");

		out.println("</body></html>");
	}

}
