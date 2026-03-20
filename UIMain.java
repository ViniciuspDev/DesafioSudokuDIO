import javax.swing.JFrame;
import custom.panel.MainPanel;
import custom.screen.MainScreen;
import custom.frame.MainFrame;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UIMain {
    public static void main(String[] args) {
        Map<String, String> gameConfig;
        if (args.length > 0) {
            gameConfig = Stream.of(args)
                    .collect(Collectors.toMap(k -> k.split(";")[0],
                            v -> v.split(";")[1]));

        } else {
            gameConfig = new HashMap<>();
            // --- LINHA 0 ---
            gameConfig.put("0,0", "5,true");
            gameConfig.put("0,1", "3,true");
            gameConfig.put("0,4", "7,true");

            // --- LINHA 1 ---
            gameConfig.put("1,0", "6,true");
            gameConfig.put("1,3", "1,true");
            gameConfig.put("1,4", "9,true");
            gameConfig.put("1,5", "5,true");

            // --- LINHA 2 ---
            gameConfig.put("2,1", "9,true");
            gameConfig.put("2,2", "8,true");
            gameConfig.put("2,7", "6,true");

            // --- LINHA 3 ---
            gameConfig.put("3,0", "8,true");
            gameConfig.put("3,4", "6,true");
            gameConfig.put("3,8", "3,true");

            // --- LINHA 4 ---
            gameConfig.put("4,0", "4,true");
            gameConfig.put("4,3", "8,true");
            gameConfig.put("4,5", "3,true");
            gameConfig.put("4,8", "1,true");

            // --- LINHA 5 ---
            gameConfig.put("5,0", "7,true");
            gameConfig.put("5,4", "2,true");
            gameConfig.put("5,8", "6,true");

            // --- LINHA 6 ---
            gameConfig.put("6,1", "6,true");
            gameConfig.put("6,6", "2,true");
            gameConfig.put("6,7", "8,true");

            // --- LINHA 7 ---
            gameConfig.put("7,3", "4,true");
            gameConfig.put("7,4", "1,true");
            gameConfig.put("7,5", "9,true");
            gameConfig.put("7,8", "5,true");

            // --- LINHA 8 ---
            gameConfig.put("8,4", "8,true");
            gameConfig.put("8,7", "7,true");
            gameConfig.put("8,8", "9,true");

            var mainScreen = new MainScreen(gameConfig);
            mainScreen.buildMainScreen();
        }

    }
}
