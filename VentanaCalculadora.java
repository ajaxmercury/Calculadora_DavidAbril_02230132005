import javax.swing.*;
import java.awt.*;

public class VentanaCalculadora extends JFrame {
    private JTextField pantalla;
    private Boton[] botones;
    private String[] etiquetas = {
        "7", "8", "9", "/",
        "4", "5", "6", "*",
        "1", "2", "3", "-",
        "0", ".", "=", "+", "AC"
    };
    private double num1, num2;
    private String operador;
    private boolean clear = false;

    public VentanaCalculadora() {
        setTitle("Calculadora");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setResizable(false);
    }

    public void iniciar() {
        pantalla = new JTextField();
        pantalla.setEditable(false);
        pantalla.setHorizontalAlignment(JTextField.RIGHT);
        pantalla.setBackground(new Color(75, 175, 80));
        pantalla.setFont(new Font("Arial", Font.BOLD, 36));
        add(pantalla, BorderLayout.NORTH);

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(5, 4, 10, 10));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelBotones.setBackground(new Color(147, 112, 219)); 
        botones = new Boton[17];
        for (int i = 0; i < 17; i++) {
            botones[i] = new Boton(etiquetas[i], this);
            panelBotones.add(botones[i].getBoton());
        }
        add(panelBotones, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public double calcular(double num1, double num2, String operador) {
        switch (operador) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 != 0) {
                    return num1 / num2;
                } else {
                    JOptionPane.showMessageDialog(this, "Error: División por cero", "Error", JOptionPane.ERROR_MESSAGE);
                    return 0;
                }
            default:
                return 0;
        }
    }

    public JTextField getPantalla() {
        return pantalla;
    }

    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    
    public boolean isClear() {
        return clear;
    }

    public void setClear(boolean clear) {
        this.clear = clear;
    }
}
