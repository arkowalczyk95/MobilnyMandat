<?php
    $con = mysqli_connect("sql300.byethost7.com", "b7_20691867", "jaja88", "b7_20691867_user");
    
    $username = $_POST["username"];
    $password = $_POST["password"];
    
    $statement = mysqli_prepare($con, "SELECT * FROM user WHERE username = ? AND password = ?");
    mysqli_stmt_bind_param($statement, "ss", $username, $password);
    mysqli_stmt_execute($statement);
    
    mysqli_stmt_store_result($statement);
    mysqli_stmt_bind_result($statement, $name, $id, $station, $username, $password);
    
    $response = array();
    $response["success"] = false;  
    
    while(mysqli_stmt_fetch($statement)){
        $response["success"] = true;  
        $response["name"] = $name;
        $response["id"] = $id;
        $response["station"] = $station;
        $response["username"] = $username;
        $response["password"] = $password;

    }
    
    echo json_encode($response);
?>
