package com.example.AWSECS.Service;

import com.example.AWSECS.Model.ECSRequest;
import com.example.AWSECS.Model.ECSResponse;

public interface ECSService {
    ECSResponse startECSChaos(ECSRequest ecsRequest);
    void listResources();
}
