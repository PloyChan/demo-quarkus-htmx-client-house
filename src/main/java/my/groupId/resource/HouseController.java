package my.groupId.resource;

import io.quarkiverse.renarde.htmx.HxController;
import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/")
public class HouseController extends HxController {
    @CheckedTemplate
    private static class Templates {
        public static native TemplateInstance houseSingle();
    }
    @GET
    @Path("/house")
    public TemplateInstance houseSingle() {
        return Templates.houseSingle();
    }
}
