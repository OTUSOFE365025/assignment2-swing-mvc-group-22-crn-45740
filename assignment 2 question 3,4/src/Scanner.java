import java.awt.BorderLayout;
import javax.swing.*;
import java.util.*;
import java.util.function.Consumer;

public class Scanner {
    private final JFrame frame;
    private final JButton scanButton;
    private final List<String> upcs;
    private final Random rng = new Random();
    private Consumer<String> onScan;

    public Scanner(Collection<String> availableUpcs, Consumer<String> onScan) {
        this.onScan = onScan;
        this.upcs = new ArrayList<>(availableUpcs);

        frame = new JFrame("Scanner");
        frame.getContentPane().setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(140, 100);
        frame.setLocation(300, 50);

        scanButton = new JButton("Scan");
        JPanel panel = new JPanel();
        panel.add(scanButton);
        frame.getContentPane().add(panel);

        scanButton.addActionListener(e -> generateAndSendUPC());
        scanButton.setEnabled(!upcs.isEmpty());
        frame.setVisible(true);

        if (upcs.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "No UPCs loaded. Check products.txt.",
                    "Scanner", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void generateAndSendUPC() {
        if (upcs.isEmpty()) return;
        String upc = upcs.get(rng.nextInt(upcs.size())); // random every time ✅
        System.out.println("Scanned UPC: " + upc);
        if (onScan != null) onScan.accept(upc);
    }
}
