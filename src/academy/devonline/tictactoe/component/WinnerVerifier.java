/*
 * Copyright (c) 2019. http://devonline.academy
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package academy.devonline.tictactoe.component;

import academy.devonline.tictactoe.model.Cell;
import academy.devonline.tictactoe.model.GameTable;

/**
 * @author devonlain
 * @link
 */
public class WinnerVerifier {
    public boolean isUserWin(GameTable gameTable) {
        char sign = 'X';
        return checkRows(gameTable, sign)
                || checkCols(gameTable, sign)
                || checkDiagonal(gameTable, sign)
                || checkReverseDiagonal(gameTable, sign);
    }

    public boolean isComputerWin(GameTable gameTable) {
        char sign = '0';
        return checkRows(gameTable, sign)
                || checkCols(gameTable, sign)
                || checkDiagonal(gameTable, sign)
                || checkReverseDiagonal(gameTable, sign);
    }


    private boolean checkRows(GameTable gameTable, char sign) {
        for (int i = 0; i < 3; i++) {
            int sum = 0;
            for (int j = 0; j < 3; j++) {
                // Cell checkCell = new Cell(i, j);
                sum += checkSign(gameTable, new Cell(i, j), sign);
            }
            if (sum == 3) return true;
        }
        return false;
    }

    private boolean checkCols(GameTable gameTable, char sign) {
        for (int i = 0; i < 3; i++) {
            int sum = 0;
            for (int j = 0; j < 3; j++) {
                // Cell checkCell = new Cell(j, i);
                sum += checkSign(gameTable, new Cell(j, i), sign);
            }
            if (sum == 3) return true;
        }
        return false;
    }

    private boolean checkDiagonal(GameTable gameTable, char sign) {
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            //Cell checkCell = new Cell(i, i);
            sum += checkSign(gameTable, new Cell(i, i), sign);
        }
        return (sum == 3);
    }

    private boolean checkReverseDiagonal(GameTable gameTable, char sign) {
        int sum = 0;
        for (int i = 0, j = 2; i < 3; i++, j--) {
            //Cell checkCell = new Cell(i, j);
            sum += checkSign(gameTable, new Cell(i, j), sign);
        }
        return (sum == 3);
    }

    private int checkSign(GameTable gameTable, Cell cell, char sign) {
        if (gameTable.getSign(cell) == sign) return 1;
        return 0;
    }

//by course

 /*

    public boolean isUserWin(final GameTable gameTable) {
        return isWinner(gameTable, 'X');
    }

    public boolean isComputerWin(final GameTable gameTable) {
        return isWinner(gameTable, '0');
    }

    private boolean isWinner(final GameTable gameTable, final char sign) {
        return isWinnerByRows(gameTable, sign) ||
                isWinnerByCols(gameTable, sign) ||
                isWinnerByMainDiagonal(gameTable, sign) ||
                isWinnerBySecondaryDiagonal(gameTable, sign);
    }

    private boolean isWinnerByRows(final GameTable gameTable, final char sign) {
        for (int i = 0; i < 3; i++) {
            if (gameTable.getSign(new Cell(i, 0)) == gameTable.getSign(new Cell(i, 1)) &&
                    gameTable.getSign(new Cell(i, 1)) == gameTable.getSign(new Cell(i, 2)) &&
                    gameTable.getSign(new Cell(i, 2)) == sign) {
                return true;
            }
        }
        return false;
    }

    private boolean isWinnerByCols(final GameTable gameTable, final char sign) {
        for (int i = 0; i < 3; i++) {
            if (gameTable.getSign(new Cell(0, i)) == gameTable.getSign(new Cell(1, i)) &&
                    gameTable.getSign(new Cell(1, i)) == gameTable.getSign(new Cell(2, i)) &&
                    gameTable.getSign(new Cell(2, i)) == sign) {
                return true;
            }
        }
        return false;
    }

    private boolean isWinnerByMainDiagonal(final GameTable gameTable, final char sign) {
        return gameTable.getSign(new Cell(0, 0)) == gameTable.getSign(new Cell(1, 1)) &&
                gameTable.getSign(new Cell(1, 1)) == gameTable.getSign(new Cell(2, 2)) &&
                gameTable.getSign(new Cell(2, 2)) == sign;
    }

    private boolean isWinnerBySecondaryDiagonal(final GameTable gameTable, final char sign) {
        return gameTable.getSign(new Cell(2, 0)) == gameTable.getSign(new Cell(1, 1)) &&
                gameTable.getSign(new Cell(1, 1)) == gameTable.getSign(new Cell(0, 2)) &&
                gameTable.getSign(new Cell(0, 2)) == sign;
    }*/
}
