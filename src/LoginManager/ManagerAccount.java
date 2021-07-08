package LoginManager;

import IOReadAndWriteFile.IOReadAndWriteFile;

import java.util.List;
import java.util.Scanner;

public class ManagerAccount {
    private static final String REGEX_USERNAME = "^\\w{1,}";
    private static final String REGEX_PASSWORD = "^\\w{1,}";
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
//-----------------------------------------
    private static void AddRegistration(){
        listAccount.add(Registration());
        IOReadAndWriteFile.Write(path, listAccount);
        showListAccount();
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
//-----------------------------------------
    private static void Revision(){
        System.out.println("Enter the account name to edit: ");
        String name = user();
        for (int i = 0; i < listAccount.size(); i ++){
            if(name.equals(listAccount.get(i).getUserName())){
                listAccount.get(i).setUserName(newName(i));
                listAccount.get(i).setPassWord(newPass(i));
            }
        }
        IOReadAndWriteFile.Write(path, listAccount);
        showListAccount();
    }
    private static String newName(int value){
        System.out.println("Enter the new name: ");
        String rename = sc.nextLine();
        if(rename == listAccount.get(value).getUserName()){
            System.out.println("The new name cannot be the same as the old name.");
            return newName(value);
        }
        return rename;
    }
    private static String newPass(int value){
        System.out.println("Enter the new name: ");
        String repass = sc.nextLine();
        if(repass == listAccount.get(value).getUserName()){
            System.out.println("The new password cannot be the same as the old password.");
            return newName(value);
        }
        return repass;
    }
//--------------------------------------------
    private static void Delete(){
        System.out.println("Enter the value to delete: ");
        showListAccount();
        int value = Integer.parseInt(sc.nextLine());
        YesOrNo(value);
        IOReadAndWriteFile.Write(path, listAccount);
    }
    private static void YesOrNo(int value){
        System.out.println("Enter '1' Yes.");
        System.out.println("Enter '0' No.");
        try{
            int choose = Integer.parseInt(sc.nextLine());
            switch (choose){
                case 0: showListAccount();
                    break;
                case 1:
                    listAccount.remove(value);
                    break;
                default: YesOrNo(value);
            }
        }catch (Exception e){
            System.out.println("Choose 1 or 0.");
            YesOrNo(value);
        }
    }

    private static void showListAccount(){
        for (int i = 0; i < listAccount.size(); i++) {
            System.out.println( i +". "+listAccount.get(i));
        }
    }
}
