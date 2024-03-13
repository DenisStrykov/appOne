package ru.denis_strykov.appone.service.implementation;

import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import ru.denis_strykov.grpccommon.MeasurementType;
import com.google.protobuf.Timestamp;
import ru.denis_strykov.grpccommon.GRPCData;
import ru.denis_strykov.grpccommon.DataServerGrpc;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;
import ru.denis_strykov.appone.model.Data;
import ru.denis_strykov.appone.service.GRPCDataService;

import java.time.ZoneOffset;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GRPCDataServiceImpl implements GRPCDataService {

    @GrpcClient(value = "data-generator-blocking")
    private DataServerGrpc.DataServerBlockingStub blockingStub;

    @GrpcClient(value = "data-generator-async")
    private DataServerGrpc.DataServerStub asyncStub;

    @Override
    public void send(Data data) {
        GRPCData request = GRPCData.newBuilder()
                .setSensorId(data.getSensorId())
                .setTimestamp(
                        Timestamp.newBuilder()
                                .setSeconds(
                                        data.getTimestamp()
                                                .toEpochSecond(ZoneOffset.UTC)
                                )
                                .build()
                )
                .setMeasurementType(
                        MeasurementType.valueOf(
                                data.getMeasurementType()
                                        .name()
                        )
                )
                .setMeasurement(data.getMeasurement())
                .build();
        StreamObserver<Empty> responseObserver = new StreamObserver<>() {
            @Override
            public void onNext(Empty empty) {
            }

            @Override
            public void onError(Throwable throwable) {
            }

            @Override
            public void onCompleted() {
            }
        };
        asyncStub.addData(request, responseObserver);
    }

    @Override
    public void send(List<Data> data) {
        StreamObserver<Empty> responseObserver = new StreamObserver<>() {
            @Override
            public void onNext(Empty empty) {
            }

            @Override
            public void onError(Throwable throwable) {
            }

            @Override
            public void onCompleted() {
            }
        };
        StreamObserver<GRPCData> requestObserver = asyncStub.addStreamOfData(responseObserver);
        for (Data d: data) {
            GRPCData request = GRPCData.newBuilder()
                    .setSensorId(d.getSensorId())
                    .setTimestamp(
                            Timestamp.newBuilder()
                                    .setSeconds(
                                            d.getTimestamp()
                                                    .toEpochSecond(ZoneOffset.UTC)
                                    )
                                    .build()
                    )
                    .setMeasurementType(
                            MeasurementType.valueOf(
                                    d.getMeasurementType()
                                            .name()
                            )
                    )
                    .setMeasurement(d.getMeasurement())
                    .build();
            requestObserver.onNext(request);
        }
        requestObserver.onCompleted();
    }

}
