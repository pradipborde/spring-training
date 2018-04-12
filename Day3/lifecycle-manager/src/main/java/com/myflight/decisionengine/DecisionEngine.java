package com.myflight.decisionengine;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myflight.deploymentengine.DeploymentEngine;
import com.myflight.deploymentrules.DeploymentRules;
import com.myflight.scalingpolicy.ScalingPolicies;

@Component
public class DecisionEngine{
	@Autowired
	ScalingPolicies scalingPolicies;
	
	@Autowired
	DeploymentEngine deploymentEngine;
	
	@Autowired
	DeploymentRules deploymentRules;
	
	public boolean execute(String serviceId, Map metrics){
		if(scalingPolicies.getPolicy(serviceId).execute(serviceId, metrics)){		
			return deploymentEngine.scaleUp(deploymentRules.getDeploymentRules(serviceId), serviceId);	
		}
		return false;
	}
}