package database;

import mapper.ResultMapper;
import model.Offer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class OfferDao implements Crudable<Offer> {
    private JdbcUtils jdbcUtils;

    public OfferDao(JdbcUtils jdbcUtils){
        this.jdbcUtils=jdbcUtils;
    }

    @Override
    public boolean create(Offer offer) {
        final String SQL_ADD_MATCH = "INSERT INTO OFFERS(DESCRIPTION, SALARY) VALUES(?,?) RETURNING TRUE";
        try (Connection connection = jdbcUtils.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SQL_ADD_MATCH);
            statement.setString(1, offer.getDescription());
            statement.setFloat(2, offer.getSalary());
            statement.executeQuery();
            statement.close();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    @Override
    public Offer read(int id) {
        final String SQL_FIND_MATCH = "SELECT * FROM OFFERS WHERE ID=?";
        try (Connection connection = jdbcUtils.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SQL_FIND_MATCH);
            statement.setInt(1, id);
            List<Offer> result = ResultMapper.resolveOffers(statement.executeQuery());
            statement.close();
            if (result.isEmpty()) return null;
            else return result.get(0);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean update(int id, Offer offer) {
        final String SQL_UPDATE_MATCH="UPDATE OFFERS SET DESCRIPTION=?, SALARY=? WHERE ID=? RETURNING TRUE";
        try(Connection connection=jdbcUtils.getConnection()){
            PreparedStatement statement =connection.prepareStatement(SQL_UPDATE_MATCH);
            statement.setInt(3,id);
            statement.setString(1,offer.getDescription());
            statement.setFloat(2,offer.getSalary());
            statement.executeQuery();
            statement.close();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        final String SQL_DELETE_MATCH="DELETE FROM OFFERS WHERE ID=? RETURNING TRUE";
        try(Connection connection=jdbcUtils.getConnection()){
            PreparedStatement statement =connection.prepareStatement(SQL_DELETE_MATCH);
            statement.setInt(1,id);
            statement.executeQuery();
            statement.close();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }
}
