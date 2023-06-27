package com.example.AWSECS.Model;

import lombok.Data;

@Data
public class ECSTargetGroupRequest {
    private String targetGroupName;
    private String vpcId;
    private String statusCode;
    private Integer port;
    private String protocol;
    private String targetType;
    private String ipAddressType;
    private String targetDescriptionId;
}
