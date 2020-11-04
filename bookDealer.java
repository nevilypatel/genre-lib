import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.Iterator;
import java.util.Scanner;

public class bookDealer {

    public static int Row;
    public static int Column;

    public static void bookDealerFun () {
        Scanner sc1 = new Scanner(System.in);
        System.out.print("Select option:\n 1. Buy book\n 2. Return Book\n 3. Exit.\n ==> ");
        int a1 = sc1.nextInt();
        switch (a1) {
            case 1:
                buyerFun();
                break;
            case 2:
                sellerFun();
                break;
            case 3:
                break;
            default:
                System.out.println("Invalid Selection...");
        }
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

    public static void bookScanner() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Row of Book: ");
        Row = sc.nextInt();
        System.out.println("Enter Column of Book: ");
        Column = sc.nextInt();
    }

    public static void buyerFun() {
        bookScanner();
        try {
            File file = new File("quantity.xlsx");
            FileInputStream fis = new FileInputStream(file);
            FileOutputStream fos;
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);
            Iterator<Row> itr = sheet.iterator();
            int c1 = 0;
            while (itr.hasNext()) {
                Row row = itr.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                if (c1 == Row - 1) {
                    int c2 = 0;
                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        if (c2 == Column - 1) {
                            int Quantity = (int) cell.getNumericCellValue();
                            if (Quantity == 0) {
                                System.out.println(" --> Book is out of stock...");
                            } else {
                                cell.setCellValue(Quantity-1);
                                fos = new FileOutputStream("quantity.xlsx");
                                wb.write(fos);
                                fos.flush();
                                fos.close();
                                System.out.println(" * Purchased Book details -> ");
                                showDetails();
                                System.out.println(" - Remained Books now: " + (Quantity-1));
                                System.out.println("/$----------------------------------------------------$/");
                            }
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

    public static void sellerFun() {
        bookScanner();
        try {
            File file = new File("quantity.xlsx");
            FileInputStream fis = new FileInputStream(file);
            FileOutputStream fos;
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);
            Iterator<Row> itr = sheet.iterator();
            int c1 = 0;
            while (itr.hasNext()) {
                Row row = itr.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                if (c1 == Row - 1) {
                    int c2 = 0;
                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        if (c2 == Column - 1) {
                            int Quantity = (int) cell.getNumericCellValue();
                            cell.setCellValue(Quantity+1);
                            fos = new FileOutputStream("quantity.xlsx");
                            wb.write(fos);
                            fos.flush();
                            fos.close();
                            System.out.println(" * Returned Book details -> ");
                            showDetails();
                            System.out.println(" - Total Books now: " + (Quantity+1));
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
