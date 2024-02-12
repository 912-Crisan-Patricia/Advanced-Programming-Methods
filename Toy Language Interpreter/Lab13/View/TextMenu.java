package View;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import Model.MyException;

public class TextMenu {
    private Map<String, Command> commands;

    public TextMenu() {
        commands = new HashMap<>();
    }

    public void addCommand(Command c) {
        commands.put(c.getKey(), c);
    }
    public void addCommands(List<Command> list) {
        for(Command c:list)
            commands.put(c.getKey(), c);
    }

    private void printMenu() {
        for (Command com : commands.values()) {
            String line = String.format("%4s : %s", com.getKey(), com.getDescription());
            System.out.println(line);
        }
    }

    public void show() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            printMenu();
            System.out.printf("Input the option: ");
            String key = scanner.nextLine();
            Command com = commands.get(key);
            if (com == null) {
                System.out.println("Invalid Option");
                continue;
            }
            try{
                com.execute();
            }catch(MyException e){
                if(e.getMessage()=="Exit")
                    running=false;
                else
                    System.out.println(e.getMessage());
            }

        }
        scanner.close();
    }
}
