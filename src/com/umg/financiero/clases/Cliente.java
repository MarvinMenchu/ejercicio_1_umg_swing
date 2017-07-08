package com.umg.financiero.clases;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by marvinmanuelmenchumenchu on 6/07/17.
 */
public class Cliente {
    private Integer codigo;
    private String nombre;
    private String sexo;
    private String id;
    private Date fechaNacimiento;
    private List<Cuenta> cuenta;

    public Cliente() {
        cuenta = new ArrayList<>();
    }

    public Cliente(Integer codigo, String nombre, String sexo, String id, Date fechaNacimiento, List<Cuenta> cuenta) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.sexo = sexo;
        this.id = id;
        this.fechaNacimiento = fechaNacimiento;
        this.cuenta = cuenta;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public List<Cuenta> getCuenta() {
        return cuenta;
    }

    public void setCuenta(List<Cuenta> cuenta) {
        this.cuenta = cuenta;
    }

    public void agregarCuenta(Cuenta cuenta){
        this.cuenta.add(cuenta);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", sexo='" + sexo + '\'' +
                ", id='" + id + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", cuenta=" + cuenta +
                '}';
    }
}
