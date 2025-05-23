package formulario;

//Se importan las librerias a utilizar
import com.google.gson.*;
import java.io.*;
import java.net.*;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

//Importar librerias personalizadas
import elementos.RoundedButton;

//Clase de juego de cartas
public class JuegoCartas  extends JFrame{
    private static final String API_URL = "https://api.pokemontcg.io/v2/cards";
    private Clip clip;
    
    public JuegoCartas(String nombre){      
        //Configuración de la ventana
        setTitle(nombre +" - Cartas");
        setSize(620,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        
        //Creación del panel
        JPanel panel = new JPanel(null);
        panel.setSize(620, 400);

        //gif de fondo
        ImageIcon iconGif = new ImageIcon(getClass().getResource("/pokemones/"+nombre+".gif"));
        Image imageGIF = iconGif.getImage();

        JLabel gif = new JLabel(new ImageIcon(imageGIF));
        gif.setBounds(0,0,620,400);
        
        JPanel fila = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        fila.setBounds(0,20,610, 300);
        fila.setBackground(new Color(0,0,0,0));
        
        //Recorre la lista de cartas y las muestra
        List<String> cartas = mostrarCartas(cardsProbability(nombre));
        
        for(String carta : cartas){
            String [] split = carta.split(" - ");
            try {
                // URL de la imagen
                ImageIcon icon = new ImageIcon(new URL(split[1]));
                Image image = icon.getImage().getScaledInstance(180, 248, Image.SCALE_SMOOTH);
                icon = new ImageIcon(image);
                JLabel labelImg = new JLabel(icon);
                labelImg.setSize(180, 248);
                
                //Agregar la imagen al panel
                fila.add(labelImg);
            } catch (Exception e) {
            }
        }
        
        JButton volver = new RoundedButton("Regresar");
        volver.setForeground(Color.white);
        volver.setBackground(new Color(125, 120, 163));
        volver.setBounds(250, 300, 100, 30);
        
        volver.addActionListener((ActionEvent e)->{
            dispose();
            clip.stop();
            clip.close();
            new formulario();
        });
        
        //Inicia la musica
        startMusic();
        
        //agrega los elementos
        panel.add(volver);
        panel.add(fila);
        panel.add(gif);
        
        //Agrega el panel al frame y lo hace visible
        add(panel);
        setVisible(true);
    }        

    //Obtiene las cartas
    public static List<String> obtenerCartas(String nombre, String rareza) {
        List<String> cartas = new ArrayList<>();
        System.out.println(nombre+", "+rareza);
        try {
            //url
            String urlString = API_URL + "?q=name:" + nombre;
            if (!rareza.isEmpty()) {
                urlString += " rarity:" + rareza;
            }

            //Conexión a la api
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            // Respuesta de petición
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                response.append(line);
            }
            br.close();

            // creación de objeto JSON
            JsonObject jsonObject = JsonParser.parseString(response.toString()).getAsJsonObject();
            JsonArray cartasArray = jsonObject.getAsJsonArray("data");

            // Obtener los valores
            for (JsonElement carta : cartasArray) {
                JsonObject obj = carta.getAsJsonObject();
                String nombreCarta = obj.get("name").getAsString();
                String imagenUrl = obj.getAsJsonObject("images").get("large").getAsString();
                cartas.add(nombreCarta + " - " + imagenUrl);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cartas;
    }

    public List<String> cardsProbability(String nombre){
        int numero = new Random().nextInt(100);
        if(numero<40){
            return obtenerCartas(nombre, "Common");
        }else if(numero<65){
            return obtenerCartas(nombre, "Uncommon");
        }else if(numero<80){
            return obtenerCartas(nombre, "Rare");
        }else if(numero<90){
            return obtenerCartas(nombre, "%22Rare%20Holo%22");
        }else if(numero<96){
            return obtenerCartas(nombre, "%22Ultra%20Rare%22");
        }else if(numero<99){
            return obtenerCartas(nombre, "Rare");
        }else{
            return obtenerCartas(nombre, "Promo");
        }
    }
    
    public List<String> mostrarCartas(List<String> cartas){
        List<String> cartasRandom = new ArrayList<>();

        //Devuelve todas las cartas si son menores que 3
        if(cartas.size()<3){
            return cartas;
        }else{

            //Devuelve 3 cartas
            int i=0;
            while(i<3) {
                int numero = new Random().nextInt(cartas.size());
                cartasRandom.add(cartas.get(numero));
                i++;
            }
            return cartasRandom;
        }
    } 
    
        //Metodo de iniciar musica
    public void startMusic(){
        try{
            File musica = new File("src/elementos/pelea.wav");
            if(musica.exists()){
                AudioInputStream audio = AudioSystem.getAudioInputStream(musica);
                clip = AudioSystem.getClip();
                clip.open(audio);
                clip.loop(Clip.LOOP_CONTINUOUSLY);
                clip.start();
            }
        }catch(Exception e){
        }
    }
}