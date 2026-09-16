package chess;

import java.util.Collection;

public interface ChessMoveFinder {
    Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition position);
}
