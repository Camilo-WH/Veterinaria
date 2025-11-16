package org.example.model;

public class Dueño {

    protected int IDdueño;
    protected String nombre;
    protected String telefono;


    //Constructor

    public Dueño(int IDdueño, String nombre, String telefono) {
        this.IDdueño = IDdueño;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    //GET-SET

    public int getIDdueño() {
        return IDdueño;
    }

    public void setIDdueño(int IDdueño) {
        this.IDdueño = IDdueño;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    //TO STRING


    @Override
    public String toString() {
        return "Dueño{" +
                "IDdueño=" + IDdueño +
                ", nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }

}
