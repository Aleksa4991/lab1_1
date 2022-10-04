package ru.kalugina.lab1_0.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.kalugina.lab1_0.model.Request;
import ru.kalugina.lab1_0.model.Response;
import ru.kalugina.lab1_0.service.MyService;

@RestController
public class MyController {
    private final MyService myService;



    @Autowired
    public MyController(@Qualifier("ModifyUid") MyService myService){

        this.myService=myService;
    }

    @PostMapping(value = "/feedback")
    public ResponseEntity<Response> feedback(@RequestBody Request request){
        Response response = Response.builder()
                .uid(request.getUid())
                .operationUid(request.getOperationUid())
                .systemTime(request.getSystemTime())
                .code("success")
                .errorCode("")
                .errorMessage("")
                .build();
        if(response!=null) {
            System.out.println(response.getUid());
            System.out.println(response.getCode());
        }

         return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
