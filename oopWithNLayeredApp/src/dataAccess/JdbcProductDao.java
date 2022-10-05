package dataAccess;

import entities.Product;

public class JdbcProductDao implements ProductDao{
    public void add(Product product){
        // sadece ve sadece db erişim kodları yazılır... SQL
        System.out.println(product.getName()+": JDBC ile veritabanına eklendi.");
    }
}
