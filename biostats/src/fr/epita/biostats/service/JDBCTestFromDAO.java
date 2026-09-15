package fr.epita.biostats.service;

import fr.epita.biostats.datamodel.BiostatEntry;
import fr.epita.biostats.exceptions.BackendInitException;
import fr.epita.biostats.exceptions.DataAccessException;

import java.security.spec.ECField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTestFromDAO {

    static void main() throws BackendInitException {

        BioStatJDBCDAO dao = new BioStatJDBCDAO();
        try {
            dao.save(new BiostatEntry("John", "M", 20, 170, 60));

           // Connection connection = DriverManager.getConnection();// here is the check

        } catch (DataAccessException e) {
            throw new RuntimeException(e);
        }


    }
}
