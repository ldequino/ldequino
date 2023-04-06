

package tp;


public class Participante {
        private int idParticipante;
	private String nombre;
	private String pronostico;

	public Participante(int idParticipante, String nombre, String pronostico) {
                super();
                this.idParticipante = idParticipante;
                this.nombre = nombre;
		this.pronostico = pronostico;

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

	public String getPronostico() {
		return pronostico;
	}

	public void setPronostico(String pronostico) {
		this.pronostico = pronostico;
	}
        
        
       
	@Override
	public String toString() {
		return "Participante [ " + "idParticipante=" + idParticipante + ", nombre=" + nombre + ", pronostico=" + pronostico + "]";
	}
     
}