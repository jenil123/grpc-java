package com.example.grpc_in_java.services;

import com.example.grpc_in_java.GreetingMessage;
import com.example.grpc_in_java.GreetingResponse;
import com.example.grpc_in_java.GreetingServiceGrpc;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;

@Slf4j
@GrpcService
public class GreetingService extends GreetingServiceGrpc.GreetingServiceImplBase {
    @Override
    public void greeting(GreetingMessage message, StreamObserver<GreetingResponse> responseObserver) {
        message.getMessage();
        log.info("Recieved message{}", message.getMessage());

        GreetingResponse response = GreetingResponse.newBuilder().setMessage("Hello from server").build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
