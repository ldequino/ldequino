

package tp;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListaParticipantes {
  
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
    

    public void addParticipante(Participante e) {
        this.participantes.add(e);
    }
    public void removeParticipante(Participante e) {
        this.participantes.remove(e);
    }
    
  
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
    
    
    public void cargarDeArchivo() {
     
        String datosParticipante;
       
        String vectorParticipante[];
     
        Participante participante;
        int fila = 0;
       
        try { 
            Scanner sc = new Scanner(new File(this.getParticipantesCSV()));
            sc.useDelimiter("\n");   //setea el separador de los datos
                
            while (sc.hasNext()) {
              
                datosParticipante = sc.next();
     
                fila ++;
                
                if (fila == 1)
                    continue;              
                 
               
                vectorParticipante = datosParticipante.split(",");   
                
                participante = new Participante();
                
                int idParticipante = Integer.parseInt(vectorParticipante[0]);
                String nombre = vectorParticipante[1];
                ListaPronosticos pronosticos = participante.getPronostico(idParticipante);
            
                participante.setIdParticipante(idParticipante);
                participante.setNombre(nombre);
                participante.setPronostico(pronosticos);
               
                this.addParticipante(participante);
            }
           
        } catch (IOException ex) {
                System.out.println("Mensaje: " + ex.getMessage());
        }       

    }

}
