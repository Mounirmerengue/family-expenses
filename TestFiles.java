import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestFiles {
    public static void main(String[] args) throws Exception {
        String[] files = {
            "backend\\src\\main\\java\\com\\familyexpenses\\repository\\ExpenseRepository.java",
            "backend\\src\\main\\java\\com\\familyexpenses\\model\\Expense.java",
            "backend\\src\\main\\java\\com\\familyexpenses\\service\\ExpenseService.java"
        };
        
        for (String filePath : files) {
            File file = new File(filePath);
            System.out.println(filePath + ": " + (file.exists() ? "EXISTS" : "MISSING") + 
                             " (" + file.length() + " bytes)");
            if (file.exists() && file.length() > 0) {
                String content = Files.readString(Paths.get(filePath));
                System.out.println("First 200 chars: " + content.substring(0, Math.min(200, content.length())) + "...");
            }
            System.out.println();
        }
    }
}
