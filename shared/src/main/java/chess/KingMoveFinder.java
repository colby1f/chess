package chess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class KingMoveFinder implements ChessMoveFinder {
    @Override
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition position) {
        List<ChessMove> availableMoves = new ArrayList<>();
        ChessGame.TeamColor kingColor = board.getPiece(position).getTeamColor();

        int[][] kingMoves = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}, {1, -1}, {1, 1}, {-1, 1}, {-1, -1}};

        for (int[] move : kingMoves) {
            int rowMove = move[0];
            int colMove = move[1];

            ChessPosition newPosition = new ChessPosition(position.getRow() + rowMove, position.getColumn() + colMove);

            if (board.getPiece(newPosition) == null) {
                availableMoves.add(new ChessMove(position, newPosition, null));
            } else {
                if (board.getPiece(newPosition).getTeamColor() != kingColor) {
                    availableMoves.add(new ChessMove(position, newPosition, null));
                }
            }
        }

        return availableMoves;
    }
}
