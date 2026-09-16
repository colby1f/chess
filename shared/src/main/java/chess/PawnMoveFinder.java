package chess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PawnMoveFinder implements ChessMoveFinder {
    @Override
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition position) {
        List<ChessMove> availableMoves = new ArrayList<>();
        ChessGame.TeamColor pawnColor = board.getPiece(position).getTeamColor();

        int[] colMove = {-1, 1};
        int rowMove;
        int promotion;
        int doubleMove;

        if (pawnColor == ChessGame.TeamColor.WHITE) {
            rowMove = 1;
            promotion = 8;
            doubleMove = 2;
        } else {
            rowMove = -1;
            promotion = 1;
            doubleMove = 7;
        }


        if (board.getPiece(new ChessPosition(position.getRow() + rowMove, position.getColumn())) == null) {
            ChessPosition newPosition = new ChessPosition(position.getRow() + rowMove, position.getColumn());
            if (newPosition.getRow() == promotion) {
                availableMoves.add(new ChessMove(position, newPosition, ChessPiece.PieceType.QUEEN));
                availableMoves.add(new ChessMove(position, newPosition, ChessPiece.PieceType.ROOK));
                availableMoves.add(new ChessMove(position, newPosition, ChessPiece.PieceType.BISHOP));
                availableMoves.add(new ChessMove(position, newPosition, ChessPiece.PieceType.KNIGHT));
            } else {
                availableMoves.add(new ChessMove(position, newPosition, null));
            }
        }
        for (int move : colMove) {
            if (board.getPiece(new ChessPosition(position.getRow() + rowMove, position.getColumn() - move)) != null) {
                ChessPosition newPosition = new ChessPosition(position.getRow() + rowMove, position.getColumn() - move);
                if (board.getPiece(newPosition).getTeamColor() != pawnColor) {
                    if (newPosition.getRow() == promotion) {
                        availableMoves.add(new ChessMove(position, newPosition, ChessPiece.PieceType.QUEEN));
                        availableMoves.add(new ChessMove(position, newPosition, ChessPiece.PieceType.ROOK));
                        availableMoves.add(new ChessMove(position, newPosition, ChessPiece.PieceType.BISHOP));
                        availableMoves.add(new ChessMove(position, newPosition, ChessPiece.PieceType.KNIGHT));
                    } else {
                        availableMoves.add(new ChessMove(position, newPosition, null));
                    }
                }
            }
        }
        if (position.getRow() == doubleMove) {
            ChessPosition newPosition1 = new ChessPosition(position.getRow() + rowMove, position.getColumn());
            ChessPosition newPosition2 = new ChessPosition(newPosition1.getRow() + rowMove, newPosition1.getColumn());

            if (board.getPiece(newPosition1) == null && board.getPiece(newPosition2) == null){
                availableMoves.add(new ChessMove(position, newPosition2, null));
            }
        }

        return availableMoves;
    }
}
