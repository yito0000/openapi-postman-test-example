/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (4.3.1).
 * https://openapi-generator.tech Do not edit the class manually.
 */
package jp.co.yito.openapipostmantest.javaapi.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import jp.co.yito.openapipostmantest.javaapi.controller.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@javax.annotation.Generated(
    value = "org.openapitools.codegen.languages.SpringCodegen",
    date = "2020-11-25T02:40:19.045642+09:00[Asia/Tokyo]")
@Validated
@Api(value = "users", description = "the users API")
public interface UsersApi {

  /**
   * GET /users : ユーザー一覧取得API ログイン可能なユーザーリストを取得します
   *
   * @return OK (status code 200) or 無効なユーザー名です (status code 400) or ユーザーが見つかりませんでした (status code
   *     404)
   */
  @ApiOperation(
      value = "ユーザー一覧取得API",
      nickname = "usersGet",
      notes = "ログイン可能なユーザーリストを取得します",
      response = User.class,
      tags = {
        "ユーザー",
      })
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "OK", response = User.class),
        @ApiResponse(code = 400, message = "無効なユーザー名です"),
        @ApiResponse(code = 404, message = "ユーザーが見つかりませんでした")
      })
  @RequestMapping(
      value = "/users",
      produces = {"application/json"},
      method = RequestMethod.GET)
  ResponseEntity<User> usersGet();

  /**
   * GET /users/login : ログインAPI
   *
   * @param username ユーザー名 (required)
   * @param password パスワード (required)
   * @return OK (status code 200) or ユーザー名/パスワードに誤りがあります (status code 400)
   */
  @ApiOperation(
      value = "ログインAPI",
      nickname = "usersLoginGet",
      notes = "",
      tags = {
        "ユーザー",
      })
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 400, message = "ユーザー名/パスワードに誤りがあります")
      })
  @RequestMapping(value = "/users/login", method = RequestMethod.GET)
  ResponseEntity<Void> usersLoginGet(
      @NotNull
          @ApiParam(value = "ユーザー名", required = true)
          @Valid
          @RequestParam(value = "username", required = true)
          String username,
      @NotNull
          @ApiParam(value = "パスワード", required = true)
          @Valid
          @RequestParam(value = "password", required = true)
          String password);

  /**
   * GET /users/logout : ログアウトAPI
   *
   * @return OK (status code 200)
   */
  @ApiOperation(
      value = "ログアウトAPI",
      nickname = "usersLogoutGet",
      notes = "",
      tags = {
        "ユーザー",
      })
  @ApiResponses(value = {@ApiResponse(code = 200, message = "OK")})
  @RequestMapping(value = "/users/logout", method = RequestMethod.GET)
  ResponseEntity<Void> usersLogoutGet();

  /**
   * POST /users : ユーザー登録API 書籍管理するユーザーを登録します
   *
   * @param user ユーザー情報 (required)
   * @return OK (status code 200)
   */
  @ApiOperation(
      value = "ユーザー登録API",
      nickname = "usersPost",
      notes = "書籍管理するユーザーを登録します",
      tags = {
        "ユーザー",
      })
  @ApiResponses(value = {@ApiResponse(code = 200, message = "OK")})
  @RequestMapping(
      value = "/users",
      consumes = {"application/json"},
      method = RequestMethod.POST)
  ResponseEntity<Void> usersPost(
      @ApiParam(value = "ユーザー情報", required = true) @Valid @RequestBody User user);

  /**
   * DELETE /users/{username} : ユーザー削除API 指定したユーザーを削除します
   *
   * @param username ユーザー名 (required)
   * @return OK (status code 200) or 無効なユーザー名です (status code 400) or ユーザーが見つかりませんでした (status code
   *     404)
   */
  @ApiOperation(
      value = "ユーザー削除API",
      nickname = "usersUsernameDelete",
      notes = "指定したユーザーを削除します",
      tags = {
        "ユーザー",
      })
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 400, message = "無効なユーザー名です"),
        @ApiResponse(code = 404, message = "ユーザーが見つかりませんでした")
      })
  @RequestMapping(value = "/users/{username}", method = RequestMethod.DELETE)
  ResponseEntity<Void> usersUsernameDelete(
      @ApiParam(value = "ユーザー名", required = true) @PathVariable("username") String username);

  /**
   * GET /users/{username} : ユーザー詳細取得APi
   *
   * @param username ユーザー名 (required)
   * @return OK (status code 200) or 無効なユーザー名です (status code 400) or ユーザーが見つかりませんでした (status code
   *     404)
   */
  @ApiOperation(
      value = "ユーザー詳細取得APi",
      nickname = "usersUsernameGet",
      notes = "",
      response = User.class,
      tags = {
        "ユーザー",
      })
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "OK", response = User.class),
        @ApiResponse(code = 400, message = "無効なユーザー名です"),
        @ApiResponse(code = 404, message = "ユーザーが見つかりませんでした")
      })
  @RequestMapping(
      value = "/users/{username}",
      produces = {"application/json"},
      method = RequestMethod.GET)
  ResponseEntity<User> usersUsernameGet(
      @ApiParam(value = "ユーザー名", required = true) @PathVariable("username") String username);

  /**
   * PUT /users/{username} : ユーザー更新API ユーザー情報を更新します
   *
   * @param username ユーザー名 (required)
   * @param user (required)
   * @return OK (status code 200) or リクエストパラメータに誤りがあります (status code 400) or ユーザーが見つかりませんでした (status
   *     code 404)
   */
  @ApiOperation(
      value = "ユーザー更新API",
      nickname = "usersUsernamePut",
      notes = "ユーザー情報を更新します",
      tags = {
        "ユーザー",
      })
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 400, message = "リクエストパラメータに誤りがあります"),
        @ApiResponse(code = 404, message = "ユーザーが見つかりませんでした")
      })
  @RequestMapping(
      value = "/users/{username}",
      consumes = {"application/json"},
      method = RequestMethod.PUT)
  ResponseEntity<Void> usersUsernamePut(
      @ApiParam(value = "ユーザー名", required = true) @PathVariable("username") String username,
      @ApiParam(value = "", required = true) @Valid @RequestBody User user);
}
