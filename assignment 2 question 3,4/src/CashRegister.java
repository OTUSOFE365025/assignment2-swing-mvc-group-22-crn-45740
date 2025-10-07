import java.nio.file.*;
import java.util.*;
import java.io.IOException;

public class CashRegister {
    // Catalog split into two maps: UPC -> Name, UPC -> Price
    private final Map<String, String> nameByUpc = new HashMap<>();
    private final Map<String, Double> priceByUpc = new HashMap<>();

    // Display-ready rows for the UI and running subtotal
    private final List<String> scannedRows = new ArrayList<>();
    private double subtotal = 0.0;

    public CashRegister(String productsFilePath) throws IOException {
        loadCatalog(productsFilePath);
    }

    private void loadCatalog(String path) throws IOException {
        for (String raw : Files.readAllLines(Paths.get(path))) {
            String line = raw.trim();
            if (line.isEmpty() || line.startsWith("#")) continue;

            // Accept either: "12345, Coffee, $8.32"  or  "12345 Coffee 8.32"
            String[] parts = line.split("[,\\s]+");
            if (parts.length < 3) continue;

            String upc = parts[0];
            String priceStr = parts[parts.length - 1].replace("$", "");
            double price = Double.parseDouble(priceStr);
            String name = String.join(" ", Arrays.asList(parts).subList(1, parts.length - 1));

            nameByUpc.put(upc, name);
            priceByUpc.put(upc, price);
        }
    }

    // Returns true if UPC exists; also appends a display row and updates subtotal
    public boolean addByUpc(String upc) {
        String name = nameByUpc.get(upc);
        Double price = priceByUpc.get(upc);
        if (name == null || price == null) return false;

        String row = upc + "  " + name + "  $" + String.format("%.2f", price);
        scannedRows.add(row);
        subtotal += price;
        return true;
    }

    public List<String> getScannedRows() {
        return Collections.unmodifiableList(scannedRows);
    }

    public double getSubtotal() {
        return subtotal;
    }

    public Set<String> getAllUpcs() {
        return Collections.unmodifiableSet(nameByUpc.keySet());
    }
}
