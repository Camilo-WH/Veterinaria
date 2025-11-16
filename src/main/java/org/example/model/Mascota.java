package org.example.model;

public class Mascota extends Animal{



    private  int IdMascota;
    private int idDueño;


    public Mascota(String nombre, String especie) {
        super(nombre, especie);
    }

    public Mascota(String nombre, String especie, int idMascota, int idDueño) {
        super(nombre, especie);
        this.IdMascota = idMascota;
        this.idDueño = idDueño;
    }



    public int getIdMascota() {
        return IdMascota;
    }

    public void setIdMascota(int idMascota) {
        this.IdMascota = idMascota;
    }



    @Override
    public String toString() {
        return "Mascota{" +
                "idMascota=" + IdMascota +
                ", idDueño=" + idDueño +
                '}';
    }
    public int getidDueño;


}
