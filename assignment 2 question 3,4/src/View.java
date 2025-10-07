import javax.swing.*;
import java.awt.*;

public class View {
    private final JFrame frame;
    private final DefaultListModel<String> scannedModel;
    private final JList<String> scannedList;
    private final JLabel subtotalLabel;

    public View(String title) {
        frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setLayout(new BorderLayout());

        scannedModel = new DefaultListModel<>();
        scannedList = new JList<>(scannedModel);
        JScrollPane listScroll = new JScrollPane(scannedList);
        frame.getContentPane().add(listScroll, BorderLayout.CENTER);

        subtotalLabel = new JLabel("Subtotal: $0.00", SwingConstants.RIGHT);
        JPanel bottom = new JPanel(new BorderLayout());
        bottom.add(subtotalLabel, BorderLayout.EAST);
        frame.getContentPane().add(bottom, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    public void addScannedRow(String row) {
        scannedModel.addElement(row);
    }

    public void setSubtotal(double value) {
        subtotalLabel.setText("Subtotal: $" + String.format("%.2f", value));
    }
}
