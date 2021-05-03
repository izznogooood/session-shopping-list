import io.javalin.Javalin;
import io.javalin.plugin.rendering.vue.VueComponent;

public class Application {
    public static void main(String[] args) {
        Javalin app = Javalin.create().start(7000);

        /* Main page with shopping carts */
        app.get("/", new VueComponent("shopping-lists"));
    }
}
