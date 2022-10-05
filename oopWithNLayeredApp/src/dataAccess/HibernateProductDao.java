package dataAccess;

import entities.Product;

public class HibernateProductDao implements ProductDao{
    public void add(Product product){
        // sadece ve sadece db erişim kodları yazılır... SQL
        System.out.println(product.getName()+": Hibernate ile veritabanına eklendi.");
    }
}
