provider "aws"{
	region="us-east-2"
}


resource "aws_lambda_function" "springBoot"{
	function_name="spring-boot-testcontainers"
	handler="com.example.demo"
	runtime ="java8"
	timeout="10"
	memory_size="1024"
	
	role= aws_IAM
	
	filename="springdb.jar"
				
			
}

resource "aws_iam_role" "testlambda"{
	name="spring-boot-testcontainers-iam"
			
   /*Vimoksh-> here we can Add IAM policies or from the AWS Console */
}

resource "aws_lambda_permission" "api-spring"{
	statment_id=;
	action="lambda:InvokeFunction"
	function_name="spring-boot-testcontainers"
	principal="apigateway.amazon.com"
}

resource "aws_api_gateway_resource" "root_user"{
	api_id=""
	parent_id=""
	
	
}

resource "aws_api_gateway_method_" "proxy.lambda"{
	api_id="";
}