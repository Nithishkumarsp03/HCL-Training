
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ProductCsvLoader {

    public static List<Product> load(Path path) throws IOException {
        List<Product> products = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line = reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",", -1);

                if (fields.length != 3) {
                    throw new IOException("Invalid product row: " + line);
                }

                String id = fields[0].trim();
                String name = fields[1].trim();

                try {
                    double price = Double.parseDouble(fields[2].trim());
                    products.add(new Product(id, name, price));
                } catch (NumberFormatException exception) {
                    throw new IOException(
                            "Invalid product price: " + line, exception
                    );
                }
            }
        }

        return products;
    }
}
