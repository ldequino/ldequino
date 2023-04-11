package tp;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListaPronosticos {

    // atributo
    private List<Pronostico> pronosticos;
    private String pronosticosCSV;

    public ListaPronosticos(List<Pronostico> pronosticos, String pronosticosCSV) {
        this.pronosticos = pronosticos;
        this.pronosticosCSV = pronosticosCSV;
    }

    public ListaPronosticos() {
        this.pronosticos = new ArrayList<Pronostico>();
        this.pronosticosCSV = "pronosticos.csv";
    }

    public List<Pronostico> getPronosticos() {
        return pronosticos;
    }

    public void setPronosticos(List<Pronostico> pronosticos) {
        this.pronosticos = pronosticos;
    }

    public String getPronosticosCSV() {
        return pronosticosCSV;
    }

    public void setPronosticosCSV(String pronosticosCSV) {
        this.pronosticosCSV = pronosticosCSV;
    }

    public void addPronostico(Pronostico p) {
        this.pronosticos.add(p);
    }

    public void removePronostico(Pronostico p) {
        this.pronosticos.remove(p);
    }

    @Override
    public String toString() {
        return "ListaParticipantes{" + "pronosticos=" + pronosticos + '}';
    }

    public String listar() {
        String lista = "";
        for (Pronostico pronostico : pronosticos) {
            lista += "\n" + pronostico;
        }
        return lista;
    }

    public void cargarDeArchivo(
            int idParticipante,
            ListaEquipos listaequipos,
            ListaPartidos listapartidos
    ) {

        String datosPronostico;
        String vectorPronostico[];

        int fila = 0;

        try {
            Scanner sc = new Scanner(new File(this.getPronosticosCSV()));
            sc.useDelimiter("\n");   //setea el separador de los datos

            while (sc.hasNext()) {
                datosPronostico = sc.next();
                fila++;
                if (fila == 1) {
                    continue;
                }

                vectorPronostico = datosPronostico.split(",");

                int readidPronostico = Integer.parseInt(vectorPronostico[0]);
                int readidParticipante = Integer.parseInt(vectorPronostico[1]);
                int readidPartido = Integer.parseInt(vectorPronostico[2]);
                int readidEquipo = Integer.parseInt(vectorPronostico[3]);
                char readResultado = vectorPronostico[4].charAt(1);

                if (readidParticipante == idParticipante) {

                    Partido partido = listapartidos.getPartido(readidPartido);
                    Equipo equipo = listaequipos.getEquipo(readidEquipo);

                    Pronostico pronostico = new Pronostico(
                            readidPronostico, // El id leido del archivo
                            partido, // El Partido que obtuvimos de la lista
                            equipo, // El Equipo que obtuvimos de la lista
                            readResultado // El resultado que leimos del archivo
                    );

                    this.addPronostico(pronostico);
                }
            }

        } catch (IOException ex) {
            System.out.println("Mensaje: " + ex.getMessage());
        }
    }

    public void cargarDeArchivoTodos(
            ListaEquipos listaequipos,
            ListaPartidos listapartidos
    ) {

        String datosPronostico;
        String vectorPronostico[];

        int fila = 0;

        try {
            Scanner sc = new Scanner(new File(this.getPronosticosCSV()));
            sc.useDelimiter("\n");   //setea el separador de los datos

            while (sc.hasNext()) {

                datosPronostico = sc.next();

                fila++;

                if (fila == 1) {
                    continue;
                }

                vectorPronostico = datosPronostico.split(",");

                int readidPronostico = Integer.parseInt(vectorPronostico[0]);
                int readidParticipante = Integer.parseInt(vectorPronostico[1]);
                int readidPartido = Integer.parseInt(vectorPronostico[2]);
                int readidEquipo = Integer.parseInt(vectorPronostico[3]);
                char readResultado = vectorPronostico[4].charAt(1);     // El primer caracter es una comilla delimitadora de campo

                Partido partido = listapartidos.getPartido(readidPartido);
                Equipo equipo = listaequipos.getEquipo(readidEquipo);

                Pronostico pronostico = new Pronostico(
                        readidPronostico, // El id leido del archivo
                        partido, // El Partido que obtuvimos de la lista
                        equipo, // El Equipo que obtuvimos de la lista                
                        readResultado // El resultado que leimos del archivo,
                );

                // llama al metodo add para grabar el equipo en la lista en memoria
                this.addPronostico(pronostico);

            }
            //closes the scanner
        } catch (IOException ex) {
            System.out.println("Mensaje: " + ex.getMessage());
        }
    }
}
