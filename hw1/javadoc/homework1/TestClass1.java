package homework1;
public class TestClass1 {
    public static void main(String[] args) {

        System.out.println("Creating Accounts...");
        System.out.println("");


        Account sibelgulmez = new Account("sibelgulmez","01.01.1999","Darica");
        Account gokhankaya = new Account("gokhankaya","03.05.1998","Tuzla");
        Account gizemsungu = new Account("gizemsungu","05.06.1988","Pendik");
        System.out.println("");

        sibelgulmez.login();
        System.out.println("");

        sibelgulmez.sharePost("I love OOP!");
        sibelgulmez.sharePost("Python is for kids :P");
        System.out.println("");


        sibelgulmez.followAccount(gokhankaya);
        sibelgulmez.followAccount(gizemsungu);
        System.out.println("");


        sibelgulmez.logout();
        System.out.println("");


        gokhankaya.login();
        System.out.println("");

        gokhankaya.viewProfile(sibelgulmez);
        System.out.println("");

        gokhankaya.viewPosts(sibelgulmez);
        System.out.println("");


        gokhankaya.likePost(sibelgulmez,1);
        gokhankaya.leaveComment(sibelgulmez,1,"OOP Rocks!");
        System.out.println("");


        gokhankaya.followAccount(sibelgulmez);
        gokhankaya.followAccount(gizemsungu);
        System.out.println("");


        gokhankaya.sendMessage(gizemsungu,"How are you doing??");
        System.out.println("");


        gokhankaya.logout();
        System.out.println("");


        gizemsungu.login();
        System.out.println("");

        //gizemsungu.likePost(sibelgulmez,1);
        //System.out.println("");


        gizemsungu.checkOutbox();
        System.out.println("");

        gizemsungu.checkInbox();
        System.out.println("");


        gizemsungu.viewInbox();
        System.out.println("");


        gizemsungu.viewProfile(sibelgulmez);
        System.out.println("");

        gizemsungu.viewPosts(sibelgulmez);
        System.out.println("");




        gizemsungu.viewInteractions(sibelgulmez);
        System.out.println("");

        gizemsungu.likePost(sibelgulmez,1);
        gizemsungu.likePost(sibelgulmez,2);
        System.out.println("");

        gizemsungu.viewInteractions(sibelgulmez);
        System.out.println("");





    }
}