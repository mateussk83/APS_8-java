package br.com.relatorio_api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RelatorioApiApplication {

	public static void main(String[] args) {
		
		String jdbcUrl = "jdbc:postgresql://isabelle.db.elephantsql.com:5432/wesndppr";
  	String username = "wesndppr";
  	String password = "RstYsGFLeB1CjqTber8WXzD2gK-00lZa";

		try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
					SpringApplication.run(RelatorioApiApplication.class, args);
        } catch (SQLException e) {
            e.printStackTrace();
   	     }
	}

}
