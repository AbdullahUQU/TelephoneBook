/*Personal Project
 * The TelephoneBook project is an implementaion of digital telephon book,
 * with diffirent features.
 * @ author Abdullah Bamufleh
 * @ groupe No.7
 * @ since 13-1-2023
 * @ id 443010650
 */
import java.util.Scanner;
import java.util.InputMismatchException;


public class ContactApp extends TelephoneBook {
    public static void main(String[] args) {

        greeting();
        ContactApp app = new ContactApp();
        app.program();
    }

































    // print greeting message
    public static void greeting() {
        System.out.println("Welcome to Contact App");
    }

    // contains a list of app services
    public static String ServicesList() {
        String menu = "\nPlease select your service:\n --------------------\n| 1) Emergency       |\n| 2) Call            |\n| 3) Add new contatc |\n| 4) Edit            |\n| 5) Delete          |\n| 6) Search          |\n| 7) Print           |\n| 8) Favorite        |\n| 9) History         |\n| 0) Exit            |\n -------------------- ";
        return menu;
    }

// prgram hold the hole project menu choices to help users
    public void program() {
        int menuChoice = 0;
        boolean exit = false;
        do {

            System.out.println(ServicesList());

            
            try {
                Scanner input = new Scanner(System.in);

             menuChoice = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("\n----- Try to choose by only number -----\n");
                program();
            }

            switch (menuChoice) {
                case 1:
                    this.Emergency();
                    break;

                case 2:
                    this.makeCall();
                    break;

                case 3:
                    this.addContatct(validNam(), validNum());
                    break;

                case 4:
                    this.editContact();
                    break;

                case 5:
                    this.deleteContact();
                    break;

                case 6:
                    this.searchByName();
                    break;

                case 7:
                    this.printAllAlphabetically();
                    break;

                case 8:
                    System.out.println(
                            "please select:\n --------------------\n| 1) Add to favorite |\n| 2) Delete favorite |\n| 3) Print           |\n| 0) Back            |\n -------------------- ");
                    Scanner fav = new Scanner(System.in);
                    int Fav = fav.nextInt();
                    switch (Fav) {
                        case 1:
                            this.addToFav();
                            break;

                        case 2:
                            this.deleteFav();
                            break;

                        case 3:
                            this.printFav();
                            break;

                        case 0:
                            break;
                    }
                    break;
                case 9:
                    this.watchHistory();
                    break;

                case 0:
                    System.out.println("Thank you.");
                    exit = true;
                    break;

                    default :
                    System.out.println("\n----- invalid enterd try again -----\n");
            }
        } while (exit == false);

    }

// validNam asks for string to check if it has digits between it if yes it will ask again for string
    public static String validNam() {
        System.out.print("Please enter the name: ");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        if (containsDigit(name)){
            System.out.println("\n ----- the name must not hava numbers ----- \n");
            return validNam();
        }else{
            return name;
        }
        
    }

    // validNum method asks for string and check if a string has 10 digits starting by 05 and without any letters otherwise it will ask again
    public static String validNum() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number please: ");
        String number = input.nextLine();
        if (number.length() == 10 && number.substring(0, 2).equals("05") && !containsLetter(number)) {
            return number;
        } else {
            System.out.println("\n----- The number must be in form of 05XXXXXXXX -----\n");
            return validNum();
        }
    }
// containsDigit method take a string and return true if the string has at least one digit otherwise return false

    public static boolean containsDigit(String name){
        boolean hasDigit = false;
        char isDigit[] =  name.toCharArray();
        for (char c : isDigit) {
            if(Character.isDigit(c)){
                hasDigit = true;
                break;
            }else{
                hasDigit = false;
            }
        }
        return hasDigit;
       
    }

// containLetter method take a string and return true if the string has at least one english letter otherwise return false
    public static boolean containsLetter(String number){
        boolean hasLetter = false;
        char isDigit[] =  number.toCharArray();
        for (char c : isDigit) {
            if(!Character.isDigit(c)){
                hasLetter = true;
                break;
            }else{
                return false;
            }
        }
        return hasLetter;
       
    }
}