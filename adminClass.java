import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.Scanner;

public class adminClass {

    public static int Row, Column;

    public static void adminOperations() {
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        System.out.println("/$----------------------------------------------------$/");
        System.out.println("Details of book you wanna Edit: \n 1. Book name\n 2. Author Name\n 3. Category\n 4. Availability\n 5. Section\n 6. Quantity\n 0. Exit \n--> ");
        int j = 1;
        while (j > 0) {
            System.out.print("Enter Your Choice: ");
            j = sc.nextInt();
            switch (j) {
                case 1:
                    bookScanner();
                    editBookName();
                    break;
                case 2:
                    bookScanner();
                    editAuthorName();
                    break;
                case 3:
                    bookScanner();
                    editCategory();
                    break;
                case 4:
                    bookScanner();
                    editAvailability();
                    break;
                case 5:
                    bookScanner();
                    editSection();
                    break;
                case 6:
                    bookScanner();
                    editQuantity();
                    break;
                default:
                    break;
            }
        }
    }

    public static void bookScanner() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Row of Book: ");
        Row = sc.nextInt();
        System.out.println("Enter Column of Book: ");
        Column = sc.nextInt();
    }

    public static void showDetails() {
        String bookName;
        String authorName;
        findBook fb = new findBook();
        findAuthor fa = new findAuthor();
        bookName = fb.findBookbyAuthorname(Row, Column);
        authorName = fa.findAuthorbyBookname(Row, Column);
        System.out.println("/$----------------------------------------------------$/");
        System.out.println(" - Book Name: " + bookName);
        System.out.println(" - Author Name: " + authorName);
    }

    public static void editBookName() {
        Scanner sc = new Scanner(System.in);
        try {
            File file = new File("BookName.xlsx");
            FileInputStream fis = new FileInputStream(file);
            FileOutputStream fos;
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);
            Iterator<org.apache.poi.ss.usermodel.Row> itr = sheet.iterator();
            int c1 = 0;
            while (itr.hasNext()) {
                Row row = itr.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                if (c1 == Row - 1) {
                    int c2 = 0;
                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        if (c2 == Column - 1) {
                            String BookName = cell.getStringCellValue();
                            System.out.println("Old Book Name: " + BookName);
                            System.out.print("Enter New Name of Book: ");
                            String newName = sc.nextLine();
                            cell.setCellValue(newName);
                            fos = new FileOutputStream("BookName.xlsx");
                            wb.write(fos);
                            fos.flush();
                            fos.close();
                            showDetails();
                            System.out.println("/$----------------------------------------------------$/");
                        }
                        c2++;
                    }
                }
                c1++;
            }
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void editAuthorName() {
        Scanner sc = new Scanner(System.in);
        try {
            File file = new File("Author.xlsx");
            FileInputStream fis = new FileInputStream(file);
            FileOutputStream fos;
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);
            Iterator<org.apache.poi.ss.usermodel.Row> itr = sheet.iterator();
            int c1 = 0;
            while (itr.hasNext()) {
                Row row = itr.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                if (c1 == Row - 1) {
                    int c2 = 0;
                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        if (c2 == Column - 1) {
                            String AuthorName = cell.getStringCellValue();
                            System.out.println("Old Author Name: " + AuthorName);
                            System.out.print("Enter New Name of Author: ");
                            String newName = sc.nextLine();
                            cell.setCellValue(newName);
                            fos = new FileOutputStream("Author.xlsx");
                            wb.write(fos);
                            fos.flush();
                            fos.close();
                            showDetails();
                            System.out.println("/$----------------------------------------------------$/");
                        }
                        c2++;
                    }
                }
                c1++;
            }
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void editCategory() {
        Scanner sc = new Scanner(System.in);
        try {
            File file = new File("category.xlsx");
            FileInputStream fis = new FileInputStream(file);
            FileOutputStream fos;
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);
            Iterator<org.apache.poi.ss.usermodel.Row> itr = sheet.iterator();
            int c1 = 0;
            while (itr.hasNext()) {
                Row row = itr.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                if (c1 == Row - 1) {
                    int c2 = 0;
                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        if (c2 == Column - 1) {
                            String BookCategory = cell.getStringCellValue();
                            System.out.println("Old Book Category: " + BookCategory);
                            System.out.print("Enter category of Book: ");
                            String newName = sc.nextLine();
                            cell.setCellValue(newName);
                            fos = new FileOutputStream("category.xlsx");
                            wb.write(fos);
                            fos.flush();
                            fos.close();
                            showDetails();
                            System.out.println("/$----------------------------------------------------$/");
                        }
                        c2++;
                    }
                }
                c1++;
            }
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void editAvailability() {
        Scanner sc = new Scanner(System.in);
        try {
            File file = new File("y_n.xlsx");
            FileInputStream fis = new FileInputStream(file);
            FileOutputStream fos;
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);
            Iterator<org.apache.poi.ss.usermodel.Row> itr = sheet.iterator();
            int c1 = 0;
            while (itr.hasNext()) {
                Row row = itr.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                if (c1 == Row - 1) {
                    int c2 = 0;
                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        if (c2 == Column - 1) {
                            String BookAvailability = cell.getStringCellValue();
                            System.out.println("Old Book's Availability: " + BookAvailability);
                            System.out.print("Enter Availability of Book: ");
                            String newName = sc.nextLine();
                            cell.setCellValue(newName);
                            fos = new FileOutputStream("y_n.xlsx");
                            wb.write(fos);
                            fos.flush();
                            fos.close();
                            showDetails();
                            System.out.println("/$----------------------------------------------------$/");
                        }
                        c2++;
                    }
                }
                c1++;
            }
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void editSection() {
        Scanner sc = new Scanner(System.in);
        try {
            File file = new File("section.xlsx");
            FileInputStream fis = new FileInputStream(file);
            FileOutputStream fos;
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);
            Iterator<org.apache.poi.ss.usermodel.Row> itr = sheet.iterator();
            int c1 = 0;
            while (itr.hasNext()) {
                Row row = itr.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                if (c1 == Row - 1) {
                    int c2 = 0;
                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        if (c2 == Column - 1) {
                            String BookSection = cell.getStringCellValue();
                            System.out.println("Old section of Book: " + BookSection);
                            System.out.print("Enter New section of Book: ");
                            String newName = sc.nextLine();
                            cell.setCellValue(newName);
                            fos = new FileOutputStream("section.xlsx");
                            wb.write(fos);
                            fos.flush();
                            fos.close();
                            showDetails();
                            System.out.println("/$----------------------------------------------------$/");
                        }
                        c2++;
                    }
                }
                c1++;
            }
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void editQuantity() {
        Scanner sc = new Scanner(System.in);
        try {
            File file = new File("quantity.xlsx");
            FileInputStream fis = new FileInputStream(file);
            FileOutputStream fos;
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);
            Iterator<org.apache.poi.ss.usermodel.Row> itr = sheet.iterator();
            int c1 = 0;
            while (itr.hasNext()) {
                Row row = itr.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                if (c1 == Row - 1) {
                    int c2 = 0;
                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        if (c2 == Column - 1) {
                            int BookQuantity = (int) cell.getNumericCellValue();
                            System.out.println("Quantity of Book: " + BookQuantity);
                            System.out.print("Enter New Quantity of Book: ");
                            int newName = sc.nextInt();
                            cell.setCellValue(newName);
                            fos = new FileOutputStream("quantity.xlsx");
                            wb.write(fos);
                            fos.flush();
                            fos.close();
                            showDetails();
                            System.out.println("/$----------------------------------------------------$/");
                        }
                        c2++;
                    }
                }
                c1++;
            }
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
