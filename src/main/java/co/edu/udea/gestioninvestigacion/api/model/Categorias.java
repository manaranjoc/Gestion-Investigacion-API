package co.edu.udea.gestioninvestigacion.api.model;

import javax.persistence.*;

@Entity
@Table(name = "Categorias")
public class Categorias {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int categoriaID;

    private String materia;
    private String tema;

    public Categorias() {
    }

    public Categorias(String materia, String tema) {
        this.materia = materia;
        this.tema = tema;
    }

    public int getCategoriaID() {
        return categoriaID;
    }

    public void setCategoriaID(int categoriaID) {
        this.categoriaID = categoriaID;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }
}
