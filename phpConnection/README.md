# Conexión a la base de datos usando PHP

Para este ejemplo, se consideró que harán páginas web porque para eso es lo que va dirigido este lenguaje de programación.

Si van a usar frameworks para esto tales como [Laravel](https://laravel.com/), [Symfony](https://symfony.com/) o [CodeIgniter](https://www.codeigniter.com/), recuerden que estos poseen ya un archivo de configuración que se encarga de hacer la conexión. Si usan un framework, **NO** deben usar los archivos de ejemplo que están incluidos en este repositorio. 

Links de la documentación de los frameworks con respecto a a la documentación de la base:

* [Laravel](https://laravel.com/docs/5.4/database)
* [Symfony](https://symfony.com/doc/current/configuration.html)
* [CodeIgniter](https://www.codeigniter.com/user_guide/database/index.html)

## Archivo conexion.php

Ese archivo deben incluirlo en todas las partes donde requieran alguna conexión en la base de datos (como se muestra en ejemplo.php) de manera obligatoria.