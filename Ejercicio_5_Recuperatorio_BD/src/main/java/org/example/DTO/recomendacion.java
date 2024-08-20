package org.example.DTO;

import org.example.entities.recomendaciones;

public class recomendacion {
    private int id;
    private int producto_id;
    private String texto;
    private int valoracion;
    public recomendacion(recomendaciones r){
        setId(r.getId());
        setProducto_id(r.getProducto().getId());
        setTexto(r.getTexto());
        setValoracion(r.getValoracion());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProducto_id() {
        return producto_id;
    }

    public void setProducto_id(int producto_id) {
        this.producto_id = producto_id;
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
}
