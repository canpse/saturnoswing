package lucas.model.dao;

import lucas.model.User;
import lucas.util.AppDb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    public boolean insert(User user) {
        Connection c = AppDb.startConnection();
        String sql = "INSERT INTO user (loginUser, passwordUser) VALUES (?, ?);";
        try {
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, user.getLogin());
            ps.setString(2, user.getPassword());
            ps.executeUpdate();
            ps.close();
            c.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public boolean updatePassword(User user) {
        Connection c = AppDb.startConnection();
        String sql = "UPDATE user SET  passwordUser = ? WHERE idUser = ?;";
        try {
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, user.getPassword());
            ps.setString(2, String.valueOf(user.getId()));
            ps.executeUpdate();
            ps.close();
            c.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public static User getUserByLogin(String login) {
        Connection c = AppDb.startConnection();
        String sql = "SELECT * FROM user WHERE loginUser = ?;";
        try {
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();
            User u = new User();
            if (rs.next()) {
                u.setLogin(login);
                u.setId(rs.getInt(1));
                u.setPassword(rs.getString(3));
            }
            rs.close();
            c.close();
            return u;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
