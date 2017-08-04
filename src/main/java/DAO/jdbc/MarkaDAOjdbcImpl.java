package DAO.jdbc;

import DAO.MarkaDAO;
import entity.MarkaCoffi;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class MarkaDAOjdbcImpl extends ConnectSUBD implements MarkaDAO  {

    private String getId = "select id, Name, Proizvoditel  from markacoffi  where id = %d";
    private String getAll = "select id, Name, Proizvoditel  from markacoffi";
    private String deleteId = "delete from markacoffi where id = %d";
    private String create = "insert into markacoffi(Name, Proizvoditel) values ('%s', '%s')";
    private String update = "update markacoffi set Name = '%s', Proizvoditel = '%s' where id = %d";


    public List<MarkaCoffi> getAll() {
        Connection dbConnection = getDBConnection();
        List<MarkaCoffi> markaCoffis = new ArrayList<MarkaCoffi>();
        try {

            Statement statement = dbConnection.createStatement();

            // выбираем данные с БД
            ResultSet rs = statement.executeQuery(getAll);

            // И если что то было получено то цикл while сработает

            while (rs.next()) {
                MarkaCoffi markaCoffi = new MarkaCoffi();

                markaCoffi.setId( rs.getInt("ID"));
                markaCoffi.setName(rs.getString("name"));
                markaCoffi.setProizvoditel(rs.getString("Proizvoditel"));
                markaCoffis.add(markaCoffi);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally {
            try {
                dbConnection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return markaCoffis;
    }

    public MarkaCoffi get(Integer id) {
        Connection dbConnection = getDBConnection();
        MarkaCoffi markaCoffi = new MarkaCoffi();
        try {

            Statement statement = dbConnection.createStatement();

            // выбираем данные с БД
            ResultSet rs = statement.executeQuery(String.format(getId, id));

            // И если что то было получено то цикл while сработает

            while (rs.next()) {
                markaCoffi.setId( rs.getInt("ID"));
                markaCoffi.setName(rs.getString("name"));
                markaCoffi.setProizvoditel(rs.getString("Proizvoditel"));

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally {
            try {
                dbConnection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return markaCoffi;
    }

    public Boolean delete(Integer id) {
        Connection connection = getDBConnection();
        try {
            Statement statement = connection.createStatement();
            statement.execute(String.format(deleteId, id));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
            }
        }
        return null;
    }

    public Boolean update(MarkaCoffi markaCoffi) {
        Connection connection = getDBConnection();
        try {
            Statement statement = connection.createStatement();
            statement.execute(String.format(update, markaCoffi.getName(), markaCoffi.getProizvoditel(), markaCoffi.getId()));
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
            }
            return true;
        }
    }

    public Boolean create(MarkaCoffi markaCoffi) {
        Connection connection = getDBConnection();
        try {
            Statement statement = connection.createStatement();
            statement.execute(String.format(create, markaCoffi.getName(), markaCoffi.getProizvoditel()));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
            }
        }

        return null;
    }
}
