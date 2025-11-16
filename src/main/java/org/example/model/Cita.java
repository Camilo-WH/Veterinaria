package org.example.model;

public class Cita {



    protected  int IdCita;
    protected  String Fecha;
    protected  String Motivo;
    protected  int Idmascota;

    public Cita(int idCita, String fecha, String motivo, int idMascota) {
        IdCita = idCita;
        Fecha = fecha;
        Motivo = motivo;
        Idmascota = idMascota;
    }

    public  int getIdCita() {
        return IdCita;
    }

    public void setIdCita(int idCita) {
        IdCita = idCita;
    }

    public  String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public  String getMotivo() {
        return Motivo;
    }

    public void setMotivo(String motivo) {
        Motivo = motivo;
    }

    public int getIdMascota() {
        return Idmascota;
    }

    public void setIdMascota(int idMascota) {
        Idmascota = idMascota;
    }

    @Override
    public String toString() {
        return "Cita{" +
                "IdCita=" + IdCita +
                ", Fecha='" + Fecha + '\'' +
                ", Motivo='" + Motivo + '\'' +
                ", IdMascota=" + Idmascota +
                '}';
    }
}
