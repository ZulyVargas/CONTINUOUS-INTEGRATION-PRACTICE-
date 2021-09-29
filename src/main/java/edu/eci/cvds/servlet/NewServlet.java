package edu.eci.cvds.servlet;

import java.io.IOException;
import java.io.Writer;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import edu.eci.cvds.servlet.model.Todo;



@WebServlet(
	    urlPatterns = "/newServlet"
)
public class NewServlet extends HttpServlet {
	
	private List<Todo> todoList;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try{
		//Recibir el id ingresado 
		String id = req.getParameter("id"); 
		//Consultar el ToDo
		Todo todo = Service.getTodo(Integer.parseInt(id));
		Writer responseWriter = resp.getWriter();
		//responseWriter.write(todo.toString()+"Hey");

		//Respuesta OK
		resp.setStatus(HttpServletResponse.SC_OK);
		// Crear List para generar la tabla
		todoList= new ArrayList<Todo>();
		todoList.add(todo);
		//Mostrar la tabla
		responseWriter = resp.getWriter();
		responseWriter.write(Service.todosToHTMLTable(todoList));
		}
		//Excepcion para valor nulo
		catch(NumberFormatException e){
			htmlInvalidRequiered(resp);
		}
		
		//Excepcion servidor
		catch (MalformedURLException e){
			htmlInsideError(resp);
		}
		
		//Excepcion valor nulo o caracter no valido
		catch(IOException e) {
			htmlNotFound(resp);
		}
		
		//Excepcion para valor nulo
		catch(Exception e){
			htmlInvalidRequiered(resp);
			}
		
	}
	
	private void htmlInsideError(HttpServletResponse resp) {
		try {
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			Writer responseWriter = resp.getWriter();
			responseWriter.write(new StringBuilder("<h1>")
		    		.append("500 : Error interno del servidor.")
		    		.append("</h1>")
		    		.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private void htmlInvalidRequiered(HttpServletResponse resp) {
		try {
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			Writer responseWriter = resp.getWriter();
			responseWriter.write(new StringBuilder("<h1>")
		    		.append("400 : Requerimiento inválido.")
		    		.append("</h1>")
		    		.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void htmlNotFound(HttpServletResponse resp) {
		try {
			resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
			Writer responseWriter = resp.getWriter();
			responseWriter.write(new StringBuilder("<h1>")
		    		.append("404 : No existe un item con el identificador dado.")
		    		.append("</h1>")
		    		.toString());
		} catch (IOException e) {
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try{
		String id = req.getParameter("id"); 
		Todo todo = Service.getTodo(Integer.parseInt(id));
		Writer responseWriter = resp.getWriter();
		resp.setStatus(HttpServletResponse.SC_OK);
		todoList= new ArrayList<Todo>();
		todoList.add(todo);
		responseWriter = resp.getWriter();
		responseWriter.write(Service.todosToHTMLTable(todoList)); }
		catch(NumberFormatException e){
			htmlInvalidRequiered(resp);
		}
		catch (MalformedURLException e){
			htmlInsideError(resp);}
		catch(IOException e) {
			htmlNotFound(resp);
		}
		catch(Exception e){
			htmlInvalidRequiered(resp);}
	}
	
	
}
