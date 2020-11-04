import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class newAddon {

    public static void enterNewItem() {
        System.out.println("Enter Details of new Book You want to add: ");
        addBookName();
        addAuthorName();
        addCategory();
        addAvailability();
        addSection();
        addQuantity();
        System.out.print("\n  Book Details Added Successfully.. :)");
    }

    public static void addBookName() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter New Book's Name: ");
        String bookName = sc.nextLine();
        try {
            File file = new File("BookName.xlsx");
            FileInputStream fis = new FileInputStream(file);
            FileOutputStream fos;
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);
            int totalRows = sheet.getLastRowNum();
            Row row1 = sheet.getRow(totalRows);
            int lastCellNum = row1.getLastCellNum();
            if (lastCellNum == 15 ) {
                Row row2 = sheet.createRow(totalRows+1);
                Cell cell2 = row2.createCell(0);
                cell2.setCellValue(bookName);
            } else {
                Cell cell1 = row1.createCell(lastCellNum);
                cell1.setCellValue(lastCellNum);
                cell1.setCellValue(bookName);
            }
            fos = new FileOutputStream("BookName.xlsx");
            wb.write(fos);
            fos.flush();
            fos.close();
            System.out.print("/$----------------------------------------------------$/");
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addAuthorName() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter New Book's Author Name: ");
        String authorName = sc.nextLine();
        try {
            File file = new File("Author.xlsx");
            FileInputStream fis = new FileInputStream(file);
            FileOutputStream fos;
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);
            int totalRows = sheet.getLastRowNum();
            Row row1 = sheet.getRow(totalRows);
            int lastCellNum = row1.getLastCellNum();
            if (lastCellNum == 15 ) {
                Row row2 = sheet.createRow(totalRows+1);
                Cell cell2 = row2.createCell(0);
                cell2.setCellValue(authorName);
            } else {
                Cell cell1 = row1.createCell(lastCellNum);
                cell1.setCellValue(lastCellNum);
                cell1.setCellValue(authorName);
            }
            fos = new FileOutputStream("Author.xlsx");
            wb.write(fos);
            fos.flush();
            fos.close();
            System.out.print("/$----------------------------------------------------$/");
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addCategory() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter New Book's Category: ");
        String categoryName = sc.nextLine();
        try {
            File file = new File("category.xlsx");
            FileInputStream fis = new FileInputStream(file);
            FileOutputStream fos;
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);
            int totalRows = sheet.getLastRowNum();
            Row row1 = sheet.getRow(totalRows);
            int lastCellNum = row1.getLastCellNum();
            if (lastCellNum == 15 ) {
                Row row2 = sheet.createRow(totalRows+1);
                Cell cell2 = row2.createCell(0);
                cell2.setCellValue(categoryName);
            } else {
                Cell cell1 = row1.createCell(lastCellNum);
                cell1.setCellValue(lastCellNum);
                cell1.setCellValue(categoryName);
            }
            fos = new FileOutputStream("category.xlsx");
            wb.write(fos);
            fos.flush();
            fos.close();
            System.out.print("/$----------------------------------------------------$/");
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addAvailability() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter New Book's Availability: ");
        String availabilityName = sc.nextLine();
        try {
            File file = new File("y_n.xlsx");
            FileInputStream fis = new FileInputStream(file);
            FileOutputStream fos;
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);
            int totalRows = sheet.getLastRowNum();
            Row row1 = sheet.getRow(totalRows);
            int lastCellNum = row1.getLastCellNum();
            if (lastCellNum == 15 ) {
                Row row2 = sheet.createRow(totalRows+1);
                Cell cell2 = row2.createCell(0);
                cell2.setCellValue(availabilityName);
            } else {
                Cell cell1 = row1.createCell(lastCellNum);
                cell1.setCellValue(lastCellNum);
                cell1.setCellValue(availabilityName);
            }
            fos = new FileOutputStream("y_n.xlsx");
            wb.write(fos);
            fos.flush();
            fos.close();
            System.out.print("/$----------------------------------------------------$/");
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addSection() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter New Book's Section: ");
        String sectionName = sc.nextLine();
        try {
            File file = new File("section.xlsx");
            FileInputStream fis = new FileInputStream(file);
            FileOutputStream fos;
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);
            int totalRows = sheet.getLastRowNum();
            Row row1 = sheet.getRow(totalRows);
            int lastCellNum = row1.getLastCellNum();
            if (lastCellNum == 15 ) {
                Row row2 = sheet.createRow(totalRows+1);
                Cell cell2 = row2.createCell(0);
                cell2.setCellValue(sectionName);
            } else {
                Cell cell1 = row1.createCell(lastCellNum);
                cell1.setCellValue(lastCellNum);
                cell1.setCellValue(sectionName);
            }
            fos = new FileOutputStream("section.xlsx");
            wb.write(fos);
            fos.flush();
            fos.close();
            System.out.print("/$----------------------------------------------------$/");
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addQuantity() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter New Book's Quantity: ");
        int bookQuantity = sc.nextInt();
        try {
            File file = new File("quantity.xlsx");
            FileInputStream fis = new FileInputStream(file);
            FileOutputStream fos;
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);
            int totalRows = sheet.getLastRowNum();
            Row row1 = sheet.getRow(totalRows);
            int lastCellNum = row1.getLastCellNum();
            if (lastCellNum == 15 ) {
                Row row2 = sheet.createRow(totalRows+1);
                Cell cell2 = row2.createCell(0);
                cell2.setCellValue(bookQuantity);
            } else {
                Cell cell1 = row1.createCell(lastCellNum);
                cell1.setCellValue(lastCellNum);
                cell1.setCellValue(bookQuantity);
            }
            fos = new FileOutputStream("quantity.xlsx");
            wb.write(fos);
            fos.flush();
            fos.close();
            System.out.print("/$----------------------------------------------------$/");
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
