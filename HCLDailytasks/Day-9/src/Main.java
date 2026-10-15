
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        Pair<Integer, String> pair = new Pair<>(101, "Laptop");
        System.out.println("Pair: " + pair);

        Box<Integer> box = new Box<>(500);
        System.out.println("Box value: " + box.getDoubleValue());

        System.out.println("Maximum: "
                + GenericToolkit.max(10, 50, 30));

        List<Product> products = ProductCsvLoader.load(
                Path.of("data", "products.csv")
        );

        CrudRepository<Product, String> repository =
                new InMemoryRepository<>(Product::getId);

        for (Product product : products) {
            repository.save(product);
        }

        System.out.println("\nAll products:");
        GenericToolkit.printAll(repository.findAll());

        System.out.println("\nProduct P102:");
        repository.findById("P102")
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("Product not found")
                );

        System.out.println("\nDelete P103: "
                + repository.deleteById("P103"));

        System.out.println("Remaining products: "
                + repository.findAll().size());

        System.out.println("\nResource closing demonstration:");
        ResourceDemo.demonstrate();
    }
}
