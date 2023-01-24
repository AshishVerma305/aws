package com.example.AWSECS.Controller;




import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.codedeploy.model.ECSService;
import com.amazonaws.services.dynamodbv2.xspec.M;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2ClientBuilder;
import com.amazonaws.services.ec2.model.DescribeInstancesRequest;
import com.amazonaws.services.ec2.model.StartInstancesRequest;
import com.amazonaws.services.ec2instanceconnect.AWSEC2InstanceConnectClient;
import com.amazonaws.services.ecs.AmazonECS;

import com.amazonaws.services.ecs.AmazonECSClientBuilder;

import com.amazonaws.services.elasticloadbalancingv2.model.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@CrossOrigin
@RequestMapping("/aws")
public class controller {

    @GetMapping("/chaos")
    public void chaos() {

        try {



            AmazonEC2 amazonEC2 = AmazonEC2ClientBuilder.standard().withRegion(Regions.US_EAST_1)
                    .build();
            String instanceId="i-01617add322847a93";

            Matcher matcher=new Matcher();
            matcher.setHttpCode("404");
            CreateTargetGroupRequest createTargetGroupRequest = new CreateTargetGroupRequest();
            createTargetGroupRequest.setName("chaos-tg-8083");
            createTargetGroupRequest.setProtocol(ProtocolEnum.HTTPS);
            createTargetGroupRequest.setPort(8083);
            createTargetGroupRequest.setTargetType(TargetTypeEnum.Ip);
            createTargetGroupRequest.setVpcId("vpc-06c677ddaf72b471b");
            createTargetGroupRequest.setHealthCheckIntervalSeconds(30);
            createTargetGroupRequest.setHealthCheckTimeoutSeconds(5);
            createTargetGroupRequest.setUnhealthyThresholdCount(2);
            createTargetGroupRequest.setHealthyThresholdCount(5);
            createTargetGroupRequest.setHealthCheckPath("/");
            createTargetGroupRequest.setIpAddressType(TargetGroupIpAddressTypeEnum.Ipv4);
            createTargetGroupRequest.setMatcher(matcher);
            createTargetGroupRequest.setHealthCheckPort("8083");
            System.out.println(createTargetGroupRequest);
            System.out.println("Created");

        }catch (Exception e)
        {
            System.out.println(e);
        }

    }
}
