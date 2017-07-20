<?php
	
	//En esta parte incluyen los datos que necesitan para realizar la conexión.
	//Tienen que indicar el host, usuario, contraseña y el nombre de la base de datos que van a usar.

    $host_db = "mihostdelabase";
    $usuario_db = "root";
    $clave_db = "miclave";
    $nombre_db = "mibasededatos";
    
    //Realiza la conexión
    $conexion = mysql_connect($host_db, $usuario_db, $clave_db);
    
    //Selecciona la base de datos
    mysql_select_db($nombre_db);
?>