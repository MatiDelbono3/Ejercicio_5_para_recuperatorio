package org.example.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Materias")
public class recomendaciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "texto", nullable = false)
    private String texto;
    @Column(name = "valoracion", nullable = false)
    private int valoracion;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producto_id")
    private productos producto;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }

    public productos getProducto() {
        return producto;
    }

    public void setProducto(productos producto) {
        this.producto = producto;
    }
}
