package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import model.Board;
import model.GameStatusEnum;
import model.Space;

public class BoardService {
    private final static int BOARD_LIMIT = 9;

    private final Board board;

    public BoardService(final Map<String, String> gameConfig) {
        this.board = new Board(initBoard(gameConfig));
    }

    public List<List<Space>> getSpaces() {
        return this.board.getSpaces();
    }

    public void reset() {
        this.board.reset();
    }

    public boolean hasErrors() {
        return board.hasErrors();

    }

    public GameStatusEnum getStatus() {
        return board.getStatus();

    }

    public boolean gameIsFinished() {
        return board.gameIsFinished();

    }

    private List<List<Space>> initBoard(final Map<String, String> gameconfig) {
        List<List<Space>> spaces = new ArrayList<>();
        for (int i = 0; i < BOARD_LIMIT; i++) {
            spaces.add(new ArrayList<>());
            for (int j = 0; j < BOARD_LIMIT; j++) {
                // Busca a config, se não achar, usa um valor padrão (ex: "0,false")
                var positionConfig = gameconfig.getOrDefault("%s,%s".formatted(i, j), "0,false");

                // Agora o split nunca pegará um valor nulo
                var expected = Integer.parseInt(positionConfig.split(",")[0]);
                var fixed = Boolean.parseBoolean(positionConfig.split(",")[1]);

                var currentSpace = new Space(expected, fixed);
                spaces.get(i).add(currentSpace);
            }
        }
        return spaces;
    }

}
