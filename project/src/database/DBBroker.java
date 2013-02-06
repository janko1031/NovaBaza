package database;

import java.sql.*;
import java.util.ArrayList;
import logika.Clan;

public class DBBroker {

    private static DBBroker instance;
    Connection connection = null;
    String url = "jdbc:mysql://localhost:3306/";
    String dbName = "db1"; // database name
    String driver = "com.mysql.jdbc.Driver";
    String userName = "root";
    String password = "papaurban";

    private DBBroker() throws ClassNotFoundException, SQLException {
        loadDriver(driver);
        setConnection();
        // private je da ne bi mogao da se instancira
       
        
    }

    public static DBBroker getInstance() throws ClassNotFoundException, SQLException {
        if (instance == null) {
            instance = new DBBroker();
        }
        return instance;
    }

    /*
     * instancing driver using reflection.
     */
    private void loadDriver(String driver) throws ClassNotFoundException {
        Class.forName(driver);
    }

    /*
     *  check if stream to database on server is closed.
     */
    public boolean isClosed() throws SQLException {
        return connection.isClosed();
    }

    /*
     *  creates connection to database on server.
     */
    public void setConnection() throws SQLException {
        connection = DriverManager.getConnection(url + dbName, userName, password);
    }

    /*
     *  closes connection to database on server.
     */
    private void closeConnection() {
        try {
            connection.close();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }


    /*
     * Gets all data from forums table in database.
     * 	 
     public void getForumsTableData() throws SQLException, ClassNotFoundException {
     if (connection.isClosed()) {
     setConnection();
     }
     String query = "select * from forums_table";
     Statement dbstatement = connection.createStatement();
     ResultSet rs = dbstatement.executeQuery(query);

     ArrayList<ForumPost> forumPostListWithLocation = new ArrayList<>();
     ArrayList<ForumPost> forumPostListWithNoLocation = new ArrayList<>();

     while (rs.next()) {
     String location = rs.getString("forumpost_location");
     String datePosted = rs.getString("forumpost_date");
     String text = rs.getString("forumpost_text");

     ForumPost post = new ForumPost(location, datePosted, text);
     if (location.equals("N/I")) {
     forumPostListWithNoLocation.add(post);
     } else {
     forumPostListWithLocation.add(post);
     }

     }
     closeConnection();
     LogicController.getInstance().setListOfPostsWithLocation(forumPostListWithLocation);
     LogicController.getInstance().setListOfPostsWithNoLocation(forumPostListWithNoLocation);

     }
     */
    public ArrayList<String> dajIDTimova() throws SQLException, ClassNotFoundException {
        if (connection.isClosed()) {
            setConnection();
        }
        String query = "select IDtimova from table2";
        Statement dbstatement = connection.createStatement();
        ResultSet rs = dbstatement.executeQuery(query);

        ArrayList<String> listaId = new ArrayList<String>();

        while (rs.next()) {
            String id = rs.getString("IDtimova");
            listaId.add(id);
        }
        closeConnection();

        return listaId;
    }
// potreban nam je ArrayList da bismo napravili listu IDTimova
    
    public void dodaj(Clan c) throws SQLException, ClassNotFoundException {
        if (connection.isClosed()) {
            setConnection();
        }

        String ime = c.getIme();
        String prezime = c.getPrezime();
        String oblast = c.getOblast();
        String idTima = c.getIdTima();
//
        String query = "select ID from table1";
        Statement dbstatement = connection.createStatement();
        ResultSet rs = dbstatement.executeQuery(query);

        ArrayList<String> listaId = new ArrayList<String>();

        while (rs.next()) {
            String id = rs.getString("ID");
            listaId.add(id);
        }
        
        int id = listaId.size() + 1;
        for (int i = 0; i < listaId.size(); i++) {
            if ((""+id).equals(listaId.get(i))) {
                id++;
            }
        }
//
        // ovo je skoro auto Inkrement. nije hteo sam da radi, smo dodaje
        
        query = "INSERT INTO table1 VALUES (" + id + ", '" + ime + "', '" + prezime + "', '" + oblast + "', '" + idTima + "')";
        dbstatement = connection.createStatement();
        dbstatement.executeUpdate(query);

        closeConnection();
    }
}
/**
 * Domaci
 * 
 * Treba da napravimo novi GUI za prikaz, i treba sa se posebno otvara kao i za unos
 * 
 * u konstruktoru GUI-a poziv metode u logici, ta metoda dalje poziva metodu u DBBrokeru
 * 
 * i ta metoda izvrsava SQL upit
 * 
 * 
 */