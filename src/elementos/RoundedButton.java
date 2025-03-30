package elementos;

//Importa las librerias necesarias
import javax.swing.JButton;
import java.awt.*;

//Clase extendida de JButton. Botón personalizado
public class RoundedButton extends JButton {
    public RoundedButton(String text) {
        super(text);
        // Evita el fondo por defecto
        setContentAreaFilled(false);
        // Quita el borde de selección        
        setFocusPainted(false); 
        //Quita el borde
        setBorder(null);
        
        setFont(new Font("Poppins", Font.PLAIN, 14));
    }

    
    //Esquinas redondeadas
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Dibujar fondo redondeado
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10); // Esquinas redondeadas
        super.paintComponent(g);
    }
}
