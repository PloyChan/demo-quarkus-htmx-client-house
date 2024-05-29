package my.groupId;

import io.quarkiverse.renarde.htmx.HxController;
import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/")
public class GreetingResource extends HxController {
    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance index();

        public static native TemplateInstance hello();

        public static native TemplateInstance about();

    }

    @GET
    public TemplateInstance hello() {
        return Templates.hello();
    }

    @GET
    @Path("/")
    public TemplateInstance index() {
        return Templates.index();
    }

    @GET
    public TemplateInstance about() {
        return Templates.about();
    }
}
