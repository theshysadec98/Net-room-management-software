package LoginManager;

import IOReadAndWriteFile.IOReadAndWriteFile;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Check {
    private static Pattern pattern;
    private static Matcher matcher;
    private static final String path = "C:\\Users\\HOANG\\IdeaProjects\\CaseStudy_Module2\\Account.txt";
    static List<User> listAccount = IOReadAndWriteFile.readDataFromFile(path);
    Scanner sc = new Scanner(System.in);

    public static boolean validate(String regex, String ACCOUNT_REGEX){
        pattern = Pattern.compile(ACCOUNT_REGEX);
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }
    public static boolean checkUserName(String user){
        for(int i =0; i < listAccount.size(); i ++){
            if(user.equals(listAccount.get(i).getUserName())){
                return true;
            }
        }
        return false;
    }
    public static boolean checkUser(String user, String pass){
        for(int i =0; i < listAccount.size(); i ++){
            if(user.equals(listAccount.get(i).getUserName()) && pass.equals(listAccount.get(i).getPassWord())){
                return true;
            }
        }
        return false;
    }
}
