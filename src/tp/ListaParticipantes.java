

package tp;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListaParticipantes {
    // atributo
    private List<Participante> participantes;
    private String participantesCSV;

    public ListaParticipantes(List<Participante> participantes, String participantesCSV) {
        this.participantes = participantes;
        this.participantesCSV = participantesCSV;
    }
    
    public ListaParticipantes() {
        this.participantes = new ArrayList<Participante>();
        this.participantesCSV = "participantes.csv";
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Participante> participantes) {
        this.participantes = participantes;
    }

    public String getParticipantesCSV() {
        return participantesCSV;
    }

    public void setParticipantesCSV(String participantesCSV) {
        this.participantesCSV = participantesCSV;
    }
    
    // add y remove elementos
    public void addParticipante(Participante e) {
        this.participantes.add(e);
    }
    public void removeParticipante(Participante e) {
        this.participantes.remove(e);
    }
    
    /***
     * Este método devuelve un Equipo (o null) buscandolo por idEquipo
     * @param idParticipante Identificador del equipo deseado
     * @return Objeto Equipo (o null si no se encuentra)
     */
    public Participante getParticipante (int idParticipante) {
       
        Participante encontrado = null;
      
        for (Participante eq : this.getParticipantes()) {
           
            if (eq.getIdParticipante() == idParticipante) {
              
                encontrado = eq;
               
                break;
            }
        }
       
        return encontrado;
    }

    @Override
    public String toString() {
        return "ListaParticipantes{" + "participantes=" + participantes + '}';
    }

    public String listar() {
        String lista = "";
        for (Participante participante: participantes) {
            lista += "\n" + participante;
        }           
        return lista;
    }
    
    // cargar desde el archivo
    public void cargarDeArchivo() {
        // para las lineas del archivo csv
        String datosParticipante;
        // para los datos individuales de cada linea
        String vectorParticipante[];
        // para el objeto en memoria
        Participante participante;
        int fila = 0;
       
        try { 
            Scanner sc = new Scanner(new File(this.getParticipantesCSV()));
            sc.useDelimiter("\n");   //setea el separador de los datos
                
            while (sc.hasNext()) {
                // levanta los datos de cada linea
                datosParticipante = sc.next();
     
                fila ++;
                
                if (fila == 1)
                    continue;              
                 
               
                vectorParticipante = datosParticipante.split(",");   
                
               
                int idParticipante = Integer.parseInt(vectorParticipante[0]);
                String nombre = vectorParticipante[1];
                String descripcion = vectorParticipante[2];
            
                participante = new Participante(idParticipante, nombre, descripcion);
               
                this.addParticipante(participante);
            }
           
        } catch (IOException ex) {
                System.out.println("Mensaje: " + ex.getMessage());
        }       

    }

}
