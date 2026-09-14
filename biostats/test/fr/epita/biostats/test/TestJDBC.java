package fr.epita.biostats.test;

import java.sql.*;

public class TestJDBC {


    public static void main(String[] args) throws SQLException {


        //url
        String url = "jdbc:h2:mem:test";

        //user
        String user = "test";

        //password
        String password = "test";


        Connection connection = DriverManager.getConnection(url, user, password);

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

       PreparedStatement insert = connection.prepareStatement("""
            INSERT INTO biostat VALUES ('thomas', 'M', 40, 170, 70);
        """);

       insert.execute();

       PreparedStatement select = connection.prepareStatement("""
            SELECT NAME, GENDER, AGE FROM biostat;
        """);
       ResultSet rs = select.executeQuery();

       while (rs.next()) {
           System.out.println(rs.getString("NAME"));
           System.out.println(rs.getString("GENDER"));
           System.out.println(rs.getInt("AGE"));
       }

        PreparedStatement update = connection.prepareStatement("""
            UPDATE biostat SET NAME = 'thomas2' WHERE NAME = 'thomas';
        """);
       update.execute();

        PreparedStatement delete = connection.prepareStatement("""
            DELETE FROM biostat WHERE NAME = 'thomas2';
        """);
        delete.execute();

        connection.close();

    }
}
