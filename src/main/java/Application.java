import io.javalin.Javalin;
import io.javalin.plugin.rendering.vue.JavalinVue;
import io.javalin.plugin.rendering.vue.VueComponent;

import models.Business;
import org.eclipse.jetty.server.session.DefaultSessionCache;
import org.eclipse.jetty.server.session.FileSessionDataStore;
import org.eclipse.jetty.server.session.SessionCache;
import org.eclipse.jetty.server.session.SessionHandler;

import java.io.File;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        /* Main server app */
        Javalin app = Javalin.create(config -> {
            config.sessionHandler(Application::fileSessionHandler);
        }).start(7000);

        /* only load the required dependencies for the requested Vue component. */
        JavalinVue.optimizeDependencies = true;

        // mock repo
        HashMap<String, List<Business>> sessions = new HashMap<>();

        /* Passing a state / store object to the Vue instance
        *  Run once every request */
        JavalinVue.stateFunction = ctx -> {
            // Creating mocking data
            if (sessions.containsKey(ctx.req.getSession().getId())) {
                List<Business> businesses = sessions.get(ctx.req.getSession().getId());
            } else {
                sessions.put(ctx.req.getSession().getId(), Arrays.asList(
                        new Business(ctx.req.getSession().getId(), "Rema 1000"),
                        new Business(ctx.req.getSession().getId(), "Coop Obs")
                ));
            }


            return Map.of(
                    "sessionId", ctx.req.getSession().getId(),
                    "businesses", sessions.get(ctx.req.getSession().getId())
            );
        };

        /* Main page with shopping carts */
        app.get("/", new VueComponent("shopping-lists"));
    }

    static SessionHandler fileSessionHandler() {
        SessionHandler sessionHandler = new SessionHandler();
        SessionCache sessionCache = new DefaultSessionCache(sessionHandler);
        sessionCache.setSessionDataStore(fileSessionDataStore());
        sessionHandler.setSessionCache(sessionCache);
        sessionHandler.setHttpOnly(true);

        /* By default Jetty uses lenient cookie security settings. In order to harden
           and to mitigate cross-site request forgery (CSRF) attacks, it is useful to
           set the SameSite=strict cookie flag. This is particularly recommended if
           the JSESSIONID cookie is also used directly or indirectly for
           authentication purposes. */

        sessionHandler.getSessionCookieConfig().setHttpOnly(true);
        sessionHandler.getSessionCookieConfig().setSecure(true);
        sessionHandler.getSessionCookieConfig().setComment("__SAME_SITE_STRICT__");

        return sessionHandler;
    }

    static FileSessionDataStore fileSessionDataStore() throws SecurityException {
        FileSessionDataStore fileSessionDataStore = new FileSessionDataStore();
        File baseDir = new File(System.getProperty("java.io.tmpdir"));
        File storeDir = new File(baseDir, "javalin-session-store");
        storeDir.mkdir();
        fileSessionDataStore.setStoreDir(storeDir);
        return fileSessionDataStore;
    }
}
