package dataAccess;

import entities.Product;

public interface ProductDao {
    void add(Product product);
    // bir katman başka bir katmanın class'ını kullanıyorken sadece interface'inden erişim kurmalıdır.
}
