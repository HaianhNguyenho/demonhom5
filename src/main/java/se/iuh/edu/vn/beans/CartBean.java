package se.iuh.edu.vn.beans;

import java.util.ArrayList;

public class CartBean {

    private ArrayList<CartItemBean> alCartItems = new ArrayList<CartItemBean>();
    private double dblOrderTotal;
    public int getLineCount(){
        return alCartItems.size();
    }
    public void deleteCartItem(String strItemIndex){
        int iItemIndex = 0;
        try {
            iItemIndex = Integer.parseInt(strItemIndex);
            alCartItems.remove(iItemIndex -1 );
            calculateOrderToTal();
        } catch (NumberFormatException nfe) {
            // TODO: handle exception
            System.out.println("Error while deleting cart item " +nfe.getMessage());
            nfe.printStackTrace();
        }

    }
 
    private void calculateOrderToTal() {
        double dblTotal = 0;
        for(int counter = 0; counter<alCartItems.size(); counter++){
            CartItemBean cartItemBean = alCartItems.get(counter);
            dblTotal += cartItemBean.getDblTotalCost();
        }
        setDblOrderTotal(dblTotal);
    }
    public ArrayList<CartItemBean> getAlCartItems() {
        return alCartItems;
    }
    public void setAlCartItems(ArrayList<CartItemBean> alCartItems) {
        this.alCartItems = alCartItems;
    }
    public double getDblOrderTotal() {
        return dblOrderTotal;
    }
    public void setDblOrderTotal(double dblOrderTotal) {
        this.dblOrderTotal = dblOrderTotal;
    }
    public void updateCartItem(String strItemIndex, String strQuantity){
        double dblTotalCost = 0.0;
        double dblUnitCost = 0.0;
        int iQuantity = 0;
        int iItemIndex = 0;
        CartItemBean cartItem = null;

        try {
            iItemIndex = Integer.parseInt(strItemIndex);

            iQuantity = Integer.parseInt(strQuantity);
            if(iQuantity > 0){
                cartItem = (CartItemBean) alCartItems.get(iItemIndex -1);
                dblUnitCost = cartItem.getDblUnitCost();
                dblTotalCost = dblUnitCost * iQuantity;
                cartItem.setiQuantity(iQuantity);
                cartItem.setDblTotalCost(dblTotalCost);
                calculateOrderToTal();
            }
        } catch (NumberFormatException nfe) {
            // TODO: handle exception
            System.out.println("Error while updating cart: "+nfe.getMessage());
            nfe.printStackTrace();
        }
    }
    public CartItemBean getCartItem(int iTemIndex){
        CartItemBean cartItem = null;
        if(alCartItems.size()>iTemIndex){
            cartItem = alCartItems.get(iTemIndex);
        }
        return cartItem;
    }

    public void addCartItem(String strModelNo, String strDescription,String strUnitCost, String strQuantity ){
        double dblTotalCost = 0.0;

        double dblUnitCost = 0.0;

        int iQuantity = 0;


        CartItemBean cartItem = new CartItemBean();

        try {
            dblTotalCost = Double.parseDouble(strUnitCost);
            cartItem.setStrPartNumber(strModelNo);
            cartItem.setStrModelDescription(strDescription);
            cartItem.setDblUnitCost(dblUnitCost);
            cartItem.setiQuantity(iQuantity);
            cartItem.setDblTotalCost(dblTotalCost);
            alCartItems.add(cartItem);
            calculateOrderToTal();            
        } catch (Exception nfe) {
            // TODO: handle exception
            System.out.println("Error while parsing from String to printive types:  "+nfe.getMessage());
            nfe.printStackTrace();
        }
    }
   public void addCartItem(CartItemBean cartItem){
    alCartItems.add(cartItem);
   }



}
