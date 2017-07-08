package com.umg.financiero.clases;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marvinmanuelmenchumenchu on 6/07/17.
 */
public class Cuenta extends Cliente {
    private String numeroCuenta;
    private String tipoCuenta;
    private Integer tasaInteres;
    private Integer numeroLibreta;
    private double saldoContable;
    private String estado;
    private List<Transaccion> transaccion;

    public Cuenta() {
        transaccion = new ArrayList<>();
    }

    public Cuenta(String numeroCuenta, String tipoCuenta, Integer tasaInteres, Integer numeroLibreta, double saldoContable, String estado, List<Transaccion> transaccion) {
        this.numeroCuenta = numeroCuenta;
        this.tipoCuenta = tipoCuenta;
        this.tasaInteres = tasaInteres;
        this.numeroLibreta = numeroLibreta;
        this.saldoContable = saldoContable;
        this.estado = estado;
        this.transaccion = transaccion;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public Integer getTasaInteres() {
        return tasaInteres;
    }

    public void setTasaInteres(Integer tasaInteres) {
        this.tasaInteres = tasaInteres;
    }

    public Integer getNumeroLibreta() {
        return numeroLibreta;
    }

    public void setNumeroLibreta(Integer numeroLibreta) {
        this.numeroLibreta = numeroLibreta;
    }

    public double getSaldoContable() {
        return saldoContable;
    }

    public void setSaldoContable(double saldoContable) {
        this.saldoContable = saldoContable;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Transaccion> getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(List<Transaccion> transaccion) {
        this.transaccion = transaccion;
    }

    public void deposito(String cuenta, String comprobante, double monto, Integer numeroTransaccion){
        Transaccion trx = new Transaccion();
        double saldoActual =  this.getSaldoContable();
        double saldoNuevo = saldoActual + monto;
        this.setSaldoContable(saldoNuevo);

        trx.setTipoTransaccion("D");
        trx.setComprobante(comprobante);
        trx.setFecha( new java.util.Date());
        trx.setMonto(monto);
        trx.setNumeroTransaccion(numeroTransaccion);
        this.transaccion.add(trx);

    }

    public void retiro(){

    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "numeroCuenta='" + numeroCuenta + '\'' +
                ", tipoCuenta='" + tipoCuenta + '\'' +
                ", tasaInteres=" + tasaInteres +
                ", numeroLibreta=" + numeroLibreta +
                ", saldoContable=" + saldoContable +
                ", estado='" + estado + '\'' +
                ", transaccion=" + transaccion +
                '}';
    }
}
