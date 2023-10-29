package com.lab8.lab8.Services;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.lab8.lab8.Models.Productos;

public class ProductosDb {
    Connection _cn;

    public ProductosDb(){
        _cn = new Conexion().openDb();
    }

    public List<Productos> ObtenerProductos(){
        try {
            Statement stmt = _cn.createStatement();
            String query = "SELECT * FROM productos";

            List<Productos> productos = new ArrayList<>();
            ResultSet result = stmt.executeQuery(query);
            while (result.next()) {
                Productos producto = new Productos(
                    result.getString("nombre"),
                    result.getFloat("precio"),
                    result.getString("foto")
                );
                productos.add(producto);
            }
            result.close();
            stmt.close();
            return productos;

        } catch (Exception e) {
            int x = 1;
        }

        return null;

    }
}
