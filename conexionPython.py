#! /usr/bin/env python
 
# Importamos el conector de MySQL
import mysql.connector

# conectamos al servidor MySql
conexion_mysql = mysql.connector.connect(user='usuario', password='contraseña', host='DireccionServidor', database='BaseDeDatos')

# cursor, clase para el manejo del SQL 
cursor = conexion_mysql.cursor()

# Creamos la consulta SQL
query= "SELECT Campo1, Campo2, Campo3 FROM Tabla1"

# Ejecutamos la consula SQL
cursor.execute(query)

# Mostramos todos los datos de la consulta
for (Campo1, Campo2, Campo3) in cursor:
    print("Campo1: " + Campo1 + ", Campo2: " + Campo2 + ", Campo3: " + Campo3)

# Cerramos la variable encargada de las consultas
cursor.close()
 
# Cerramos la conexión
conexion_mysql.close()