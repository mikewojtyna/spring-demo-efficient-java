package pro.buildmysoftware.efficientjava.springdemo.product;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {
	List<Product> findFirstByIdBefore(String id);
}
