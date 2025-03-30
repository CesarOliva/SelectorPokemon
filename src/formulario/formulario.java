package formulario;

//Se importan las librerias a usar
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

//Importar las "librerias" personalizadas a utilizar
import elementos.CheckBoxSelected;
import elementos.BackgroundTextField;
import elementos.CustomCB;
import elementos.RoundedButton;
import elementos.RBSelected;
import elementos.SliderSize;


//Clase principal que muestra los elementos del formulario
public class formulario extends JFrame{
    //Filtros
    private JTextField nombreTF;
    private JSlider slider;
    private JComboBox categoriasComboBox;
    //Listas de elementos de tipo especifico
    private JCheckBox [] tiposCB; 
    private JRadioButton [] regionRB;
    private ButtonGroup regiones;

    private Clip clip;
    private static formulario instancia;
    
    //Arreglo de opciones para el comboBox
    String categoriasLista [] = {"Pokémon Ratón", "Pokémon Pez", "Pokémon Ave", "Pokémon Bicho", 
        "Pokémon Dragón", "Pokémon Perro/Lobo", "Pokémon Gato/Felino", "Pokémon Planta/Flor", 
        "Pokémon Humanoide", "Pokémon Fantasma/Espectral"};

    //Tipos de pokemones para iterar
    String tiposLista [] = {"Eléctrico", "Fuego", "Lucha", "Agua", "Normal", "Fantasma",
        "Planta", "Bicho", "Psíquico", "Volador", "Tierra", "Dragón"};

    //Nombre de regiones para iterar
    String regionLista [] = {"Kanto", "Johto" ,"Hoenn", "Sinnoh", "Unova", "Kalos",
        "Alola", "Galar", "Paldea"};
            
    //Constructor clase formulario
    public formulario(){
        //Configuración de la ventana
        setTitle("Selección de personaje");
        setSize(500, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        
        
        //Comienza la musica de fondo
        startMusic();

        //Creación del panel
        JPanel panel = new JPanel();
        panel.setLayout(null);
        
        instancia = this;

        //Lista de checkBox        
        tiposCB = new JCheckBox[tiposLista.length];
        //Lista de regiones
        regionRB = new JRadioButton[regionLista.length];
        //Grupo de los RadioButton
        regiones = new ButtonGroup();
        
        //Imagen del fondo panel.
        JLabel fondo = new JLabel(new ImageIcon(getClass().getResource("/elementos/fondoInicio.png")));
        fondo.setBounds(0, 0, 500, 700); // Ajusta al tamaño de la ventana
        
        //Elementos del panel
        JLabel nombre = new JLabel("Busqueda por nombre:");
        nombre.setFont(new Font("Poppins", Font.PLAIN, 16));
        nombre.setForeground(Color.WHITE);
        nombre.setBounds(30, 30, 200, 30);

        nombreTF = new BackgroundTextField();
        nombreTF.setBounds(230, 30, 130, 30);
        
        JButton select = new RoundedButton("Seleccionar");
        select.setBackground(new Color(125, 120, 163));
        select.setForeground(Color.WHITE);
        select.setBounds(370, 30, 100, 30);
        
        JLabel tipo = new JLabel("Tipo de Pokémon: ");
        tipo.setFont(new Font("Poppins", Font.PLAIN, 16));
        tipo.setForeground(Color.WHITE);
        tipo.setBounds(30, 70, 200, 30);

        //Crea checkbox y los agrega al panel
        int pos1 = 100;
        int pos2 = 100;
        int pos5 = 100;
        for(int i=0;i<tiposLista.length;i++){
            tiposCB[i] = new CheckBoxSelected(tiposLista[i]);
            if(i<5){
                //Cambio de posicion en el eje y con un  x fijo
                tiposCB[i].setBounds(30, pos1, 120, 30);
                pos1+=30;
            }else if(i<10){
                //Cambio de posicion en el eje y con un  x fijo
                tiposCB[i].setBounds(160, pos2, 120, 30);                
                pos2+=30;
            }else{
                tiposCB[i].setBounds(290, pos5, 100, 30);
                pos5+=30;
            }
            tiposCB[i].addActionListener((ActionEvent e)->{
                VerificarCB();
            });
            
            //Se agregan los checkbox al panel
            panel.add(tiposCB[i]);
        }        

        JLabel tamaño = new JLabel("Tamaño:");
        tamaño.setFont(new Font("Poppins", Font.PLAIN, 16));
        tamaño.setForeground(Color.WHITE);
        tamaño.setBounds(30, 260, 100, 30);

        slider = new SliderSize();
        slider.setBounds(30, 280, 400, 80);

        JLabel region = new JLabel("Región:");
        region.setFont(new Font("Poppins", Font.PLAIN, 16));
        region.setForeground(Color.WHITE);
        region.setBounds(30, 360, 100, 30);

        //Crea radioButton y los agrega al panel        
        int pos3 = 390;
        int pos4 = 390;
        for(int i=0;i<regionLista.length;i++){
            regionRB[i] = new RBSelected(regionLista[i]);
            if(i<5){
                //Cambio de posicion en el eje y con un  x fijo
                regionRB[i].setBounds(30, pos3, 100, 30);
                pos3+=30;
            }else{
                //Cambio de posicion en el eje y con un  x fijo
                regionRB[i].setBounds(200, pos4, 100, 30);
                pos4+=30;
            }
            //Se agregan los radioButton al grupo de radioButton y al panel
            regiones.add(regionRB[i]);
            panel.add(regionRB[i]);
        }

        JLabel categorias = new JLabel("Categoría:");
        categorias.setFont(new Font("Poppins", Font.PLAIN, 16));
        categorias.setForeground(Color.WHITE);
        categorias.setBounds(30, 550, 100, 30);
        
        categoriasComboBox = new CustomCB(categoriasLista);
        categoriasComboBox.setMaximumRowCount(3);
        categoriasComboBox.setBounds(130, 550, 250, 30);
        
        JButton reset = new RoundedButton("Limpiar");
        reset.setBounds(125, 600, 100, 30);
        reset.setBackground(new Color(193,191,203));        
        reset.setForeground(Color.BLACK);
        
        JButton search = new RoundedButton("Buscar");
        search.setBounds(275, 600, 100, 30);
        search.setBackground(Color.RED);
        search.setForeground(Color.white);
        
        
        //Funcionalidad del botón de selección
        select.addActionListener((ActionEvent e)->{
            //Llama al metodo de busqueda por nombre utilizando el texto del textField
            Pokemon.busquedaNombre(getNombre());
            limpiarFiltros();
        });
        
        //Funcionalidad del botón de reset
        reset.addActionListener((ActionEvent e)->{
            limpiarFiltros();
        });
        
        //Funcionalidad del botón de busqueda
        search.addActionListener((ActionEvent e)->{
            //Abre el frame de selección de personaje
            new Mostrar(getFiltros());
            limpiarFiltros();
        });
        
        //Agrega los elementos al panel
        panel.add(nombre);
        panel.add(nombreTF);
        panel.add(select);        
        panel.add(tipo);
        panel.add(tamaño);
        panel.add(slider);
        panel.add(region);
        panel.add(categorias);
        panel.add(categoriasComboBox);
        panel.add(reset);
        panel.add(search);
        panel.add(fondo);
        
        //Agrega el panel al frame
        add(panel);

        //Quita el focus del textField al abrir la interfáz
        SwingUtilities.invokeLater(() -> {
            nombreTF.setEnabled(false);
            nombreTF.setEnabled(true);
            nombre.requestFocusInWindow();
        });
 
        setVisible(true);
    }
    
    //Metodo de iniciar musica
    public void startMusic(){
        try{
            File musica = new File("src/elementos/fondo.wav");
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
    
    public void VerificarCB(){
        int CBSelected = 0;
        for(int i=0;i<tiposLista.length;i++){
            if(tiposCB[i].isSelected()){
                CBSelected++;
            }
            if(CBSelected>=3){
                tiposCB[i].setSelected(false);
            }
        }
    }
    
    //Obtener el nombre
    public String getNombre(){
        //Devuelve el nombre
        return nombreTF.getText();
    }
    
    //Obtener tipo
    public List<String> getTipo(){
        //Lista que guarda los elementos seleccionados
        List<String> tipoString = new ArrayList<>();
        for(int i=0;i<tiposLista.length;i++){
            if(tiposCB[i].isSelected()){
                //Agrega a la lista el checkbox seleccionado
                tipoString.add(tiposCB[i].getText());
            }
        }
        //Devuelve la lista con los checkbox seleccionados
        return tipoString;
    }

    //Obtener tamaño
    public String getTamaño(){
        int valor = slider.getValue();
        //Devuelve el tamaño en base a los valores del slider
        if(valor<33){
            return "Chico";
        }else if(valor<66){
            return "Mediano";
        }else{
            return "Grande";
        }
    }
    
    //Obtener región
    public String getRegion(){
        for(int i=0;i<regionRB.length;i++){
            if(regionRB[i].isSelected()){
                //Devuelve la región
                return regionLista[i];
            }
        }
        //Devuelve vacio si no está nada seleccionado
        return "";
    }
    
    //Obtener categoría
    public String getCategoria(){
        //Obtiene el texto del comboBox
        String categoria = (String) categoriasComboBox.getSelectedItem();
        //Separa el texto en cada espacio para separar la categoría de la palabra "Pokémon"
        String [] categoriaSplit = categoria.split(" ");
        //Devuelve la categoría
        return categoriaSplit[1];
    }
    
    
    
    //Obtiene todos los filtros juntos
    public List <Pokemon> getFiltros(){
        List<String> tipo = getTipo();
        String tamaño = getTamaño();
        String categoria = getCategoria();
        String region = getRegion();

        //Dependiendo de los filtros llama un metodo u otro (Sobrecarga)
        if(regiones.getSelection() != null && Arrays.stream(tiposCB).anyMatch(JCheckBox::isSelected)){
            return Pokemon.pokemonesFiltrados(tipo, tamaño, region, categoria);
        }else if(Arrays.stream(tiposCB).anyMatch(JCheckBox::isSelected)){
            return Pokemon.pokemonesFiltrados(tipo, tamaño, categoria);
        }else if(regiones.getSelection() != null ){
            return Pokemon.pokemonesFiltrados(tamaño, region, categoria);
        }else{
            return Pokemon.pokemonesFiltrados(tamaño, categoria);
        }
    }
    
    
    //Limpia los filtros
    public void limpiarFiltros(){
        nombreTF.setText("");

        for(JCheckBox cb : tiposCB){
            cb.setSelected(false);
        }

        slider.setValue(50);
        regiones.clearSelection();
        categoriasComboBox.setSelectedIndex(0);
    }
    
    //Obtiene una instancia de la clase formulario
    public static formulario getInstancia(){
        return instancia;
    }
    
    //Cierra la ventana
    public void cerrar(){
        dispose();
        clip.stop();
        clip.close();
    }
}