import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.List;

public interface UserDao {
    List<User> allUsers() throws IOException, ParseException;

    User getUserById(Long id) throws IOException;

}
