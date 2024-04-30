import javax.swing.*;


public class CalculadoraGUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                VentanaCalculadora ventana = new VentanaCalculadora();
                ventana.iniciar();
            }
        });
    }
}

