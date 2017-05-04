<?php
require_once '../includes/DbOperation.php';
$response = array();
if($_SERVER['REQUEST_METHOD']=='POST'){
if(isset($_POST['username']) and isset($_POST['email']) and isset($_POST['password'])){
	$db= new DbOperation();
	$result=$db->createUser( $_POST['username'],
	                         $_POST['password'],
	                         $_POST['email']);
		if($result==1){					 
							 
		$response['error']=false;
		$response['message']="User registered successfully...Please login from menu->login to continue...";
	}
	elseif($result==2)
	{
		$response['error']=true;
		$response['message']="Failed to register";
	}
	elseif($result==0)
	{
		$response['error']=true;
		$response['message']="It seems you are already registered ...Please use a different username and email";
    }
}

else
{
	$response['error']=true;
	$response['message']="Required fields are missing";
}
}
else{
	$response['error']=true;
	$response['message']="Invalid Request";
}
echo json_encode($response);



