package cz.educanet.webik;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;


@SessionScoped
public class LogManager implements Serializable {

    User logInUser = null;

}
