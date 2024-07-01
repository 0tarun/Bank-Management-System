import java.util.*;

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
            System.out.println("Enter the name of the person: ");
            name = sc.nextLine();
            name = name.toLowerCase();

            System.out.println("Enter the mobile number: ");
            contact = sc.nextLine();
            if (contact.length() != 10) {
                System.out.println("!!! Invalid mobile number !!! ");
                break label;
            } else {
                System.out.println("This is a valid number ");
            }

            try {
                System.out.println("Enter the age of the person: ");
                age = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid age");
                break;
            }
            if (age < 18) {
                System.out.println("Sorry for inconvenience! Minor account feature is not present in our bank.");
                break label;
            }

            try {
                System.out.println("Enter the gender (Press 1 for male, Press 2 for female, Press 3 for other): ");
                gender = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid gender selection");
                break;
            }
            if (gender < 1 || gender > 3) {
                System.out.println("!!! Invalid gender !!! ");
                break label;
            }

            System.out.println("Do you have a national ID card?");
            try {
                System.out.println("Press 1 for Yes or Press 2 for No ");
                original_national_id_card = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("!!! Invalid option !!! ");
                break;
            }
            if (original_national_id_card == 2) {
                System.out.println("!!! Sorry, a national ID card is a must for opening a new bank account !!! ");
                break label;
            } else if (original_national_id_card == 1) {
                sc.nextLine(); // consume newline character
                System.out.println("Enter the national ID card number: ");
                national_id_no = sc.nextLine().toUpperCase(); // fixing the placement
                if (national_id_no.length() != 12) {
                    System.out.println("!!! Invalid national ID card number !!! ");
                    break label;
                }
            }

            System.out.println("Do you have a PAN card?");
            try {
                System.out.println("Press 1 for Yes or Press 2 for No ");
                original_pin = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("!!! Invalid option !!! ");
                break;
            }
            if (original_pin == 2) {
                System.out.println("!!! Sorry, a PAN card is a must for opening a new account !!!");
                break label;
            }
            if (original_pin == 1) {
                sc.nextLine(); // consume newline character
                System.out.println("Enter the 10-digit PAN card number: ");
                pin_code = sc.nextLine().toUpperCase();
                if (pin_code.length() != 10) {
                    System.out.println("!!! Invalid PAN card number !!! ");
                    break label;
                }
            }

            System.out.println("Enter your date of birth (DD/MM/YYYY): ");
            date_of_birth = sc.nextLine();
            if (date_of_birth.length() != 10 || date_of_birth.charAt(2) != '/' || date_of_birth.charAt(5) != '/') {
                System.out.println("!!! Invalid date of birth format !!! ");
                break label;
            }

            System.out.println("Enter the current address of the person: ");
            address = sc.nextLine();

            System.out.println("Enter the email address: ");
            email = sc.nextLine();
            if (!email.contains("@") || !email.contains(".")) {
                System.out.println("!!! Invalid email format !!! ");
                break label;
            }

            try {
                System.out.println("Enter the 8-digit account number: ");
                account_no = sc.nextLong();
            } catch (InputMismatchException e) {
                System.out.println("!!! Invalid account number !!! ");
                break;
            }
            // Correcting the account number validation logic
            if (account_no < 10000000 || account_no > 99999999) {
                System.out.println("Account number not available ");
                System.out.println("Sorry for inconvenience");
                break label;
            }

            try {
                System.out.println("Enter the opening balance:");
                balance = sc.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Invalid opening balance");
                break;
            }
            if (balance < 500) {
                System.out.println("Sorry, you have to maintain at least a balance of 500 taka.");
                break label;
            }

            sc.nextLine(); // consume newline character
            System.out.println("Enter the branch name: ");
            branch = sc.nextLine();

            System.out.println("Enter the IFSC code of the branch: ");
            ifsc = sc.nextLine();
            if (ifsc.length() != 11 || ifsc.charAt(4) != '0') {
                System.out.println("Invalid IFSC code");
                break label;
            }

            try {
                System.out.println("Enter your PIN code: ");
                pin_code = sc.nextLine();
                int pin = Integer.parseInt(pin_code); // Convert to integer for validation
                if (pin < 100000 || pin > 999999) {
                    System.out.println("Invalid PIN code");
                    break label;
                }
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Invalid PIN code");
                break;
            }
            System.out.println();
            System.out.println("Thanks for opening a new bank account in Sonar Bank, Bolodpur:");
            System.out.println("************* HAVE A NICE DAY ***********");
            break;
        }
    }

    void account_Details() {
        System.out.println("************** SONAR BANK BOLODPUR ***********");
        System.out.println("Branch Name " + branch + "/t/tPhone " + contact + "");
        System.out.println("BFSC Code " + ifsc + " ");
        System.out.println("Account Holder " + name + " ");
        System.out.println("Account Number " + account_no + " ");
        System.err.println("Address " + address + " ");
        System.out.println("Birthday " + date_of_birth + " ");
        System.out.println("Email " + email + " ");

        if (gender == 1) {
            System.out.print("Gender Male");
        } else if (gender == 2) {
            System.out.print("Gender Female");
        } else {
            System.out.println("Gender Gey");
        }
        System.out.println("PIN " + pin_code + " ");
        System.out.println("Account Balance " + balance + " ");
        System.out.println("Fixed Deposit " + transaction_amount_fixed + " ");
        System.out.println(" ");

    }

    void deposit() {
        System.out.println("Enter the amount you want to deposit: ");
        transaction_amount = sc.nextDouble();
        balance = balance + transaction_amount;

    }

    void withdraw() {
        System.out.print("Enter the you want the withdrow :");
        transaction_amount = sc.nextDouble();

        if (balance > 0.00) {
            balance = balance - transaction_amount;
            System.err.println("*********** SUCCESSFULLY WITHDEOW DONE ************");

        } else {
            System.err.println("!!!!!!! INSUFFICIENT BALANCE !!!!!!!!");
        }
    }
}
