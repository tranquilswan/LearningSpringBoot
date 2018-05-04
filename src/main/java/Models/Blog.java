package Models;

public class Blog {
    //int id
    //String title
    //String content

    private int id;
    private String title;
    private String content;

    public Blog(){}

    public Blog(int id, String title, String content){
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public int getId(){
        return this.id;
    }

    public String getTitle(){
        return this.title;
    }

    public String getContent(){
        return this.content;
    }

    public void setId(int someId){
        this.id = someId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}