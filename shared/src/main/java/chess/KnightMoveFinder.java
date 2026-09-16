package chess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class KnightMoveFinder implements ChessMoveFinder {
    @Override
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition position) {
        List<ChessMove> availableMoves = new ArrayList<>();
        ChessGame.TeamColor knightColor = board.getPiece(position).getTeamColor();

        int[][] knightMoves = {{2, -1}, {2, 1}, {-2, -1}, {-2, 1}, {1, -2}, {1, 2}, {-1, -2}, {-1, 2}};

        for (int[] move : knightMoves) {
            int rowMove = move[0];
            int colMove = move[1];

            ChessPosition newPosition = new ChessPosition(position.getRow() + rowMove, position.getColumn() + colMove);

            if (newPosition.getRow() >= 1 && newPosition.getRow() <= 8 && newPosition.getColumn() >= 1 && newPosition.getColumn() <= 8) {
                if (board.getPiece(newPosition) == null) {
                    availableMoves.add(new ChessMove(position, newPosition, null));
                } else {
                    if (board.getPiece(newPosition).getTeamColor() != knightColor) {
                        availableMoves.add(new ChessMove(position, newPosition, null));
                    }
                }
            }
        }

        return availableMoves;
    }
}
