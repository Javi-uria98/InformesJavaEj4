package com.javier.informes.extra;

public class Empresa {

    private String nombre;
    private String campo;
    private int id;

    public Empresa(String nombre, String campo, int id){
        this.nombre=nombre;
        this.campo=campo;
        this.id=id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}