package fr.epita.biostats.test;

import fr.epita.biostats.datamodel.BiostatEntry;
import fr.epita.biostats.exceptions.BackendInitException;
import fr.epita.biostats.exceptions.DataAccessException;
import fr.epita.biostats.service.BioStatJDBCDAO;

import java.util.List;

public class JDBCTestFromDAO {

    static void main() throws BackendInitException {

        BioStatJDBCDAO dao = new BioStatJDBCDAO();
        try {
            //save
            dao.save(new BiostatEntry("John", "M", 20, 170, 60));
            BiostatEntry bio = new BiostatEntry();
            bio.setName("Joh");
            bio.setGender("M");

            //find
            List<BiostatEntry> entries = dao.find(bio);
            if (entries.size() != 1) {
                System.out.println("Error size mismatch");
            }
            System.out.println(entries);
            //update
            entries.get(0).setAge(21);
            dao.update(entries.get(0));

            //check again
            entries = dao.find(bio);

            //delete
            dao.delete(entries.get(0));

            //check again
            entries = dao.find(bio);

        } catch (DataAccessException e) {
            throw new RuntimeException(e);
        }


    }
}
