package com.fernandotaa.salary;

import com.fernandotaa.salary.model.dao.DatabaseUtils;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class DataLoader {

    public static void main(String[] args) throws URISyntaxException, IOException {
        String fileContent = getFileContent("database-creation-script.sql");
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

    private static String getFileContent(String fileName) throws FileNotFoundException {
        InputStream resourceInputStream = getResourceInputStream(fileName);
        Reader reader = new InputStreamReader(resourceInputStream);
        BufferedReader bufferedReader = new BufferedReader(reader);
        return bufferedReader.lines().collect(Collectors.joining(" "));
    }

    public static InputStream getResourceInputStream(String fileName) throws FileNotFoundException {
        List<String> listLikelyFileNames = Arrays.asList(fileName, "/" + fileName, "./" + fileName);
        for (String likelyFileName : listLikelyFileNames) {
            InputStream url = DataLoader.class.getResourceAsStream(likelyFileName);
            if (Objects.nonNull(url)) {
                return url;
            }
        }
        throw new FileNotFoundException(fileName);
    }

}
