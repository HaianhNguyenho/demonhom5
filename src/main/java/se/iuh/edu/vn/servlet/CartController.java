package se.iuh.edu.vn.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import se.iuh.edu.vn.beans.CartBean;
@WebServlet("/CartController")
public class CartController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String strAction = req.getParameter("action");
        if(strAction != null && strAction.equals("")){
            if(strAction.equals("add")){
                    addToCart(req);
            }else if(strAction.equals("Update")){
                updateCart(req);
            }else if(strAction.equals("Delete")){
                deleteCart(req);
            }
        }
        resp.sendRedirect(getServletContext().getContextPath()+ "/ShoppingCartServlet");
    }

    private void addToCart(HttpServletRequest request) {

        HttpSession session = request.getSession();

        String strModelNo = request.getParameter("ModelNo");

        String strDescription = request.getParameter("description");

        String strPrice = request.getParameter("price");

        String strQuantity = request.getParameter("quantity");

        CartBean cartBean = null;

        Object objCarBean = session.getAttribute("cart");

        if(objCarBean != null){
            cartBean = (CartBean) objCarBean;
        }else{
            cartBean = new CartBean();
            session.setAttribute("cart", cartBean);
        }

        cartBean.addCartItem(strModelNo, strDescription, strPrice, strQuantity);


    }

    protected void deleteCart(HttpServletRequest request){
            HttpSession session = request.getSession();
            String strItemIndex = request.getParameter("itemIndex");
            CartBean cartBean = null;

            Object objectCartBean = session.getAttribute("cart");
            if(objectCartBean != null){
                cartBean = (CartBean) objectCartBean;
            }else{
                cartBean = new CartBean();
            }
            cartBean.deleteCartItem(strItemIndex);

    }

    protected void updateCart(HttpServletRequest request){

        HttpSession session = request.getSession();

        String strQuantity = request.getParameter("quantity");

        String strItemIndex = request.getParameter("itemIndex");

        CartBean cartBean = null;

        Object objCartBean = session.getAttribute("cart");
        if(objCartBean != null){
            cartBean = (CartBean) objCartBean;

        }else{
            cartBean = new CartBean();
        }
        cartBean.updateCartItem(strItemIndex, strQuantity);
    }



    


    
}
