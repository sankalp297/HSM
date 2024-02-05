import java.util.Scanner;
import java.util.regex.Pattern;

public class Validator {
    public static final String RED = "\u001B[31m";
    public static final String CYAN = "\033[0;36m";
    public static final String RESET = "\u001B[0m";

    private static Pattern ID_PATTERN = Pattern.compile("^\\d{1,4}$");
    private static Pattern name_Pattern = Pattern.compile("^[a-zA-Z ]+$");
    private static Pattern PYear_Pattern = Pattern.compile("^\\d{4}$");
    private static Pattern Doctor_Degree=Pattern.compile("^[a-zA-Z.]+$");
    private static Pattern Choice=Pattern.compile("^\\d{1}");
    Scanner sc = new Scanner(System.in);


    public String validateId() {
        String bookid;
        while (true) {
            System.out.println("Enter DOCTOR ID ");
            bookid = sc.nextLine();
            
            if (!ID_PATTERN.matcher(bookid).matches()) {
                System.out.println(CYAN + "SORRY ! PLEASE ENTER VALID DOCTOR ID " + RESET);
            } else {
                break;
            }
        }
        return bookid;
    }


    public String validateDoctorName(String input) {
        String result;
        while (true) {
            if (input == "Name") {
                System.out.println("Enter NAME");
            } else {
                System.out.println("Enter DEGREE");
            }
            result = sc.nextLine();
            if (!name_Pattern.matcher(result).matches()) {
                System.out.println(RED + "Please Enter Valid " + input + RESET);
            } else {
                break;
            }

        }
        return result;
    }

    public String validatePassoutYear() {
        String year;
        while (true) {
            System.out.println("Enter PASSOUT Year of GRADUATION ");
            year = sc.nextLine();
            if (!PYear_Pattern.matcher(year).matches()) {
                System.out.println(RED + "Enter valid  Year" + RESET);
            } else {
                break;
            }
        }
        return year;
    }

    public String validateDegree(String input) {
        String D;
        while (true){
            System.out.println("Enter Degree");
            D=sc.nextLine();
            if (!Doctor_Degree.matcher(D).matches()){
                System.out.println(RED+"Enter Valid Degree"+RESET);
            }else {
                break;
            }
        }
        return D;

    }

}



