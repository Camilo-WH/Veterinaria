package org.example.dao;
import org.example.model.Cita;
import java.util.List;

public interface CitaDAO {
    void crear(Cita cita);
    Cita leer(int IdCita);
    void actualizar (Cita cita);
    void eliminar (int IdCita);
    List<Cita> listar ();

}
