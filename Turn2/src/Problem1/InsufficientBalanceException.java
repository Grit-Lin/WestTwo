package Problem1;

public class InsufficientBalanceException extends RuntimeException{
    static final long serialVersionUID = 773010520;
    private String message;

    public InsufficientBalanceException() {
        this.message = "拿不出money";
    }
}
