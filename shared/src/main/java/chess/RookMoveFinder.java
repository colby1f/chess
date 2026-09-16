package chess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RookMoveFinder implements ChessMoveFinder {

    @Override
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition position) {
        List<ChessMove> availableMoves = new ArrayList<>();
        ChessGame.TeamColor rookColor = board.getPiece(position).getTeamColor();

        int[][] rookMoves = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};


        for (int[] move : rookMoves) {
            int rowMove = move[0];
            int colMove = move[1];

            ChessPosition newPosition = new ChessPosition(position.getRow() + rowMove, position.getColumn() + colMove);

            while (newPosition.getRow() >= 1 && newPosition.getRow() <= 8 && newPosition.getColumn() >= 1 && newPosition.getColumn() <= 8) {
                if (board.getPiece(newPosition) == null) {
                    availableMoves.add(new ChessMove(position, newPosition, null));
                } else {
                    if (board.getPiece(newPosition).getTeamColor() != rookColor) {
                        availableMoves.add(new ChessMove(position, newPosition, null));
                    }
                    break;
                }
                newPosition = new ChessPosition(newPosition.getRow() + rowMove, newPosition.getColumn() + colMove);
            }

        }

        return availableMoves;
    }
}
