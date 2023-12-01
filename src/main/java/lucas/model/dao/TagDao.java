package lucas.model.dao;

import lucas.model.Tag;
import lucas.util.AppDb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TagDao {

    public boolean insert(Tag tag) {
        Connection c = AppDb.startConnection();
        String sql = "INSERT INTO tag (nameTag) VALUES (?);";
        try {
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, tag.getName());
            ps.executeUpdate();
            ps.close();
            c.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public boolean delete(Tag tag) {
        Connection c = AppDb.startConnection();
        String sql = "DELETE FROM tag WHERE idTag = ?;";
        try {
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, String.valueOf(tag.getId()));
            ps.executeUpdate();
            ps.close();
            c.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }


}
