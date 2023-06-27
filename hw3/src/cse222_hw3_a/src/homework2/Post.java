package homework2;
import java.util.ArrayList;

/**
 * A class representing a post that can be shared on a social media platform.
 */
public class Post {

    /**
     * Constructs a new Post object with the given content.
     *
     * @param content the content of the post.
     */
    public Post(String content){
        System.out.println("Shared a post.");
        this.content = content;
        this.postID = 0;
    }

    /**
     * The account who owns the post.
     */
    protected Account ownerAcc;
    /**
     * The ID of the account that shared the post.
     */
    protected int AccountID;
    /**
     * The ID of the post.
     */
    protected int postID;
    /**
     * The number of likes on the post.
     */
    protected int likes = 0;

    /**
     * An ArrayList of usernames who liked the post.
     */
    protected ArrayList<String> whoLiked = new ArrayList<>();
    /**
     * An ArrayList of usernames who commented on the post.
     */
    protected ArrayList<String> whoCommented = new ArrayList<>();
    /**
     * The content of the post, (the post itself) .
     */
    protected String content;
    /**
     * An ArrayList of comments on the post.
     */
    protected ArrayList<Comment> comments = new ArrayList<>(); /////////
    /**
     * Returns a String representation of the Post object.
     *
     * @return a String representation of the Post object.
     */
    @Override
    public String toString() {

        return "(Post ID:" + postID + ")  " + content + "\n";
    }
}
