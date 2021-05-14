/*
 * Organisiert das Spiel
 * am 04.05.2021
 * von Joel und Paul
 * 
 * Tabellenname: q11blackjack21
 * Tabelle: UUID, Benutzername, Passwort(mit Verschlüsslung), E-Mail, Spielergeld
 * 
 */

import java.sql.*;

public class Datenbankanbindung
{
    private Connection verbindung;

    public Datenbankanbindung(){
        try{
            verbindung = DriverManager.getConnection("");
        }
        catch(SQLException e){
            System.out.println("Es gab einen Fehler mit der Datenbank: " + e);
        }

    }
    
    public void benutzerHinzufügen(String name, String email, String passwort){
        int spielergeld = 100;
        int uuid = 0;
        String sql = "INSERT INTO q11blackjack21 (UUID, Benutzername, Passwort, E-Mail, Spielergeld) VALUES (" + uuid +", "+ name +"', "+ passwort +"', "+ email +"', "+ spielergeld +")";
        
        try{
            Statement st = verbindung.createStatement();
            st.executeUpdate(sql);
            st.close();
        }
        catch(SQLException e){
            System.out.println("Es gab einen Fehler mit der Datenbank: " + e);
        }
    }
    
    public void benutzerLöschen(String email, String passwort){
        
        String sql = "DELETE FROM q11blackjack21 WHERE E-Mail='"+ email+"',AND Passwort='"+passwort+"'";
        
        try{
            Statement st = verbindung.createStatement();
            st.executeUpdate(sql);
            st.close();
        }
        catch(SQLException e){
            System.out.println("Es gab einen Fehler mit der Datenbank: " + e);
        }
    }
    
    public void benutzernameÄndern(String email, String passwort, String nameNeu){
    
        String sql = "UPDATE q11blackjack21 SET benutzername='"+nameNeu+"' WHERE E-Mail='"+ email+"',AND Passwort='"+passwort+"'";
        
        try{
            Statement st = verbindung.createStatement();
            st.executeUpdate(sql);
            st.close();
        }
        catch(SQLException e){
            System.out.println("Es gab einen Fehler mit der Datenbank: " + e);
        }
    }
    
    public void passwortÄndern(String email, String passwort, String passwortNeu){
        
        String sql = "UPDATE q11blackjack21 SET Passwort='"+passwortNeu+"' WHERE E-Mail='"+ email+"',AND Passwort='"+passwort+"'";
        
         try{
            Statement st = verbindung.createStatement();
            st.executeUpdate(sql);
            st.close();
        }
        catch(SQLException e){
            System.out.println("Es gab einen Fehler mit der Datenbank: " + e);
        }
    }
    
    public String spielergeldGeben(String benutzername){
        
        String sql = " SELECT Spielergeld FROM q11blackjack21 WHERE Benutzername='"+benutzername+"'";
        
         try{
            Statement st = verbindung.createStatement();
            st.executeQuery(sql);
            st.close();
        }
        catch(SQLException e){
            System.out.println("Es gab einen Fehler mit der Datenbank: " + e);
        }
        
        return sql;
    }
    
    public void spielergeldHinzufügen(String benutzername){
        
        //String sql = " q11blackjack21 SET Passwort='"+passwortNeu+"' WHERE E-Mail='"+ email+"',AND Passwort='"+passwort+"'";
    }
    
    
}
