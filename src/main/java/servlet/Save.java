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
import java.io.PrintWriter;
import java.util.Enumeration;

public class Save extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String nameI = request.getParameter("id");

        if (nameI != null && !nameI.equals("") ){
            MarkaDAO markaDAO = new MarkaDAOHibarnateImpl();
            MarkaCoffi markaCoffi = markaDAO.get(new Integer(nameI));

            request.setAttribute("id", markaCoffi.getId());
            request.setAttribute("name", markaCoffi.getName());
            request.setAttribute("proizvoditel", markaCoffi.getProizvoditel());
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/vvodvbd.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        this.process(request, response);
    }

    /*
       generate the page showing all the request parameters
     */
    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        MarkaCoffi markaCoffi = new MarkaCoffi();
        String nameID = request.getParameter("id");
        String nameN = request.getParameter("name");
        String nameP = request.getParameter("Proivoditel");

        if (nameID !=null && !nameID.equals("") ) {
            markaCoffi.setId(new Integer(nameID));
        }
        markaCoffi.setName(nameN);
        markaCoffi.setProizvoditel(nameP);

        MarkaDAO markaDAO = new MarkaDAOHibarnateImpl();
        if (markaCoffi.getId() == null) {
            markaDAO.create(markaCoffi);
        }else {
            markaDAO.update(markaCoffi);
        }


        request.setAttribute("save", true);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);



    }


}
