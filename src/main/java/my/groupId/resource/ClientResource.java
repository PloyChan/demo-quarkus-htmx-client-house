package my.groupId.resource;

import io.quarkiverse.renarde.htmx.HxController;
import io.quarkus.panache.common.Sort;
import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import io.smallrye.common.annotation.Blocking;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import my.groupId.mapstruct.ClientMapper;
import my.groupId.model.Client;
import my.groupId.repo.ClientRepo;
import org.jboss.resteasy.reactive.RestForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Path("/")
@ApplicationScoped
public class ClientResource extends HxController {
    @Inject
    ClientRepo repo;
    @Inject
    ClientMapper mapper;

    private static final Logger log = LoggerFactory.getLogger(ClientResource.class);

    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance modal(Client client, String crudMode);
        public static native TemplateInstance client(List<Client> clients);
        public static native TemplateInstance client$list(List<Client> clients);
        public static native TemplateInstance alert(String message);
    }

    @GET
    @Path("/client")
    @Blocking
    public TemplateInstance client() {
        if(isHxRequest()) {
            return Templates.client$list(repo.listAll());
        }
        return Templates.client(repo.listAll(Sort.by("id")));
    }
//    @POST
//    @Path("client/save")
//    @Transactional
//    public Response save(@RestForm("firstName") String firstName, @RestForm("lastName") String lastName,
//                         @RestForm("tel") String tel, @RestForm("email") String email, @RestForm("lineId") String lineId) {
//        Client client = new Client();
//        client.setFirstName(firstName);
//        client.setLastName(lastName);
//        client.setEmail(email);
//        client.setLineId(lineId);
//        client.setTel(tel);
//        repo.persist(client);
//
//        JsonObject responseJson = Json.createObjectBuilder()
//                .add("redirect", "/client")
//                .build();
//
//        return Response.ok(responseJson.toString())
//                .header("HX-Redirect", "/client")
//                .build();
//    }


    @PUT
    @Path("client/update/{id}")
    @Transactional
    public TemplateInstance update(@PathParam("id") Long id, @RestForm("firstName") String firstName, @RestForm("lastName") String lastName,
                                 @RestForm("tel") String tel, @RestForm("email") String email, @RestForm("lineId") String lineId) {
        Client clientExist = repo.findById(id);
        clientExist.setFirstName(firstName);
        clientExist.setLastName(lastName);
        clientExist.setEmail(email);
        clientExist.setLineId(lineId);
        clientExist.setTel(tel);
        repo.persist(clientExist);

        return Templates.client$list(repo.listAll(Sort.by("id")));
    }

    @GET
    @Path("client/modal/{id}")
    @Blocking
    public TemplateInstance modal(Long id) {
        Client byId = repo.findById(id);
        return Templates.modal(byId,"view");
    }
    @GET
    @Path("client/modal/edit/{id}")
    @Blocking
    public TemplateInstance modalEdit(Long id) {
        Client byId = repo.findById(id);
        return Templates.modal(byId,"edit");
    }

    @DELETE
    @Blocking
    @Path("client/{id}")
    public TemplateInstance delete(Long id) {
        repo.deleteById(id);
        return Templates.client$list(repo.listAll());
    }

}
