package com.umg.financiero.clases;

import com.umg.financiero.clases.Cliente;

import java.util.Arrays;

/**
 * Created by marvinmanuelmenchumenchu on 6/07/17.
 */
public class Sucursal {
    private Integer codigo;
    private String nombre;
    private String direccion;
    private String telefono;
    private Cliente[] cliente;
    private int cantidadCliente;

    public Sucursal(int cantidadClientes) {
        cliente = new Cliente[cantidadClientes];
        cantidadClientes = 0;
    }

    public Sucursal(Integer codigo, String nombre, String direccion, String telefono, Cliente[] cliente) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.cliente = cliente;
    }

    public int getCantidadCliente() {
        return cantidadCliente;
    }

    public void setCantidadCliente(int cantidadCliente) {
        this.cantidadCliente = cantidadCliente;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Cliente[] getCliente() {
        return cliente;
    }

    public void setCliente(Cliente[] cliente) {
        this.cliente = cliente;
    }

    public void agragarCliente (Cliente cliente) throws Exception{
        if (cantidadCliente < this.cliente.length){
            this.cliente[cantidadCliente] = cliente;
            cantidadCliente++;
        }else{
            throw new Exception("No se puede agregar mas Clientes");
        }
    }

    @Override
    public String toString() {
        return "Sucursal{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", cliente=" + Arrays.toString(cliente) +
                '}';
    }
}
