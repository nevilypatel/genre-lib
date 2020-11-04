import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class findBook {

    private static boolean found;

    public static void findBookByBookName() {

        bookDealer bd = new bookDealer();

        Scanner s1 = new Scanner(System.in);
        System.out.print("Enter name of Book you want to find: ");
        String bookText = s1.nextLine();
        try {
            File file = new File("BookName.xlsx");
            FileInputStream fis = new FileInputStream(file);
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);
            Iterator<Row> itr = sheet.iterator();
            int i = 0;
            while (itr.hasNext()) {
                Row row = itr.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                int j = 0;
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    findBook(cell.getStringCellValue(), bookText, i + 1, j + 1);
                    j++;
                    //System.out.print(cell.getNumericCellValue() + "\t\t\t");
                }
                i++;
            }
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("/$----------------------------------------------------$/");
        bd.bookDealerFun();

    }

    public static void findBook(String cellString, String bookText, int i, int j) {
        Pattern pattern = Pattern.compile(bookText.toLowerCase(), Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(cellString.toLowerCase());
        boolean matchFound = matcher.find();
        if (matchFound) {
            found = true;
            findAuthor fan = new findAuthor();
            String Author = fan.findAuthorbyBookname(i, j);
            boolean Available0 = findAvailableBooks(i, j);
            String Available = Available0 ? "Yes" : "No";
            String Category = findCategory(i, j);
            String Section = findSection(i, j);
            System.out.println("/$----------------------------------------------------$/");
            System.out.println("- Book: " + cellString + "\n- Written by: " + Author + "\n- Category of Book: " + Category + "\n- Section in Library: " + Section + "\n- Available: " + Available + "\n- Match found at => " + i + ":" + j);
        } else if (i == 69 && j == 14 && !found) {
            System.out.println("Book is not available in Library. ;(");
        }
        //return 0;
    }

    public static String findBookbyAuthorname(int i, int j) {
        String book = null;
        try {
            File file = new File("BookName.xlsx");
            FileInputStream fis = new FileInputStream(file);
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);
            Iterator<Row> itr = sheet.iterator();
            int c1 = 0;
            while (itr.hasNext()) {
                Row row = itr.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                if (c1 == i - 1) {
                    int c2 = 0;
                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        if (c2 == j - 1) {
                            book = cell.getStringCellValue();
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
        return book;
    }

    public static String findCategory(int i, int j) {
        String category = null;
        try {
            File file = new File("category.xlsx");
            FileInputStream fis = new FileInputStream(file);
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);
            Iterator<Row> itr = sheet.iterator();
            int c1 = 0;
            while (itr.hasNext()) {
                Row row = itr.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                if (c1 == i - 1) {
                    int c2 = 0;
                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        if (c2 == j - 1) {
                            category = cell.getStringCellValue();
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
        return category;
    }

    public static String findSection(int i, int j) {
        String section = null;
        try {
            File file = new File("section.xlsx");
            FileInputStream fis = new FileInputStream(file);
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);
            Iterator<Row> itr = sheet.iterator();
            int c1 = 0;
            while (itr.hasNext()) {
                Row row = itr.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                if (c1 == i - 1) {
                    int c2 = 0;
                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        if (c2 == j - 1) {
                            section = cell.getStringCellValue();
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
        return section;
    }

    public static boolean findAvailableBooks(int i, int j) {
        boolean availability = false;
        try {
            File file = new File("y_n.xlsx");
            FileInputStream fis = new FileInputStream(file);
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);
            Iterator<Row> itr = sheet.iterator();
            int c1 = 0;
            while (itr.hasNext()) {
                Row row = itr.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                if (c1 == i - 1) {
                    int c2 = 0;
                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        if (c2 == j - 1) {
                            availability = (cell.getStringCellValue().split(" ")[0].equals("y")) ? true : false;
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
        return availability;
    }
}
