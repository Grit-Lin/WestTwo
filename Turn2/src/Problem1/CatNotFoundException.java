package Problem1;

public class CatNotFoundException extends RuntimeException{
    static final long serialVersionUID = 773010520;
    private String message;

    public CatNotFoundException() {
        message = "没找到猫猫";
    }
}
