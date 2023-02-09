import java.util.Vector;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

// the main class that create object of a class Contatct and store it in a Vector variable
public class TelephoneBook {
    private Vector<Contact> contacts;
    private Vector<String> history = new Vector<String>();
    private static final String emergency = "911";

    // the class Constructor
    public TelephoneBook() {
        contacts = new Vector<Contact>();
    }

    // Emergency number getter
    public static String getEmergency() {
        return emergency;
    }

    // addContatc method to add contatct to your vector list
    public void addContatct(String name, String number) {
        contacts.add(new Contact(name, number));
        System.out.println("done. \n");
    }

    // deleteContact method to delete the hole contacte by it's name
    public void deleteContact() {
        String name;
        boolean exist = true;
        if (contacts.isEmpty()) {
            emptyList();
        } else {
            name = ContactApp.validNam();
            for (int i = 0; i < contacts.size(); i++) {
                Contact p = contacts.get(i);
                if (p.getName().equals(name)) {
                    contacts.remove(i);
                    System.out.println("done. \n");
                    exist = true;
                    break;
                }else{
                    exist = false;
                }
            }if (!exist){
               notExist();
            }
            
        }
        
    }

    // editContact method to modify the contact info
    public void editContact() {
       
        String oldName,newName,newNumber;

        boolean exist = true;
        if (contacts.isEmpty()) {
            emptyList();
        } else {
           
              oldName = ContactApp.validNam();
              
            for (Contact N : contacts) {
                if (N.getName().equals(oldName)) {

                    System.out.println(N);
                  
                    newName = ContactApp.validNam();
                    newNumber = ContactApp.validNum();

                    N.setName(newName);
                    N.setNumber(newNumber);
                    System.out.println("done. \n");
                    exist = true;
                    break;
                } else {
                    exist = false;
                }
            }
        }
        if (!exist) {
            notExist();
        }

    }

    // searchByName method, return the contact stored by the name provided
    public void searchByName() {
        String name;
        boolean checker = true;
        if (contacts.isEmpty()) {
            emptyList();
        } else {
            name = ContactApp.validNam();
            for (Contact N : contacts) {
                if (N.getName().equals(name)) {
                    checker = true;
                    System.out.println( N );
                    System.out.println("done. \n");
                    break;
                } else {
                    checker = false;
                }
            }
            if (!checker) {
               notExist();
            }
        }
    }

    // printAllAlphabetically method used to print all contacts in alphabet order
    public void printAllAlphabetically() {
        if (contacts.isEmpty()) {
            emptyList();
        } else {
            char[] i = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
                    't', 'u', 'v', 'w', 'x', 'y', 'z' };
            char[] I = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
                    'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
            for (int j = 0; j < I.length; j++) {
                System.out.println("----" + I[j] + "----");
                for (Contact N : contacts) {
                    if (N.getName().charAt(0) == I[j] || N.getName().charAt(0) == i[j]) {
                        System.out.println( N );
                    }
                }
            }
        }
    }

    // addToFav method to add an exist contact to your favorite list
    public void addToFav() {
        String name;
        boolean checker = true;
        if (contacts.isEmpty()) {
            emptyList();
        } else {
            name = ContactApp.validNam();
            for (Contact N : contacts) {
                if (N.getName().equals(name)) {
                    N.setFavourite(true);
                    System.out.println("done. \n");
                    checker = true;
                    break;
                } else {
                    checker = false;
                }
            }
            if (checker) {

            } else {
                notExist();
            }
        }
    }

    // deleteFav method to delete an exist contact from your favorite list
    public void deleteFav() {
        String name;
        boolean exist = true;
        if (contacts.isEmpty()) {
            emptyList();
        } else {
            name = ContactApp.validNam();
            for (Contact N : contacts) {
                if (N.getName().equals(name)) {
                    N.setFavourite(false);
                    System.out.println("done. \n");
                    exist = true;
                    break;
                } else {
                    exist = false;
                }
            }if (!exist){
                notExist();
            }
            
        }
    }

    // printFav method to demonstrate all favorait contacts
    public void printFav() {
        if (contacts.isEmpty()){
            emptyList();
        }else{
            System.out.println("----- All favorait -----");
        for (Contact N : contacts) {
            if (N.getFavourite() == true)
                System.out.println(N + "\n");
        }
        System.out.println("------------------------");
        }
    }

    // makeCall methode is used to call the spesfiy contact
    public void makeCall(){
        String name;
        Date date;
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        boolean exist = true;
        if(contacts.isEmpty()){
            emptyList();
        }else{
                name = ContactApp.validNam();
            for (Contact N : contacts) {
                if (N.getName().equals(name)){
                    System.out.println("calling ...\n tooot \n tooot \n " + N.getName() + ": yes hello?");
                    date = new Date();
                     history.add( dateFormat.format(date)  + "   " + N.getName() );
                    exist = true;
                    break;
                }else{
                    exist = false;
                }
            }if(!exist){
                notExist();
            }
        }
    }
    

    // watchHistory methode used to show the last calls with it's date
    public void watchHistory() {
        System.out.println("-------- History --------");
        for (String N : history) {
            System.out.println(N);
        }
        System.out.println("--------------------------");
    }

    // Emergency method used to call Emergency
    public void Emergency() {
        System.out.println("calling ...\n tooot \n tooot \n " + getEmergency() + ": yes " + getEmergency()
                + " with you How can I help?");
        Date date;
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Scanner input = new Scanner(System.in);
        String EmergencyCase = input.nextLine();
        System.out.println("OK hold on, I'm on my way.");
        date = new Date();
        history.add( dateFormat.format(date) + "   " + getEmergency() );
    }

    // print Sorry the list is Empty!
    public static void emptyList(){
        System.out.println("\n----- Sorry the list is Empty! -----\n");
    }

    // print Sorry, the contact you are looking for is not exist
    public static void notExist(){
        System.out.println("\n----- Sorry, the contact you are looking for is not exist -----\n");
    }
}
