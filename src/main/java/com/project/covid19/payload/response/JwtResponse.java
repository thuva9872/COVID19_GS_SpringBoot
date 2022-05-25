package com.project.covid19.payload.response;


public class JwtResponse {
  private String token;
  private String type = "Bearer";
  private String nic;
  private String username;

  public JwtResponse(String accessToken, String nic, String username) {
    this.token = accessToken;
    this.nic = nic;
    this.username = username;

  }

  public String getAccessToken() {
    return token;
  }

  public void setAccessToken(String accessToken) {
    this.token = accessToken;
  }

  public String getTokenType() {
    return type;
  }

  public void setTokenType(String tokenType) {
    this.type = tokenType;
  }

  public String getNic() {
    return nic;
  }

  public void setNic(String nic) {
    this.nic = nic;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }
}
