
package tp;

public class Pronostico {
    private int idParticipante;
    private int idPartido;
    private int Equipo;
    private String Resultado;

    public Pronostico(int idParticipante, int idPartido, int Equipo, String Resultado) {
        this.idParticipante = idParticipante;
        this.idPartido = idPartido;
        this.Equipo =  Equipo;
        this.Resultado = Resultado;
    }
    
    public Pronostico(int readidPronostico, Equipo equipo, Partido partido, char readResultado) {
        this.idParticipante = 0;
        this.idPartido = 0;
        this.Equipo = 0;
        this.Resultado = null;
    }

    public int getEquipo() {
        return Equipo;
    }

    public int getIdPartido() {
        return idPartido;
    }

    public int getIdParticipante() {
        return idParticipante;
    }

    public String getResultado() {
        return Resultado;
    }

    public void setEquipo(int Equipo) {
        this.Equipo = Equipo;
    }

    public void setIdParticipante(int idParticipante) {
        this.idParticipante = idParticipante;
    }

    public void setResultado(String Resultado) {
        this.Resultado = Resultado;
    }

    public void setIdPartido(int idPartido) {
        this.idPartido = idPartido;
    }

    @Override
    public String toString() {
        return "Partido{" + "idPartido=" + idPartido + " Equipo=" + Equipo + ", Resultado=" + Resultado +  '}';
    }

    
}