import java.util.*;
import java.sql.*;
@SuppressWarnings("unused")
class Bank {
    private String name;
    protected String pin_code;
    private String email;
    private String contact;
    private int original_national_id_card;
    private int original_pin;
    private String date_of_birth;
    private String address;
    private String national_id_no;
    private int age;
    private int gender;
    private String branch;
    private String ifsc;
    protected long account_no;
    protected double balance;
    protected double transaction_amount;
    protected double loan_amount, total_loan;
    protected double transaction_amount_fixed;
    Scanner sc = new Scanner(System.in);

    void newAccount() {
        int ch = 1;
        label: while (ch == 1) {
            System.out.println("Enter the number of the person : ");
            name = sc.nextLine();
            name = name.toLowerCase();

            System.out.println("Enter the mobile number : ");
            contact = sc.nextLine();
            if (contact.length() < 10 || contact.length() > 10) {

                System.out.println("!!! Invalid mobile number !!! ");
                break label;
            } else {
                System.out.println("This is valid number ");
            }

            try {
                System.out.println("Enter the age of person : ");
                age = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println(" Invalid age ");
                break;
            }
            if (age < 18) {
                System.out.println(" Sorry for inconvenience ! ");
                System.out.println("Minor account feature is not present in our bank ");
                break label;
            }
            try {
                System.out.println("Enter the gender (Press 1 for male, Press 2 for female, Press 3 for gay ) : ");
                gender = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid gender selection");
                break;
            }
            if (age < 1 && age > 3) {
                System.out.println("!!! Invalid gender !!! ");
                break label;
            }
            System.out.println("Do you have national id card");
            try {
                System.out.println("Press 1 for Yes or Press 2 for No ");
                original_national_id_card = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("!!! Invalid option !!! ");
                break;
            }
            if (original_national_id_card == 2) {
                System.out.println("!!! Sorry national id card is must for opening a new bank account !!! ");
                break label;
            }
            if (original_national_id_card == 1) {
                System.out.println("Enter the national id card number");
                national_id_no = sc.nextLine();
                while (national_id_no.length() < 12 || national_id_no.length() > 12) {
                    System.out.println("!!! Invalid national id card number !!! ");
                    break label;
                }
            }
            System.out.println("Do you have any pan card ");
            try {
                System.out.println("Press 1 for Yes or Press 2 for No ");
                original_pin = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("!!! Invalid option !!! ");
                break;
            }
            if (original_pin == 2) {
                System.out.println("!!! Sorry pan card is must for opening a new account !!!");
                break label;
            }
            if (original_pin == 1) {
                System.out.println("Enter 10 digits pan card number");
                pin_code = sc.nextLine();
                pin_code = pin_code.toUpperCase();
                if (pin_code.length() < 10 || pin_code.length() > 10) {
                    System.out.println("Pin card number is invalid");
                    break label;
                }
            }
            System.out.println("Enter your date of birthday");
            date_of_birth = sc.nextLine();
            if (date_of_birth.charAt(2) != '/' || date_of_birth.charAt(5) != '/') {
                System.out.println("!!! Invalid date of birth format !!! ");
                break label;
            }
            System.out.println("Enter the current address of the person : ");
            address = sc.nextLine();
            System.out.println("Enter the email number : ");
            email = sc.nextLine();
            if (email.indexOf('@') > email.indexOf('.') && email.charAt(0) == '@') {
                System.out.println("!!! Invalid email format !!! ");
                break label;
            }

            try {
                System.out.println("Enter the 8 digit account number : ");
                account_no = sc.nextLong();
            } catch (InputMismatchException e) {
                System.out.println("!!! Invalid account number !!! ");

            }

        }
    }
}
