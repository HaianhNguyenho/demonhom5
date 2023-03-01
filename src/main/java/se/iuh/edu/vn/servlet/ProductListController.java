package se.iuh.edu.vn.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import se.iuh.edu.vn.beans.Product;
import se.iuh.edu.vn.beans.ProductList;
@WebServlet("/DSSP")
public class ProductListController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        List<Product> list = ProductList.queryProducts();
        req.setAttribute("ds", list);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/ModelList.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(req, resp);
    }

    
}
