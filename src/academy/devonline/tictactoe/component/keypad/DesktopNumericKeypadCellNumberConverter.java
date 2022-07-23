package academy.devonline.tictactoe.component.keypad;

import academy.devonline.tictactoe.component.CellNumberConverter;
import academy.devonline.tictactoe.model.Cell;

/**
 * @author devonlain
 * @link
 */
public class DesktopNumericKeypadCellNumberConverter implements CellNumberConverter {
    char[][] mapping = {
            {'7', '8', '9'},
            {'4', '5', '6'},
            {'1', '2', '3'}};

    @Override
    public Cell toCell(char number) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (mapping[i][j] == number) return new Cell(i, j);
            }
        }
        return null;
    }

    @Override
    public char toNumber(Cell cell) {
        return mapping[cell.getRow()][cell.getCol()];
    }

}
