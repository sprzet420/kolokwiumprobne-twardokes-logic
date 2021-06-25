public class IncorrentValueException extends Exception{
    private int weight;

    public IncorrentValueException(String message, int weight){
        super(message);
        this.weight=weight;
    }
}
