package fr.epita.biostats.service;

import fr.epita.biostats.datamodel.BiostatEntry;
import fr.epita.biostats.exceptions.BackendInitException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class BioStatJDBCDAO {


    public BioStatJDBCDAO() throws BackendInitException {

        Connection connection = getConnection();
        try {
            PreparedStatement create = connection.prepareStatement(
                    """
                        CREATE TABLE IF NOT EXISTS 
                            biostat (NAME VARCHAR(255), 
                                GENDER VARCHAR(255), 
                                AGE INT, 
                                HEIGHT INT, 
                                WEIGHT INT)
                        """);
            create.execute();
        } catch (SQLException e) {
            throw   new BackendInitException(e);
        }


    }

    private Connection getConnection() throws SQLException{

        //FIXME delegate this to the configuration file
        //url
        String url = "jdbc:h2:mem:test";

        //user
        String user = "test";

        //password
        String password = "test";


        return DriverManager.getConnection(url, user, password);
    }

    public void save(BiostatEntry entry) {
        getConnection()
    }
    public void delete(BiostatEntry entry) {

    }
    public void update(BiostatEntry entry) {
    }

    public BiostatEntry findById(int id) {
    }

    public List<BiostatEntry> find(BiostatEntry qbe){

    }
}

