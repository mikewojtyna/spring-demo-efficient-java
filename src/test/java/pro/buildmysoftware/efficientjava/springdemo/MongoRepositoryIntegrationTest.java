package pro.buildmysoftware.efficientjava.springdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.test.context.junit4.SpringRunner;
import pro.buildmysoftware.efficientjava.springdemo.product.Product;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MongoRepositoryIntegrationTest {

	@Autowired
	private MongoRepository repository;

	@Test
	public void should_SaveProduct() {
		repository.save(new Product("product"));

		assertThat(repository.findAll()).hasSize(1);
	}
}
