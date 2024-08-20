package org.example;

import org.example.DTO.producto;
import org.example.DTO.recomendacion;
import org.example.Services.productosServices;
import org.example.Services.recomendacionesServices;
import org.example.entities.productos;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        productosServices ServicioProducto=new productosServices();
        recomendacionesServices ServicioRecomendacion=new recomendacionesServices();

        productos ProductoParametro=new productos();
        Scanner scanner=new Scanner(System.in);
        System.out.println("Lea un Id de producto");
        int IdProducto= scanner.nextInt();
        while (IdProducto !=0){
            System.out.println("Lea un Id de recomendacion");
            int IdRecomendacion= scanner.nextInt();

            // Retornar el promedio de valoraciones
            List<Double> ObtenerPromedioValoraciones=ServicioRecomendacion.ObtenerPromedioValoracionesPorCategoria();

            // Retornar valoraciones de un producto
            List<recomendacion>R1=ServicioRecomendacion.ObtenerValoracionesDeUnProducto( IdProducto);
            R1.forEach(recomendacion -> System.out.println(", Valoracion" + recomendacion.getValoracion()));

            // Retornar producto con más valoraciones
            List<producto> R2= (List<producto>) ServicioProducto.ObtenerProductoConMasValoraciones();

        }
}}