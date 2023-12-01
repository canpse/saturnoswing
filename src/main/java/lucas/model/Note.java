package lucas.model;

/**
 *
 * @author lucas campestrini <lucas.campestrini@gmail.com>
 */
public class Note {
    
    private String content;
    private int id;
    private User user;

    public Note(String content, User user) {
        this.content = content;
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
