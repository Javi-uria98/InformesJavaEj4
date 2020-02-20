package com.javier.informes.extra;

import java.util.ArrayList;
import java.util.List;

public class FactoryEmpresa {

    public static List<Empresa> createListEmpresas(){
        List<Empresa>listaEmpresas = new ArrayList<>();
        listaEmpresas.add(new Empresa("Inditex","Textil",1));
        listaEmpresas.add(new Empresa("Ali Baba","Compra-Venta",2));
        listaEmpresas.add(new Empresa("Pescanova","Alimentación",3));
        return listaEmpresas;
    }
}
