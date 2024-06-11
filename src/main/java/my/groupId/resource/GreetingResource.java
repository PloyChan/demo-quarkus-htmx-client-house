package my.groupId.resource;

import io.quarkiverse.renarde.htmx.HxController;
import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import my.groupId.dto.ClientDto;
import my.groupId.mapstruct.ClientMapper;
import my.groupId.repo.ClientRepo;

@Path("/")
public class GreetingResource extends HxController {
    @Inject
    ClientRepo repo;
    @Inject
    ClientMapper mapper;
    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance index(ClientDto client);
//        public static native TemplateInstance index$form(String firstName);
        public static native TemplateInstance index$form(ClientDto client);
    }

    @GET
    @Path("/")
    public TemplateInstance index() {
        return Templates.index(null);
    }

    @POST
    @Path("/save")
    public TemplateInstance save(@Valid @BeanParam ClientDto clientDto) {
        if (validation.hasErrors()) {
            return Templates.index$form(clientDto);
        } else {
            repo.persist(mapper.toEntity(clientDto));
            return ClientResource.Templates.alert("บันทึกข้อมูลเสร็จสิ้น");
        }
    }

}
