package jp.co.yito.openapipostmantest.javaapi.controller;

import java.util.Arrays;
import java.util.List;
import jp.co.yito.openapipostmantest.javaapi.controller.model.Book;
import jp.co.yito.openapipostmantest.javaapi.controller.model.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

@javax.annotation.Generated(
    value = "org.openapitools.codegen.languages.SpringCodegen",
    date = "2020-11-25T01:09:57.961351+09:00[Asia/Tokyo]")
@RestController
@RequestMapping("${openapi.bookManagement.base-path:/v1}")
@RequiredArgsConstructor
public class BooksApiController implements BooksApi {

  private final NativeWebRequest request;

  @Override
  public ResponseEntity<Void> booksBookIdDelete(Long bookId, String apiKey) {
    return new ResponseEntity<Void>(HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Book> booksBookIdGet(Long bookId) {
    Book book1 =
        new Book()
            .id(1L)
            .title("タイトル１")
            .author("著者１")
            .tags(Arrays.asList(new Tag().id(1L).name("タグ名１"), new Tag().id(2L).name("タグ名２")));
    return new ResponseEntity<Book>(book1, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<List<Book>> booksFindByTagsGet(List<String> tags) {
    Book book1 =
        new Book()
            .id(1L)
            .title("タイトル１")
            .author("著者１")
            .tags(Arrays.asList(new Tag().id(1L).name("タグ名１"), new Tag().id(2L).name("タグ名２")));
    Book book2 =
        new Book()
            .id(2L)
            .title("タイトル２")
            .author("著者２")
            .tags(Arrays.asList(new Tag().id(1L).name("タグ名１"), new Tag().id(2L).name("タグ名２")));
    Book book3 =
        new Book()
            .id(3L)
            .title("タイトル３")
            .author("著者３")
            .tags(Arrays.asList(new Tag().id(1L).name("タグ名１"), new Tag().id(2L).name("タグ名２")));
    Book book4 =
        new Book()
            .id(4L)
            .title("タイトル４")
            .author("著者４")
            .tags(Arrays.asList(new Tag().id(1L).name("タグ名１"), new Tag().id(2L).name("タグ名２")));
    Book book5 =
        new Book()
            .id(5L)
            .title("タイトル５")
            .author("著者５")
            .tags(Arrays.asList(new Tag().id(1L).name("タグ名１"), new Tag().id(2L).name("タグ名２")));
    List<Book> books = Arrays.asList(book1, book2, book3, book4, book5);
    return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<List<Book>> booksGet() {
    Book book1 =
        new Book()
            .id(1L)
            .title("タイトル１")
            .author("著者１")
            .tags(Arrays.asList(new Tag().id(1L).name("タグ名１"), new Tag().id(2L).name("タグ名２")));
    Book book2 =
        new Book()
            .id(2L)
            .title("タイトル２")
            .author("著者２")
            .tags(Arrays.asList(new Tag().id(1L).name("タグ名１"), new Tag().id(2L).name("タグ名２")));
    Book book3 =
        new Book()
            .id(3L)
            .title("タイトル３")
            .author("著者３")
            .tags(Arrays.asList(new Tag().id(1L).name("タグ名１"), new Tag().id(2L).name("タグ名２")));
    Book book4 =
        new Book()
            .id(4L)
            .title("タイトル４")
            .author("著者４")
            .tags(Arrays.asList(new Tag().id(1L).name("タグ名１"), new Tag().id(2L).name("タグ名２")));
    Book book5 =
        new Book()
            .id(5L)
            .title("タイトル５")
            .author("著者５")
            .tags(Arrays.asList(new Tag().id(1L).name("タグ名１"), new Tag().id(2L).name("タグ名２")));
    List<Book> books = Arrays.asList(book1, book2, book3, book4, book5);
    return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Void> booksPost(Book body) {
    return new ResponseEntity<Void>(HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Void> booksPut(Book body) {
    return new ResponseEntity<Void>(HttpStatus.OK);
  }
}
