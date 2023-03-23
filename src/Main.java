import java.util.regex.Pattern;
import java.util.Scanner;

class Main
{
    public static class CheckLogException extends RuntimeException {

    }
    public  static class CheckPasException extends RuntimeException{

    }
    public static class CheckPasEqualsException extends RuntimeException{

    }
    private static Pattern p = Pattern.compile("[0-9a-zA-Z_]");


    public static boolean checkAuthentiffication(String login, String password, String confirmPassword) {
        boolean check1 = false;
        boolean check2 = false;
        if (login.length() > 20 || !p.matcher(login).find()){
            throw new CheckLogException();
        } else {
            check1 = true;
        }
        if (password.length() > 20 || !p.matcher(password).find()) {
            throw new CheckPasException();
        } else {
            check2 = true;
        }
        if (!password.equals(confirmPassword)){
            throw new CheckPasEqualsException();
        }
        return check1&&check2;
    }
    public static void main(String[] args)
    {
        System.out.println("Введите login");
        Scanner personLogin = new Scanner (System.in);
        String login = personLogin.nextLine();

        System.out.println("Введите password");
        Scanner personPassword = new Scanner (System.in);
        String password = personPassword.nextLine();

        System.out.println("Подтвердите password");
        Scanner confirm = new Scanner (System.in);
        String confirmPassword = confirm.nextLine();
        try{
            System.out.println(checkAuthentiffication(login,password,confirmPassword));
        }
        catch   (CheckLogException e1){
            System.out.println("WrongLoginException");
        }
        catch (CheckPasException e2){
            System.out.println("WrongPasswordException");
        }
        catch (CheckPasEqualsException e) {
            System.out.println("WrongConfirmPasswordException");
        }
    }
}
