package database;

import mapper.ResultMapper;
import model.Candidate;
import model.Offer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CandidateDao implements Crudable<Candidate> {
    private JdbcUtils jdbcUtils;

    public CandidateDao(JdbcUtils jdbcUtils){
        this.jdbcUtils=jdbcUtils;
    }

    @Override
    public boolean create(Candidate candidate) {
        final String SQL_ADD_MATCH = "INSERT INTO CANDIDATES(NAME_, AGE, SEX, PHONE, EMAIL, ADDRESS, YEARS_OF_EXPERIENCE, HAVE_HIGHER_EDUCATION) VALUES(?,?,?,?,?,?,?,?) RETURNING TRUE";
        try (Connection connection = jdbcUtils.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SQL_ADD_MATCH);
            statement.setString(1,candidate.getName());
            statement.setInt(2, candidate.getAge());
            statement.setString(3,candidate.getSex());
            statement.setString(4,candidate.getPhone());
            statement.setString(5,candidate.getEmail());
            statement.setString(6,candidate.getAddress());
            statement.setInt(7,candidate.getExperience());
            statement.setBoolean(8,candidate.isHaveHigherEducation());
            statement.executeQuery();
            statement.close();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    @Override
    public Candidate read(int id) {
        final String SQL_FIND_MATCH = "SELECT * FROM CANDIDATES WHERE ID=?";
        try (Connection connection = jdbcUtils.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SQL_FIND_MATCH);
            statement.setInt(1, id);
            List<Candidate> result = ResultMapper.resolveCandidates(statement.executeQuery());
            statement.close();
            if (result.isEmpty()) return null;
            else return result.get(0);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean update(int id, Candidate candidate) {
        final String SQL_UPDATE_MATCH="UPDATE CANDIDATES SET NAME_=?, AGE=?, SEX=?, PHONE=?, EMAIL=?, ADDRESS=?, YEARS_OF_EXPERIENCE=?, HAVE_HIGHER_EDUCATION=? WHERE ID=? RETURNING TRUE";
        try(Connection connection=jdbcUtils.getConnection()){
            PreparedStatement statement =connection.prepareStatement(SQL_UPDATE_MATCH);
            statement.setString(1,candidate.getName());
            statement.setInt(2, candidate.getAge());
            statement.setString(3,candidate.getSex());
            statement.setString(4,candidate.getPhone());
            statement.setString(5,candidate.getEmail());
            statement.setString(6,candidate.getAddress());
            statement.setInt(7,candidate.getExperience());
            statement.setBoolean(8,candidate.isHaveHigherEducation());
            statement.setInt(9,id);
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
        final String SQL_DELETE_MATCH="DELETE FROM CANDIDATES WHERE ID=? RETURNING TRUE";
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
