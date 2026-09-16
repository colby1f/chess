package chess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RookMoveFinder implements ChessMoveFinder {

    @Override
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition position) {
        List<ChessMove> availableMoves = new ArrayList<>();
        ChessGame.TeamColor rookColor = board.getPiece(position).getTeamColor();

        for (int left = 1; left < 8; left++){
            ChessPosition newPosition = new ChessPosition(position.getRow(), position.getColumn() - left);
            if (newPosition.getColumn() < 1){
                break;
            }
            if (board.getPiece(newPosition) == null){
                availableMoves.add(new ChessMove(position, newPosition, null));
            } else if (board.getPiece(newPosition).getTeamColor() != rookColor){
                availableMoves.add(new ChessMove(position, newPosition, null));
            } else {
                break;
            }
        }

        for (int right = 1; right < 8; right++){
            ChessPosition newPosition = new ChessPosition(position.getRow(), position.getColumn() + right);
            if (newPosition.getColumn() > 8){
                break;
            }
            if (board.getPiece(newPosition) == null){
                availableMoves.add(new ChessMove(position, newPosition, null));
            } else if (board.getPiece(newPosition).getTeamColor() != rookColor){
                availableMoves.add(new ChessMove(position, newPosition, null));
            } else {
                break;
            }
        }

        for (int up = 1; up < 8; up++){
            ChessPosition newPosition = new ChessPosition(position.getRow() + up, position.getColumn());
            if (newPosition.getRow() > 8){
                break;
            }
            if (board.getPiece(newPosition) == null){
                availableMoves.add(new ChessMove(position, newPosition, null));
            } else if (board.getPiece(newPosition).getTeamColor() != rookColor){
                availableMoves.add(new ChessMove(position, newPosition, null));
            } else {
                break;
            }
        }

        for (int down = 1; down < 8; down++){
            ChessPosition newPosition = new ChessPosition(position.getRow() - down, position.getColumn());
            if (newPosition.getRow() < 1){
                break;
            }
            if (board.getPiece(newPosition) == null){
                availableMoves.add(new ChessMove(position, newPosition, null));
            } else if (board.getPiece(newPosition).getTeamColor() != rookColor){
                availableMoves.add(new ChessMove(position, newPosition, null));
            } else {
                break;
            }
        }


        return availableMoves;
    }
}
