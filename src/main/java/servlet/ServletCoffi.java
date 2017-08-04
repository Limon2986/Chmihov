package servlet;

import DAO.MarkaDAO;
import DAO.hibarnate.MarkaDAOHibarnateImpl;
import entity.MarkaCoffi;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class ServletCoffi extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        MarkaDAO markaDAO = new MarkaDAOHibarnateImpl();


        List<MarkaCoffi> list = markaDAO.getAll();
        request.setAttribute("poxer", list);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/marka.jsp");
        dispatcher.forward(request, response);
    }

}
