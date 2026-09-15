package fr.epita.biostats.service;

import fr.epita.biostats.exceptions.BackendInitException;

import java.security.spec.ECField;
import java.sql.SQLException;

public class JDBCTestFromDAO {

    static void main() throws BackendInitException {
      try {
          BioStatJDBCDAO dao = new BioStatJDBCDAO();
      } catch (BackendInitException e) {
          e.printStackTrace();
      }
    }
}
