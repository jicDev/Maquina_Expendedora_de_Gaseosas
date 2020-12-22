package dao.soda;

import dao.DBManager;
import entidades.Soda;
import excepciones.ExceptionManager;
import org.h2.jdbc.JdbcSQLException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class SodaDataManager implements SodaDAO {
    public SodaDataManager() {}

    @Override
    public void InsertSoda(Soda soda) throws ExceptionManager {
        String sql = "INSERT INTO GASEOSA(marca, productor, stock) VALUES(?,?,?)";

        try (Connection conn = DBManager.connectar();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, soda.GetBrand());
            preparedStatement.setString(2, soda.GetCompany());
            preparedStatement.setInt(3, soda.GetStock());
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
            preparedStatement.setString(1, soda.GetBrand());
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
            preparedStatement.setString(1, soda.GetCompany());
            preparedStatement.setInt(2, soda.GetStock());
            preparedStatement.setString(3, soda.GetBrand());
            if (soda.GetStock() >= 0) {
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Soda GetSoda(String brand) {
        String sql = "SELECT * FROM GASEOSA WHERE marca = ?";
        Soda soda = new Soda();

        try (Connection conn = DBManager.connectar();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, brand);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String company = resultSet.getString("productor");
                int stock = resultSet.getInt("stock");

                soda.SetBrand(brand);
                soda.SetCompany(company);
                soda.SetStock(stock);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return soda;
    }

    @Override
    public Vector<Vector> ListSoda() {
        Vector<Vector> sodas = new Vector<>();
        String sql = "SELECT * FROM GASEOSA ORDER BY MARCA";

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
