package homework1;

/**
 * A class representing a post that can be shared on a social media platform.
 */
public class Post {
    /**
     * A counter for the ID of each new post.
     */
    protected int postIdCounter = 1;
    /**
     * Constructs a new Post object with the given content.
     *
     * @param content the content of the post.
     */
    public Post(String content){
        System.out.println("Shared a post.");
        this.content = content;
        //Scanner scanner = new Scanner(System.in);
        //this.content = scanner.nextLine();
        this.postID = postIdCounter;
        postIdCounter = postIdCounter + 1;
    }
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
     * The number of comments on the post.
     */
    protected int commentCounter = 0;
    /**
     * An array of usernames who liked the post.
     */
    protected String[] whoLiked = new String[32];
    /**
     * An array of usernames who commented on the post.
     */
    protected String[] whoCommented = new String[32];
    /**
     * The content of the post, (the post itself) .
     */
    protected String content;
    /**
     * An array of comments on the post.
     */
    protected String[] comments = new String[32];
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
