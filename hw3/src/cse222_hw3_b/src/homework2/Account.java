package homework2;
import java.util.LinkedList;
/**
 * A class that represents a user account on this social media platform program.
 */
public class Account {

    /**
     * A counter for assigning unique IDs to new accounts.
     */
    //private int idCounter = 1;
    /**
     * A bool representing whether the account is currently logged in.
     */
    private boolean isLoggedIn = false;
    /**
     * Creates a new account with default values for username, birthdate, and location (for test purposes only).
     */
    private Account(){
        //this.userID = idCounter;
        //idCounter = idCounter + 1;
        System.out.println("Welcome to Account Creating Tab!");
        System.out.println("Please enter username:  ");
        this.username = "emir";
        System.out.println("Please enter your Birth Date (use XX.XX.XXXX format) :  ");
        this.birthDate = "1.1.2001";
        System.out.println("Please enter your Location:  ");
        this.location = "gungoren";

    }
    /**
     * Creates a new account with the specified values for username, birth date, and location.
     *
     * @param uname the username of the account
     * @param ubirthdate the birthdate of the account holder
     * @param ulocation the location of the account holder
     */
    protected Account(int userid,String uname, String ubirthdate, String ulocation){
        this.userID = userid;
        //idCounter = idCounter + 1;
        System.out.println("An account with name " + uname + " has been created");
        this.username = uname;
        this.birthDate = ubirthdate;
        this.location = ulocation;

    }
    /**
     * The ID of the account.
     */
    protected int userID;
    /**
     * The username of the account.
     */
    protected String username;
    /**
     * The birth date of the account holder.
     */
    protected String birthDate;
    /**
     * The location of the account holder.
     */
    protected String location;
    /**
     * An LinkedList of accounts that this account is following.
     */
    protected LinkedList<Account> following = new LinkedList<>();


    /**
     * An LinkedList of accounts that are following this account (which are this account's "followers").
     */
    protected LinkedList<Account> followers = new LinkedList<>();

    /**
     * An LinkedList of posts that have been made by this account.
     */
    protected LinkedList<Post> posts = new LinkedList<>();

    /**
     * An LinkedList of messages that have been 'received' by this account.
     */
    protected LinkedList<Message> inbox = new LinkedList<>();

    /**
     * An LinkedList of messages that have been 'sent' by this account.
     */
    protected LinkedList<Message> outbox = new LinkedList<>();

    /**
     * An LinkedList of strings which stores the user's action history.
     */
    protected LinkedList<String> actionHistory = new LinkedList<>();
    /**
     * An LinkedList of Account objects who are blocked by the current user.
     */
    protected LinkedList<Account> blockedUsers = new LinkedList<>();

    /**
     * Logs in to the account.
     */
    protected void login(){
        if(isLoggedIn == true){
            System.out.println("First log out from the current user to log in to your account...");
            return;
        }
        System.out.println("Logged in as " + this.username);
        actionHistory.add("Logged in.");
        isLoggedIn = true;
    }
    /**
     * Logs out from the account.
     */
    protected void logout(){
        isLoggedInCheck();
        System.out.println("Logging out from account " + this.username);
        actionHistory.add("Logged out.");
        isLoggedIn = false;
    }
    /**
     * Shares a new post on the account.
     *
     * @param content the content of the post
     */
    protected void sharePost(String content){
        isLoggedInCheck();
        Post newPost = new Post(content);
        newPost.ownerAcc = this;
        newPost.AccountID = this.userID;
        newPost.postID = this.posts.size() + 1;
        posts.add(newPost);
        actionHistory.add("You shared a post.");

    }

    /**
     * Displays the profile information of the provided Account object.
     *
     * @param acc The Account object whose profile information will be displayed.
     */
    protected void viewProfile(Account acc){
        isLoggedInCheck();
        if(isUserBlocked(acc)){
            System.out.println("User not found.");
        }else{
            System.out.println("Viewing " + acc.username + "'s Account...");
            System.out.println("------------------------------------");
            System.out.println("Username: " + acc.username);
            System.out.println("Location : " + acc.location);
            System.out.println("Birth Date: " + acc.birthDate);
            System.out.println("This Account has " + acc.posts.size() + " post(s).");
            System.out.println( acc.username +" is following " + acc.following.size() + " account(s) and has " + acc.followers.size()+ " follower(s).");
            actionHistory.add("You viewed " + acc.username + "'s profile.");
        }



    }
    /**
     * Displays the posts of the provided Account object.
     *
     * @param acc The Account object whose posts will be displayed.
     */
    protected void viewPosts(Account acc){
        isLoggedInCheck();
        if(isUserBlocked(acc)){
            System.out.println("User not found.");
        }else{
            System.out.println("Viewing " + acc.username + " posts...");
            for(int i=0;i<acc.posts.size();i++){
                System.out.println(acc.posts.get(i).toString());

            }
            actionHistory.add("You viewed " + acc.username + "'s posts.");
        }

    }
    /**
     * Displays the interactions (likes and comments) of the provided Account object's posts.
     *
     * @param acc The Account object whose post interactions will be displayed.
     */
    protected void viewInteractions(Account acc){
        isLoggedInCheck();
        if(isUserBlocked(acc)){
            System.out.println("User not found.");
        }else{
            System.out.println("Viewing " + acc.username + " post interactions...");
            for(int i=0;i<acc.posts.size();i++){
                System.out.println("----------------------------------");
                System.out.print(acc.posts.get(i).toString());

                System.out.println("The post has " + acc.posts.get(i).likes + " like(s)");

                if(acc.posts.get(i).likes != 0){
                    System.out.print("The post was liked by the following accounts: ");// +posts[i].likes+ " user(s).");
                    for(int k=0;k<acc.posts.get(i).likes;k++){
                        System.out.println(acc.posts.get(i).whoLiked.get(k) + ",");
                    }
                }

                System.out.println("The post has " + acc.posts.get(i).comments.size() + " comment(s)");

                for(int j=0;j<acc.posts.get(i).comments.size();j++){
                    System.out.println("Comment "+(j+1)+": " + "'"+acc.posts.get(i).whoCommented.get(j)+ "'"+" said: "+ acc.posts.get(i).comments.get(j).content);
                }
            }
            actionHistory.add("You viewed " + acc.username + "'s post interactions.");
        }

    }

    /**
     * Likes a post of the provided Account object with the given ID.
     *
     * @param acc The Account object whose post will be liked.
     * @param postid The ID of the post to be liked.
     */
    protected void likePost(Account acc,int postid){
        isLoggedInCheck();

        if(isUserBlocked(acc)){
            System.out.println("User not found.");
        }else{
            if(postid > acc.posts.size()){
                throw new IndexOutOfBoundsException("Post ID " + postid + " does not exist.");
            }
            acc.posts.get(postid-1). whoLiked.add(this.username);
            acc.posts.get(postid-1).likes = acc.posts.get(postid-1).likes + 1;
            System.out.println("Liking (Post ID: "+ postid + ") of " + acc.username + "...");
            actionHistory.add("You liked " + acc.username + "'s post (Post ID: " + postid + ")");
        }

    }
    /**
     * Unlikes a post of the provided Account object with the given ID.
     *
     * @param acc The Account object whose post will be unliked.
     * @param postid The ID of the post to be unliked.
     */
    protected void unlikePost(Account acc,int postid){
        isLoggedInCheck();
        if(isUserBlocked(acc)){
            System.out.println("User not found.");
        }else{
            if(postid > acc.posts.size()){
                throw new IndexOutOfBoundsException("Post ID " + postid + " does not exist.");
            }
            if(acc.posts.get(postid-1).whoLiked.contains(this.username)){
                acc.posts.get(postid-1). whoLiked.remove(this.username);
                acc.posts.get(postid-1).likes = acc.posts.get(postid-1).likes - 1;
                System.out.println("Unliking (Post ID: "+ postid + ") of " + acc.username + "...");
                actionHistory.add("You unliked " + acc.username + "'s post (Post ID: " + postid + ")");
            }else{
                System.out.println("You can not unlike a post you haven't liked!!");
            }
        }


    }
    /**
     * Leaves a comment on a post of the provided Account object.
     *
     * @param acc The Account object whose post the comment will be left on.
     * @param postid The ID of the post to leave the comment on.
     * @param content The content of the comment to be left.
     */
    protected void leaveComment(Account acc, int postid, String content){
        isLoggedInCheck();
        if(isUserBlocked(acc)){
            System.out.println("User not found.");
        }else{
            if(postid > acc.posts.size()){
                throw new IndexOutOfBoundsException("Post ID " + postid + " does not exist.");
            }
            Comment newComment = new Comment(content);
            newComment.owner = this;
            acc.posts.get(postid-1).comments.add(newComment);
            acc.posts.get(postid-1).whoCommented.add(this.username);
            System.out.println("Adding a comment on " +acc.username+"'s post...");
            actionHistory.add("You commented on " + acc.username + "'s post (Post ID: " + postid + ")");
        }

    }
    /**
     * Removes a comment on a post of the provided Account object.
     *
     * @param acc The Account object whose post the comment will be left on.
     * @param postid The ID of the post to leave the comment on.
     * @param commentid The ID of the comment to be removed.
     */
    protected void uncomment(Account acc, int postid, int commentid){
        isLoggedInCheck();
        if(isUserBlocked(acc)){
            System.out.println("User not found.");
        }else{
            if(postid > acc.posts.size()){
                throw new IndexOutOfBoundsException("Post ID " + postid + " does not exist.");
            }
            if(acc.posts.get(postid-1).whoCommented.get(commentid-1) != this.username){
                throw new IllegalStateException("You are not allowed to remove other users' comments.");
            }
            acc.posts.get(postid-1).comments.remove(commentid-1);
            acc.posts.get(postid-1).whoCommented.remove(commentid-1);
            System.out.println("You uncommented (removed a comment) from " +acc.username+"'s post. (Post ID: "+postid+").");
            actionHistory.add("You removed a comment from "+ acc.username + "'s post. (Post ID: " + postid + ").");

        }

    }
    /**
     * Follows the provided Account object.
     *
     * @param toFollow The Account object to be followed.
     */
    protected void followAccount(Account toFollow){
        isLoggedInCheck();
        if(isUserBlocked(toFollow)){
            System.out.println("User not found.");
        }else{
            this.following.add(toFollow);
            toFollow.followers.add(this);
            System.out.println("Following " + toFollow.username + " ...");
            actionHistory.add("You followed " + toFollow.username + ".");
        }


    }
    /**
     * Unfollows the provided Account object.
     *
     * @param acc The Account object to be unfollowed.
     */
    protected void unfollowAccount(Account acc){
        isLoggedInCheck();
        if(isUserBlocked(acc)){
            System.out.println("User not found.");
        }else{
            if(this.following.contains(acc)){
                acc.followers.remove(this);
                this.following.remove(acc);

            }else{
                System.out.println("You can not unfollow an account that you don't follow!!");
            }
            System.out.println("Unfollowing " +acc.username+"...");
            actionHistory.add("You unfollowed "+acc.username+".");
        }

    }
    /**
     * Sends a message to the provided Account object.
     *
     * @param toAcc The Account object to send the message to.
     * @param content The content of the message to be sent.
     */
    protected void sendMessage(Account toAcc, String content){
        isLoggedInCheck();
        if(isUserBlocked(toAcc)){
            System.out.println("User not found.");
        }else{
            Message theMessage = new Message(this,toAcc,content);
            toAcc.inbox.add(theMessage);
            this.outbox.add(theMessage);
            System.out.println("Sending a message to " + toAcc.username + "...");
            actionHistory.add("You sent a message to " + toAcc.username + ".");
        }



    }
    /**
     * Displays the messages in the inbox of the logged-in Account object.
     */
    protected void viewInbox(){
        isLoggedInCheck();
        System.out.println("Viewing inbox...");
        System.out.println("-----------------------------------------------");
        for(int i=0;i<this.inbox.size();i++){
            System.out.println(this.inbox.get(i));
        }
        actionHistory.add("You viewed your inbox. ");
    }
    /**
     * Displays the messages in the outbox of the logged-in Account object.
     */
    protected void viewOutbox(){
        isLoggedInCheck();
        System.out.println("Viewing outbox...");
        System.out.println("-----------------------------------------------");
        for(int i=0;i<this.outbox.size();i++){
            System.out.println(this.outbox.get(i));
        }
        actionHistory.add("You viewed your outbox. ");

    }
    /**
     * Checks the number of messages in the inbox of the logged-in Account object.
     */
    protected void checkInbox(){
        isLoggedInCheck();
        System.out.println("Checking inbox...");
        System.out.println("There is/are " + this.inbox.size() + " message(s) in the inbox.");
        actionHistory.add("You checked your inbox. ");
    }
    /**
     * Checks the number of messages in the outbox of the logged-in Account object.
     */
    protected void checkOutbox(){
        isLoggedInCheck();
        System.out.println("Checking outbox...");
        System.out.println("There is/are " + this.outbox.size() + " message(s) in the outbox.");
        actionHistory.add("You checked your outbox. ");
    }

    /**
     * Prints out the Action History information of the user.
     */
    protected void viewActionHistory(){
        isLoggedInCheck();
        int i=0;
        System.out.println("Viewing Action History for " + this.username + " ... ");
        System.out.println("---------------------------------------------------");
        for(i=0;i<actionHistory.size();i++){
            System.out.println(actionHistory.get(i));
        }
        System.out.println("---------------------------------------------------");

    }
    /**
     * Blocks an account. If a user is blocked, the accounts are both invisible to each other.
     *
     * @param acc The Account object to be blocked.
     *
     */
    protected void blockUser(Account acc){
        isLoggedInCheck();
        blockedUsers.add(acc);
        System.out.println("You have blocked "+acc.username+".");
        actionHistory.add("You blocked "+acc.username+".");
    }
    /**
     * Unblocks an account.
     *
     * @param acc The Account object to be unblocked.
     *
     */
    protected void unblockUser(Account acc){
        isLoggedInCheck();
        blockedUsers.remove(acc);
        System.out.println("You have unblocked "+acc.username+".");
        actionHistory.add("You unblocked "+acc.username+".");
    }
    /**
     * Checks whether the account which is being tried to operate on is blocked or not.
     * If one of the users had blocked the other one, the function returns true.
     *
     * @param acc The Account object to be checked.
     *
     */
    protected boolean isUserBlocked(Account acc){
        if( blockedUsers.contains(acc) || acc.blockedUsers.contains(this)){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Checks whether the object which is being tried to be operated on is logged in, terminates the program if not.
     */
    protected void isLoggedInCheck(){
        if(isLoggedIn == false){
            System.out.println("Please Log-In to the account first. The account you are trying to operate is not logged in. Terminating program...");
            System.exit(1);
        }
    }



}
