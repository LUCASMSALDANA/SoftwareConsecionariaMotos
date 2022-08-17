/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.producto;

/**
 *
 * @author Lucas
 */
public class Producto {
    
    private int idproducto;
    private String descripcion;
    private int anio;
    private int stock;
    private float precio;
    private String color;

    public Producto() {
    }

    public Producto(int idproducto, String descripcion, int anio, int stock, float precio, String color) {
        this.idproducto = idproducto;
        this.descripcion = descripcion;
        this.anio = anio;
        this.stock = stock;
        this.precio = precio;
        this.color = color;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Producto{" + "idproducto=" + idproducto + ", descripcion=" + descripcion + ", anio=" + anio + ", stock=" + stock + ", precio=" + precio + ", color=" + color + '}';
    }
    
    
    
}
