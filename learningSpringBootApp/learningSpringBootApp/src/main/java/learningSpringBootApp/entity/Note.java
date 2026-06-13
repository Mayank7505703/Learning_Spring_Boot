package learningSpringBootApp.entity;

import org.springframework.stereotype.Component;

@Component
public class Note {
  private String id;
  private String title;
  private String content;
  
  
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public String getTitle() {
    return title;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  
}
