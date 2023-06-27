package com.example.AWSECS.Model;

import lombok.Data;

@Data
public class ECSLoadBalancerRequest {
    private String loadBalancerName;
    private String certificateArn;
    private String protocol;
    private Integer port;
    private String values;
    private String field;
    private Integer priority;
    private String actionType;
    private String redirectHost;
    private String redirectPath;
    private String redirectQuery;
    private String redirectPort;
    private String redirectProtocol;
    private String redirectStatusCode;

}
