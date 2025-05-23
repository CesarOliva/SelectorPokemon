package formulario;

//Se importan las librerias a utilizar
import elementos.RoundedButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.*;
import javax.swing.*;

//Clase pokemon. Estructura/Formato de pokemones
public class Pokemon {
    //Atributos del tipo Pokemon
    private String nombre;
    private List<String> tipos;
    private String tamaño;
    private String region;
    private String categoria;
    private String url;
    
    //Lista de tipo Pokemon
    private static List<Pokemon> pokemones = new ArrayList<>();


    //Constructor del pokémon
    public Pokemon(String nombre, List<String> tipos, String tamaño, String region, String categoria, String url) {
        //Atributos
        this.nombre = nombre;
        this.tipos = tipos;
        this.tamaño = tamaño;
        this.region = region;
        this.categoria = categoria;
        this.url = url;
    }
    
    //Metodos para obtener los datos del pokemon
    protected String getNombre(){return nombre;}
    protected List<String> getTipo(){return tipos;}
    protected String getTamaño(){return tamaño;}
    protected String getRegion(){return region;}
    protected String getCategoria(){return categoria;}
    protected String getURL(){return url;}
    
    //Clase interna Pokedex que crea los pokemones y los guarda en una lista
    static class Pokedex {
        //Obtiene la lista de los pokemones
        private List<Pokemon> getListaPokemon() {
            //Se crean los pokemones
            pokemones.add(new Pokemon("Pikachu", Arrays.asList("Eléctrico"), "Chico", "Kanto", "Ratón",
                    "/pokemones/Pikachu.png"));
            pokemones.add(new Pokemon("Raichu", Arrays.asList("Eléctrico"), "Mediano", "Kanto", "Ratón",
                    "/pokemones/Raichu.png"));
            pokemones.add(new Pokemon("Pawmot", Arrays.asList("Eléctrico", "Lucha"), "Chico", "Paldea", "Ratón",
                    "/pokemones/Pawmot.png"));
            pokemones.add(new Pokemon("Jolteon", Arrays.asList("Eléctrico"), "Chico", "Kanto", "Gato/Felino",
                    "/pokemones/Jolteon.png"));
            pokemones.add(new Pokemon("Luxray", Arrays.asList("Eléctrico"), "Mediano", "Sinnoh", "Gato/Felino",
                    "/pokemones/Luxray.png"));
            pokemones.add(new Pokemon("Manectric", Arrays.asList("Eléctrico"), "Mediano", "Hoenn", "Perro/Lobo",
                    "/pokemones/Manectric.png"));
            pokemones.add(new Pokemon("Zapdos", Arrays.asList("Eléctrico", "Volador"), "Grande", "Kanto", "Ave",
                    "/pokemones/zapdos.png"));
            pokemones.add(new Pokemon("Eelektross", Arrays.asList("Eléctrico"), "Grande", "Unova", "Pez",
                    "/pokemones/eelektross.png"));
            pokemones.add(new Pokemon("Rotom-Mow", Arrays.asList("Eléctrico", "Planta"), "Mediano", "Sinnoh", "Planta/Flor",
                    "/pokemones/rotom-mow.png"));

            pokemones.add(new Pokemon("Arcanine", Arrays.asList("Fuego"), "Grande", "Kanto", "Perro/Lobo",
                    "/pokemones/arcanine.png"));
            pokemones.add(new Pokemon("Typhlosion", Arrays.asList("Fuego"), "Mediano", "Johto", "Perro/Lobo",
                    "/pokemones/typhlosion.png"));
            pokemones.add(new Pokemon("Houndoom", Arrays.asList("Fuego"), "Mediano", "Johto", "Perro/Lobo",
                    "/pokemones/houndoom.png"));
            pokemones.add(new Pokemon("Blaziken", Arrays.asList("Fuego", "Lucha"), "Mediano", "Hoenn", "Humanoide",
                    "/pokemones/blaziken.png"));
            pokemones.add(new Pokemon("Infernape", Arrays.asList("Fuego", "Lucha"), "Mediano", "Sinnoh", "Humanoide",
                    "/pokemones/infernape.png"));
            pokemones.add(new Pokemon("Cinderace", Arrays.asList("Fuego"), "Mediano", "Galar", "Humanoide",
                    "/pokemones/cinderace.png"));
            pokemones.add(new Pokemon("Incineroar", Arrays.asList("Fuego"), "Grande", "Alola", "Gato/Felino",
                    "/pokemones/incineroar.png"));
            pokemones.add(new Pokemon("Litten", Arrays.asList("Fuego"), "Chico", "Alola", "Gato/Felino",
                    "/pokemones/litten.png"));
            pokemones.add(new Pokemon("Charizard", Arrays.asList("Fuego", "Volador"), "Grande", "Kanto", "Dragón",
                    "/pokemones/charizard.png"));
            pokemones.add(new Pokemon("Torchic", Arrays.asList("Fuego"), "Chico", "Hoenn", "Ave",
                    "/pokemones/torchic.png"));

            pokemones.add(new Pokemon("Blastoise", Arrays.asList("Agua"), "Grande", "Kanto", "Pez",
                    "/pokemones/blastoise.png"));
            pokemones.add(new Pokemon("Gyarados", Arrays.asList("Agua", "Volador"), "Grande", "Kanto", "Pez",
                    "/pokemones/gyarados.png"));
            pokemones.add(new Pokemon("Feraligatr", Arrays.asList("Agua"), "Grande", "Johto", "Pez",
                    "/pokemones/feraligatr.png"));
            pokemones.add(new Pokemon("Empoleon", Arrays.asList("Agua"), "Grande", "Sinnoh", "Pez",
                    "/pokemones/empoleon.png"));
            pokemones.add(new Pokemon("Primarina", Arrays.asList("Agua"), "Grande", "Alola", "Pez",
                    "/pokemones/primarina.png"));
            pokemones.add(new Pokemon("Quaquaval", Arrays.asList("Agua", "Lucha"), "Grande", "Paldea", "Ave",
                    "/pokemones/quaquaval.png"));
            pokemones.add(new Pokemon("Inteleon", Arrays.asList("Agua"), "Mediano", "Galar", "Humanoide",
                    "/pokemones/inteleon.png"));
            pokemones.add(new Pokemon("Greninja", Arrays.asList("Agua"), "Mediano", "Kalos", "Humanoide",
                    "/pokemones/greninja.png"));
            pokemones.add(new Pokemon("Marill", Arrays.asList("Agua"), "Chico", "Johto", "Ratón",
                    "/pokemones/marill.png"));
            pokemones.add(new Pokemon("Vaporeon", Arrays.asList("Agua"), "Mediano", "Kanto", "Gato/Felino",
                    "/pokemones/vaporeon.png"));
            pokemones.add(new Pokemon("Frillish", Arrays.asList("Agua", "Fantasma"), "Chico", "Unova", "Fantasma/Espectral",
                    "/pokemones/frillish.png"));

            pokemones.add(new Pokemon("Pidgeot", Arrays.asList("Normal", "Volador"), "Grande", "Kanto", "Ave",
                    "/pokemones/pidgeot.png"));
            pokemones.add(new Pokemon("Eevee", Arrays.asList("Normal"), "Chico", "Kanto", "Gato/Felino",
                    "/pokemones/eevee.png"));
            pokemones.add(new Pokemon("Minccino", Arrays.asList("Normal"), "Chico", "Unova", "Ratón",
                    "/pokemones/minccino.png"));
            pokemones.add(new Pokemon("Lillipup", Arrays.asList("Normal"), "Chico", "Unova", "Perro/Lobo",
                    "/pokemones/lillipup.png"));

            pokemones.add(new Pokemon("Banette", Arrays.asList("Fantasma"), "Mediano", "Hoenn", "Fantasma/Espectral",
                    "/pokemones/banette.png"));
            pokemones.add(new Pokemon("Chandelure", Arrays.asList("Fantasma", "Fuego"), "Mediano", "Unova", "Fantasma/Espectral",
                    "/pokemones/chandelure.png"));
            pokemones.add(new Pokemon("Sableye", Arrays.asList("Fantasma"), "Chico", "Hoenn", "Fantasma/Espectral",
                    "/pokemones/sableye.png"));
            pokemones.add(new Pokemon("Decidueye", Arrays.asList("Fantasma", "Planta"), "Mediano", "Alola", "Ave",
                    "/pokemones/decidueye.png"));

            pokemones.add(new Pokemon("Venusaur", Arrays.asList("Planta"), "Grande", "Kanto", "Planta/Flor",
                    "/pokemones/venusaur.png"));
            pokemones.add(new Pokemon("Bulbasaur", Arrays.asList("Planta"), "Chico", "Kanto", "Planta/Flor",
                    "/pokemones/bulbasaur.png"));
            pokemones.add(new Pokemon("Meganium", Arrays.asList("Planta"), "Grande", "Johto", "Planta/Flor",
                    "/pokemones/meganium.png"));
            pokemones.add(new Pokemon("Sceptile", Arrays.asList("Planta"), "Grande", "Hoenn", "Planta/Flor",
                    "/pokemones/sceptile.png"));
            pokemones.add(new Pokemon("Roserade", Arrays.asList("Planta"), "Mediano", "Sinnoh", "Planta/Flor",
                    "/pokemones/roserade.png"));
            pokemones.add(new Pokemon("Meowscarada", Arrays.asList("Planta"), "Mediano", "Paldea", "Gato/Felino",
                    "/pokemones/Meowscarada.png"));
            pokemones.add(new Pokemon("Rillaboom", Arrays.asList("Planta"), "Grande", "Galar", "Humanoide",
                    "/pokemones/Rillaboom.png"));
            pokemones.add(new Pokemon("Oddish", Arrays.asList("Planta"), "Chico", "Kanto", "Planta/Flor",
                    "/pokemones/Oddish.png"));
            pokemones.add(new Pokemon("Phantump", Arrays.asList("Planta", "Fantasma"), "Chico", "Kalos", "Fantasma/Espectral",
                    "/pokemones/Phantump.png"));
            pokemones.add(new Pokemon("Pumpkaboo", Arrays.asList("Planta", "Fantasma"), "Chico", "Kalos", "Planta/Flor",
                    "/pokemones/Pumpkaboo.png"));

            pokemones.add(new Pokemon("Torterra", Arrays.asList("Tierra", "Planta"), "Grande", "Sinnoh", "Planta/Flor",
                    "/pokemones/Torterra.png"));
            pokemones.add(new Pokemon("Swampert", Arrays.asList("Tierra", "Agua"), "Grande", "Hoenn", "Pez",
                    "/pokemones/Swampert.png"));
            pokemones.add(new Pokemon("Garchomp", Arrays.asList("Tierra", "Dragón"), "Grande", "Sinnoh", "Dragón",
                    "/pokemones/Garchomp.png"));
            pokemones.add(new Pokemon("Flygon", Arrays.asList("Tierra"), "Grande", "Hoenn", "Dragón",
                    "/pokemones/Flygon.png"));
            pokemones.add(new Pokemon("Sandshrew", Arrays.asList("Tierra"), "Chico", "Kanto", "Ratón",
                    "/pokemones/Sandshrew.png"));
            pokemones.add(new Pokemon("Nincada", Arrays.asList("Tierra", "Bicho"), "Chico", "Hoenn", "Bicho",
                    "/pokemones/Nincada.png"));

            pokemones.add(new Pokemon("Dragonite", Arrays.asList("Volador"), "Grande", "Kanto", "Dragón",
                    "/pokemones/Dragonite.png"));
            pokemones.add(new Pokemon("Salamence", Arrays.asList("Volador"), "Grande", "Hoenn", "Dragón",
                    "/pokemones/Salamence.png"));
            pokemones.add(new Pokemon("Togetic", Arrays.asList("Volador"), "Chico", "Johto", "Ave",
                    "/pokemones/Togetic.png"));
            pokemones.add(new Pokemon("Altaria", Arrays.asList("Volador"), "Mediano", "Hoenn", "Ave",
                    "/pokemones/Altaria.png"));
            pokemones.add(new Pokemon("Togekiss", Arrays.asList("Volador"), "Grande", "Sinnoh", "Ave",
                    "/pokemones/Togekiss.png"));
            pokemones.add(new Pokemon("Talonflame", Arrays.asList("Volador", "Fuego"), "Mediano", "Kalos", "Ave",
                    "/pokemones/Talonflame.png"));
            pokemones.add(new Pokemon("Corviknight", Arrays.asList("Volador"), "Grande", "Galar", "Ave",
                    "/pokemones/Corviknight.png"));
            pokemones.add(new Pokemon("Crobat", Arrays.asList("Volador"), "Mediano", "Johto", "Bicho",
                    "/pokemones/Crobat.png"));
            pokemones.add(new Pokemon("Hoppip", Arrays.asList("Volador", "Planta"), "Chico", "Johto", "Planta/Flor",
                    "/pokemones/Hoppip.png"));
            pokemones.add(new Pokemon("Drifloon", Arrays.asList("Volador", "Fantasma"), "Chico", "Sinnoh", "Fantasma/Espectral",
                    "/pokemones/Drifloon.png"));

            pokemones.add(new Pokemon("Scizor", Arrays.asList("Bicho"), "Mediano", "Johto", "Bicho",
                    "/pokemones/Scizor.png"));
            pokemones.add(new Pokemon("Volcarona", Arrays.asList("Bicho", "Fuego"), "Grande", "Unova", "Bicho",
                    "/pokemones/Volcarona.png"));
            pokemones.add(new Pokemon("Surskit", Arrays.asList("Bicho", "Agua"), "Chico", "Hoenn", "Pez",
                    "/pokemones/Surskit.png"));
            pokemones.add(new Pokemon("Larvesta", Arrays.asList("Bicho", "Fuego"), "Mediano", "Unova", "Tierra",
                    "/pokemones/Larvesta.png"));

            pokemones.add(new Pokemon("Gardevoir", Arrays.asList("Psíquico"), "Mediano", "Hoenn", "Humanoide",
                    "/pokemones/Gardevoir.png"));
            pokemones.add(new Pokemon("Metagross", Arrays.asList("Psíquico"), "Grande", "Hoenn", "Humanoide",
                    "/pokemones/Metagross.png"));
            pokemones.add(new Pokemon("Delphox", Arrays.asList("Psíquico", "Fuego"), "Mediano", "Kalos", "Humanoide",
                    "/pokemones/Delphox.png"));
            pokemones.add(new Pokemon("Espeon", Arrays.asList("Psíquico"), "Mediano", "Johto", "Gato/Felino",
                    "/pokemones/Espeon.png"));
            pokemones.add(new Pokemon("Cosmog", Arrays.asList("Psíquico"), "Chico", "Alola", "Fantasma/Espectral",
                    "/pokemones/Cosmog.png"));

            pokemones.add(new Pokemon("Lucario", Arrays.asList("Lucha"), "Mediano", "Sinnoh", "Humanoide",
                    "/pokemones/Lucario.png"));
            pokemones.add(new Pokemon("Chesnaught", Arrays.asList("Lucha", "Planta"), "Grande", "Kalos", "Humanoide",
                    "/pokemones/Chesnaught.png"));
            pokemones.add(new Pokemon("Kommo-o", Arrays.asList("Lucha", "Dragón"), "Grande", "Alola", "Dragón",
                    "/pokemones/Kommo.png"));
            pokemones.add(new Pokemon("Tyrogue", Arrays.asList("Lucha"), "Chico", "Johto", "Humanoide",
                    "/pokemones/Tyrogue.png"));
            pokemones.add(new Pokemon("Riolu", Arrays.asList("Lucha"), "Chico", "Sinnoh", "Perro/Lobo",
                    "/pokemones/Riolu.png"));

            pokemones.add(new Pokemon("Dragapult", Arrays.asList("Dragón", "Fantasma"), "Grande", "Galar", "Dragón",
                    "/pokemones/Dragapult.png"));
            pokemones.add(new Pokemon("Hydreigon", Arrays.asList("Dragón"), "Grande", "Unova", "Dragón",
                    "/pokemones/Hydreigon.png"));
            pokemones.add(new Pokemon("Haxorus", Arrays.asList("Dragón"), "Grande", "Unova", "Dragón",
                    "/pokemones/Haxorus.png"));
            pokemones.add(new Pokemon("Applin", Arrays.asList("Dragón", "Planta"), "Chico", "Galar", "Planta/Flor",
                    "/pokemones/Applin.png"));
            pokemones.add(new Pokemon("Goomy", Arrays.asList("Dragón"), "Chico", "Kalos", "Dragón",
                    "/pokemones/Goomy.png"));

            //Devuelve la lisa de pokemones
            return pokemones;
        }
    }

    
    //Busqueda de pokemones por nombre
    public static void busquedaNombre(String nombre) {
        if(pokemones == null || pokemones.isEmpty()){
            pokemones = new Pokedex().getListaPokemon();        
        }
        
        //Guarda el valor para verificar si existe el pokémon
        Boolean encontrado  = false;
        
        //Recorre toda la lista de pokemones
        for (Pokemon pokemon : pokemones) {
            //Compara el nombre con los de los pokemones
            if(pokemon.nombre.equalsIgnoreCase(nombre)){
                encontrado = true;
                new JuegoCartas(pokemon.getNombre());
                formulario.getInstancia().cerrar();
            }
        }
        //Si no lo encuentra muestra panel de no encontrado
        if(!encontrado){
            //Creación de la ventana
            JFrame frame = new JFrame("Pokemones encontrados");
            frame.setSize(500,390);
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
            
            //Creación del panel
            JPanel panel = new JPanel(null);
            
            //Creación de los elementos
            JLabel imagen = new JLabel(new ImageIcon(ClassLoader.getSystemResource("elementos/canyon.jpg")));
            imagen.setBounds(0, 0, 500, 360);
            
            JLabel text = new JLabel("Pokémon no encontrado");
            text.setFont(new Font("Poppins", Font.BOLD, 18));        
            text.setForeground(Color.white);
            text.setBounds(130, 150, 400, 30);
            
            JButton cerrar = new RoundedButton("Cerrar");
            cerrar.setBackground(Color.red);
            cerrar.setFont(new Font("Poppins", Font.PLAIN, 14));
            cerrar.setForeground(Color.white);
            cerrar.setBounds(210, 180, 80, 30);
            
            //funcionalidad del boton cerrar
            cerrar.addActionListener((ActionEvent e)->{
                frame.dispose();
            });
            
            //Agrega el panel
            panel.add(text); 
            panel.add(cerrar); 
            panel.add(imagen);
            frame.add(panel);
            
            frame.setVisible(true);
        }
    }
    
    
    
    //Sobrecarga de metodos
    //Metodo que devuelve los pokemones que cumplen con los filtros establecidos
    protected static List<Pokemon> pokemonesFiltrados(String tamaño, String categoria){
        //Crea una lista para guardar los pokemones que coincidan con los filtros
        ArrayList<Pokemon> filtroPokemon = new ArrayList<>();

        if(pokemones == null || pokemones.isEmpty()){
            pokemones = new Pokedex().getListaPokemon();        
        }        
        
        //Recorre toda la lista de pokemones
        for(Pokemon pokemon : pokemones){
            if(pokemon.tamaño.equals(tamaño) && pokemon.categoria.equals(categoria)){
                filtroPokemon.add(pokemon);
            }
        }
        return filtroPokemon;
    }
    
    protected static List<Pokemon> pokemonesFiltrados(List<String> tipo, String tamaño, String categoria){
        //Crea una lista para guardar los pokemones que coincidan con los filtros
        ArrayList<Pokemon> filtroPokemon = new ArrayList<>();

        if(pokemones == null || pokemones.isEmpty()){
            pokemones = new Pokedex().getListaPokemon();        
        }
        
        String lado1 = tipo.toString();
        String [] split = lado1.replace("[", "").replace("]", "").split(", ");
        String lado2 = "";
        if(tipo.size()==2){
            lado2 = "["+split[1]+", "+split[0]+"]";
        }else{
            lado2 = split[0];
        }
        
        //Recorre toda la lista de pokemones
        for (Pokemon pokemon : pokemones) {
            if (pokemon.tamaño.equals(tamaño) && pokemon.categoria.equals(categoria) && 
                (pokemon.tipos.toString().equals(lado1) || pokemon.tipos.toString().equals(lado2))){
                filtroPokemon.add(pokemon);
            }else if (pokemon.tamaño.equals(tamaño) && pokemon.categoria.equals(categoria) && 
                (pokemon.tipos.toString().contains(lado1) || pokemon.tipos.toString().contains(lado2))){
                filtroPokemon.add(pokemon);                
            }
        }

        return filtroPokemon;
    }
    
    protected static List<Pokemon> pokemonesFiltrados(String tamaño, String region ,String categoria){
        //Crea una lista para guardar los pokemones que coincidan con los filtros
        ArrayList<Pokemon> filtroPokemon = new ArrayList<>();

        if(pokemones == null || pokemones.isEmpty()){
            pokemones = new Pokedex().getListaPokemon();        
        }        
        
        //Recorre toda la lista de pokemones
        for(Pokemon pokemon : pokemones){
            if(pokemon.tamaño.equals(tamaño)&& pokemon.region.equals(region)&& pokemon.categoria.equals(categoria)){
                filtroPokemon.add(pokemon);
            }
        }
        return filtroPokemon;
    }
    
    protected static List<Pokemon> pokemonesFiltrados(List<String> tipo, String tamaño, String region ,String categoria){
        //Crea una lista para guardar los pokemones que coincidan con los filtros
        ArrayList<Pokemon> filtroPokemon = new ArrayList<>();

        if(pokemones == null || pokemones.isEmpty()){
            pokemones = new Pokedex().getListaPokemon();        
        }        
        
        String lado1 = tipo.toString();
        String [] split = lado1.replace("[", "").replace("]", "").split(", ");
        String lado2 = "";
        if(tipo.size()==2){
            lado2 = "["+split[1]+", "+split[0]+"]";
        }else{
            lado2 = split[0];
        }
        
        //Recorre toda la lista de pokemones
        for (Pokemon pokemon : pokemones) {
            if (pokemon.tamaño.equals(tamaño) && pokemon.categoria.equals(categoria) && pokemon.region.equals(region)&& 
                (pokemon.tipos.toString().equals(lado1) || pokemon.tipos.toString().equals(lado2))){
                filtroPokemon.add(pokemon);
            }else if (pokemon.tamaño.equals(tamaño) && pokemon.categoria.equals(categoria) && pokemon.region.equals(region) && 
                (pokemon.tipos.toString().contains(lado1) || pokemon.tipos.toString().contains(lado2))){
                filtroPokemon.add(pokemon);                
            }
        }
        return filtroPokemon;
    }
}