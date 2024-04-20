package org.example;

import org.example.connection.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        try (Connection connection = DBConnection.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM pessoa");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String sobrenome = resultSet.getString("sobrenome");
                String dataNascimento = resultSet.getString("dataNascimento");
                String telefone = resultSet.getString("telefone");
                String cidade = resultSet.getString("cidade");
                String estado = resultSet.getString("estado");

                System.out.printf("ID: %d, Nome: %s %s, Data Nascimento: %s, Telefone: %s, Cidade: %s, Estado: %s%n",
                        id, nome, sobrenome, dataNascimento, telefone, cidade, estado);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}