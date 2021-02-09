package cz.educanet.webik;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("users")
@Produces(MediaType.APPLICATION_JSON)

public class UsersResource {

    @Inject
    private UserManager userManager;


    @Inject
    private LogManager logManager;

    @Path ("/register")
    @POST
    public Response register(

            @FormParam("firstName") String firstName,
            @FormParam("lastName") String lastName,
            @FormParam("username") String username,
            @FormParam("password") String password,
            @FormParam("email") String email

    ) {
        User tempUser = new User(firstName, lastName, username, password, email);

        if (userManager.existByUsername(username)) {
            return Response.status(Response.Status.BAD_REQUEST).entity("tento uživatel už existuje").build();
        } else {
            userManager.save(tempUser);
            return Response.ok("uživatel se úšpěšně zaregistroval").build();
        }
    }
    @Path ("/login")
    @POST
    public Response login(
            @FormParam("username") String username,
            @FormParam("password") String password

    ) {
        User temp = userManager.getUserByUsernameAndPassword(username, password);

        if (temp == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Blbý username nebo password").build();
        } else {
            logManager.logInUser = temp;
            return Response.ok("uživatel se úšpěšně přihlásil").build();
        }
    }
    @Path ("/logout")
    @DELETE
    public Response logout() {
        logManager.logInUser = null;
        return Response.ok("uživatel se odhlásil").build();
    }


    @Path ("/user")
    @GET 
    public Response getCurrentUser() {
        if (logManager.logInUser == null) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        } else {
            return Response.ok(logManager.logInUser.getUsername()).build();
        }

    }

    @GET
    public Response getAllUsers(){
        return Response.ok(userManager.getAllUsers()).build();
    }

}
