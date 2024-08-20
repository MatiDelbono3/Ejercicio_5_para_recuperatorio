package org.example.DTO;

import org.example.entities.productos;

public class producto {
    private int id;
    private String nombre;
    private String descripcion;
    private int categoria_id;
    public producto(productos p){
        setId(p.getId());
        setNombre(p.getNombre());
        setDescripcion(p.getDescripcion());
        setCategoria_id(p.getCategoria().getId());
    }

    public producto() {

    }

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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(int categoria_id) {
        this.categoria_id = categoria_id;
    }
}
