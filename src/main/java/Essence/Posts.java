package Essence;

/**
 * Created by Rustam on 19.10.16.
 */
public class Posts {
    private int id_author;
    private int id_posts;
    private String content;
    private String date;

    public Posts(int id_author, String content, String date) {
        this.id_author = id_author;
        this.content = content;
        this.date = date;
    }
    public Posts(int id_posts, int id_author, String content, String date) {
        this.id_posts = id_posts;
        this.id_author = id_author;
        this.content = content;
        this.date = date;


    }
    public Posts(){

    }

    public int getId_posts(){
        return id_posts;
    }

    public int getId_author() {
        return id_author;
    }

    public String getContent() {
        return content;
    }

    public String getDate() {
        return  date;
    }


    public void setId_posts(int id_posts){
        this.id_posts = id_posts;
    }

    public void setId_author(int id_author) {
        this.id_author = id_author;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
