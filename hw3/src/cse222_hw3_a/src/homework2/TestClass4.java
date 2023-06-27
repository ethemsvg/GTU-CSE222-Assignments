package homework2;


import java.text.NumberFormat;
import java.text.DecimalFormat;

public class TestClass4 {
    public static void main(String[] args) {
	long start = System.currentTimeMillis();
        System.out.println("Creating Accounts...");
        System.out.println("");


        Account sibelgulmez = new Account(1,"sibelgulmez","01.01.1999","Darica");
        Account gokhankaya = new Account(2,"gokhankaya","03.05.1988","Tuzla");
        Account gizemsungu = new Account(3,"gizemsungu","05.06.1998","Pendik");
        Account ysa = new Account(4,"ysa","23.10.1971","Houston");
        Account mehmetG = new Account(5,"mehmetG","21.11.1974","Dubai");
        Account yakupG = new Account(6,"yakupG","13.09.3047","Planet G-4723");
        Account abdurrahman = new Account(7,"abdurrahman","05.06.1988","Kartal");
        Account ethem = new Account(8,"ethem","15.07.2002","Gtu Library");
        Account enesss = new Account(9,"enesss","01.06.2000","Dudullu");
        Account reveha = new Account(10,"reveha","02.09.2001","Cayirova");
        Account habilK = new Account(11,"habilK","05.06.1986","Texas");


        ysa.login();
        ysa.followAccount(mehmetG);
        ysa.followAccount(yakupG);


        ysa.sharePost("I have a boxing match with Linus tomorrow!!");
        ysa.sharePost("God I love tetris!!!! ");

        ysa.blockUser(abdurrahman);
        ysa.viewProfile(ethem);
        ysa.sendMessage(ethem,"I believe in you kid..");
        ysa.sendMessage(habilK,"How are you hocam?");

        ysa.viewActionHistory();

        ysa.logout();

        abdurrahman.login();
        abdurrahman.viewProfile(ysa);
        abdurrahman.sharePost("Why can't I see YSA's account???");
        abdurrahman.logout();

        yakupG.login();
        yakupG.followAccount(ethem);
        yakupG.followAccount(ysa);
        yakupG.leaveComment(ysa,1,"Don't you dare touch him hoca!!");
        yakupG.likePost(ysa,2);
        yakupG.leaveComment(ysa,2,"Damn right!!");
        yakupG.sharePost("Hey guys, i just uploaded your 824th assignment on teams!!");
        yakupG.viewInteractions(ysa);
        yakupG.sendMessage(ethem,"Let's do business you little genius!");
        yakupG.blockUser(abdurrahman);
        yakupG.viewActionHistory();
        yakupG.logout();

        mehmetG.login();
        mehmetG.followAccount(ysa);
        mehmetG.followAccount(yakupG);
        mehmetG.blockUser(abdurrahman);
        mehmetG.viewPosts(ysa);
        mehmetG.likePost(ysa,1);
        mehmetG.likePost(ysa,2);
        mehmetG.leaveComment(ysa,1,"He is a nice guy hoca !!");
        mehmetG.viewInteractions(ysa);
        mehmetG.uncomment(ysa,1,2);
        mehmetG.viewInteractions(ysa);
        mehmetG.viewPosts(yakupG);
        mehmetG.leaveComment(yakupG,1,"Don't be too harsh on the kids hocam!");
        mehmetG.likePost(yakupG,1);
        mehmetG.viewInteractions(yakupG);
        mehmetG.sendMessage(ysa,"Admit that bogazici is better!");
        mehmetG.unfollowAccount(yakupG);
        mehmetG.viewActionHistory();
        mehmetG.logout();

        ysa.login();
        ysa.checkInbox();
        ysa.viewInbox();
        ysa.sendMessage(mehmetG,"No way!!!");
        ysa.viewOutbox();
        ysa.unblockUser(abdurrahman);
        ysa.logout();

        abdurrahman.login();
        abdurrahman.viewProfile(ysa);
        abdurrahman.followAccount(ysa);
        abdurrahman.sharePost("YES!! He unblocked me !! Finally i can view YSA's account!! ");
        abdurrahman.viewPosts(ysa);
        abdurrahman.likePost(ysa,1);
        abdurrahman.likePost(ysa,2);
        abdurrahman.logout();

        ethem.login();
        ethem.checkInbox();
        ethem.viewInbox();
        ethem.sendMessage(ysa,"It is an honor for me sir. I believe in myself too!");
        ethem.sendMessage(yakupG,"That's an awesome offer hocam!! But let me finish my homeworks first <3 ");
        ethem.followAccount(ysa);
        ethem.followAccount(yakupG);
        ethem.followAccount(mehmetG);
        ethem.followAccount(enesss);
        ethem.sharePost("I love gtu!");
        ethem.unfollowAccount(enesss);
        ethem.blockUser(enesss);
        ethem.logout();

        enesss.login();
        enesss.followAccount(ethem);
        enesss.viewProfile(mehmetG);
        enesss.followAccount(mehmetG);
        enesss.viewActionHistory();
        enesss.logout();

        reveha.login();
        reveha.sendMessage(ethem,"Brothers for life!!");
        reveha.followAccount(ethem);
        reveha.followAccount(ysa);
        reveha.viewProfile(ysa);
        reveha.leaveComment(ysa,2,"I feel like a L tetromino, i am not a human being anymore...");
        reveha.logout();

        habilK.login();
        habilK.followAccount(ysa);
        habilK.followAccount(yakupG);
        habilK.followAccount(mehmetG);
        habilK.viewProfile(yakupG);
        habilK.viewPosts(yakupG);
        habilK.leaveComment(yakupG,1," this is why kids don't have time to study for my logic class lol");
        habilK.likePost(yakupG,1);
        habilK.unlikePost(yakupG,1);
        habilK.viewInteractions(yakupG);

        habilK.viewInbox();
        habilK.sendMessage(ysa,"I am fine hocam, i hope you are doing well !");
        habilK.logout();


        sibelgulmez.login();
        sibelgulmez.followAccount(gokhankaya);
        sibelgulmez.followAccount(gizemsungu);
        sibelgulmez.followAccount(ysa);
        sibelgulmez.sharePost("How am i supposed to evaulate all this assignments! God help me.");
        sibelgulmez.sendMessage(gizemsungu,"Lets share the assignments fifty fifty!");
        sibelgulmez.logout();

        gizemsungu.login();
        gizemsungu.followAccount(sibelgulmez);
        gizemsungu.checkInbox();
        gizemsungu.viewInbox();
        gizemsungu.sendMessage(sibelgulmez,"I was about to offer the same thing to you!");
        gizemsungu.viewActionHistory();
        gizemsungu.logout();

        gokhankaya.login();
        gokhankaya.viewProfile(ysa);
        gokhankaya.followAccount(ysa);
        gokhankaya.viewProfile(ethem);
        gokhankaya.followAccount(ethem);
        gokhankaya.viewInteractions(ysa);
        gokhankaya.sharePost(" I give the most enjoyable assignments ever!! ");
        gokhankaya.logout();

        ethem.login();
        ethem.viewProfile(gokhankaya);
        ethem.viewPosts(gokhankaya);
        ethem.leaveComment(gokhankaya,1," Writing reports and test cases are not even enjoyable hocam :( ");
        ethem.likePost(gokhankaya,1);
        ethem.logout();

        gokhankaya.login();
        gokhankaya.viewProfile(ethem);
        gokhankaya.leaveComment(gokhankaya,1," shut up peasent!! they are enjoyable!! ");
        gokhankaya.unfollowAccount(ethem);
        gokhankaya.blockUser(ethem);
        gokhankaya.viewInteractions(ysa);
        gokhankaya.viewActionHistory();
        gokhankaya.logout();



	long end = System.currentTimeMillis();

	NumberFormat formatter =  new DecimalFormat("#0.00000");
	System.out.print("Execution time is " + formatter.format((end - start) / 1000d) + " seconds");







    }
}
