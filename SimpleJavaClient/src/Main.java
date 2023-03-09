import org.json.simple.parser.ParseException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {

        UserDao userDao = new UserDaoImpl();

//        userDao.getUserById(1L);

        System.out.println(userDao.allUsers());


    }
}