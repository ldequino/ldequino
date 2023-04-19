
package tp;

public class Pronostico {

    private int idPronostico;
    private Partido Partido;
    private Equipo Equipo;
    private char Resultado;

    public Pronostico(int idPronostico, Equipo Equipo, Partido Partido, char Resultado, int readidParticipante) {
        this.idPronostico = idPronostico;
        this.Partido = Partido;
        this.Equipo = Equipo;
        this.Resultado = Resultado;
    }

    
    
   
    public Pronostico(int readidPronostico, Equipo equipo, Partido partido, char readResultado) {
        this.idPronostico = 0;
        this.Partido = null;
        this.Equipo = null;
        this.Resultado = '\u0000';
    }

    public int getIdPronostico() {
        return idPronostico;
    }

    public void setIdPronostico(int idPronostico) {
        this.idPronostico = idPronostico;
    }

    public Partido getPartido() {
        return Partido;
    }

    public void setPartido(Partido Partido) {
        this.Partido = Partido;
    }

    public Equipo getEquipo() {
        return Equipo;
    }

    public void setEquipo(Equipo Equipo) {
        this.Equipo = Equipo;
    }

    public char getResultado() {
        return Resultado;
    }

    public void setResultado(char Resultado) {
        this.Resultado = Resultado;
    }

    @Override
    public String toString() {
        return "Pronostico{" + "idPronostico=" + idPronostico + ", Partido=" + Partido + ", Equipo=" + Equipo + ", Resultado=" + Resultado + '}';
    }

    
    public int puntos() {
        int puntos = 0;
        char pron = getResultado();

        Partido partidoReal = getPartido();

        char rfinal = partidoReal.Resultado();

        if (pron == rfinal) {
            puntos = +1;
        } else {
            if (pron != rfinal) {
                puntos = +0;
            }
        }

        return puntos;

    }
}
