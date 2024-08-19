package org.example.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Alumnos")
public class categorias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<productos> productos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<org.example.entities.productos> getProductos() {
        return productos;
    }

    public void setProductos(List<org.example.entities.productos> productos) {
        this.productos = productos;
    }
}
