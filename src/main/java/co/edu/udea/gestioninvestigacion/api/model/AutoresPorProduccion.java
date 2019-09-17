package co.edu.udea.gestioninvestigacion.api.model;

import javax.persistence.*;

@Entity
@Table(name="AutoresPorProduccion", uniqueConstraints=@UniqueConstraint(columnNames={"personaID", "produccionID"}))
public class AutoresPorProduccion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int autoresProdID;

    @ManyToOne(optional=false,fetch = FetchType.LAZY)
    @JoinColumn(name="personaID")
    private Persona autor;

    @ManyToOne(optional=false,fetch = FetchType.LAZY)
    @JoinColumn(name="produccionID")
    private Produccion produccion;

    public AutoresPorProduccion() {
    }

    public AutoresPorProduccion(Persona autor, Produccion produccion) {
        this.autor = autor;
        this.produccion = produccion;
    }

    public int getAutoresProdID() {
        return autoresProdID;
    }

    public void setAutoresProdID(int autoresProdID) {
        this.autoresProdID = autoresProdID;
    }

    public Persona getAutor() {
        return autor;
    }

    public void setAutor(Persona autor) {
        this.autor = autor;
    }

    public Produccion getProduccion() {
        return produccion;
    }

    public void setProduccion(Produccion produccion) {
        this.produccion = produccion;
    }
}
