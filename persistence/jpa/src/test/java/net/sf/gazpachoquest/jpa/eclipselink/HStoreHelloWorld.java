package net.sf.gazpachoquest.jpa.eclipselink;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import net.sf.gazpachoquest.jpa.converter.support.HstoreSupport;

public class HStoreHelloWorld {

    public static void main(String[] args) {
        Connection conn = null;
        String userName = "postgres";
        String password = "admin";
        String url = "jdbc:postgresql://localhost:5432/gazpachoquest";

        try {
            Class.forName("org.postgresql.Driver").newInstance();
            conn = DriverManager.getConnection(url, userName, password);

            String sql = "INSERT INTO users (id, api_key, email, given_names, secret, surname, username, attributes) VALUES (?, ?, 'admin@gazpacho.net', 'admin', ?, 'admin', ?, ?);";
            Map<String, String> map = new HashMap<String, String>();
            map.put("position", "manager");

            // PGHStore hstore = new PGHStore(map);
            String s = HstoreSupport.toString(map);

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, (int) System.currentTimeMillis());
            stmt.setString(2, String.valueOf(System.currentTimeMillis()));
            stmt.setString(3, String.valueOf(System.currentTimeMillis()));
            stmt.setString(4, String.valueOf(System.currentTimeMillis()));

            // stmt.setObject(5, s, Types.OTHER);

            stmt.setString(5, s);

            stmt.executeUpdate();
            System.out.println("fin");
        } catch (Exception e) {
            // For the sake of this tutorial, let's keep exception handling
            // simple
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ignore) {
                }
            }
        }
    }
}
