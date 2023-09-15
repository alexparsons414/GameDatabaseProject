package Core;

public class Game {
    private int id;
    private String console,
            rating,
            publisher;

    public Game(int id, String console, String rating, String publisher) {
        this.id = id;
        this.console = console;
        this.rating = rating;
        this.publisher = publisher;
    }

    public int getGame() {
        return id;
    }

    public void setGame(int game) {
        this.id = game;
    }

    public String getConsole() {
        return console;
    }

    public void setConsole(String console) {
        this.console = console;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    
    @Override
    public String toString()
    {
        return String.format("Game [ProductID=%s, Console=%s, Rating=%s"
                + ", Publisher=%s]",id,console,rating,publisher);
    }
}
