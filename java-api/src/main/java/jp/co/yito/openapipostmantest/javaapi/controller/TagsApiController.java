package jp.co.yito.openapipostmantest.javaapi.controller;

import java.util.List;
import jp.co.yito.openapipostmantest.javaapi.controller.model.Tag;
import lombok.RequiredArgsConstructor;
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
public class TagsApiController implements TagsApi {

  private final NativeWebRequest request;

  @Override
  public ResponseEntity<List<Tag>> tagsGet() {
    return null;
  }
}
