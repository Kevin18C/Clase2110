
package Clases;

/**
 *
 * @author kevin
 */
public class Producto {
    private int codigo_producto;
    private String nombre_producto;
    private int Precio;
    private int Existencia;
    private int Fechavencimiento;
    private int id_categoria;
    private int id_marca;

    public Producto(int codigo_producto, String nombre_producto, String Categoria, String Marca, String parameter3, String parameter4, int Precio){
        this.codigo_producto=codigo_producto;
        this.nombre_producto=nombre_producto;
        this.Precio=Precio;
        this.Existencia=Existencia;
        this.Fechavencimiento=Fechavencimiento;
    }

    public Producto(){
        this.nombre_producto=nombre_producto;
    }

    public Producto(int parseInt, String parameter, String parameter0, String parameter1, String parameter2, String parameter3, String id_marca) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Producto(int parseInt, String parameter, String parameter0, String parameter1, String parameter2, String parameter3, String parameter4, String guardarProducto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int getCodigo() {
        return codigo_producto;
    }

    public void setCodigo(int codigo_producto) {
        this.codigo_producto = codigo_producto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public int getPrecio() {
        return Precio;
    }

    public void setPrecio(int Precio) {
        this.Precio = Precio;
    }

    public int getExistencia() {
        return Existencia;
    }

    public void setExistencia(int Existencia) {
        this.Existencia = Existencia;
    }

    public int getFechavencimiento() {
        return Fechavencimiento;
    }

    public void setFechavencimiento(int Fechavencimiento) {
        this.Fechavencimiento = Fechavencimiento;
    }

    public int getCategoria() {
        return id_categoria;
    }

    public void setCategoria(int Categoria) {
        this.id_categoria = Categoria;
    }

    public int getMarca() {
        return id_marca;
    }

    public void setMarca(int Marca) {
        this.id_marca = Marca;
    }
    
}
