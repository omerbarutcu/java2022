package kodlama.io.rentACar.dataAccess.abstracts;

import kodlama.io.rentACar.entities.concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BrandRepository extends JpaRepository<Brand, Integer> {
    boolean existsByName(String name); // Spring jpa keywords

}
// BTK ileri java spring kısmı engindemiroğ