package se.iuh.edu.vn.beans;

import java.util.ArrayList;
import java.util.List;

public class ProductList {

    private static final List<Product> ds = new ArrayList<>();

    static{
        initData();
    }
    public static List<Product> queryProducts(){
        return ds;
    }
    private static void initData() {
        Product sp = new Product();

        sp.setId("PRO01");
        sp.setDescription("");
        sp.setPrice(99000);
        sp.setModel("Nokia Lumia");
        sp.setQuantity(10);
        sp.setImgURL("");
        ds.add(sp);

        sp = new Product();
        sp.setId("PRO02");
        sp.setDescription("");
        sp.setPrice(48000);
        sp.setModel("BlackBerry Passport");
        sp.setQuantity(10);
        sp.setImgURL("");
        ds.add(sp);

        sp = new Product();
        sp.setId("PRO03");
        sp.setDescription("");
        sp.setPrice(52000);
        sp.setModel("Sony Xpers Z5");
        sp.setQuantity(10);
        sp.setImgURL("");
        ds.add(sp);

        sp = new Product();
        sp.setId("PRO04");
        sp.setDescription("");
        sp.setPrice(83000);
        sp.setModel("HTC One M9");
        sp.setQuantity(10);
        sp.setImgURL("");
        ds.add(sp);

        sp = new Product();
        sp.setId("PRO05");
        sp.setDescription("");
        sp.setPrice(71000);
        sp.setModel("Samsung Galaxy Note 5");
        sp.setQuantity(10);
        sp.setImgURL("");
        ds.add(sp);


    }
    
}
