import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserDaoImpl implements UserDao {

    @Override
    public List<User> allUsers() throws IOException, ParseException {
        URL url = new URL("http://localhost:8082/api/v1/users");

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

        int responseCode = conn.getResponseCode();

        if (responseCode != 200)
            throw new RuntimeException("HttpResponseCode: " + responseCode);


        StringBuilder data = new StringBuilder();
        Scanner scanner = new Scanner(url.openStream());

        while (scanner.hasNext())
            data.append(scanner.nextLine());

        scanner.close();

        JSONParser parse = new JSONParser();
        JSONArray dataObject = (JSONArray) parse.parse(String.valueOf(data));

        List<User> allUsers = new ArrayList<>();

        for (Object object : dataObject) {
            GsonBuilder builder = new GsonBuilder();
            builder.setPrettyPrinting();

            Gson gson = builder.create();
            User user = gson.fromJson(object.toString(), User.class);
            allUsers.add(user);
        }
//        System.out.println(allUsers);
        return allUsers;
    }

    @Override
    public User getUserById(Long id) throws IOException {
        URL url = new URL("http://localhost:8082/api/v1/user/" + id);

        var conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();


        if (conn.getResponseCode() != 200)
            throw new RuntimeException("HttpResponseCode: " + conn.getResponseCode());

        StringBuilder data = new StringBuilder();
        Scanner scanner = new Scanner(url.openStream());

        while (scanner.hasNext())
            data.append(scanner.nextLine());

        scanner.close();

        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        User user = gson.fromJson(String.valueOf(data), User.class);
        System.out.println(user);

        return user;
    }

    @Override
    public boolean updateUser(User user) throws IOException {
        URL url = new URL("http://localhost:8082/api/v1/update_user/" + user.getId() + "?firstName=" + user.getFirstName() + "&lastName=" + user.getLastName() + "&emailAddress=" + user.getEmailAddress());

        var conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("PUT");
        conn.connect();

        return conn.getResponseCode() == 200;
    }

    @Override
    public boolean deleteUser(Long id) throws IOException {
        URL url = new URL("http://localhost:8082/api/v1/user/delete/" + id);

        var conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("DELETE");
        conn.connect();

        return conn.getResponseCode() == 200;
    }

}