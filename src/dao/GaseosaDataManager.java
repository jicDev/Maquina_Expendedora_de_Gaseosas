package dao;

import entidades.Gaseosa;
import excepciones.MiException;
import org.h2.jdbc.JdbcSQLException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class GaseosaDataManager implements GaseosaDAO {

    private Gaseosa gaseosa;

    public GaseosaDataManager() {

    }

    public GaseosaDataManager(Gaseosa gaseosa){
        this.gaseosa = gaseosa;
    }

    @Override
    public void insertarGaseosa(Gaseosa gaseosa) throws MiException {
        String sql = "INSERT INTO GASEOSA(marca, productor, stock) VALUES(?,?,?)";

        try (Connection conn = DBManager.connectar();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            preparedStatement.setString(1, gaseosa.getMarca());
            preparedStatement.setString(2, gaseosa.getProductor());
            preparedStatement.setInt(3, gaseosa.getStock());
            preparedStatement.executeUpdate();

        } catch (JdbcSQLException e) {

            throw new MiException("No se puede insertar dos marcas iguales.");

        } catch (SQLException e) {

            throw new MiException("Error en el formato de texto.");

        }
    }

    @Override
    public void borrarGaseosa(Gaseosa gaseosa) {
        String sql = "DELETE FROM gaseosa WHERE marca = ?";

        try (Connection conn = DBManager.connectar();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            preparedStatement.setString(1, gaseosa.getMarca());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

    @Override
    public void modificarGaseosa(Gaseosa gaseosa) {
        String sql = "UPDATE gaseosa SET productor = ?, stock = ? WHERE marca = ?";

        try (Connection conn = DBManager.connectar();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            preparedStatement.setString(1, gaseosa.getProductor());
            preparedStatement.setInt(2, gaseosa.getStock());
            preparedStatement.setString(3, gaseosa.getMarca());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

    @Override
    public Vector<Vector> listarTodasLasGaseosas() {
        Vector<Vector> gaseosas = new Vector<>();

        String sql = "SELECT * FROM GASEOSA";

        try (Connection conn = DBManager.connectar();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                String marca = resultSet.getString("marca");
                String productor = resultSet.getString("productor");
                int stock = resultSet.getInt("stock");
                Vector<String> gaseosa = new Vector<>();
                gaseosa.add(marca);
                gaseosa.add(productor);
                gaseosa.add(String.valueOf(stock));
                gaseosas.add(gaseosa);

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return gaseosas;
    }
}
