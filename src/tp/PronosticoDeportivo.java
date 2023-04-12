
package tp;

public class PronosticoDeportivo {
    private final ListaEquipos equipos;
    private final ListaPartidos partidos;
    private final ListaParticipantes participantes;
    private final ListaPronosticos pronosticos;

    public PronosticoDeportivo() {
        equipos = new ListaEquipos();
        partidos = new ListaPartidos();
        participantes = new ListaParticipantes();
        pronosticos = new ListaPronosticos();
    }

    public void play(){
      
        equipos.cargarDeArchivo();
        System.out.println("Los equipos participantes son: " + equipos.listar());
        
        partidos.cargarDeArchivo(equipos);
        System.out.println("Los Resultados de los partidos son: " + partidos.listar());

        participantes.cargarDeArchivo();
        System.out.println("Los participantes son: " + participantes.listar());
       
        //pronosticos.cargarDeArchivo();
        //System.out.println("Los Pronosticos cargados son: " + pronosticos.listar());
        
        
        //for (Participante p : participantes.getParticipantes()) {
           // p.cargarPronosticos(equipos, partidos);
        //}
        //pronosticos.cargarDeArchivo(0, equipos, partidos);
        
        
        
       
    }    
}