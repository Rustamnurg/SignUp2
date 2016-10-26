package Essence;

/**
 * Created by Rustam on 26.10.16.
 */
public class SuperAll {
    private int id_author;
    private int id_posts;
    private String content;
    private String date;
    private boolean editable;
    private String loginAutor;
    private boolean isLikes;
    private int likes;




    public SuperAll(int id_posts, int id_author, String content, String date, boolean editable, String loginAutor,
             boolean isLikes, int likes) {
        this.id_posts = id_posts;
        this.id_author = id_author;
        this.content = content;
        this.date = date;
        this.editable = editable;
        this.loginAutor = loginAutor;
        this.isLikes = isLikes;
        this.likes = likes;
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

    public int getLikes() {
        return likes;
    }

    public boolean getIsEditable() {
        return editable;
    }

    public String getLoginAutor() {
        return loginAutor;
    }

    public boolean getIsLikes() {
        return isLikes;
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

    public void setLikes(int likes){
        this.likes = likes;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public void setLoginAutor(String loginAutor) {
        this.loginAutor = loginAutor;
    }

    public void setLikes(boolean isLikes) {
        isLikes = isLikes;
    }


}
