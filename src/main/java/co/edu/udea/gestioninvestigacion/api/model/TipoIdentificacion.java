package co.edu.udea.gestioninvestigacion.api.model;


import javax.persistence.*;

//TODO: Revisar componentes y nombre de la tabla.
@Entity
@Table(name="TiposIdentificacion")
public class TipoIdentificacion {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int tipoIID;

    private String descripcion;

    public TipoIdentificacion() {
    }

    public TipoIdentificacion(int tipoIID, String descripcion) {
        this.tipoIID = tipoIID;
        this.descripcion = descripcion;
    }

    public int getTipoIID() {
        return tipoIID;
    }

    public void setTipoIID(int tipoIID) {
        this.tipoIID = tipoIID;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
