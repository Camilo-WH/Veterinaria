package org.example.dao;
import java.util.List;


import org.example.model.Dueño;

public interface DueñoDAO {

    void crear(Dueño dueño);
    Dueño leer(int IDdueño);
    void actualizar(Dueño dueño);
    void eliminar (int IDdueño);
    List<Dueño> listar ();

}
