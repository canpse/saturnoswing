package lucas.model.dao;

import lucas.model.Note;
import lucas.model.User;
import lucas.util.AppDb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NoteDao {

    public static boolean insert(Note note) {
        Connection c = AppDb.startConnection();
        String sql = "INSERT INTO note (contentNote, idUser) VALUES (?, ?);";
        try {
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, note.getContent());
            ps.setString(2, ""+note.getUser().getId());
            ps.executeUpdate();
            ps.close();
            c.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public static boolean update(Note note) {
        Connection c = AppDb.startConnection();
        String sql = "UPDATE note set contentNote = ? WHERE idNote = ?;";
        try {
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, note.getContent());
            ps.setString(2, String.valueOf(note.getId()));
            ps.executeUpdate();
            ps.close();
            c.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public static boolean delete(Note note) {
        Connection c = AppDb.startConnection();
        String sql = "DELETE FROM note  WHERE idNote = ?;";
        try {
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, String.valueOf(note.getId()));
            ps.executeUpdate();
            ps.close();
            c.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public static List<Note> getAllFromUser(User user) {
        Connection c = AppDb.startConnection();
        String sql = "SELECT * FROM note WHERE idUser = ?;";
        try {
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, String.valueOf(user.getId()));
            ResultSet rs = ps.executeQuery();
            return resultSetAsNoteList(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<Note> resultSetAsNoteList(ResultSet rs) throws SQLException {
        List<Note> noteList = new ArrayList<Note>();
        while (rs.next()) {
            int id = rs.getInt(1);
            String content = rs.getString(2);
            int userId = rs.getInt(3);
            User u = new User();
            u.setId(userId);
            Note n = new Note(content, u);
            n.setId(id);
            noteList.add(n);
        }
        return noteList;
    }

}
