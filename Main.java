import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner s1 = new Scanner(System.in);
        Scanner s2 = new Scanner(System.in);

        System.out.println("*/----------------------------------------------------/*");
        System.out.print(" 1. Student\n 2. Librarian\n --> ");
        int choice = s1.nextInt();
        switch (choice){
            case 1:
                System.out.print("Do you want to find Book by Name or Author name ?\n 1. Book by Author name\n 2. Book by its name \n ==> ");
                int select = s1.nextInt();
                switch (select) {
                    case 1:
                        findAuthor fa1 = new findAuthor();
                        fa1.findBookByAuthorName();
                        break;
                    case 2:
                        findBook fb1 = new findBook();
                        fb1.findBookByBookName();
                        break;
                    default:
                        System.out.println("Incorrect Value -> plz try again.. ;(");
                        break;
                }
                break;
            case 2:
                System.out.println("Enter Username: ");
                String user = s2.nextLine();
                System.out.println("Enter Password: ");
                String pwd = s2.nextLine();
                if (user.equals("genre lib") && pwd.equals("12345")) {
                    System.out.print("You want to Edit books or want to Add new Books to Library: \n 1. Edit Book Details\n 2. Add new Books\n --> ");
                    int choice2 = s1.nextInt();
                    switch (choice2) {
                        case 1:
                            adminClass ad = new adminClass();
                            ad.adminOperations();
                            break;
                        case 2:
                            newAddon na1 = new newAddon();
                            na1.enterNewItem();
                            break;
                        default:
                            System.out.println("Plz select Appropriate operation :(");
                    }
                } else {
                    System.out.println("Incorrect username Or password...");
                }
                break;

            default:
                System.out.println("Incorrect Choice -> plz try again.. :(");
                break;
        }
        System.out.println("\n/$----------------------------------------------------$/");
        System.out.println("  Have a Great day, visit again :)");
        System.out.print("/$----------------------------------------------------$/\n");
    }
}
