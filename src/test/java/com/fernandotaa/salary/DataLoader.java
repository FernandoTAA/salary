package com.fernandotaa.salary;

import com.fernandotaa.salary.model.dao.DatabaseUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.stream.Collectors;

public class DataLoader {

    public static void main(String[] args) throws URISyntaxException, IOException {
        Path path = Paths.get(DataLoader.class.getResource("/database-creation-script.sql").toURI());
        String fileContent = Files.readAllLines(path).stream().collect(Collectors.joining(" "));
        for (String commands : fileContent.split(";")) {
            executeQuery(commands);
        }
    }

    public static void executeQuery(String sql) {
        try (Connection connection = DatabaseUtils.getConnection(); Statement statement = connection.createStatement()) {
            int result = statement.executeUpdate(sql);
            System.out.println("OK - " + result + " - " + sql);

        } catch (SQLException e) {
            System.err.println("FAIL - " + e.getMessage() + " - " + sql);
        }
    }

}
