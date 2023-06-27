package homework1;

/**
 * A class representing a comment on a post.
 */
public class Comment extends Interaction {
    /**
     * Constructs a new Comment object with the given content.
     *
     * @param content the content of the comment.
     */
    Comment(String content){
        this.content = content;
    }
    /**
     * The content of the comment.
     */
    protected String content;
    /**
     * Returns a String representation of the Comment object.
     *
     * @return a String representation of the Comment object.
     */
    @Override
    public String toString() {
        return content;
    }
}
