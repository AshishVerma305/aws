package com.example.AWSECS.Controller;




import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.xspec.M;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2ClientBuilder;
import com.amazonaws.services.ec2.model.DescribeInstancesRequest;
import com.amazonaws.services.ec2.model.StartInstancesRequest;
import com.amazonaws.services.ec2.model.TargetGroup;
import com.amazonaws.services.ec2instanceconnect.AWSEC2InstanceConnectClient;
import com.amazonaws.services.ecs.AmazonECS;

import com.amazonaws.services.ecs.AmazonECSClientBuilder;

import com.amazonaws.services.elasticloadbalancingv2.AmazonElasticLoadBalancing;
import com.amazonaws.services.elasticloadbalancingv2.AmazonElasticLoadBalancingClientBuilder;
import com.amazonaws.services.elasticloadbalancingv2.model.*;
import com.amazonaws.services.opsworks.model.ElasticLoadBalancer;
import com.example.AWSECS.Model.ECSRequest;
import com.example.AWSECS.Model.ECSResponse;
import com.example.AWSECS.Service.ECSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;


@RestController
@CrossOrigin
@RequestMapping("/aws")
public class controller {

    @Autowired
    @Qualifier("ECSService")
    ECSService ecsService;

    @RequestMapping(value = "/chaos", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public ECSResponse chaos(@RequestBody ECSRequest ecsRequest) {
        return ecsService.startECSChaos(ecsRequest);
    }

    @RequestMapping(value = "/listResources", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public void listResources() {
         ecsService.listResources();
    }
}
