import io.javalin.Javalin;
import io.javalin.plugin.rendering.vue.JavalinVue;
import io.javalin.plugin.rendering.vue.VueComponent;

import java.util.HashMap;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        /* Main server app */
        Javalin app = Javalin.create().start(7000);

        /* only load the required dependencies for your route component. */
        JavalinVue.optimizeDependencies = true;




        JavalinVue.stateFunction = ctx -> Map.of("user", "Anders");




        /* Main page with shopping carts */
        app.get("/", new VueComponent("shopping-lists"));
    }
}
