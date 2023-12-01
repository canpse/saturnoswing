package lucas.model.bo;

import lucas.model.User;
import lucas.model.dao.UserDao;
import lucas.util.AppDb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserBo {

    public static boolean login(String login, String password) {
        User u = UserDao.getUserByLogin(login);
        return u.getPassword().equals(password);
    }

}
