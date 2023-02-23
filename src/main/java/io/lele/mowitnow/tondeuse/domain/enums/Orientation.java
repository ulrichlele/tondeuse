package io.lele.mowitnow.tondeuse.domain.enums;
/**
 * @author Ulrich LELE
 */
public enum Orientation {
    N, E, S, W;

    public Orientation turn(Direction direction){
        Orientation nextOrientation;
        switch (direction){
            case L:
                nextOrientation =turnLeft();
                break;
            case R:
                nextOrientation =turnRight();
                break;
            default:
                throw new RuntimeException("Orientation.turn : Direction not implemented :"+direction);
        }
        return nextOrientation;
    }

    private Orientation turnLeft(){
        int next = this.ordinal() != Orientation.N.ordinal() ? this.ordinal() -1 :  Orientation.W.ordinal();
        return Orientation.values()[next];
    }

    private Orientation turnRight(){
        int next = this.ordinal() != Orientation.W.ordinal() ? this.ordinal() +1 :  Orientation.N.ordinal();
        return Orientation.values()[next];
    }
}
