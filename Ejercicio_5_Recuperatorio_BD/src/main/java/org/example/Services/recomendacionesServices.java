package org.example.Services;

import org.example.DTO.recomendacion;
import org.example.connections.HibernateUtil;
import org.example.entities.productos;
import org.example.entities.recomendaciones;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class recomendacionesServices {
    public void CargarRecomendacion(recomendaciones recomendacion){
        Session session= HibernateUtil.getSession();
        try{
        session.beginTransaction();
        session.save(recomendacion);
        session.getTransaction().commit();
    }finally {
            session.close();
        }
    }
    public List<Double>ObtenerPromedioValoracionesPorCategoria(){
        Session session=HibernateUtil.getSession();
        List<Double>PromedioValoracionesPorCategoria=new ArrayList<>();
        try{
            session.beginTransaction();
            String Sql1="SELECT c.nombre AS nombre_categoria, AVG(r.valoracion) AS promedio_valoracion\n" +
                    "FROM categorias c\n" +
                    "JOIN productos p ON c.id = p.categoria_id\n" +
                    "JOIN recomendaciones r ON p.id = r.producto_id\n" +
                    "GROUP BY c.id, c.nombre\n" +
                    "ORDER BY promedio_valoracion DESC";
            Query<Double> Consulta1=session.createQuery(Sql1, Double.class);
            PromedioValoracionesPorCategoria=Consulta1.getResultList();
            return PromedioValoracionesPorCategoria;
        }finally {
            session.close();
        }
    }
    public List<recomendacion>ObtenerValoracionesDeUnProducto(int idProducto){
        Session session=HibernateUtil.getSession();
        List<recomendaciones>ValoracionesDeUnProducto=new ArrayList<>();
        List<recomendacion>R1=new ArrayList<>();
        try{
            session.beginTransaction();
            String Sql2="SELECT r.id, r.texto, r.valoracion\n" +
                    "FROM recomendaciones r\n" +
                    "JOIN productos p ON r.producto_id = p.id\n" +
                    "WHERE p.id := idProducto";
            Query Consulta2=session.createQuery(Sql2, recomendacion.class);
            ValoracionesDeUnProducto=Consulta2.getResultList();
            for (recomendaciones r : ValoracionesDeUnProducto){
                R1.add(new recomendacion (r));
            }
            session.getTransaction().commit();
            return R1;
        }finally {
            session.close();
        }
    }

}
