package cz.educanet.webik;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;


@SessionScoped
public class LogManager implements Serializable {

    ArrayList<UserToken> validTokens = new ArrayList<UserToken>();

    public boolean validate(UserToken token){
        return validTokens.stream().anyMatch(token1 -> token1.body.equals(token.body));
    }
    public boolean validate(String token){
        return validTokens.stream().anyMatch(token1 -> token1.body.equals(token));
    }

    public UserToken createToken(){
        UserToken temp = new UserToken();
        validTokens.add(temp);
        return temp;
    }


}
