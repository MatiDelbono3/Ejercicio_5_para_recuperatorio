package org.example.DTO;

import org.example.entities.recomendaciones;

public class recomendacion {
    private int id;
    private int producto_id;
    private String texto;
    private int valoracion;
    public recomendacion(recomendaciones r){
        id=r.getId();
        producto_id=r.getProducto().getId();
        texto=r.getTexto();
        valoracion=r.getValoracion();
    }
}
