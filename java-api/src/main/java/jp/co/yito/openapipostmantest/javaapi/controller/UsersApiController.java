package jp.co.yito.openapipostmantest.javaapi.controller;

import jp.co.yito.openapipostmantest.javaapi.controller.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

@javax.annotation.Generated(
    value = "org.openapitools.codegen.languages.SpringCodegen",
    date = "2020-11-25T01:09:57.961351+09:00[Asia/Tokyo]")
@Controller
@RequestMapping("${openapi.bookManagement.base-path:/v1}")
@RequiredArgsConstructor
public class UsersApiController implements UsersApi {

  private final NativeWebRequest request;

  @Override
  public ResponseEntity<User> usersGet() {
    return null;
  }

  @Override
  public ResponseEntity<Void> usersLoginGet(String username, String password) {
    return new ResponseEntity<Void>(HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Void> usersLogoutGet() {
    return new ResponseEntity<Void>(HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Void> usersPost(User body) {
    return new ResponseEntity<Void>(HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Void> usersUsernameDelete(String username) {
    return new ResponseEntity<Void>(HttpStatus.OK);
  }

  @Override
  public ResponseEntity<User> usersUsernameGet(String username) {
    return null;
  }

  @Override
  public ResponseEntity<Void> usersUsernamePut(String username, User body) {
    return new ResponseEntity<Void>(HttpStatus.OK);
  }
}
