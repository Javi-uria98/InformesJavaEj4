package com.javier.informes.logica;

import com.javier.informes.model.Empresa;
import java.util.ArrayList;

public class Logica {

    private static Logica INSTANCE = null;
    private ArrayList<Empresa> listaEmpresa;

    private Logica() {
        listaEmpresa = new ArrayList<Empresa>();
    }

    public ArrayList<Empresa> getListaEmpresa(){
        return listaEmpresa;
    }

    public void addEmpresa(Empresa empresa){
        listaEmpresa.add(empresa);
    }

    public static Logica getInstance() {
        if (INSTANCE == null)
            INSTANCE = new Logica();

        return INSTANCE;
    }




}
