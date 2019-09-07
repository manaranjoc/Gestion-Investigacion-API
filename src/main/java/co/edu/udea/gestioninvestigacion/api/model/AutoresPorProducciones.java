package co.edu.udea.gestioninvestigacion.api.model;

import javax.persistence.*;

@Entity
@Table(name="AutoresPorProducciones")
public class AutoresPorProducciones {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int autoresProdID;

    @ManyToOne(optional=false,fetch = FetchType.LAZY)
    @JoinColumn(name="personaID")
    private int autor;

    @ManyToOne(optional=false,fetch = FetchType.LAZY)
    @JoinColumn(name="produccionID")
    private int produccion;

    public AutoresPorProducciones() {
    }

    public AutoresPorProducciones(int autor, int produccion) {
        this.autor = autor;
        this.produccion = produccion;
    }

    public int getAutoresProdID() {
        return autoresProdID;
    }

    public void setAutoresProdID(int autoresProdID) {
        this.autoresProdID = autoresProdID;
    }

    public int getAutor() {
        return autor;
    }

    public void setAutor(int autor) {
        this.autor = autor;
    }

    public int getProduccion() {
        return produccion;
    }

    public void setProduccion(int produccion) {
        this.produccion = produccion;
    }
}
