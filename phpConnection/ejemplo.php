<?php

	//Incluyes el archivo de la conexión para que no la estés creando en cada archivo de php que se vaya a usar
	include('conexion.php');

	//El charset debe coincidir con el de la base que están utilizando
	mysql_set_charset('utf8');

	//Inicializa el uso de la base
	session_start();

	//Ejemplo de query a usar en select porque necesitas guardar lo que retorna
	$sql_query = mysql_query("SELECT * FROM tabla1");

	while ($row = mysql_fetch_array($sql_query)) {
		printf("id: %s  campo_1: %s", $row[0], $row[1]);  
	}

	//Ejemplo de query a usar en update porque no necesitas un valor de regreso
	$campo_cambio = "Hola";
	$campo_sel = "2";

	mysql_query("UPDATE tabla2 SET campo2 = '".$campo_cambio."' WHERE id_tabla2 = '".$campo_sel."'");
	

	//Esto tiene que ir siempre al final de su código
	ob_end_flush();
?>