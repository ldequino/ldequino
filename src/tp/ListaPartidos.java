
package tp;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListaPartidos {
  
    private List<Partido> partidos;
    private String partidosCSV;
   
    public ListaPartidos(List<Partido> partidos, String partidosCSV) {
        this.partidos = partidos;
        this.partidosCSV = partidosCSV;
    }
    
    public ListaPartidos() {
        this.partidos = new ArrayList<Partido>();
        this.partidosCSV = "partidos.csv";
    }

    public List<Partido> getPartidos() {
        return partidos;
    }
    
    public void setPartidos(List<Partido> partidos) {
        this.partidos = partidos;
    }

    public String getPartidosCSV() {
        return partidosCSV;
    }

    
    public void setPartidosCSV(String partidosCSV) {
        this.partidosCSV = partidosCSV;
    }
    
    public void addPartido(Partido e) {
        this.partidos.add(e);
    }
    public void removePartido(Partido e) {
        this.partidos.remove(e);
    }
    
   
public Partido getPartido (int idPartido) {
        
        Partido encontrado = null;
      
        for (Partido eq : this.getPartidos()) {
           
            if (eq.getidPartido() == idPartido) {
               
                encontrado = eq;
                
                break;
            }
        }
      
        return encontrado;
    }

@Override
    public String toString() {
        return "ListaPartidos{" + "partidos=" + partidos + '}';

    public String listar() {
        String lista = "";
        for (Partido partido: partidos) {
            lista += "\n" + partido;
        }           
        return lista;
        }
    
    // cargar desde el archivo
    public void cargarDeArchivo() {
        // para las lineas del archivo csv
        String datosPartido;
        // para los datos individuales de cada linea
        String vectorPartido[];
        // para el objeto en memoria
        Partido partido;
        int fila = 0;
       
        try { 
            Scanner sc = new Scanner(new File(this.getPartidosCSV()));
            sc.useDelimiter("\n");   //setea el separador de los datos
                
            while (sc.hasNext()) {
                datosPartido = sc.next();
                fila ++;
                if (fila == 1)
                    continue;              
                vectorPartido = datosPartido.split(",");   
                
                
                int idPartido = Integer.parseInt(vectorPartido[0]);
                int idEquipo1 = Integer.parseInt(vectorPartido[1]);
                int idEquipo2 = Integer.parseInt(vectorPartido[2]);
                int GolesEquipo1 = Integer.parseInt(vectorPartido[3]);
                int GolesEquipo2 = Integer.parseInt(vectorPartido[4]);
                partido = new Partido(idPartido, idEquipo1, idEquipo2, GolesEquipo1, GolesEquipo2);
                
              
                this.addPartido(partido);
            }
            //closes the scanner
        } catch (IOException ex) {
                System.out.println("Mensaje: " + ex.getMessage());
        }       

    }

}
    
    
   
