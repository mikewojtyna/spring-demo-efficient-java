package pro.buildmysoftware.efficientjava.springdemo.product;

import org.springframework.data.annotation.Id;

import java.util.Objects;

public class Product {
	@Id
	private String id;

	private String name;

	public Product(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Product{" + "id='" + id + '\'' + ", name='" + name + '\'' + '}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Product product = (Product) o;
		return Objects.equals(id, product.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
