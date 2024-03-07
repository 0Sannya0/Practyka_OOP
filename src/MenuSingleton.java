
import java.util.ArrayList;

public class MenuSingleton {
    private static MenuSingleton instance;
    private Menu menu;

    private MenuSingleton() {
        menu = new Menu(new ArrayList<>());
    }

    public static MenuSingleton getInstance() {
        if (instance == null) {
            instance = new MenuSingleton();
        }
        return instance;
    }

    public Menu getMenu() {
        return menu;
    }
}
