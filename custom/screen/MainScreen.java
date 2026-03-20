package custom.screen;

import java.awt.Dimension;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import custom.button.CheckGameStatusButton;
import custom.button.FinishGameButton;
import custom.button.ResetButton;
import custom.frame.MainFrame;
import custom.panel.MainPanel;
import service.BoardService;

public class MainScreen {

    private final static Dimension dimension = new Dimension(600, 600);

    private final BoardService boardService;

    private JButton finishGameButton;
    private JButton checkGameStatusButton;
    private JButton resetButton;

    public MainScreen(final Map<String, String> gameConfig) {
        this.boardService = new BoardService(gameConfig);

    }

    public void buildMainScreen() {
        JPanel mainPanel = new MainPanel(dimension);
        JFrame mainFrame = new MainFrame(dimension, mainPanel);
        addResetButton(mainPanel);
        addCheckGameStatusButton(mainPanel);
        addFinishGameButton(mainPanel);
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    private void addFinishGameButton(final JPanel maiPanel) {
        finishGameButton = new FinishGameButton(e -> {
            if (boardService.gameIsFinished()) {
                JOptionPane.showMessageDialog(null, "Parabéns você concluiu o jogo!");
                resetButton.setEnabled(false);
                checkGameStatusButton.setEnabled(false);
                finishGameButton.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(null, "Seu jogo tem alguma inconsistência, ajuste e tente novamente.");

            }

        });
        maiPanel.add(finishGameButton);

    }

    private void addCheckGameStatusButton(final JPanel maiPanel) {
        checkGameStatusButton = new CheckGameStatusButton(e -> {
            var hasErrors = boardService.hasErrors();
            var gameStatus = boardService.getStatus();
            var message = switch (gameStatus) {
                case NON_STARTED -> "O jogo não foi iniciado";
                case INCOMPLETE -> "O jogo está incompleto";
                case COMPLETE -> "O jogo está completo, Parabéns!";
            };
            message += hasErrors ? " e contém erros" : " e não contém erros";
        });
        maiPanel.add(checkGameStatusButton);

    }

    private void addResetButton(final JPanel maiPanel) {
        resetButton = new ResetButton(e -> {
            var dialogResult = JOptionPane.showConfirmDialog(null, "Deseja realmente reiniciar o jogo?",
                    "Limpar o jogo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (dialogResult == 0) {
                boardService.reset();

            }
        });
        maiPanel.add(resetButton);

    }

}
