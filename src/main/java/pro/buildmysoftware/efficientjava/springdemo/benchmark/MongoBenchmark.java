package pro.buildmysoftware.efficientjava.springdemo.benchmark;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import pro.buildmysoftware.efficientjava.springdemo.SpringDemoApplication;
import pro.buildmysoftware.efficientjava.springdemo.product.Product;
import pro.buildmysoftware.efficientjava.springdemo.product.ProductRepository;

import java.util.ArrayList;
import java.util.Collection;

public class MongoBenchmark {
	@Benchmark
	public void writes(ContextState state) {
		state.productRepository.saveAll(state.products);
	}

	@State(value = Scope.Benchmark)
	public static class ContextState {

		public ProductRepository productRepository;
		public Collection<Product> products;

		@Setup
		public void setup() {
			ApplicationContext context = SpringApplication
				.run(SpringDemoApplication.class);
			productRepository = context
				.getBean(ProductRepository.class);

			products = new ArrayList<>();
			for (int i = 0; i < 1000; i++) {
				products.add(new Product("name"));
			}
		}
	}
}
