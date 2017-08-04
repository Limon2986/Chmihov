package servlet;

import DAO.MarkaDAO;
import DAO.hibarnate.MarkaDAOHibarnateImpl;
import sun.net.httpserver.HttpServerImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class Delete extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);

        String nameI = req.getParameter("id");
        MarkaDAO markaDAO = new MarkaDAOHibarnateImpl();
        markaDAO.delete(new Integer(nameI));

        RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
       dispatcher.forward(req, resp);
        return;
    }
}
