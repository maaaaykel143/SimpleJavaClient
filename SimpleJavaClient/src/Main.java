import org.json.simple.parser.ParseException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {

        UserDao userDao = new UserDaoImpl();

//        userDao.getUserById(1L);

//      -------------
//        update user
//        User paulo = new User(1, "Paulo", "Avelino", "");
//        boolean isUpdated = userDao.updateUser(paulo);
//        if(isUpdated)
//            System.out.println("Updated Successfully!");
//        else
//            System.out.println("Failed to update user");


//        Delete User
//        boolean isDeleted = userDao.deleteUser(2L);
//        if(isDeleted)
//            System.out.println("Delete Successfully!");
//        else
//            System.out.println("User doesn't exist!");




        System.out.println(userDao.allUsers());


    }
}