

package tp;


public class Participante {
        private int idParticipante;
	private String nombre;
	private ListaPronosticos pronostico;

    public Participante(int idParticipante, String nombre, ListaPronosticos pronostico) {
        this.idParticipante = idParticipante;
        this.nombre = nombre;
        this.pronostico = pronostico;
    }
    public Participante() {
        this.idParticipante = 0;
        this.nombre = null;
        this.pronostico = null;
    }
    
        public int getIdParticipante() {
        return idParticipante;
    }

    public void setIdParticipante(int idParticipante) {
        this.idParticipante = idParticipante;
    }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ListaPronosticos getPronostico(int idParticipante) {
		return pronostico;
	}

	public void setPronostico(ListaPronosticos pronostico) {
		this.pronostico = pronostico;
	}
        
        
       
	@Override
	public String toString() {
		return "Participante [ " + "idParticipante=" + idParticipante + ", nombre=" + nombre + ", pronostico=" + pronostico + "]";
	}

    void cargarPronosticos(ListaEquipos equipos, ListaPartidos partidos) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
     
}