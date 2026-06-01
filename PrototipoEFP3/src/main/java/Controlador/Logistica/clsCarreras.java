//Boris de Leon 9959-24-6203
package Controlador.Logistica;

public class clsCarreras {

    private String codigoCarrera;
    private String nombreCarrera;
    private String codigoFacultad;
    private String estatusCarrera;

    // Constructor vacío
    public clsCarreras() {
    }

    // Constructor con parámetros
    public clsCarreras(String codigoCarrera, String nombreCarrera,
            String codigoFacultad, String estatusCarrera) {
        this.codigoCarrera = codigoCarrera;
        this.nombreCarrera = nombreCarrera;
        this.codigoFacultad = codigoFacultad;
        this.estatusCarrera = estatusCarrera;
    }

    // Getters y Setters
    public String getCodigoCarrera() {
        return codigoCarrera;
    }

    public void setCodigoCarrera(String codigoCarrera) {
        this.codigoCarrera = codigoCarrera;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public String getCodigoFacultad() {
        return codigoFacultad;
    }

    public void setCodigoFacultad(String codigoFacultad) {
        this.codigoFacultad = codigoFacultad;
    }

    public String getEstatusCarrera() {
        return estatusCarrera;
    }

    public void setEstatusCarrera(String estatusCarrera) {
        this.estatusCarrera = estatusCarrera;
    }

    // ToString
    @Override
    public String toString() {
        return "clsCarreras{" +
                "codigoCarrera='" + codigoCarrera + '\'' +
                ", nombreCarrera='" + nombreCarrera + '\'' +
                ", codigoFacultad='" + codigoFacultad + '\'' +
                ", estatusCarrera='" + estatusCarrera + '\'' +
                '}';
    }
}