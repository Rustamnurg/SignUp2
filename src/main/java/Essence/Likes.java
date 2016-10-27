package Essence;

/**
 * Created by Rustam on 24.10.16.
 */
public class Likes {
    private int id_posts;
    private int id_likers;


    public Likes(int id_posts, int id_likers) {
        this.id_posts = id_posts;
        this.id_likers = id_likers;
    }


    public int getId_likers() {
        return id_likers;
    }

    public void setId_likers(int id_likers) {
        this.id_likers = id_likers;
    }

    public int getId_posts() {
        return id_posts;
    }

    public void setId_posts(int id_posts) {
        this.id_posts = id_posts;
    }
}
