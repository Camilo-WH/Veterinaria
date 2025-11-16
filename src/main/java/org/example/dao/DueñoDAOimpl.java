package org.example.dao;

import org.example.model.Dueño;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DueñoDAOimpl implements DueñoDAO {
    private final Connection connection;

    public DueñoDAOimpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void crear(Dueño dueño) {
        String sql = "INSERT INTO Dueno (IDdueno, nombre, telefono) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, dueño.getIDdueño());
            statement.setString(2, dueño.getNombre());
            statement.setString(3, dueño.getTelefono());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Dueño leer(int IDdueño) {
        String sql = "SELECT * FROM Dueno WHERE IDdueno = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, IDdueño);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Dueño(
                        resultSet.getInt("IDdueno"),
                        resultSet.getString("nombre"),
                        resultSet.getString("telefono")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void actualizar(Dueño dueño) {
        String sql = "UPDATE Dueno SET nombre = ?, telefono = ? WHERE IDdueno = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, dueño.getNombre());
            statement.setString(2, dueño.getTelefono());
            statement.setInt(3, dueño.getIDdueño());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int IDdueño) {
        String sql = "DELETE FROM Dueno WHERE IDdueno = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, IDdueño);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Dueño> listar() {
        List<Dueño> listaDueños = new ArrayList<>();
        String sql = "SELECT * FROM Dueno";

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Dueño dueño = new Dueño(
                        resultSet.getInt("IDdueno"),
                        resultSet.getString("nombre"),
                        resultSet.getString("telefono")
                );
                listaDueños.add(dueño);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaDueños;
    }
}