/*
 * Organisiert das Spiel
 * am 04.05.2021
 * von Joel und Paul
 * 
 * Tabellenname: blackjack
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
        String sql = "INSERT INTO blackjack (UUID, Benutzername, Passwort, E-Mail, Spielergeld) VALUES (" + uuid +", "+ name +"', "+ passwort +"', "+ email +"', "+ spielergeld +")";
        
        try{
            Statement st = verbindung.createStatement();
            st.executeUpdate(sql);
            st.close();
        }
        catch(SQLException e){
            System.out.println("Es gab einen Fehler mit der Datenbank: " + e);
        }
    }

}
