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

import academy.devonline.tictactoe.model.GameTable;

import java.util.Random;

/**
 * @author devonlain
 * @link
 */
public class Game {
    private final DataPrinter dataPrinter;
    private final WinnerVerifier winnerVerifier;
    private final ComputerMove computerMove;
    private final UserMove userMove;
    private final CellVerifier CellVerifier;

    public Game(final DataPrinter dataPrinter,
                final ComputerMove computerMove,
                final UserMove userMove,
                final WinnerVerifier winnerVerifier,
                final CellVerifier CellVerifier) {
        this.computerMove = computerMove;
        this.dataPrinter = dataPrinter;
        this.winnerVerifier = winnerVerifier;
        this.userMove = userMove;
        this.CellVerifier = CellVerifier;
    }

    public void play() {
        System.out.println("используй клаву");
        final GameTable gameTable = new GameTable();
        dataPrinter.printMappingTable(gameTable);

        if (new Random().nextBoolean()) {
            computerMove.make(gameTable);
            dataPrinter.printGameTable(gameTable);
        }
        while (true) {
            userMove.make(gameTable);
            dataPrinter.printGameTable(gameTable);
            if (winnerVerifier.isUserWin(gameTable)) {
                System.out.println("you win");
                break;
            }
            if (CellVerifier.allCellsFilled(gameTable)) {
                System.out.println("draw ");
                break;
            }
            computerMove.make(gameTable);
            dataPrinter.printGameTable(gameTable);
            if (winnerVerifier.isComputerWin(gameTable)) {
                System.out.println("computer win");
                break;
            }
            if (CellVerifier.allCellsFilled(gameTable)) {
                System.out.println("draw ");
                break;
            }
        }
        System.out.println("game over");

    }
}
