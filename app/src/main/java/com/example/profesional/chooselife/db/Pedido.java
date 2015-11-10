package com.example.profesional.chooselife.db;

import com.orm.SugarRecord;

import java.util.Date;

/**
 * Created by PROFESIONAL on 09/11/2015.
 */
public class Pedido extends SugarRecord {

    String placa,modelo,marca;
    int telefono;
    Date date;

    public Pedido() {
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
}
