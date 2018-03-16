<?php
    $con = mysqli_connect("sql300.byethost7.com", "b7_20691867", "jaja88", "b7_20691867_user");
    
    $name = $_POST["name"];
    $id = $_POST["id"];
    $station = $_POST["station"];
    $username = $_POST["username"];
    $password = $_POST["password"];

    $statement = mysqli_prepare($con, "INSERT INTO user (name, id, station, username, password) VALUES (?, ?, ?, ?, ?)");
    mysqli_stmt_bind_param($statement, "sisss", $name, $id, $station, $username, $password);
    mysqli_stmt_execute($statement);
    
    $response = array();
    $response["success"] = true;  
    
    echo json_encode($response);
?>
