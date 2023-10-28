/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductoController {
    Producto[] tablaProducto;
    int indiceArray;
    private ConexionBaseDeDatos conectorBD;
    private Connection conexion;
    private PreparedStatement statement = null;
    private ResultSet result = null;
    
    public void abrirConexion(){
        conectorBD= new ConexionBaseDeDatos();
        conexion=conectorBD.conectar();
    }       
    
    public String guardarProducto(Producto producto) {
    String sql = "INSERT INTO producto (codigo_producto, nombre_producto, precio, existencia, fecha_vencimiento, id_marca, id_categoria)";
    sql += "VALUES (?, ?, ?, ?, ?, ?, ?)";
    try {
        abrirConexion();
        statement = conexion.prepareStatement(sql);
        statement.setInt(1, producto.getCodigo());
        statement.setString(2, producto.getNombre_producto());
        statement.setInt(3, producto.getPrecio());
        statement.setInt(4, producto.getExistencia());
        statement.setInt(5, producto.getFechavencimiento()); // Asegúrate de que Fechavencimiento sea de tipo String
        statement.setInt(6, producto.getMarca()); // Asegúrate de que id_marca sea de tipo String
        statement.setInt(7, producto.getCategoria());
        int resultado = statement.executeUpdate();
        if (resultado > 0) {
            return String.valueOf(resultado);
        } else {
            return String.valueOf(resultado);
        }
    } catch (SQLException e) {
        return e.getMessage();
    }
}
    
    public void getProducto(StringBuffer respuesta){   
        String sql = "SELECT codigo_producto, nombre_producto, precio, existencia, fecha_vencimiento, id_marca, id_categoria FROM producto";
        try{
        abrirConexion();
        statement= conexion.prepareStatement(sql);                        
        result = statement.executeQuery();            
            if(result!=null){
                while (result.next()){
                respuesta.append("<tr>");//crear la fila y la etique td son las columnas
                respuesta.append("<td >").append(result.getInt("codigo_producto")).append("</td>");
                respuesta.append("<td >").append(result.getString("nombre_producto")).append("</td>");
                respuesta.append("<td >").append(result.getInt("precio")).append("</td>");
                respuesta.append("<td >").append(result.getInt("existencia")).append("</td>");
                respuesta.append("<td >").append(result.getDate("fecha_vencimiento")).append("</td>");
                respuesta.append("<td >").append(result.getInt("id_marca")).append("</td>");
                respuesta.append("<td >").append(result.getInt("id_categoria")).append("</td>");
                respuesta.append("<td id=\"").append(result.getInt("codigo_producto"))
                        .append("\"  onclick=\"eliminarproducto(this.id);\">")
                        .append(" <a class=\"btn btn-warning\"'><i class=\"fas fa-edit\"></i>  </a>"
                                +" <a class=\"btn btn-danger\"'> <i class=\"fas fa-trash-alt\"></i> </a>"
                                + " <td></tr>");
                }
            }else{
                respuesta.append("error al consultar");
            }           
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public String eliminarproducto(int codigo_producto){        
        String sql = "DELETE FROM producto WHERE codigo_producto="+codigo_producto;              
       try{     
            abrirConexion();
            statement = conexion.prepareStatement(sql); 
            int resultado = statement.executeUpdate();
            if(resultado > 0){
                return String.valueOf(resultado);
            }else{
                return String.valueOf(resultado);
            }
        }catch(SQLException e){ 
            return e.getMessage();
        }
    }
    
    // *** FUNCIONALIDAD PARA TRABAJAR CON ARRAYS ***
    public ProductoController(){// Construcctor para trabar con arrays
        this.tablaProducto = new Producto[100];
        this.indiceArray=0;
    }
    
     public void guardarProductoEnArray(Producto producto){
        this.tablaProducto[this.indiceArray]= producto;  
        this.indiceArray=this.indiceArray+1;
        // procedimiento para almacenar en la Base de Datos
    }
    
    public Producto[] getProductoFromArray(){
        return this.tablaProducto;
    }
    
}
