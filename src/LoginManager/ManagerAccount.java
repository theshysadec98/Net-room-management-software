package LoginManager;

import IOReadAndWriteFile.IOReadAndWriteFile;

import java.util.List;
import java.util.Scanner;

public class ManagerAccount {
    private static final String REGEX_USERNAME = "^\\w{1,}";
    private static final String REGEX_PASSWORD = "^\\w{0,}";
    private static final String path = "C:\\Users\\HOANG\\IdeaProjects\\CaseStudy_Module2\\Account.txt";
    static List<User> listAccount = IOReadAndWriteFile.readDataFromFile(path);
    static Scanner sc = new Scanner(System.in);

    private static String user(){
        System.out.println("User: ");
        String name = sc.nextLine();
        try{
            if(!Check.validate(name,REGEX_USERNAME) ){
                System.out.println("User name must have at least 1 character");
                return user();
            }
            else return name;
        }catch (Exception e){
            System.out.println("Must start with a letter or number");
            return user();
        }

    }
    private static String passWord(){
        System.out.println("PassWord: ");
        return sc.nextLine();
    }

    public static void Account(){
        while (true){
            System.out.println("1. Add account.");
            System.out.println("2. Revision");
            System.out.println("3. Delete.");
            System.out.println("4. List account.");
            System.out.printf("Choose :");
            try {
                int value = Integer.parseInt(sc.nextLine());
                switch (value){
                    case 1: AddRegistration();
                        break;
                    case 2: Revision();
                        break;
                    case 3: Delete();
                        break;
                    case 4: showListAccount();
                        break;
                    default:
                        System.out.println("Choose 1, 2, 3 or 4.");
                }
            }catch (Exception e){
                System.out.println("Please enter number to select");
            }
        }
    }
    private static void AddRegistration(){
        listAccount.add(Registration());
        IOReadAndWriteFile.Write(path, listAccount);
    }
    private static User Registration(){
        System.out.println("Registration :");
        User newUser = new User(user(), passWord());
        if(!Check.validate(newUser.getUserName(),REGEX_USERNAME) && !Check.validate(newUser.getPassWord(), REGEX_PASSWORD)){
            return Registration();
        }else{
            if(Check.checkUserName(newUser.getUserName())){
                System.out.println("Account already exists.");
                return Registration();
            }
            else{
                return newUser;
            }
        }
    }

    private static void Revision(){
        System.out.println("Enter the account name to edit: ");
        String name = user();
        for (User i : listAccount){
            if(name.equals(i.getUserName())){
                i.setUserName(user());
                i.setPassWord(passWord());
            }
        }
        IOReadAndWriteFile.Write(path, listAccount);
    }
    private static void Delete(){
        System.out.println("Enter the account name to edit: ");
        String name = user();
        for (int i =0; i < listAccount.size(); i ++){
            if(name.equals(listAccount.get(i).getUserName())){
                listAccount.remove(i);
            }
        }
        IOReadAndWriteFile.Write(path, listAccount);
    }
    private static void showListAccount(){
        for (User i : listAccount){
            System.out.println(i);
        }
    }
}
