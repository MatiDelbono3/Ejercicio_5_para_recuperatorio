package org.example.DTO;

import org.example.entities.productos;

public class producto {
    private int id;
    private String nombre;
    private String descripcion;
    private int categoria_id;
    public producto(productos p){
        id=p.getId();
        nombre=p.getNombre();
        descripcion= p.getDescripcion();
        categoria_id= p.getCategoria().getId();
    }

    public producto() {

    }
}
