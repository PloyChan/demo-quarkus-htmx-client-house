package my.groupId.resource;

import io.quarkiverse.renarde.htmx.HxController;
import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("/")
public class GreetingResource extends HxController {
    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance index(String firstName);
    }

    @GET
    @Path("/")
    public TemplateInstance index() {
        return Templates.index(null);
    }

}
