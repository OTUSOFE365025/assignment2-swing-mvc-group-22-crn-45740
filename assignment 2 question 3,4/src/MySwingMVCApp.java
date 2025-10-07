import javax.swing.*;
import java.nio.file.*;

public class MySwingMVCApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                // 1) Try working directory
                Path path = Paths.get("src/products.txt");

                // 2) If not there, try folder of compiled classes
                if (!Files.exists(path)) {
                    try {
                        Path base = Paths.get(
                                MySwingMVCApp.class.getProtectionDomain()
                                        .getCodeSource()
                                        .getLocation()
                                        .toURI()
                        ).getParent();
                        path = base.resolve("src/products.txt");
                    } catch (Exception ignored) { }
                }

                CashRegister register = new CashRegister(path.toString());
                View view = new View("Cash Register (MVC)");
                Controller controller = new Controller(view, register);

                new Scanner(register.getAllUpcs(), controller.scanHandler());
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null,
                        "Failed to start app:\n" + ex.getMessage(),
                        "Startup Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
