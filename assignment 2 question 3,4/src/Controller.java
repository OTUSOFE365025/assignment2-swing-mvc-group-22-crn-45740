import javax.swing.JOptionPane;
import java.util.function.Consumer;

public class Controller {
    private final View view;
    private final CashRegister register;

    public Controller(View v, CashRegister r) {
        this.view = v;
        this.register = r;
        initView();
    }

    private void initView() {
        view.setSubtotal(register.getSubtotal());
    }

    public void onScanUpc(String upc) {
        boolean ok = register.addByUpc(upc);
        if (ok) {
            // Grab the last display row and push to the view
            java.util.List<String> rows = register.getScannedRows();
            String last = rows.get(rows.size() - 1);
            view.addScannedRow(last);
            view.setSubtotal(register.getSubtotal());
        } else {
            JOptionPane.showMessageDialog(null, "Unknown UPC: " + upc,
                    "Scan Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public Consumer<String> scanHandler() {
        return this::onScanUpc;
    }
}
