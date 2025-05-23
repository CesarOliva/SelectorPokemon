package formulario;

//Se importan las librerias a usar
import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.awt.event.ActionEvent;

//Importar las "librerias" personalizadas a utilizar
import elementos.RoundedButton;
import elementos.CustomScroll;
import elementos.RoundedPanel;
import elementos.TransparentImage;

//Clase Mostrar heredada de JFrame. Frame personalizado
public class Mostrar extends JFrame {
    JPanel fila;

    public Mostrar(List<Pokemon> filtrados) {
        //Configuración de la ventana
        setTitle("Pokemones encontrados");
        setSize(700, 480);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout());

        //Si hay al menos un pokemon encontrado
        if (filtrados.size()>0) {

            int filas = (int) Math.ceil((double) filtrados.size() / 3);

            //Creación del panel        
            //Grid layout de n filas y 1 columna
            JPanel panel = new JPanel(new GridLayout(filas, 1));
            panel.setBackground(new Color(0, 0, 0, 0));

            //Imagen del fondo panel.
            JLabel fondo = new JLabel(new ImageIcon(getClass().getResource("/elementos/cave.jpg")));
            fondo.setBounds(0, 0, 700, 480);

            //Guarda el numero de pokemon recorrido
            int pokemonRecorrido = 0;

            //Crea n filas de paneles segun la cantidad de pokemones encontrados
            for (int i = 0; i < filas; i++) {
                //Crea el panel de las filas
                fila = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
                fila.setBackground(new Color(0, 0, 0, 0));

                //Recorre la lista de pokemones encontrados
                for (int j = 0; j < filtrados.size(); j++) {
                    if (j < 3) {
                        if (pokemonRecorrido < filtrados.size()) {
                            Pokemon pokemon = filtrados.get(pokemonRecorrido);

                            //Creación de cards de cada pokemon encontrado
                            JPanel card = new JPanel(null);
                            card.setPreferredSize(new Dimension(180, 380));
                            card.setBackground(new Color(0, 0, 0, 0));

                            JLabel fondoCard = new JLabel(new TransparentImage("/elementos/caveBlur.jpg", .8f));
                            fondoCard.setBounds(0, 0, 180, 380);

                            //Creación de elementos
                            ImageIcon icon = new ImageIcon(getClass().getResource(pokemon.getURL()));
                            Image imagenIcon = icon.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);

                            JLabel imagen = new JLabel(new ImageIcon(imagenIcon));
                            imagen.setBounds(30, 10, 120, 120);

                            JLabel nombre = new JLabel(pokemon.getNombre());
                            nombre.setBounds(0, 130, 180, 30);
                            nombre.setHorizontalAlignment(SwingConstants.CENTER);
                            nombre.setForeground(Color.white);
                            nombre.setFont(new Font("Poppins", Font.PLAIN, 14));

                            RoundedPanel underName = new RoundedPanel("/elementos/FondoLabel.jpg", 140, 30);
                            underName.setBounds(20, 130, 140, 30);
                            
                            //Crea un arreglo que contenga los tipos de pokemones
                            String tipo = pokemon.getTipo().toString().replace("[", "").replace("]", "");
                            String [] tipoSplit = tipo.split(", ");
                            
                            int x = 60;
                            for(int k=0;k<pokemon.getTipo().size();k++){
                                String path = "/elementos/"+tipoSplit[k]+".png";
                                ImageIcon iconImage = new ImageIcon(getClass().getResource(path));
                                Image ImagenTipo = iconImage.getImage().getScaledInstance(25,25,Image.SCALE_SMOOTH);
                                JLabel labelTipo = new JLabel(new ImageIcon(ImagenTipo));
                                if(tipoSplit.length==2){
                                    labelTipo.setBounds(x, 172, 25, 25);
                                    x+=40;
                                }else{
                                    labelTipo.setBounds(0, 172, 180, 25);                                    
                                }
                                
                                card.add(labelTipo);
                            }
                            
                            RoundedPanel underType = new RoundedPanel("/elementos/FondoLabel.jpg", 140, 30);
                            underType.setBounds(20, 170, 140, 30);
                            
                            JLabel tamaño = new JLabel(pokemon.getTamaño());
                            tamaño.setBounds(0, 210, 180, 30);
                            tamaño.setHorizontalAlignment(SwingConstants.CENTER);
                            tamaño.setForeground(Color.white);
                            tamaño.setFont(new Font("Poppins", Font.PLAIN, 14));
                            
                            RoundedPanel underSize = new RoundedPanel("/elementos/FondoLabel.jpg", 140, 30);
                            underSize.setBounds(20, 210, 140, 30);

                            JLabel region = new JLabel(pokemon.getRegion());
                            region.setBounds(0, 250, 180, 30);
                            region.setHorizontalAlignment(SwingConstants.CENTER);
                            region.setForeground(Color.white);
                            region.setFont(new Font("Poppins", Font.PLAIN, 14));
                            
                            RoundedPanel underRegion = new RoundedPanel("/elementos/FondoLabel.jpg", 140, 30);
                            underRegion.setBounds(20, 250, 140, 30);
                            
                            JLabel categoria = new JLabel(pokemon.getCategoria());
                            categoria.setBounds(0, 290, 180, 30);
                            categoria.setHorizontalAlignment(SwingConstants.CENTER);
                            categoria.setForeground(Color.white);
                            categoria.setFont(new Font("Poppins", Font.PLAIN, 14));
                            
                            RoundedPanel underCat = new RoundedPanel("/elementos/FondoLabel.jpg", 140, 30);
                            underCat.setBounds(20, 290, 140, 30);

                            JButton select = new RoundedButton("Seleccionar");
                            select.setBackground(Color.red);
                            select.setForeground(Color.WHITE);
                            select.setBounds(40, 340, 100, 30);

                            //Funcionalidad del botón de selección
                            select.addActionListener((ActionEvent e) -> {
                                new JuegoCartas(pokemon.getNombre());
                                formulario.getInstancia().cerrar();
                                dispose();
                            });

                            //Agrega los elementos al card
                            card.add(imagen);
                            card.add(nombre);
                            card.add(underName);
                            card.add(underType);
                            card.add(tamaño);
                            card.add(underSize);
                            card.add(region);
                            card.add(underRegion);
                            card.add(categoria);
                            card.add(underCat);
                            card.add(select);
                            card.add(fondoCard);
                            //Agrega la card a la fila
                            fila.add(card);
                        }
                        pokemonRecorrido++;
                    }
                }

                //Agrega la fila al panel.
                panel.add(fila);
            }

            //ScrollPane por si la lista de pokemones no entra en el panel
            JScrollPane scroll = new CustomScroll(panel);

            //Se agrega la imagen del fondo
            scroll.add(fondo);
            //Agrega el ScrollPane
            add(scroll);
        }else{
            setSize(500,390);
            setLocationRelativeTo(null);
            
            //Creación del panel
            JPanel panel = new JPanel(null);
            
            //Creación de los elementos
            JLabel imagen = new JLabel(new ImageIcon(getClass().getResource("/elementos/canyon.jpg")));
            imagen.setBounds(0, 0, 500, 360);
            
            JLabel text = new JLabel("No se ha encontrado ningun Pokémon");
            text.setFont(new Font("Poppins", Font.BOLD, 18));        
            text.setForeground(Color.white);
            text.setBounds(60, 150, 400, 30);
            
            JButton aceptar = new RoundedButton("Cerrar");
            aceptar.setBackground(Color.red);
            aceptar.setFont(new Font("Poppins", Font.PLAIN, 14));
            aceptar.setForeground(Color.white);
            aceptar.setBounds(195, 180, 100, 30);
            
            aceptar.addActionListener((ActionEvent e)->{
                dispose();
            });
            
            //Agrega el panel
            panel.add(text); 
            panel.add(aceptar); 
            panel.add(imagen);
            add(panel);
        }
        
        setVisible(true);
    }
}
