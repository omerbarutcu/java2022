package business;

import core.logging.Logger;
import dataAccess.ProductDao;
import entities.Product;


public class ProductManager {
    private ProductDao productDao;
    private Logger[] loggers;

    public ProductManager(ProductDao productDao, Logger[] loggers) {
        this.productDao = productDao;
        this.loggers = loggers;
    }

    public void add(Product product) throws Exception {
        // iş kuralları yazılır
        if (product.getUnitePrice() < 10) {
            throw new Exception("Ürün fiyatı 10 dan küçük olamaz.");
        }
        productDao.add(product);
        for (Logger logger : loggers) { // [db,mail]
            logger.log(product.getName());
        }
    }
}
