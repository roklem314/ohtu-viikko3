
package ohtu.io;

import ohtu.App;
import java.util.Scanner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class ConsoleIO implements IO {
    private Scanner scanner = new Scanner(System.in);
    
    @Override
    public void print(String toPrint) {
        System.out.println(toPrint);
    }

    @Override
    public int readInt(String prompt) {
        System.out.println(prompt);
        return Integer.parseInt(scanner.nextLine());
    }

    @Override
    public String readLine(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }
    
}
