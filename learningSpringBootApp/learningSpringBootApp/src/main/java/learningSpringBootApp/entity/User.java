package learningSpringBootApp.entity;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

@Document
public class User {

    @Id
    private String id;
    
  private String name;

  @Indexed(unique=true)
  @NonNull
  private String userName;

  @NonNull
  private String password;

  @DBRef
  private ArrayList<Note>note =new ArrayList<>();

    public String getName() {

        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public ArrayList<Note> getNote() {
        return note;
    }

    public void setNote(ArrayList<Note> note) {
        this.note = note;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
  
}
