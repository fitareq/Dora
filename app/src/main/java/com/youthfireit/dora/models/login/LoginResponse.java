package com.youthfireit.dora.models.login;

public class LoginResponse {
    private String access_token;
    private String token_type;
    private String expires_at;
    private LoginUser user;



    public LoginResponse(String access_token, String token_type, String expires_at, LoginUser user) {

        this.access_token = access_token;
        this.token_type = token_type;
        this.expires_at = expires_at;
        this.user = user;
    }



    public String getAccess_token() {

        return access_token;
    }



    public String getToken_type() {

        return token_type;
    }



    public String getExpires_at() {

        return expires_at;
    }



    public LoginUser getUser() {

        return user;
    }




}
