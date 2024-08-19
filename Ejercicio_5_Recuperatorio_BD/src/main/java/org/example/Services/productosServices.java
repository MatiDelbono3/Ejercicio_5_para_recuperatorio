package org.example.Services;

import jakarta.persistence.Query;
import org.example.DTO.producto;
import org.example.connections.HibernateUtil;
import org.example.entities.productos;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class productosServices {
    public producto ObtenerProductoConMasValoraciones(){
        Session session= HibernateUtil.getSession();
        producto producto;
        producto productoConMasValoraciones=new producto();
        try {
            session.beginTransaction();
            String Sql3="SELECT p.id, p.nombre, COUNT(r.id) AS total_valoraciones\n" +
                    "FROM productos p\n" +
                    "JOIN recomendaciones r ON p.id = r.producto_id\n" +
                    "GROUP BY p.id, p.nombre\n" +
                    "ORDER BY total_valoraciones DESC\n" +
                    "LIMIT 1";
            Query Consulta3=session.createQuery(Sql3, producto.class);
            productoConMasValoraciones= (org.example.DTO.producto) Consulta3.getSingleResult();
            return productoConMasValoraciones;
        }finally {
            session.close();
        }
    }
}
