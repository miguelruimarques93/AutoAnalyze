package pt.up.fe.comp.fsa;

public class NoSuchEdgeException extends FSAException {
    private static final long serialVersionUID = 1340753997868025507L;

    public NoSuchEdgeException(String message) {
        super(message);
    }
}
