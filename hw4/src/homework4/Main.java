package homework4;
public class Main {
    public static void main(String[] args) {

        SecurityControlMethods myObj = new SecurityControlMethods();


        myObj.login("sibelgulmez","[rac()ecar]",74);

        myObj.login("", "[rac()ecar]", 74);

        myObj.login("sibel1", "[rac()ecar]", 74);

        myObj.login("sibel", "pass[]", 74);

        myObj.login("sibel", "abcdabcd", 74);

        myObj.login("sibel", "[[[[]]]]", 74);

        myObj.login("sibel", "[no](no)", 74);

        myObj.login("sibel", "[rac()ecar]]", 74); // unbalanced

        myObj.login("sibel", "[rac()ecars]", 74);

        myObj.login("sibel", "[rac()ecar]", 5);

        myObj.login("sibel", "[rac()ecar]", 35);



    }


}