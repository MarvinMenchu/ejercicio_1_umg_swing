package com.umg.financiero.clases;

import java.util.Date;

/**
 * Created by marvinmanuelmenchumenchu on 6/07/17.
 */
public class Transaccion {
    private Integer numeroTransaccion;
    private Date fecha;
    private String comprobante;
    private String tipoTransaccion;  //'D' debito 'C' credito
    private double monto;

    public Transaccion() {
    }

    public Transaccion(Integer numeroTransaccion, Date fecha, String comprobante, String tipoTransaccion, double monto) {
        this.numeroTransaccion = numeroTransaccion;
        this.fecha = fecha;
        this.comprobante = comprobante;
        this.tipoTransaccion = tipoTransaccion;
        this.monto = monto;
    }

    public Integer getNumeroTransaccion() {
        return numeroTransaccion;
    }

    public void setNumeroTransaccion(Integer numeroTransaccion) {
        this.numeroTransaccion = numeroTransaccion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getComprobante() {
        return comprobante;
    }

    public void setComprobante(String comprobante) {
        this.comprobante = comprobante;
    }

    public String getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(String tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "Transaccion{" +
                "numeroTransaccion=" + numeroTransaccion +
                ", fecha=" + fecha +
                ", comprobante='" + comprobante + '\'' +
                ", tipoTransaccion='" + tipoTransaccion + '\'' +
                ", monto=" + monto +
                '}';
    }
}
