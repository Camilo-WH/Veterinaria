package org.example.dao;


import org.example.model.Mascota;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MascotaDAOimpl implements MascotaDAO {

    private final Connection connection;

    public MascotaDAOimpl(Connection connection) {
        this.connection = connection;
    }


    @Override
    public void crear(Mascota mascota) {
        String sql = "INSERT INTO Mascota (IDMascota, nombre, especie, IDdueno) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, mascota.getIdMascota());
            statement.setString(2, mascota.getNombre());
            statement.setString(3, mascota.getEspecie());
            statement.setInt(4, mascota.getidDueño);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Mascota leer(int IDmascota) {
        String sql = "SELECT * FROM Mascota WHERE IDMascota = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, IDmascota);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Mascota(
                        resultSet.getString("especie"),
                        resultSet.getString("nombre"),
                        resultSet.getInt("IDMascota"),
                        resultSet.getInt("IDdueno")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return null;
    }

    @Override
    public void actualizar(Mascota mascota) {
            String sql = "UPDATE Mascota SET nombre = ?, especie = ? WHERE IDMascota = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, mascota.getNombre());
                statement.setString(2, mascota.getEspecie());
                statement.setInt(3, mascota.getIdMascota());
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }



    @Override
    public void eliminar(int IDmascota) {
        String sql = "DELETE FROM Mascota WHERE IDMascota = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, IDmascota);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Mascota> listar() {
        List<Mascota> listaMascota = new ArrayList<>();
        String sql = "SELECT * FROM Mascota";

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Mascota mascota = new Mascota(
                        resultSet.getString("nombre"),
                        resultSet.getString("especie"),
                        resultSet.getInt("IDMascota"),
                        resultSet.getInt("IDdueno")
                );
                listaMascota.add(mascota);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaMascota;
    }
}
