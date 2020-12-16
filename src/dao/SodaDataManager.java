package dao;

import entidades.Soda;
import excepciones.ExceptionManager;
import org.h2.jdbc.JdbcSQLException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class SodaDataManager implements SodaDAO {
    private Soda soda;

    public SodaDataManager() {}
    public SodaDataManager(Soda soda){
        this.soda = soda;
    }

    @Override
    public void InsertSoda(Soda soda) throws ExceptionManager {
        String sql = "INSERT INTO GASEOSA(marca, productor, stock) VALUES(?,?,?)";

        try (Connection conn = DBManager.connectar();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, soda.getBrand());
            preparedStatement.setString(2, soda.getCompany());
            preparedStatement.setInt(3, soda.getStock());
            preparedStatement.executeUpdate();
        } catch (JdbcSQLException e) {
            throw new ExceptionManager("No se puede insertar dos marcas iguales.");
        } catch (SQLException e) {
            throw new ExceptionManager("Error en el formato de texto.");
        }
    }

    @Override
    public void DeleteSoda(Soda soda) {
        String sql = "DELETE FROM gaseosa WHERE marca = ?";

        try (Connection conn = DBManager.connectar();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, soda.getBrand());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void ModifySoda(Soda soda) {
        String sql = "UPDATE gaseosa SET productor = ?, stock = ? WHERE marca = ?";

        try (Connection conn = DBManager.connectar();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, soda.getCompany());
            preparedStatement.setInt(2, soda.getStock());
            preparedStatement.setString(3, soda.getBrand());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Vector<Vector> ListSoda() {
        Vector<Vector> sodas = new Vector<>();
        String sql = "SELECT * FROM GASEOSA";

        try (Connection conn = DBManager.connectar();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String brand = resultSet.getString("marca");
                String company = resultSet.getString("productor");
                int stock = resultSet.getInt("stock");

                Vector<String> soda = new Vector<>();
                soda.add(brand);
                soda.add(company);
                soda.add(String.valueOf(stock));

                sodas.add(soda);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sodas;
    }
}
