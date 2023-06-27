package homework1;

/**
 * A class representing a message sent from one account to another.
 */
public class Message {
    /**
     * Constructs a new Message object with the given sender and receiver Accounts, and content.
     *
     * @param fromAcc the Account object representing the sender of the message.
     * @param toAcc the Account object representing the receiver of the message.
     * @param content the content of the message.
     */
    public Message(Account fromAcc, Account toAcc, String content){
        this.senderID = fromAcc.userID;
        this.senderObj = fromAcc;
        this.receiverID = toAcc.userID;
        this.receiverObj = toAcc;
        this.content = content;
        this.messageID = toAcc.inboxCounter + 1;
    }
    /**
     * Returns a String representation of the Message object.
     *
     * @return a String representation of the Message object.
     */
    @Override
    public String toString() {
        return "Message ID: " + this.messageID + "\n"+
                "From: " + this.senderObj.username + "\n" +
                "To: " + this.receiverObj.username + "\n" +
                "Message: " + this.content + "\n";
    }
    /**
     * The ID of the message.
     */
    protected int messageID;
    /**
     * The ID of the sender of the message.
     */
    protected int senderID;

    /**
     * The ID of the receiver of the message.
     */
    protected int receiverID;
    /**
     * Sender account as an Account object.
     */
    protected Account senderObj;
    /**
     * Receiver account as an Account object.
     */
    protected Account receiverObj;
    /**
     * The content of the message.
     */
    protected String content;


}
