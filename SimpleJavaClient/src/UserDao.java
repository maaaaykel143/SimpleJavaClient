import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

public interface UserDao {
    List<User> allUsers() throws IOException, ParseException;

    User getUserById(Long id) throws IOException;

    boolean updateUser(User user) throws IOException;

    boolean deleteUser(Long id) throws IOException;

}
