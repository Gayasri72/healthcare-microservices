package com.example.billing_service;

import com.example.billing.BillingRequest;
import com.example.billing.BillingResponse;
import com.example.billing.BillingServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import java.util.UUID;

@GrpcService
public class BillingServiceGrpcImpl extends BillingServiceGrpc.BillingServiceImplBase {

    @Override
    public void createBillingAccount(BillingRequest request,
            StreamObserver<BillingResponse> responseObserver) {

        String accountId = "ACC-" + UUID.randomUUID().toString().substring(0, 8);

        BillingResponse response = BillingResponse.newBuilder()
                .setAccountId(accountId)
                .setStatus("ACTIVE")
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}