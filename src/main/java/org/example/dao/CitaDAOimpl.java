package org.example.dao;

import org.example.model.Cita;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CitaDAOimpl implements CitaDAO{
    private final Connection connection;

    public CitaDAOimpl(Connection connection) {
        this.connection = connection;
    }


    @Override
    public void crear(Cita cita) {
        String sql = "INSERT INTO Cita (IDcita, fecha, motivo, idmascota) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, cita.getIdCita());
            statement.setString(2, cita.getFecha());
            statement.setString(3, cita.getMotivo());
            statement.setInt(4, cita.getIdMascota());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Cita leer(int IdCita) {
        String sql = "SELECT * FROM Cita WHERE IDcita = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, IdCita);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Cita(
                        resultSet.getInt("IDcita"),
                        resultSet.getString("fecha"),
                        resultSet.getString("motivo"),
                        resultSet.getInt("idmascota")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return null;
    }

    @Override
    public void actualizar(Cita cita) {
        String sql = "UPDATE Cita SET motivo = ?, fecha = ? WHERE IDcita = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, cita.getMotivo());
            statement.setString(2, cita.getFecha());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void eliminar(int IdCita) {
        String sql = "DELETE FROM Cita WHERE IDcita = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, IdCita);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Cita> listar() {
        List<Cita> listaCita = new ArrayList<>();
        String sql = "SELECT * FROM Cita";

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Cita cita = new Cita(
                        resultSet.getInt("IDcita"),
                        resultSet.getString("fecha"),
                        resultSet.getString("motivo"),
                        resultSet.getInt("idmascota")
                );
                listaCita.add(cita);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaCita;
    }
}
