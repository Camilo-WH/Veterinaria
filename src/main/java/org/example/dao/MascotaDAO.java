package org.example.dao;

import org.example.model.Mascota;
import java.util.List;


public  interface MascotaDAO {

    void crear(Mascota mascota);
    Mascota leer(int IDmascota);
    void actualizar(Mascota mascota);
    void eliminar (int IDmascota);
    List<Mascota> listar ();

}
