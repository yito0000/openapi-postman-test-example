const fs = require('fs');
const readFileData = fs.readFileSync('../api-spec.yml', {encoding: 'UTF8'});

const Converter = require('openapi-to-postmanv2');
const Collection = require('postman-collection').Collection;

const newman = require('newman');

const { v4: uuidv4 } = require('uuid');

const updateRequestVariable = (request, key, value) => {
  const findVariable = request.url.variables.find(
      variable => variable.key === key);
  if (findVariable) {
    findVariable.update({
      key: key,
      value: value
    })
  }
}

const updateRequestQuery = (request, key, value) => {
  const findQueryParam = request.url.query.find(
      queryParam => queryParam.key === key);
  if (findQueryParam) {
    findQueryParam.update({
      key: key,
      value: value
    })
  }
}

const updateRequest = (request) => {

  // Authorization
  if (request.auth && request.auth.type === 'apikey') {
    request.auth.update({
      "key": "api_key",
      "value": `api-key-${uuidv4()}`
    }, 'apikey')
  }

  // 書籍関連のAPI
  if (request.url.getPath().includes('books')) {
    updateRequestVariable(request, 'bookId', '100000001');
    if (request.body && (request.method === 'POST' || request.method === 'PUT')) {
      const body = {
        mode: 'raw',
        raw: "{\n"
            + `    \"title\": \"test-${uuidv4()}\",\n`
            + `    \"author\": \"author-${uuidv4()}\",\n`
            + `    \"tags\": [\n`
            + `        {\n`
            + `            \"id\": \"1\",\n`
            + `            \"name\": \"タグ1\"\n`
            + `        },\n`
            + `        {\n`
            + `            \"id\": \"2\",\n`
            + `            \"name\": \"タグ2\"\n`
            + `        }\n`
            + `    ]\n`
            + `}`
      }
      request.body.update(body)
    }
  }

  // ユーザー関連のAPI
  if (request.url.getPath().includes('users')) {
    updateRequestVariable(request, 'username', 'user-XXXX');
    updateRequestQuery(request, 'username', 'user-XXXX');
    updateRequestQuery(request, 'password', 'pass-XXXX');
    if (request.body && (request.method === 'POST' || request.method === 'PUT')) {

      const body = {
        mode: 'raw',
        raw: "{\n"
            + `          \"username\": \"user-${uuidv4()}\",\n`
            + `          \"firstName\": \"firstname\",\n`
            + `          \"lastName\": \"lastname\",\n`
            + `          \"email\": \"${uuidv4()}@test.com\",\n`
            + `          \"password\": \"${uuidv4()}\"\n`
            + `}`
      };
      request.body.update(body)
    }

  }

  return request;
}

const updateItem = (item) => {
  if (item.items) {
    item.items.all().forEach(item => updateItem(item));
  } else {
    item.events.add({
      listen: 'test',
      script: {
        exec: "pm.test('response 200 test', () => {\n"
            + "    pm.response.to.have.status(200);\n"
            + "});"
      },
      type: 'text/javascript'
    })

    if (item.request.url.getPath(true) === '/books/:bookId' && item.request.method === 'GET') {
      item.events.add({
        listen: 'test',
        script: {
          exec: "pm.test('books API response body test', () => {\n"
              + "    pm.response.to.have.jsonBody(\"id\");\n"
              + "    pm.response.to.have.jsonBody(\"title\");\n"
              + "    pm.response.to.have.jsonBody(\"tags\");\n"
              + "\n"
              + "});"
        }
      })
    }
    item.request = updateRequest(item.request);

  }

  return item;
}

Converter.convert({type: 'string', data: readFileData}, {},
    (err, conversionResult) => {
      if (!conversionResult.result) {
        console.error('API定義をPostman Collectionに変換できませんでした',
            conversionResult.reason);
        return;
      }

      const convertData = conversionResult.output[0].data;

      // Postman CollectionのJSONを出力する
      const collection = new Collection(convertData);

      collection.items.all().forEach(item => updateItem(item))
      fs.writeFile('postman-collections.json', JSON.stringify(collection, null, 4), (err) => {
        if(err) console.error(err)
      });

      newman.run({
        collection: collection,
        reporters: 'cli',
        environment: require('./local.postman_environment.json')
      }, (err) => {
        if (err) console.error(err);
      });
    }
);


