package liubomyr.stepanenko.goodsstore.repository;

import liubomyr.stepanenko.goodsstore.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
