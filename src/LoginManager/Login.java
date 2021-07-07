package LoginManager;

import IOReadAndWriteFile.IOReadAndWriteFile;

import java.util.*;
import java.util.List;
import java.util.Scanner;


public class Login {
    private final String path = "C:\\Users\\HOANG\\IdeaProjects\\CaseStudy_Module2\\Account.txt";
    List<User> listAccount = IOReadAndWriteFile.readDataFromFile(path);
    Scanner sc = new Scanner(System.in);
    private final String REGEX_USERNAME = "^\\w{1,}";
    private final String REGEX_PASSWORD = "^\\w{0,}";

    private String user(){
        System.out.println("User: ");
        return sc.nextLine();
    }
    private String passWord(){
        System.out.println("PassWord: ");
        return sc.nextLine();
    }

    //Lua chon dang nhap hoac dang ky.
    public void LoginOrRegistration(){
        while (true){
            System.out.println("1. Login.");
            System.out.printf("Enter the valule:");
           try{
               int value = Integer.parseInt(sc.nextLine());
               switch (value){
                   case 1: login();
                       break;
                   default:System.out.println("Enter 1.");
               }
           }catch (Exception e) {
               System.out.println("Enter 1 or 2.");
           }
        }
    }
    private User loginAccount(){
        String user = user();
        String password = passWord();
        if(!Check.validate(user,REGEX_USERNAME) && !Check.validate(password, REGEX_PASSWORD)){
            System.out.println("Account must have at least 1 character: ");
            return loginAccount();
        }else{
            return new User(user,password);
        }
    }
    //dang nhap vao menu
    private void login(){
        while (true) {
            User user = loginAccount();
            if(Check.checkUser(user.getUserName(),user.getPassWord())){
                while (true){
                    System.out.println(
                            "    1. Display the list of machines available in the shop\n" +
                                    "    2. Add 1 new device to the list\n" +
                                    "    3. Modify the machine's information.\n" +
                                    "    4. Remove 1 device from the list.\n" +
                                    "    5. More services\n" +
                                    "    6. Edit hourly billing\n" +
                                    "    7. Billing\n" +
                                    "    8. Manage login accounts\n" +
                                    "   9. Revenue\n" +
                                    "   \"");
                    int value = Integer.parseInt(sc.nextLine());
                    switch (value){
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        case 5:
                            break;
                        case 6:
                            break;
                        case 7:
                            break;
                        case 8: ManagerAccount.Account();
                            break;
                        case 9:
                            break;
                        default:
                            System.out.println("Please choose again");
                    }

                }
            }
            else{
                System.out.println("UserName or PassWord false.");
                LoginOrRegistration();
            }
        }
    }

}
