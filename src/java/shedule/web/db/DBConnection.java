/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shedule.web.db;

import javax.sql.DataSource;
import javax.naming.NamingException;
import javax.naming.InitialContext;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.sql.SQLException;
import java.sql.Connection;

/**
 *
 * @author macbook
 */
public class DBConnection {

    private static Connection conn;
    private static InitialContext ic;
    private static DataSource ds;

    public static Connection getConnection() {
        try {
            ic = new InitialContext();
            ds = (DataSource) ic.lookup("java:comp/env/jdbc/Shedule");
            conn = ds.getConnection();
        } catch (SQLException | NamingException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);

        }

        return conn;
    }

}
