package homework1;
/**
 * A class that represents a user account on this social media platform program.
 */
public class Account {

    /**
     * A counter for assigning unique IDs to new accounts.
     */
    private int idCounter = 1;
    /**
     * A bool representing whether the account is currently logged in.
     */
    private boolean isLoggedIn = false;
    /**
     * Creates a new account with default values for username, birthdate, and location (for test purposes only).
     */
    private Account(){
        this.userID = idCounter;
        idCounter = idCounter + 1;
        //Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Account Creating Tab!");
        System.out.println("Please enter username:  ");
        this.username = "emir";//scanner.next();
        System.out.println("Please enter your Birth Date (use XX.XX.XXXX format) :  ");
        this.birthDate = "1.1.2001";//scanner.next();
        System.out.println("Please enter your Location:  ");
        this.location = "gungoren";//scanner.next();

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
        idCounter = idCounter + 1;
        System.out.println("An account with name " + uname + " has been created");
        //Scanner scanner = new Scanner(System.in);
        //System.out.println("Welcome to Account Creating Tab!");
        //System.out.println("Please enter username:  ");
        this.username = uname;//scanner.next();
        //System.out.println("Please enter your Birth Date (use XX.XX.XXXX format) :  ");
        this.birthDate = ubirthdate;//scanner.next();
        //System.out.println("Please enter your Location:  ");
        this.location = ulocation;//scanner.next();

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
     * An array of accounts that this account is following.
     */
    protected Account[] following = new Account[32];
    /**
     * A counter for keeping track of the number of accounts that this account is following.
     */
    protected int followingCounter = 0;
    /**
     * An array of accounts that are following this account (which are this account's "followers").
     */
    protected Account[] followers = new Account[32];
    /**
     * A counter for keeping track of the number of accounts that are following this account.
     */
    protected int followerCounter = 0;
    /**
     * An array of posts that have been made by this account.
     */
    protected Post[] posts = new Post[32];
    /**
     * A counter for keeping track of the number of posts that have been made by this account.
     */
    protected int postCounter = 0;
    /**
     * An array of messages that have been 'received' by this account.
     */
    protected Message[] inbox = new Message[32];
    /**
     * A counter for keeping track of the number of messages that have been received by this account.
     */
    protected int inboxCounter = 0;
    /**
     * An array of messages that have been 'sent' by this account.
     */
    protected Message[] outbox = new Message[32];
    /**
     * A counter for keeping track of the number of messages that have been sent by this account.
     */
    protected int outboxCounter = 0;

    /**
     * Logs in to the account.
     */
    protected void login(){
        if(isLoggedIn == true){
            System.out.println("First log out from the current user to log in to your account...");
            return;
        }
        System.out.println("Logged in as " + this.username);
        isLoggedIn = true;
    }
    /**
     * Logs out from the account.
     */
    protected void logout(){
        isLoggedInCheck();
        System.out.println("Logging out from account " + this.username);
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
        newPost.AccountID = this.userID;
        posts[postCounter] = newPost;
        this.postCounter += 1;

    }
    /**
     * Displays the profile information of the provided Account object.
     *
     * @param acc The Account object whose profile information will be displayed.
     */
    protected void viewProfile(Account acc){
        isLoggedInCheck();
        System.out.println("Viewing " + acc.username + "'s Account...");
        System.out.println("------------------------------------");
        System.out.println("Username: " + acc.username);
        System.out.println("Location : " + acc.location);
        System.out.println("Birth Date: " + acc.birthDate);
        System.out.println("This Account has " + acc.postCounter + " post(s).");
        System.out.println( acc.username +" is following " + acc.followingCounter + " account(s) and has " + acc.followerCounter+ " follower(s).");
        //System.out.println("This Account follow(s) " + (followingCounter) + " accounts.");


    }
    /**
     * Displays the posts of the provided Account object.
     *
     * @param acc The Account object whose posts will be displayed.
     */
    protected void viewPosts(Account acc){
        isLoggedInCheck();
        System.out.println("Viewing " + acc.username + " posts...");
        for(int i=0;i<acc.postCounter;i++){
            System.out.println(acc.posts[i].toString());

        }
    }
    /**
     * Displays the interactions (likes and comments) of the provided Account object's posts.
     *
     * @param acc The Account object whose post interactions will be displayed.
     */
    protected void viewInteractions(Account acc){
        isLoggedInCheck();
        System.out.println("Viewing " + acc.username + " post interactions...");
        for(int i=0;i<acc.postCounter;i++){
            System.out.println("----------------------------------");
            System.out.print(acc.posts[i].toString());

            System.out.println("The post has " + acc.posts[i].likes + " like(s)");

            if(acc.posts[i].likes != 0){
                System.out.print("The post was liked by the following accounts: ");// +posts[i].likes+ " user(s).");
                for(int k=0;k<acc.posts[i].likes;k++){
                    System.out.println(acc.posts[i].whoLiked[k] + ",");
                }
            }

            System.out.println("The post has " + acc.posts[i].commentCounter + " comment(s)");

            for(int j=0;j<acc.posts[i].commentCounter;j++){
                System.out.println("Comment "+(j+1)+": " + "'"+acc.posts[i].whoCommented[j]+ "'"+" said: "+ acc.posts[i].comments[j]);
            }
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
        //Post toLike = acc.posts[postid-1];
        acc.posts[postid-1].whoLiked[acc.posts[postid-1].likes] = this.username;
        acc.posts[postid-1].likes = acc.posts[postid-1].likes + 1;
        System.out.println("Liking (Post ID: "+ postid + ") of " + acc.username + "...");
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
        //Post toComment = acc.posts[postid-1];
        Comment newComment = new Comment(content);
        acc.posts[postid-1].comments[acc.posts[postid-1].commentCounter] = newComment.content;
        acc.posts[postid-1].whoCommented[acc.posts[postid-1].commentCounter] = this.username;
        acc.posts[postid - 1].commentCounter ++;
        System.out.println("Adding a comment on " +acc.username+"'s post...");
    }
    /**
     * Follows the provided Account object.
     *
     * @param toFollow The Account object to be followed.
     */
    protected void followAccount(Account toFollow){
        isLoggedInCheck();
        this.following[this.followingCounter] = toFollow;
        this.followingCounter++;
        toFollow.followers[toFollow.followerCounter]  = this;
        toFollow.followerCounter = toFollow.followerCounter + 1;
        System.out.println("Following " + toFollow.username + " ...");

    }
    /**
     * Sends a message to the provided Account object.
     *
     * @param toAcc The Account object to send the message to.
     * @param content The content of the message to be sent.
     */
    protected void sendMessage(Account toAcc, String content){
        isLoggedInCheck();
        Message theMessage = new Message(this,toAcc,content);
        this.outboxCounter++;
        toAcc.inbox[toAcc.inboxCounter] = theMessage;
        this.outbox[this.outboxCounter] = theMessage;
        toAcc.inboxCounter++;
        System.out.println("Sending a message to " + toAcc.username + "...");

    }
    /**
     * Displays the messages in the inbox of the logged-in Account object.
     */
    protected void viewInbox(){
        isLoggedInCheck();
        System.out.println("Viewing inbox...");
        System.out.println("-----------------------------------------------");
        for(int i=0;i<this.inboxCounter;i++){
            System.out.println(this.inbox[i]);
        }
    }
    /**
     * Displays the messages in the outbox of the logged-in Account object.
     */
    protected void viewOutbox(){
        isLoggedInCheck();
        System.out.println("Viewing outbox...");
        System.out.println("-----------------------------------------------");
        for(int i=0;i<this.outboxCounter;i++){
            System.out.println(this.outbox[i]);
        }

    }
    /**
     * Checks the number of messages in the inbox of the logged-in Account object.
     */
    protected void checkInbox(){
        isLoggedInCheck();
        System.out.println("Checking inbox...");
        System.out.println("There is/are " + inboxCounter + " message(s) in the inbox.");
    }
    /**
     * Checks the number of messages in the outbox of the logged-in Account object.
     */
    protected void checkOutbox(){
        isLoggedInCheck();
        System.out.println("Checking outbox...");
        System.out.println("There is/are " + outboxCounter + " message(s) in the outbox.");
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
