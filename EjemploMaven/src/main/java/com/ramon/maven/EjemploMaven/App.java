package com.ramon.maven.EjemploMaven;
import java.sql.*;

public class App 
{
    public static void main( String[] args )
    {
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
    		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/DAO","ramon","monlau");
    		System.out.println( "Esta conectado a mysql" );
    		System.out.println();  
    		Statement orden = con.createStatement();
    		
    		ResultSet resul = orden.executeQuery("SELECT * from departamentos");
    		System.out.println( "Lista de Departamentos" );
    		System.out.println( "----------------------" );
    		System.out.println();
    		while (resul.next()) {
    			System.out.println(resul.getInt("dept_no")+" "+resul.getString(2)+" "+resul.getString("loc"));
    		}
    		System.out.println( "Fin de lista" );
    		resul.close();
    		orden.close();
    		con.close();
    	}
    	catch (ClassNotFoundException cn) {cn.printStackTrace();}
    	catch (SQLException e) {
    		System.out.println("Ha ocurrido un error:");
    		System.out.println("Mensaje: " + e.getMessage());
    		System.out.println("SQL estado: " + e.getSQLState());
    		System.out.println("Codigo de error: " + e.getErrorCode());
    	}       
    }
}
