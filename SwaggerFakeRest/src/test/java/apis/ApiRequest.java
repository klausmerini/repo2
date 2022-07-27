package apis;

import utils.APIUtils;

import static io.restassured.RestAssured.given;

public class ApiRequest extends APIUtils implements ApiVerbos {

    @Override
    public void GET() {
        // TODO Auto-generated method stub
        System.out.println("ApiRequest.GET()");
        response = given().
                relaxedHTTPSValidation().
                params(params).
                headers(headers).
                get(uri);

        super.log("GET");
    }

    @Override
    public void POST() {
        // TODO Auto-generated method stub
        System.out.println("POST");
        response = given().
                relaxedHTTPSValidation().
                params(params).
                headers(headers).
                body(body.toString()).
                post(uri);


        super.log("POST");

    }

    @Override
    public void PUT()
    {        // TODO Auto-generated method stub
        response = given().
                relaxedHTTPSValidation().
                params(params).
                headers(headers).
                body(body.toString()).
                put(uri);
        System.out.println("PUT");
        super.log("PUT");

    }

    @Override
    public void PATCH() {
        // TODO Auto-generated method stub
        response = given().
                relaxedHTTPSValidation().
                params(params).
                headers(headers).
                body(body.toString()).
                patch(uri);

        super.log("PATCH");

    }

    @Override
    public void DELETE() {
        // TODO Auto-generated method stub
        response = given().
                relaxedHTTPSValidation().
                params(params).
                headers(headers).
                delete(uri);

        super.log("DELETE");

    }

}
