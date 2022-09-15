/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.cliente;

/**
 *
 * @author Lucas
 */
public class Cliente {
    
    private int idcliente;
    private String dni;
    private String nombreApellido;
    private String telefono;
    private String direccion;
    private String condicionFiscal;
    private String razonSocial;

    public Cliente(int idcliente, String dni, String nombreApellido, String telefono, String direccion, String condicionFiscal, String razonSocial) {
        this.idcliente = idcliente;
        this.dni = dni;
        this.nombreApellido = nombreApellido;
        this.telefono = telefono;
        this.direccion = direccion;
        this.condicionFiscal = condicionFiscal;
        this.razonSocial = razonSocial;
    }

    public Cliente() {
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombreApellido() {
        return nombreApellido;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCondicionFiscal() {
        return condicionFiscal;
    }

    public void setCondicionFiscal(String condicionFiscal) {
        this.condicionFiscal = condicionFiscal;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    @Override
    public String toString() {
        return "Cliente{" + "idcliente=" + idcliente + ", dni=" + dni + ", nombreApellido=" + nombreApellido + ", telefono=" + telefono + ", direccion=" + direccion + ", condicionFiscal=" + condicionFiscal + ", razonSocial=" + razonSocial + '}';
    }
    
        
    
}
