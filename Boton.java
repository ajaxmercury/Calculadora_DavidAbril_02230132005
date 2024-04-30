import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

public class Boton {
    private JButton boton;
    private VentanaCalculadora ventana;

    public Boton(String etiqueta, VentanaCalculadora ventana) {
        this.ventana = ventana;
        boton = new JButton(etiqueta);
        boton.setFont(new Font("Arial", Font.BOLD, 20));
        boton.setBackground(new Color(240, 240, 240));
        boton.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        boton.addActionListener(new BotonListener());
    }

    public JButton getBoton() {
        return boton;
    }

    private class BotonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String comando = e.getActionCommand();
            JTextField pantalla = ventana.getPantalla();
            switch(comando) {
                case "=":
                    ventana.setNum2(Double.parseDouble(pantalla.getText()));
                    double resultado = ventana.calcular(ventana.getNum1(), ventana.getNum2(), ventana.getOperador());
                    pantalla.setText(String.valueOf(resultado));
                    ventana.setClear(true);
                    break;
                case "AC":
                    pantalla.setText("");
                    ventana.setNum1(0);
                    ventana.setNum2(0);
                    ventana.setOperador("");
                    break;
                case ".":
                    if (!pantalla.getText().contains(".")) {
                        pantalla.setText(pantalla.getText() + ".");
                    }
                    break;
                case "+":
                case "-":
                case "*":
                case "/":
                    pantalla.setText(pantalla.getText() + comando);
                    if (comando.equals("+") || comando.equals("-") || comando.equals("*") || comando.equals("/")) {
                        ventana.setNum1(Double.parseDouble(pantalla.getText().substring(0, pantalla.getText().length() - 1)));
                        ventana.setOperador(comando);
                        pantalla.setText("");
                    }
                    break;
                default:
                    if (ventana.isClear()){
                        ventana.setClear(false);
                        pantalla.setText("");
                    }
                    pantalla.setText(pantalla.getText() + comando);
                    break;
            }
        }
    }
}
