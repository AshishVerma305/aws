package com.example.AWSECS.Model;

import lombok.Data;

@Data
public class ECSRequest {
    private ECSLoadBalancerRequest ecsLoadBalancerRequest;
    private ECSTargetGroupRequest ecsTargetGroupRequest;
    private String actionName;
    private EC2Request ec2Request;
}
