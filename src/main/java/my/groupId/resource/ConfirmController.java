package my.groupId.resource;

import io.quarkiverse.renarde.htmx.HxController;
import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import my.groupId.dto.ClientDto;

@Path("/confirm")
public class ConfirmController extends HxController {

    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance modal(ClientDto clientDto);
    }

    @GET
    public TemplateInstance modal(@BeanParam ClientDto clientDto) {
        return Templates.modal(clientDto);
    }
}
