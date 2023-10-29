package com.lab8.lab8.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lab8.lab8.Models.Productos;
import com.lab8.lab8.Services.ProductosDb;

@RestController
public class ProductoControllers {

    @GetMapping("/productos/all")
    public List<Productos> ObtenerTodosProductos(){
         return new ProductosDb().ObtenerProductos();
    }
}
